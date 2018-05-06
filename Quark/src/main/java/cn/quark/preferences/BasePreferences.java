package cn.quark.preferences;

import android.content.SharedPreferences.Editor;

import cn.quark.core.IPreferences;

/**
 * SharedPreferences基类
 * @author timpkins
 */
public abstract class BasePreferences<T> implements IPreferences<T> {
    String key;
    T defValue;
    PreferencesHelper helper;

    BasePreferences(PreferencesHelper helper, String key, T defValue) {
        this.helper = helper;
        this.key = key;
        this.defValue = defValue;
    }

    Editor getEditor() {
        return helper.getPreferences().edit();
    }

    @Override
    public void remove() {
        getEditor().remove(key).apply();
    }

    @Override
    public void clear() {
        getEditor().clear().apply();
    }

    @Override
    public boolean isContains() {
        return helper.getPreferences().contains(key);
    }

    @Override
    public T getDefValue() {
        return defValue;
    }
}
