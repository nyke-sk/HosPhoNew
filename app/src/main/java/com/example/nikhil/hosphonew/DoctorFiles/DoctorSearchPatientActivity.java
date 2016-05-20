package com.example.nikhil.hosphonew.DoctorFiles;

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

public class DoctorSearchPatientActivity extends AppCompatActivity {

    List<String> listItems;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_search_patient);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listItems= new ArrayList<String>();

        listItems.add("Patient1");
        listItems.add("Patient2");
        listItems.add("Patient3");
        listItems.add("Patient4");
        listItems.add("Patient5");
        listItems.add("Patient6");
        listItems.add("Patient7");
        listItems.add("Patient8");

        list= (ListView)findViewById(R.id.listViewPatientSearch);
        add();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(DoctorSearchPatientActivity.this,SelectorActivity.class);
                startActivity(intent);
            }
        });
    }

    private void add() {

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_dropdown_item_1line,listItems);
        list.setAdapter(adapter);

    }

    }

