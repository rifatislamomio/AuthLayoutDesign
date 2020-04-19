package com.example.authlayoutdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity {

    Button btnContinue;
    EditText phoneNumber;
    TextView textViewTermsnCond;
    public static String PHONE_NUMBER;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        phoneNumber = findViewById(R.id.editText_phoneNumber);
        btnContinue = findViewById(R.id.btn_continue);
        textViewTermsnCond = findViewById(R.id.TextViewTerm);

        phoneNumber.clearFocus();
        phoneNumber.setSelection(phoneNumber.getText().toString().length());
        phoneNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(phoneNumber.getText().toString().length()==9)
                {
                    phoneNumber.setText(phoneNumber.getText().toString()+"-");
                    phoneNumber.setSelection(phoneNumber.getText().toString().length());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        phoneNumber.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus) phoneNumber.setCursorVisible(true);
                else phoneNumber.setCursorVisible(false);
            }
        });

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(phoneNumber.getText().toString().length()==16)  //Write a function to check phone number validity
                {
                    //Write OTP Request Function
                    PHONE_NUMBER = phoneNumber.getText().toString();
                    finish();
                    startActivity(new Intent(getApplicationContext(), VerificationPageActivity.class));
                }
                else
                {
                    phoneNumber.setError("Invalid Number!");
                }
            }
        });

        textViewTermsnCond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Write Terms and Condition Page Function
                textViewTermsnCond.setTextColor(getResources().getColor(R.color.colorInactive));
            }
        });


    }
}
