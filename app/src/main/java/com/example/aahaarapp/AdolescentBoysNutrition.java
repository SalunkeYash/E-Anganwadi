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

public class AdolescentBoysNutrition extends AppCompatActivity {
    CheckBox FalicAcid1,Iron1,Vitamin1,Calcium1,allopath,homopathy,ayush;
    EditText height,weight,fat,hemoglobin;
    RadioGroup radio;
    RadioButton r;
    Button btn;
    MyDbHelperAdolescentBoys helper;
    String mobileno="",nurtrition="",service="";
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState) ;

        setContentView(R.layout.adolescent_boys_nutrition);
        FalicAcid1 = findViewById(R.id.FalicAcid1);
        Iron1 = findViewById(R.id.Iron1);
        Vitamin1 = findViewById(R.id.Vitamin1);
        Calcium1 = findViewById(R.id.Calcium1);

        allopath = findViewById(R.id.allopath1);
        homopathy = findViewById(R.id.hemopathy1);
        ayush = findViewById(R.id.ayush1);

        height = findViewById(R.id.height4);
        weight = findViewById(R.id.weight4);
        fat = findViewById(R.id.hemo4);
        hemoglobin = findViewById(R.id.weight3);


        if(FalicAcid1.isSelected())
        {
            nurtrition=nurtrition+","+(FalicAcid1.getText().toString());
        }
        if(Iron1.isSelected())
        {
            nurtrition=nurtrition+","+(Iron1.getText().toString());
        }
        if(Vitamin1.isSelected())
        {
            nurtrition=nurtrition+","+(Vitamin1.getText().toString());
        }
        if(Calcium1.isSelected())
        {
            nurtrition=nurtrition+","+(Calcium1.getText().toString());
        }

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
            service=service+","+(ayush.getText().toString());
        }

        radio = findViewById(R.id.unit4);

        btn = findViewById(R.id.submitI);

        helper = new MyDbHelperAdolescentBoys(this);

        btn.setOnClickListener(view -> {
            String heightn = height.getText().toString();
            String weightn = weight.getText().toString();
            String fatn = fat.getText().toString();
            String hemoglobinn = hemoglobin.getText().toString();

            // Retrieve the selected RadioButton text
            // inside the OnClickListener
            int selectedId = radio.getCheckedRadioButtonId();
            if (selectedId != -1) {
                r = findViewById(selectedId);
                String radion = r.getText().toString();

                helper.updateColumns(mobileno,nurtrition,heightn,weightn,fatn,radion,hemoglobinn,service);
                Toast.makeText(AdolescentBoysNutrition.this, "Data Saved Successfully", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), Logup.class);
                startActivity(intent);
            } else {
                // Handle the case where no RadioButton is selected
                Toast.makeText(AdolescentBoysNutrition.this, "Please Select ALl the Fields", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
