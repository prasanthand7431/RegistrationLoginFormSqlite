package com.example.prasanth.registrationforminsqlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup_screen extends AppCompatActivity{

    EditText Name;
    EditText MobileNumber;
    EditText Email;
    EditText Password;
    EditText Confirmpassword;
    Button button;
    databaseb databaseb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_page);
        Name=findViewById(R.id.edit1);
        MobileNumber=findViewById(R.id.edit2);
        Email=findViewById(R.id.edit3);
        Password=findViewById(R.id.edit4);
        Confirmpassword=findViewById(R.id.edit5);
        button=findViewById(R.id.but1);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String sName=Name.getText().toString();
                String sMobileNumber=MobileNumber.getText().toString();
                String sEmail=Email.getText().toString();
                String sPasssword=Password.getText().toString();
                String sConfirmpassword=Confirmpassword.getText().toString();


                if(sName.isEmpty() || sMobileNumber.isEmpty() || sEmail.isEmpty() || sPasssword.isEmpty() || sConfirmpassword.isEmpty()){

                    Toast.makeText(signup_screen.this, "Kindly fill all details", Toast.LENGTH_SHORT).show();

                }else if (sPasssword.equals(sConfirmpassword)){

                    databaseb1=new databaseb(signup_screen.this);

                    long h=databaseb1.saveit(sName,sMobileNumber,sEmail,sPasssword,sConfirmpassword);

                    if (h>0) {
                        Toast.makeText(signup_screen.this, "user created..Login now" + h, Toast.LENGTH_SHORT).show();
//                        Intent bikes=new Intent(signup_screen.this,login_screen.class);
//                        startActivity(bikes);
                        finish();
                    }

                }
                else {

                    Toast.makeText(signup_screen.this, "Password donot match", Toast.LENGTH_SHORT).show();
                }

                }
        });
    }
}
