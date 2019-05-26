package com.example.cngnt.intentsss;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.datbase.Mydata;
import com.example.modle.Contact;

public class SecondActivity extends AppCompatActivity {
    Contact contact;
    EditText edtName, edtPhone, edtGmail;
    Button btnExit, btnPlus;
    Mydata mydata;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        addControls();


    }

        private void addControls() {

    }


}
