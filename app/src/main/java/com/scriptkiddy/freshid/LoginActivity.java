package com.scriptkiddy.freshid;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.scriptkiddy.freshid.Model.User;
public class LoginActivity extends AppCompatActivity{

    FirebaseDatabase database;
    DatabaseReference users;

    EditText edtUsername,edtPassword;
    Button btnSignIn;
    TextView btnToSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        database = FirebaseDatabase.getInstance();
        users = database.getReference("Users");

        edtUsername = (EditText)findViewById(R.id.edtUsername);
        edtPassword = (EditText)findViewById(R.id.edtPassword);

        btnToSignUp = (TextView)findViewById(R.id.btnToSignUp);

        btnToSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),SignUp.class);
                startActivity(i);
            }
        });

        btnSignIn = (Button)findViewById(R.id.btnSignIn);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn(edtUsername.getText().toString(),
                        edtPassword.getText().toString());


            }
        });

    }

    private void signIn(final String username,final String password) {
        users.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.child(username).exists()){
                    if(!username.isEmpty()){
                        User login = dataSnapshot.child(username).getValue(User.class);
                        if (login.getPassword().equals(password)){
                            Toast.makeText(LoginActivity.this, "Success Login", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(getApplicationContext(),HomeActivity.class);
                            startActivity(i);
                        }else {
                            Toast.makeText(LoginActivity.this, "Password Is Wrong", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                        Toast.makeText(LoginActivity.this, "Username is Not Registered", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
