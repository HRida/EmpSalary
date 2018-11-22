package com.example.hrida.empsalary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent i = getIntent();



        String name = i.getStringExtra("N");
        String rate = i.getStringExtra("R");
        String message = i.getStringExtra("M");
        String overtime = i.getStringExtra("OT");

        TextView txtName = findViewById(R.id.txtName);
        txtName.setTextSize(15);
        txtName.setText(name);


        TextView txtSalary = findViewById(R.id.txtSalary);
        txtSalary.setTextSize(15);
        txtSalary.setText(rate);

        TextView txtResult = findViewById(R.id.txtResult);
        txtResult.setTextSize(15);
        txtResult.setText(message);

        if (i != null) {
            TextView txtOvertime = findViewById(R.id.txtOvertime);
            txtOvertime.setTextSize(15);
            txtOvertime.setText(overtime);
        }

        Button back;

        back = findViewById(R.id.btnBack);

        back.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToMain();
            }
        });

    }

    public void backToMain() {

        Intent j = new Intent(this, MainActivity.class);
        startActivity(j);
    }
}
