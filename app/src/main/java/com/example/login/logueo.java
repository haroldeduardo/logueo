package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class logueo extends AppCompatActivity {

    EditText textpasswordlogueo;
    EditText textcorreologueo;
    Button btnlogueo;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logueo);
        textcorreologueo=findViewById(R.id.passwordlogueo);
        textcorreologueo=   findViewById(R.id.nombrelogueo);

        btnlogueo=findViewById(R.id.logueo);
        firebaseAuth= FirebaseAuth.getInstance();
        btnlogueo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=textcorreologueo.getText().toString();
                String contraseña=textpasswordlogueo.getText().toString();
                firebaseAuth.signInWithEmailAndPassword(email,contraseña).addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){

                        }else{
                            Intent intentlogueo=new Intent(logueo.this, MainActivity.class);
                            startActivity(intentlogueo);

                        }
                    }
                });
            }
        });
    }
}