package com.maniaq.acadcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CGPA_calculator extends AppCompatActivity {
    EditText old_cgpa,credits,gpa,curr_credits;
    TextView cgpa;
    Button calc;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cgpa_calc);

        old_cgpa=(EditText) findViewById(R.id.editText1);
        credits=(EditText) findViewById(R.id.editText2);
        gpa=(EditText) findViewById(R.id.editText3);
        curr_credits=(EditText) findViewById(R.id.editText4);
        cgpa=(TextView) findViewById(R.id.textView2);
        calc=(Button) findViewById(R.id.button);

        calc.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String cgpa2=old_cgpa.getText().toString();
                Float cgpa1=Float.parseFloat(cgpa2);
                String gpa2=gpa.getText().toString();
                Float gpa1=Float.parseFloat(gpa2);
                String credits2=credits.getText().toString();
                Float credits1=Float.parseFloat(credits2);
                String curr_credits2=curr_credits.getText().toString();
                Float curr_credits1=Float.parseFloat(curr_credits2);
                Float op;

                op=((cgpa1*credits1)+(gpa1*curr_credits1))/(credits1+curr_credits1);
                String op1=op.toString();
                String result="Your CCPA: "+op1;
                cgpa.setText(result);

            }
    });
}
}