package com.example.login;

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

import javax.annotation.Nonnull;

public class MainActivity extends AppCompatActivity {

    EditText textemail;
    EditText textpassword;
    Button registrarse ;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textemail=  findViewById(R.id.nombre);
        textpassword= findViewById(R.id.password);
        firebaseAuth=FirebaseAuth.getInstance();
        registrarse=findViewById(R.id.registrarse);
        registrarse.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View view){
                String email = textemail.getText().toString();
                String password = textpassword.getText().toString();
                firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>()
                {
                    @Override
                    public void onComplete(@Nonnull Task<AuthResult>task){
                        Toast.makeText(MainActivity.this, "Usuario adicionado", Toast.LENGTH_SHORT).show();
                        Intent intentlogueo = new Intent(MainActivity.this,logueo.class);
                        startActivity(intentlogueo);
                        finish();
                    }
                });


            }
        });

    }
}