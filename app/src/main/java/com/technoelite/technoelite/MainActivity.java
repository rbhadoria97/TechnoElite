package com.technoelite.technoelite;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private Button SignIn, SignUp;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText) findViewById(R.id.etEmail);
        Password = (EditText) findViewById(R.id.loginPassword);
        SignIn = (Button) findViewById(R.id.btnSignIn);
        SignUp = (Button) findViewById(R.id.btnsignUp);

        firebaseAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);

        FirebaseUser user =  firebaseAuth.getCurrentUser();


        if(user != null){
            finish();
            startActivity(new Intent(MainActivity.this, Dashboard.class));
        }

       SignIn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               validate(Name.getText().toString(),Password.getText().toString() );
           }
       });

       SignUp.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(MainActivity.this, Registraion.class));
           }
       });
    }

    private void validate(String userName, String userPassword) {

        progressDialog.setMessage("Welcome to TechnoElite");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(userName,userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
             if(task.isSuccessful()){
                 progressDialog.dismiss();
                 Toast.makeText(MainActivity.this, "Login Successfull",Toast.LENGTH_SHORT).show();
                 startActivity(new Intent(MainActivity.this, Dashboard.class));
             }else {
                 Toast.makeText(MainActivity.this, "Login Failed",Toast.LENGTH_SHORT).show();
             }

            }
        });
    }
}