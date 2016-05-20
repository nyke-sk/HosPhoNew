package com.example.nikhil.hosphonew.CommonFiles;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.ValueCallback;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.nikhil.hosphonew.R;

import java.io.File;

public class AddFile extends AppCompatActivity {

    private Uri mCapturedImageURI = null;
    private static final int FILECHOOSER_RESULTCODE = 2888;
    private ValueCallback<Uri> mUploadMessage;
    private String[] arraySpinner = new String[]{"Report" , "Prescription" , "Appointment"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_file);

        Button button = (Button)findViewById(R.id.buttonUploadFile);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser(mUploadMessage);
            }
        });

        Spinner S = (Spinner)findViewById(R.id.spinnerSelectCategory);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,arraySpinner);
        S.setAdapter(adapter);
    }

    public void openFileChooser(ValueCallback<Uri> uploadMessage, String acceptType) {

        mUploadMessage = uploadMessage;

        try {

            File imageStore = new File(Environment.getExternalStorageDirectory(), "HosPho");
            if (!imageStore.exists()) {
                imageStore.mkdirs();
            }

            File file = new File(imageStore +
                    File.separator +
                    "IMG_" + String.valueOf(System.currentTimeMillis()) +
                    ".jpg");
            mCapturedImageURI = Uri.fromFile(file);

            Intent captureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            captureIntent.putExtra(MediaStore.EXTRA_OUTPUT, mCapturedImageURI);
            Toast.makeText(getApplicationContext(), "Capture Intent", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            intent.setType("image/*");

            Intent chooserIntent = Intent.createChooser(intent, "Image Chooser");
            chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Parcelable[]{captureIntent});
            startActivityForResult(chooserIntent, FILECHOOSER_RESULTCODE);
        } catch (Exception e) {
            Toast.makeText(getBaseContext(), "Exception:" + e, Toast.LENGTH_LONG).show();
        }


    }

    public void openFileChooser(ValueCallback<Uri> uploadMessage) {
        openFileChooser(uploadMessage, "");
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if(requestCode==FILECHOOSER_RESULTCODE){
            if(null == this.mUploadMessage){
                return;
            }

            Uri result = null;
            try {
                if (resultCode != RESULT_OK) {
                    result = null;
                } else {
                    result = intent == null ? mCapturedImageURI : intent.getData();
                }
            }
            catch (Exception e){
                Toast.makeText(getApplicationContext(),"activity : "+e,Toast.LENGTH_LONG).show();
            }
        }

    }

}



