package com.example.hrida.empsalary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText N;
    EditText S;
    EditText H;
    Button btnMetric;

    String name;
    String salaryCondition;
    String hoursCondition;

    double salary;
    double hours;
    double overtime = 0;
    double rate = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        N = findViewById(R.id.editName);
        S = findViewById(R.id.editSalary);
        H = findViewById(R.id.editHours);
        btnMetric = findViewById(R.id.btnCalculate);

        btnMetric.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateRate();
            }
        });
    }

    public void calculateRate() {

        String message;
        String OT = "";

        Intent i = new Intent(this, Result.class);

        salaryCondition = S.getText().toString();
        hoursCondition = H.getText().toString();
        name = N.getText().toString();

        if (name.matches("") || salaryCondition.matches("") || hoursCondition.matches("")) {
            Toast.makeText(this, "Fill up the fields", Toast.LENGTH_SHORT).show();
            return;
        } else {
                salary = Double.parseDouble(S.getText().toString());
                hours = Double.parseDouble(H.getText().toString());
                rate = salary / hours;

                if (rate <= 0) {
                    message = "Error";
                } else if (rate <= 3.125) {
                    message = "Low Rate";
                } else if (rate > 3.125 && rate <= 5) {
                    message = "Good Rate";
                } else if (rate > 5 && rate <= 7.5) {
                    message = "Amazing Rate";
                } else {
                    message = "Super Rate !!";
                }
        }

        if (hours > 160) {
            overtime = (hours - 160) * rate * 1.5;
            OT = Double.toString(overtime); //convert double overtime to string
        }

        String StringRate = Double.toString(rate); //convert double rate to string

        i.putExtra("N", name);
        i.putExtra("R", StringRate);
        i.putExtra("M", message);
        i.putExtra("OT", OT);

        startActivity(i);
    }
}
