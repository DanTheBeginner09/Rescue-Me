package com.example.rescueme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText editloginUsername,editloginPassword;
    TextView EVtoRegistration;
    CheckBox CheckBox;

    Button LoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RedRegisterToLogin();
        checkRemember();



    }

    public void RedRegisterToLogin(){
        EVtoRegistration=findViewById(R.id.toRegister);// kani last error mao nag crashes ang program

        String ToColorRed=EVtoRegistration.getText().toString();
        String targetWord="Register";// kani last error nako
        int startIndex = ToColorRed.indexOf(targetWord);
        SpannableString spannableString = new SpannableString(ToColorRed);
        spannableString.setSpan(new ForegroundColorSpan(Color.RED), startIndex, startIndex + targetWord.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        EVtoRegistration.setText(spannableString);

        EVtoRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }


    public void checkRemember(){
       CheckBox = findViewById(R.id.myCheckBox);

        CheckBox.setOnClickListener(new View.OnClickListener() {
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