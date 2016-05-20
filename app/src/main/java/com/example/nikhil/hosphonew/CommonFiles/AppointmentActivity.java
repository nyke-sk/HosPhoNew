package com.example.nikhil.hosphonew.CommonFiles;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.nikhil.hosphonew.R;

import java.util.ArrayList;
import java.util.List;

public class AppointmentActivity extends AppCompatActivity {

    List<String> listItems;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listItems= new ArrayList<String>();

        listItems.add("Appointment1");
        listItems.add("Appointment2");
        listItems.add("Appointment3");
        listItems.add("Appointment4");
        listItems.add("Appointment5");
        listItems.add("Appointment6");
        listItems.add("Appointment7");
        listItems.add("Appointment8");

        list= (ListView)findViewById(R.id.listViewAppointment);
        add();


    }

    private void add() {

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_dropdown_item_1line,listItems);
        list.setAdapter(adapter);
    }

}
