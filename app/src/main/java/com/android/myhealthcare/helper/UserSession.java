package com.android.myhealthcare.helper;

import android.content.Context;
import android.content.SharedPreferences;

import com.android.myhealthcare.R;
import com.android.myhealthcare.api.UserAPI;

public class UserSession {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private static final String IS_USER_LOGGED_IN = "IS_USER_LOGGED_IN";
    private static final String AUTH_USER = "LOGGED_IN_USER";
    private static final String ID="ID";
    private static final String TOKEN="TOKEN";

    public UserSession(Context context) {
        sharedPreferences = context.getSharedPreferences(context.getString(R.string.user_session), Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void startSession() {

        editor.putBoolean(IS_USER_LOGGED_IN, true);
        editor.putString(ID, UserAPI.id);
        editor.putString(TOKEN, UserAPI.token);

        editor.commit();
    }

    public boolean isActive() {
        return sharedPreferences.getBoolean(IS_USER_LOGGED_IN, false);
    }
    public String getID(){
        String id= sharedPreferences.getString(ID,"");
        return id;
    }

    public String getTOKEN(){
        String token= sharedPreferences.getString(TOKEN,"");
        return token;
    }

    public void endSession() {

        editor.putBoolean(IS_USER_LOGGED_IN, false);
        editor.remove(AUTH_USER);
        editor.remove(ID);
        editor.remove(TOKEN);
        editor.commit();
    }
}