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

public class LactatingMother_Nutrition extends AppCompatActivity {
    CheckBox allopath,homopathy,ayush,thr,hcm;
    EditText height,weight,hemo;
    Button btn;

    RadioButton r;

    RadioGroup radio1;
    MyDBHelperLactatingMother helper;
    String mobileno="";
    String service = "";
    String service1="";

    public void onCreate( Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.lactating_nutrition);

        weight = findViewById(R.id.weight4 );
        height = findViewById(R.id.height4);
        btn=findViewById(R.id.submitI);
        allopath=findViewById(R.id.allopath4);
        homopathy=findViewById(R.id.homeopathy4);
        ayush=findViewById(R.id.ayush4);
        thr=findViewById(R.id.THR);
        hcm=findViewById(R.id.HCM);
        helper = new MyDBHelperLactatingMother(this);
        radio1= findViewById(R.id.unit4);
hemo=findViewById(R.id.hemo4);

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
        if(thr.isSelected())
        {
            service1=service1+","+(thr.getText().toString());
        }
        if (thr.isSelected())
        {
            service1 = service1+"," + (thr.getText().toString());
        }
        btn.setOnClickListener(view -> {


            // Retrieve the selected RadioButton text
            // inside the OnClickListener
            int selectedId = radio1.getCheckedRadioButtonId();

            if (selectedId != -1) {
                RadioButton selectedRadioButton2 = findViewById(selectedId);
                String radio2 = selectedRadioButton2.getText().toString();

                String height2=height.getText().toString();
                String weight2=weight.getText().toString();
String hemo1=hemo.getText().toString();
                String weight1=weight.getText().toString();
                helper.updateColumns(mobileno,radio2,height2,weight2,hemo1,service1,service);
                Toast.makeText(LactatingMother_Nutrition.this, "Data Saved Successfully", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), Logup.class);
                startActivity(intent);
            } else {
                // Handle the case where no RadioButton is selected
                Toast.makeText(LactatingMother_Nutrition.this, "Please Select ALl the Fields", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
