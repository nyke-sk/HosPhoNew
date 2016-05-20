package com.example.nikhil.hosphonew.PatientFiles;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.nikhil.hosphonew.R;
import com.example.nikhil.hosphonew.CommonFiles.SelectorActivity;

import java.util.ArrayList;
import java.util.List;

public class PatientSearchDoctorActivity extends AppCompatActivity {

    List<String> listItems;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_search_doctor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listItems= new ArrayList<String>();

        listItems.add("Doctor1");
        listItems.add("Doctor2");
        listItems.add("Doctor3");
        listItems.add("Doctor4");
        listItems.add("Doctor5");
        listItems.add("Doctor6");
        listItems.add("Doctor7");
        listItems.add("Doctor8");

        list= (ListView)findViewById(R.id.listViewDoctorSearch);
        add();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(PatientSearchDoctorActivity.this,SelectorActivity.class);
                startActivity(intent);
            }
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void add() {

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_dropdown_item_1line,listItems);
        list.setAdapter(adapter);
    }

}
