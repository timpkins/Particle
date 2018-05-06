package cn.quark.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import cn.quark.BaseApplication;

/**
 * SharedPreferences创建
 * @author timpkins
 */
public class PreferencesHelper {
    private SharedPreferences preferences;

    public PreferencesHelper(String name) {
        preferences = BaseApplication.getContext().getSharedPreferences(name, Context.MODE_PRIVATE);
    }

    public PreferencesHelper(String name, int mode) {
        preferences = BaseApplication.getContext().getSharedPreferences(name, mode);
    }

    public SharedPreferences getPreferences() {
        return preferences;
    }
}
