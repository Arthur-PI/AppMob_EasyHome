package fr.appmob.easyhome.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fr.appmob.easyhome.R;
import fr.appmob.easyhome.models.SessionManagement;

public class BeforeLoginActivity extends AppCompatActivity {
	private Button login, register;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_before_login);

		login = findViewById(R.id.front_connexion_button);
		register = findViewById(R.id.front_register_button);

		login.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent= new Intent(getApplicationContext(), LoginActivity.class);
				startActivity(intent);
				finish();
			}
		});

		register.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent= new Intent(getApplicationContext(), RegisterActivity.class);
				startActivity(intent);
				finish();
			}
		});
	}

	@Override
	protected void onStart() {
		super.onStart();
		checkSession();
	}

	private void checkSession() {
		// Check if user is already logged in
		SessionManagement sessionManagement = new SessionManagement(BeforeLoginActivity.this);
		String userId = sessionManagement.getSession();
		if (userId != null) moveToMainActivity();
	}

	private void moveToMainActivity() {
		Intent mainActivity= new Intent(getApplicationContext(), MainActivity.class);
		mainActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(mainActivity);
	}

}