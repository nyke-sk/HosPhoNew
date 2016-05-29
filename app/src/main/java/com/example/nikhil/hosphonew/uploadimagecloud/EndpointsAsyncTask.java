package com.example.nikhil.hosphonew.uploadimagecloud;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v4.util.Pair;
import android.util.Base64;
import android.widget.Toast;

import com.example.alinoureddine.myapplication.backend.photoApi.PhotoApi;
import com.example.alinoureddine.myapplication.backend.photoApi.model.Photo;
import com.example.nikhil.hosphonew.AfterImageupload;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by alinoureddine on 5/25/16.
 */

public class EndpointsAsyncTask extends AsyncTask<Pair<Activity, Bitmap>, Void, Bitmap> {
    private static PhotoApi myApiService = null;
    private Activity activity;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Bitmap doInBackground(Pair<Activity, Bitmap>... params) {
        activity = params[0].first;
        Bitmap bm = params[0].second;
        showProgressDialog();


        Photo photo = new Photo();
        photo.setName("DefaultPictureId123");
//        photo.setId(date.getValue());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] b = baos.toByteArray();
        String imageEncoded = Base64.encodeToString(b,Base64.DEFAULT);
        photo.setBlobImage(imageEncoded);

        PhotoApi.Builder builder = new PhotoApi.Builder(AndroidHttp.newCompatibleTransport(),
                new AndroidJsonFactory(), null)
                .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                    @Override
                    public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                        abstractGoogleClientRequest.setDisableGZipContent(true);
                    }
                });
        myApiService = builder.build();

        try {
            photo = myApiService.insertPhoto(photo).execute();
            System.out.println("photo uploaded: "+photo);
            byte[] decodedBytes = Base64.decode(photo.getBlobImage(), 0);
            return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;


    }

    @Override
    protected void onPostExecute(Bitmap result) {
        Toast.makeText(activity,"Succeeded",Toast.LENGTH_LONG).show();
        System.out.println("opPostExecute: "+result.toString());
        hideProgressDialog();
        AfterImageupload afterImageupload = (AfterImageupload) activity;
        afterImageupload.onImageUploaded(result);
    }


    private void showProgressDialog() {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mProgressDialog == null) {
                    mProgressDialog = new ProgressDialog(activity);
                    mProgressDialog.setMessage("Uploading...");
                    mProgressDialog.setIndeterminate(true);
                }
                mProgressDialog.show();
            }
        });

    }

    private void hideProgressDialog() {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mProgressDialog != null && mProgressDialog.isShowing()) {
                    mProgressDialog.hide();
                }
            }
        });

    }
}