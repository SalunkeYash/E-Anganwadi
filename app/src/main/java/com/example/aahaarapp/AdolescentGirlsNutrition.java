package com.example.aahaarapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AdolescentGirlsNutrition extends AppCompatActivity {

    CheckBox allopath,homopathy,ayush;
    EditText iron,hemoglobin,height,weight;
    Button btn;
    RadioButton r,r2;
    RadioGroup radio,radioht;
    MyDbHelperAdolescentBoys helper;
    String mobileno="";
    String service = "";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adolescent_girls_nutrition);

        iron = findViewById(R.id.height2);
        hemoglobin = findViewById(R.id.weight3);

        weight = findViewById(R.id.weight3);
        height = findViewById(R.id.height2);
        btn=findViewById(R.id.submitI);
        allopath=findViewById(R.id.Allopath2);
        homopathy=findViewById(R.id.Hamopathy2);
        ayush=findViewById(R.id.Ayush2);

        helper = new MyDbHelperAdolescentBoys(this);
        radio = findViewById(R.id.radiogrp);
        radioht = findViewById(R.id.unit4);

        if(allopath.isSelected())
        {
            service=service+","+(allopath.getText().toString());
        }
        if(homopathy.isSelected())
        {
            service=service+","+(homopathy.getText().toString());
        }
        if (ayush.isSelected())
        {
            service = service+"," + (ayush.getText().toString());
        }
        btn.setOnClickListener(view -> {


            // Retrieve the selected RadioButton text
            int selectedId = radio.getCheckedRadioButtonId();
            int selectedId1 = radioht.getCheckedRadioButtonId();
            if (selectedId != -1 && selectedId1 != -1) {
                RadioButton selectedRadioButton = findViewById(selectedId);
                String radio1 = selectedRadioButton.getText().toString();

                RadioButton selectedRadioButton2 = findViewById(selectedId1);
                String radio2 = selectedRadioButton2.getText().toString();
                String height2=height.getText().toString();
                String weight2=weight.getText().toString();
                String iron1= iron.getText().toString();
                String hemoglobin1=hemoglobin.getText().toString();
                String weight1=weight.getText().toString();
                helper.updateColumns(mobileno,radio1,iron1,hemoglobin1,service,radio2,height2,weight2);
                Toast.makeText(AdolescentGirlsNutrition.this, "Data Saved Successfully", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), Logup.class);
                startActivity(intent);
            } else {
                // Handle the case where no RadioButton is selected
                Toast.makeText(AdolescentGirlsNutrition.this, "Please Select ALl the Fields", Toast.LENGTH_SHORT).show();
            }
        });

    }
}