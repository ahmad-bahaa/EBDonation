package com.ghanem.nour.ebd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends Activity {

    private FirebaseAuth mAuth;

    private EditText email,password;
    private Button loging,signup;

    String sEmail,sPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        loging = findViewById(R.id.login);
        signup = findViewById(R.id.signup);

        loging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sEmail = email.getText().toString();
                sPassword = password.getText().toString();
                if (TextUtils.isEmpty(sEmail)){
                    Toast.makeText(LoginActivity.this, "Please Enter Your Email", Toast.LENGTH_LONG).show();
                }else if (TextUtils.isEmpty(sPassword)){
                    Toast.makeText(LoginActivity.this, "Please Write Your Password", Toast.LENGTH_LONG).show();
                }else {
                    mAuth.signInWithEmailAndPassword(sEmail, sPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                SendUsetToActivity();
                            }else {
                                String message = task.getException().getMessage().toString();
                                Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                          } }});
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sEmail = email.getText().toString();
                sPassword = password.getText().toString();
                if (TextUtils.isEmpty(sEmail)){
                    Toast.makeText(LoginActivity.this, "Please Enter Your Email", Toast.LENGTH_LONG).show();
                }else if (TextUtils.isEmpty(sPassword)){
                    Toast.makeText(LoginActivity.this, "Please Write Your Password", Toast.LENGTH_LONG).show();
                }else {
                    mAuth.createUserWithEmailAndPassword(sEmail, sPassword)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                SendUsetToActivity();
                            }else {
                                String message = task.getException().getMessage().toString();
                                Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
                            } }
                    });
                } }
        });


    }

    private void SendUsetToActivity() {
        Intent intent = new Intent(this,FillingFormActivity.class);
        startActivity(intent);
    }

}
