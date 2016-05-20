package com.example.nikhil.hosphonew;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        EditText Name = (EditText) findViewById(R.id.editName);
        EditText Email = (EditText) findViewById(R.id.editEmailID);
        EditText Password  = (EditText) findViewById(R.id.editPassword);
        EditText Gender = (EditText) findViewById(R.id.editTextGender);
        EditText DOB = (EditText) findViewById(R.id.editTextDOB);

        Button SignUp = (Button)findViewById(R.id.buttonSignUpPage) ;

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RadioButton selector1 = (RadioButton)findViewById(R.id.radioButtonDoctorSignUp);
                RadioButton selector2 = (RadioButton)findViewById(R.id.radioButtonPatientSignUp);

                if(selector1.isChecked()){

                }

                else if(selector2.isChecked()){

                }

                else {

                }



            }
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
