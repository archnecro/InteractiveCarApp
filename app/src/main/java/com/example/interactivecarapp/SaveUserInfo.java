package com.example.interactivecarapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class SaveUserInfo
{
    static String USERNAME = "";

    static SharedPreferences GetSP(Context context)
    {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }
    public static void setUsername(Context context, String username)
    {
        Editor spEdit = GetSP(context).edit();
        spEdit.putString(USERNAME, username);
        spEdit.commit();
    }
    public static String getUsername(Context context)
    {
        return GetSP(context).getString(USERNAME, "");
    }
}
