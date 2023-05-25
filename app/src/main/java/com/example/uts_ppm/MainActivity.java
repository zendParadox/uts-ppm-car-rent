package com.example.uts_ppm;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private RadioGroup radioGroupCars;
    private EditText editTextDays;
    private Button buttonCalculate;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        radioGroupCars = findViewById(R.id.radioGroupCars);
        editTextDays = findViewById(R.id.editTextDays);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        textViewResult = findViewById(R.id.textViewResult);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateRent();
            }
        });
    }

    private void calculateRent() {
        String name = editTextName.getText().toString();

        int selectedCarId = radioGroupCars.getCheckedRadioButtonId();
        RadioButton selectedCar = findViewById(selectedCarId);
        String car = selectedCar.getText().toString();

        int days = Integer.parseInt(editTextDays.getText().toString());

        int rentPrice = 0;

        if (car.equals("Avanza/Xenia/Grandmax")) {
            rentPrice = 250000;
        } else if (car.equals("Minibus/Elf")) {
            rentPrice = 500000;
        } else if (car.equals("Bus")) {
            rentPrice = 1000000;
        }

        int totalRent = rentPrice * days;

        String result = "Biaya sewa atas nama " + name + " sebesar " + totalRent;
        textViewResult.setText(result);
    }
}
