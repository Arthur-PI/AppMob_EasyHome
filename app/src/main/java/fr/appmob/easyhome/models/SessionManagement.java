package fr.appmob.easyhome.models;

import android.content.Context;
import android.content.SharedPreferences;


public class SessionManagement {
	SharedPreferences sharedPreferences;
	SharedPreferences.Editor editor;
	String SHARED_PREF_NAME = "session";
	String SESSION_KEY;

	public SessionManagement(Context context){
		sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
		editor = sharedPreferences.edit();
	}

	public void saveSession(User user) {
		editor.putString(SESSION_KEY, user.getUserId()).commit();
	}

	public String getSession() {
		return sharedPreferences.getString(SESSION_KEY, null);
	}

	public void clearSession() {
		editor.putString(SESSION_KEY, null).commit();
	}
}
