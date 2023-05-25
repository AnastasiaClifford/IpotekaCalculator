package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText loanAmountEditText;
    private EditText interestRateEditText;
    private EditText loanTermEditText;
    private Button calculateButton;
    private TextView monthlyPaymentTextView;
    private CheckBox diffCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        loanAmountEditText = findViewById(R.id.loan_amount_edit_text);
        interestRateEditText = findViewById(R.id.interest_rate_edit_text);
        loanTermEditText = findViewById(R.id.loan_term_edit_text);
        calculateButton = findViewById(R.id.calculate_button);
        monthlyPaymentTextView = findViewById(R.id.monthly_payment_text_view);
        diffCheckBox = findViewById(R.id.checkBox);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateMonthlyPayment();
            }

            private void calculateMonthlyPayment() {
                double loanAmount = Double.parseDouble(loanAmountEditText.getText().toString());
                double interestRate = Double.parseDouble(interestRateEditText.getText().toString());
                double loanTerm = Double.parseDouble(loanTermEditText.getText().toString());

                double totalPayment = loanAmount / (interestRate / 100);
                double yearlyPayment = totalPayment / loanTerm;
                double monthlyPayment = yearlyPayment / 12;

                monthlyPaymentTextView.setText(getString(R.string.monthly_payment, monthlyPayment) + "\n" + getString(R.string.totalPayroll, totalPayment));
            }
        });
    }
}