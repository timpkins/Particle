package cn.quark.preferences;

import java.util.Set;

/**
 * SharedPreferences中Set<String>类型的操作
 * @author timpkins
 */
public class StringSetPreferences extends BasePreferences<Set<String>>{

    public StringSetPreferences(PreferencesHelper helper, String key, Set<String> defValue) {
        super(helper, key, defValue);
    }

    @Override
    public void put(Set<String> value) {
        getEditor().putStringSet(key, value).apply();
    }

    @Override
    public Set<String> get() {
        return helper.getPreferences().getStringSet(key, defValue);
    }

    @Override
    public void reset() {
        getEditor().putStringSet(key, defValue).apply();
    }
}
