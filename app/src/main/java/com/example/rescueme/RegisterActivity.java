package com.example.rescueme;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {


    TextView EVLogin;
    Button BregisterSave_button, Bregister_reset;
    TextView TVregister_selectBarangay;

    EditText ETregister_username, ETregister_email,ETregister_password, ETregister_confirmedpassword, ETregister_realName;


    FirebaseDatabase database;
    DatabaseReference reference;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

       //condition method
        RedLoginToRegister();

    BregisterSave_button=findViewById(R.id.registerSave_button);
        Bregister_reset=findViewById(R.id.register_reset);
    ETregister_username=findViewById(R.id.register_username);
    ETregister_email=findViewById(R.id.register_email);
    ETregister_password=findViewById(R.id.register_password);
    ETregister_confirmedpassword=findViewById(R.id.register_confirmedpassword);
    ETregister_realName=findViewById(R.id.register_realName);


    //Method
        BregisterSave_button.setOnClickListener(v-> CreateAccountBtn());
        Bregister_reset.setOnClickListener(v-> ResetBtn());



    }//end of oncreate


    //Sarting of method function


//unresolve problem pani
    public  void  barangaySelection(){

        TVregister_selectBarangay=findViewById(R.id.register_selectBarangay);
        String[] fruits = {"Apple", "Banana", "Cherry", "Date", "Fig", "Grape", "Kiwi", "Lemon", "Mango", "Orange", "Peach", "Pear"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, fruits);


    } // END OF METHOD



    // Start method

   public void CreateAccountBtn(){

       String name= ETregister_username.getText().toString();
       String email=ETregister_email.getText().toString();
       String password=ETregister_password.getText().toString();
       String confirmedPassword=ETregister_confirmedpassword.getText().toString();
       String realName= ETregister_realName.getText().toString();

        boolean isValidated= validateData(name,email,password, confirmedPassword, realName);

       if(!isValidated){

        return;
       }else{
           BregisterSave_button.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {

                   database = FirebaseDatabase.getInstance();
                   reference= database.getReference("enrolled");


                   String username= ETregister_username.getText().toString();
                   String realName= ETregister_realName.getText().toString();
                   String email=ETregister_email.getText().toString();
                   String password=ETregister_password.getText().toString();

                   HelperClass helperClass = new HelperClass( username, realName, email, password);
                   reference.child(username).setValue(helperClass);


                 /*  FirebaseDatabase database = FirebaseDatabase.getInstance();
                   DatabaseReference myRef = database.getReference("test user3");

                   myRef.setValue("Successfully");*/

                   Toast.makeText( RegisterActivity.this,"You have successfully register!", Toast.LENGTH_SHORT).show();


                   Intent intent= new Intent(RegisterActivity.this, MainActivity.class);
                   startActivity(intent);
                   finish();

               }
           });
       }





   }

    boolean validateData(String name, String email, String password, String confirmedPassword, String realName){

        if(name.isEmpty() || name.length()<2){
            ETregister_username.setError("fill out the form");
            return  false;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            ETregister_email.setError("Email is invalid");
            return  false;
        }

        if(password.length()<4){
            ETregister_password.setError("Password less than 4 is invalid");

            return  false;
        }

        if(!confirmedPassword.contentEquals(password)){
            ETregister_confirmedpassword.setError("not matched!");

            return  false;
        }

        if(realName.isEmpty() || realName.length()<2){
            ETregister_realName.setError("fill out the form");
            return  false;
        }

        return true;
    }// end of validate data


    public void ResetBtn(){


            Bregister_reset.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ETregister_username.setText("");
                    ETregister_email.setText("");
                    ETregister_password.setText("");
                    ETregister_confirmedpassword.setText("");
                    ETregister_realName.setText("");
                }
            });

    }


    //Sa RegisterActivity balhin to MainActivity
    public void RedLoginToRegister(){
        EVLogin=findViewById(R.id.toLogin);
        String ToColorRed=EVLogin.getText().toString();
        String targetWord="Login";// Kani ang last error nako
        int startIndex = ToColorRed.indexOf(targetWord);
        SpannableString spannableString = new SpannableString(ToColorRed);
        spannableString.setSpan(new ForegroundColorSpan(Color.RED), startIndex, startIndex + targetWord.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
       EVLogin.setText(spannableString);

        EVLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }// end of RedLoginToRegister





    }
