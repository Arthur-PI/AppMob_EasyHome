package fr.appmob.easyhome.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import fr.appmob.easyhome.R;
import fr.appmob.easyhome.activities.BeforeLoginActivity;
import fr.appmob.easyhome.activities.MainActivity;
import fr.appmob.easyhome.models.SessionManagement;

public class ProfileFragment extends Fragment {

	private Button logout;

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_profile, container, false);
		logout = view.findViewById(R.id.profile_logout_button);

		logout.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				SessionManagement sessionManagement = new SessionManagement(getContext());
				sessionManagement.clearSession();
				moveToFrontPageActivity();
			}
		});
		return view;
	}

	private void moveToFrontPageActivity() {
		Intent intent= new Intent(getActivity(), BeforeLoginActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(intent);
	}
}
