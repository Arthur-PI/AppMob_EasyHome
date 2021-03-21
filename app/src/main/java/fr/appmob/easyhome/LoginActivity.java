package fr.appmob.easyhome;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "LoginActivity";
    private FirebaseAuth mAuth;
    private EditText mail, password;
    private Button button,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        mail = findViewById(R.id.emailAddress);
        password = findViewById(R.id.password);
        button  = findViewById(R.id.loginButton);
        button2 = findViewById(R.id.registerButton);

        button2.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v)
            {
                Intent profileActivity= new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(profileActivity);
                finish();
            }
        });
        button.setOnClickListener(this);
    }

    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser currentUser) {
    }

    @Override
    public void onClick(View v) {
        String email = mail.getText().toString().trim();
        String password = this.password.getText().toString().trim();

        if (!validateData(email, password)) {
            Toast.makeText(LoginActivity.this, "Les informations de sont pas valides " + email + " " + password, Toast.LENGTH_LONG).show();
            return;
        }

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseUser user = mAuth.getCurrentUser();
                    Toast.makeText(LoginActivity.this, "User login avec succes !", Toast.LENGTH_LONG).show();
                    Intent profileActivity= new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(profileActivity);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Credentials invalides", Toast.LENGTH_LONG).show();
                    Log.w(TAG, "signIn:failure", task.getException());
                }
            }
        });
    }

    private boolean validateData(String email, String password) {
        boolean flag = true;

        if (email.isEmpty()) flag = false ;
        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) flag = false ;
        if (password.isEmpty()) flag = false ;

        return flag;
    }

}