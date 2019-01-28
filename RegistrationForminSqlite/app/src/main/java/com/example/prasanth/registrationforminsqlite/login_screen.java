package com.example.prasanth.registrationforminsqlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login_screen extends AppCompatActivity {

    EditText Email;
    EditText Password;
    Button button;
    databaseb databaseb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        Email=findViewById(R.id.edit1);
        Password=findViewById(R.id.edit2);
        button=findViewById(R.id.but1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sEmail=Email.getText().toString();
                String sPassword=Password.getText().toString();

                if (sEmail.isEmpty() || sPassword.isEmpty()){

                    Toast.makeText(login_screen.this, "Kindly provide username and password", Toast.LENGTH_SHORT).show();
                }else {

                    databaseb2=new databaseb(login_screen.this);
                    int a=databaseb2.checkuser(sEmail,sPassword);

                    if (a==1){

                        Intent bike=new Intent(login_screen.this,welcome_screen.class);
                        startActivity(bike);
                        finish();

                        }else if(a==0){

                        Toast.makeText(login_screen.this, "Incorrect username & password", Toast.LENGTH_SHORT).show();

                        }
                }
            }
        });
    }
}
