package com.maniaq.acadcalc;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GPA_calculator extends AppCompatActivity {

    EditText credits, grade;
    TextView cgpa;
    Button ad, calc, res;
    Float tot, tot_cred;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_gpa_calculator);


        tot = 0.0f;
        tot_cred = 0.0f;
        credits = (EditText) findViewById(R.id.credits);
        grade = (EditText) findViewById(R.id.grade);
        cgpa = (TextView) findViewById(R.id.cgpa);
        ad = (Button) findViewById(R.id.add);
        calc = (Button) findViewById(R.id.calculate);
        res = (Button) findViewById(R.id.reset);

        ad.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String cred = credits.getText().toString();
                Float creds = Float.parseFloat(cred);
                String grad = grade.getText().toString();
                Float val=0f;
                switch (grad) {
                    case "S":
                        val = 10f;
                        break;
                    case "A":
                        val = 9f;
                        break;
                    case "B":
                        val = 8f;
                        break;
                    case "C":
                        val = 7f;
                        break;
                    case "D":
                        val = 6f;
                        break;
                    case "E":
                        val = 5f;
                        break;
                    case "F":
                        val = 4f;
                        break;
                }
                ;
                tot_cred = tot_cred + creds;
                tot = tot + (val * creds);
                cgpa.setText("Course added.");
                credits.setText("");
                grade.setText("");
            }

        });
        calc.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Float fin=tot/tot_cred;
                String gpa = fin.toString();
                String op = "Your GPA is: " + gpa;
                cgpa.setText(op);
                tot = 0f;
                tot_cred = 0f;
                credits.setText("");
                grade.setText("");
            }

        });
        res.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                cgpa.setText("Values have been reset.");
                tot = 0f;
                tot_cred = 0f;
                credits.setText("");
                grade.setText("");
            }

        });

    }
}
