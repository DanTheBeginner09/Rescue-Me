package com.example.rescueme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    TextView LoginRedirection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // method to color red and redirection to register
        LoginTORedColor();


    }

    public void LoginTORedColor(){

        LoginRedirection=findViewById(R.id.LoginRedirection);



        String ToColorRed=LoginRedirection.getText().toString();
        String targetWord="Login";
        int startIndex = ToColorRed.indexOf(targetWord);
        SpannableString spannableString = new SpannableString(ToColorRed);
        spannableString.setSpan(new ForegroundColorSpan(Color.RED), startIndex, startIndex + targetWord.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        LoginRedirection.setText(spannableString);

        LoginRedirection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(RegisterActivity.this, MainActivity.class);
                  startActivity(intent);
                  onPause();
            }
        });

     //   Intent intent= new Intent(RegisterActivity.this, MainActivity.class);
     //   startActivity(intent);

    }
}