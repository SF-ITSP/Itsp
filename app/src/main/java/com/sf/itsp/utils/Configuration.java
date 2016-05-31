package com.sf.itsp.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.sf.itsp.DriverApplication;

public class Configuration {
    public static final String PREFERENCES_LOG_IN_SESSION = "preferences_log_in_session";
    public static final String KEY_LOGIN_USER_ID = "userId";

    private static Editor getEditor(String preferencesName) {
        return getPreferences(preferencesName).edit();
    }

    private static SharedPreferences getPreferences(String preferencesName) {
        return DriverApplication.getInstance().getSharedPreferences(preferencesName, Context.MODE_PRIVATE);
    }

    public static void setLoginUserId(String userId) {
        Editor editor = getEditor(userId);
        editor.putString(KEY_LOGIN_USER_ID, userId);
        editor.commit();
    }

//    public static String getLoginUserId() {
//        return getPreferences(getLogInSessionAccountID()).getString(KEY_LOGIN_USER_ID, "");
//    }
}
