package com.technoelite.technoelite;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Registraion extends AppCompatActivity {

    private EditText firstName, lastName, userPassword, userEmail;
    private Button regButton;
    private TextView userLogin;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registraion);
        setupUIViews();


        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate()){
                    //regsiter to database
                    String user_email = userEmail.getText().toString().trim();
                    String user_password = userPassword.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(user_email,user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                 Toast.makeText(Registraion.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Registraion.this,MainActivity.class));
                            }else{
                                Toast.makeText(Registraion.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Registraion.this,MainActivity.class));
            }
        });

    }

  private void setupUIViews(){
        firstName = (EditText)findViewById(R.id.firstName);
        lastName = (EditText)findViewById(R.id.lastName);
        userEmail = (EditText)findViewById(R.id.email);
        userPassword = (EditText)findViewById(R.id.newPassword);
        regButton = (Button)findViewById(R.id.btnRegister);
        userLogin = (TextView)findViewById(R.id.tvUserLogin);
  }

  private Boolean validate(){
      Boolean result =false;
      String name = firstName.getText().toString();
      String surname = lastName.getText().toString();
      String email = userEmail.getText().toString();
      String password = userPassword.getText().toString();

      if(name.isEmpty() || surname.isEmpty() || email.isEmpty() || password.isEmpty()){
          Toast.makeText(this, "Please enter the all details",Toast.LENGTH_SHORT).show();
      }else{
          result = true;
      }
      return result;

    }

}
