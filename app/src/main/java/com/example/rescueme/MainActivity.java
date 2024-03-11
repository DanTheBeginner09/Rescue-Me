package com.example.rescueme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView RegisterRedirection;
    CheckBox myCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // method to color red and redirection to register
        RegisterTORedColor();
        // remember method
        checkRemember();



    }

    public void RegisterTORedColor(){
        RegisterRedirection=findViewById(R.id.RegisterRedirection);

        String ToColorRed=RegisterRedirection.getText().toString();
        String targetWord="Register";
        int startIndex = ToColorRed.indexOf(targetWord);
        SpannableString spannableString = new SpannableString(ToColorRed);
        spannableString.setSpan(new ForegroundColorSpan(Color.RED), startIndex, startIndex + targetWord.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        RegisterRedirection.setText(spannableString);

    //    Intent intent= new Intent(MainActivity.this, RegisterActivity.class);
    //    startActivity(intent);
            RegisterRedirection.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent= new Intent(MainActivity.this, RegisterActivity.class);
                    startActivity(intent);
                    onResume();
                }
            });
    }

    public void checkRemember(){
        CheckBox myCheckBox = findViewById(R.id.myCheckBox);

        myCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check the state of the CheckBox
                boolean isChecked = ((CheckBox) v).isChecked();

                // Show a toast message based on the CheckBox state
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "Checkbox is checked", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Checkbox is unchecked", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}