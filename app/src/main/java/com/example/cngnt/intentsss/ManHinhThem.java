package com.example.cngnt.intentsss;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.datbase.Mydata;
import com.example.modle.Contact;

public class ManHinhThem extends AppCompatActivity {
    Button btnAddBT, btnClAdd;
    EditText addTen, addDT, addMail;
    Mydata mydata;
    Contact contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_them);
        Intent intent = getIntent();
    addControl();
    addEvent();
    }

    private void addEvent() {
        btnAddBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contact = new Contact(addTen.getText().toString(), addDT.getText().toString(), addMail.getText().toString());
                if (mydata.addContact(contact)!=0){
                    Intent intentBack = new Intent(ManHinhThem.this, MainActivity.class);
                    intentBack.putExtra("", contact);
                    setResult(MainActivity.RESULT_FIRST_USER, intentBack);
                    Toast.makeText(ManHinhThem.this, "Them thanh cong!", Toast.LENGTH_SHORT).show();

                    finish();
                }else {
                    Toast.makeText(ManHinhThem.this, "Them khong thanh cong!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnClAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentcc = new Intent(ManHinhThem.this, MainActivity.class);
                setResult(MainActivity.RESULT_FIRST_USER, intentcc);
                finish();
            }
        });
    }

    private void addControl() {
        btnAddBT =(Button) findViewById(R.id.btnAdd);
        btnClAdd = (Button) findViewById(R.id.btnCancel);
        addTen = (EditText) findViewById(R.id.edtAddTen);
        addDT = (EditText) findViewById(R.id.edtaddDT);
        addMail = (EditText) findViewById(R.id.edtAddMail);
        mydata = new Mydata(this);
    }
}
