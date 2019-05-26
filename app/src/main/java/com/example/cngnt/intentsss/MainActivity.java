package com.example.cngnt.intentsss;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;


import com.example.Adapter.ContactAdapter;
import com.example.datbase.Mydata;
import com.example.modle.Contact;

import java.util.ArrayList;
import java.util.List;

import static com.example.cngnt.intentsss.R.id.list_item;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    List<Contact> listContact;
    Contact contact;
    RecyclerView recyclerView;
    Mydata mydata;
    ContactAdapter adapter;


    Button btnThem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listContact = new ArrayList<Contact>();
        recyclerView = (RecyclerView) findViewById(list_item);
        mydata = new Mydata(this);
        mydata.getWritableDatabase();
        listContact = mydata.getAllContacts();
        addControl();
    }

    private void addControl() {
        adapter = new ContactAdapter(listContact, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        btnThem = findViewById(R.id.btnThem);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ManHinhThem.class);
                startActivity(intent);
            }
        });
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        adapter.notifyDataSetChanged();
    }
}
