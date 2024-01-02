package com.example.todayinpalestine;

import android.content.Context;
import android.content.SharedPreferences;

public class UserPreferences {

    private static final String PREFERENCES_NAME = "user_preferences";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_CONFIRM_PASSWORD = "confirm_password";
    private static final String KEY_REMEMBER_ME = "remember_me";

    private static SharedPreferences sharedPreferences;

    public UserPreferences(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    public void addUser(String username, String email, String password, String confirmPassword) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_USERNAME, username);
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_PASSWORD, password);
        editor.putString(KEY_CONFIRM_PASSWORD, confirmPassword);
        editor.apply();
    }

    public static String getUsername() {
        return sharedPreferences.getString(KEY_USERNAME, "");
    }

    public String getPassword() {
        return sharedPreferences.getString(KEY_PASSWORD, "");
    }


    public void setRememberMe(boolean rememberMe) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(KEY_REMEMBER_ME, rememberMe);
        editor.apply();
    }

    public boolean isRememberMe() {
        return sharedPreferences.getBoolean(KEY_REMEMBER_ME, false);
    }
    public boolean isUserLoggedIn() {
        // Check for both username and password to determine login status
        return !getUsername().isEmpty() && !getPassword().isEmpty();
    }

    public void clearCredentials() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(KEY_USERNAME);
        editor.remove(KEY_EMAIL);
        editor.remove(KEY_PASSWORD);
        editor.remove(KEY_CONFIRM_PASSWORD);
        editor.remove(KEY_REMEMBER_ME);
        editor.apply();
    }
}
