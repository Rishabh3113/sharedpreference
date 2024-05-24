package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.SplittableRandom;

public class login extends AppCompatActivity {

    TextInputEditText name,pass;
    MaterialButton login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        name=findViewById(R.id.username);
        pass=findViewById(R.id.Password);
        login=findViewById(R.id.login);
        SharedPreferences preferences=getSharedPreferences("userdata", Context.MODE_PRIVATE);


        String s1=preferences.getString("username","");
        String s2=preferences.getString("password","");
        name.setText(s1);
        pass.setText(s2);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=name.getText().toString();
                String password=pass.getText().toString();
                if(TextUtils.isEmpty(username)){
                    name.setError("please enter name");
                    name.requestFocus();

                } else if (TextUtils.isEmpty(password)) {
                    pass.setError("please enter password");
                    pass.requestFocus();

                }
                else{
                    login_user(username,password);
                }

            }
        });
    }

    private void login_user(String username, String password) {

        Toast.makeText(this, "Login successfull", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(com.example.assignment.login.this,image.class);
        startActivity(intent);
        SharedPreferences preferences=getSharedPreferences("userdata",MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putString("username",username);
        editor.putString("password",password);
        editor.apply();




    }
}