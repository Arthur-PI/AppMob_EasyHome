package fr.appmob.easyhome;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
import com.google.firebase.firestore.FirebaseFirestore;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "RegisterActivity";
    private FirebaseAuth mAuth;
    private EditText nom, prenom, email, password, confirmPassword;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        nom = findViewById(R.id.nom);
        prenom = findViewById(R.id.prenom);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirm_password);
        button = findViewById(R.id.button);

        button.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        String nom = this.nom.getText().toString().trim();
        String prenom = this.prenom.getText().toString().trim();
        String email = this.email.getText().toString().trim();
        String password = this.password.getText().toString().trim();
        String confirmPassword = this.confirmPassword.getText().toString().trim();

        if (!validateData(nom, prenom, email, password, confirmPassword)) {
            Toast.makeText(RegisterActivity.this, "Les informations de sont pas valides", Toast.LENGTH_LONG).show();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    String userId = mAuth.getUid();
                    if (userId == null) return;

                    User user = new User(nom, prenom, email, mAuth.getUid());
                    FirebaseFirestore db = FirebaseFirestore.getInstance();
                    db.collection("users").document(mAuth.getUid()).set(user).addOnCompleteListener(new OnCompleteListener<Void>() {

                        @Override
                        public void onComplete(@NonNull Task task) {
                            if (task.isSuccessful()){
                                Toast.makeText(RegisterActivity.this, "User inscrit avec succes !", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(RegisterActivity.this, "Erreur lors de l'ajout dans la DB !", Toast.LENGTH_LONG).show();
                            }
                        }
                    });

                } else {
                    Toast.makeText(RegisterActivity.this, "Erreur lors de creation de l'identifiant", Toast.LENGTH_LONG).show();
                    Log.w(TAG, "signIn:failure", task.getException());
                }
            }
        });

    }

    private boolean validateData(String nom, String prenom, String email, String password, String confirmPassword) {
        // TODO : Error fields in the layout
        boolean flag = true;
        if (prenom.isEmpty()) flag = false;
        if (nom.isEmpty()) flag = false;
        if (email.isEmpty()) flag = false;
        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) flag = false;
        if (password.isEmpty()) flag = false;
        if (!password.equals(confirmPassword)) flag = false;

        return flag;
    }
}