package cn.quark.preferences;

/**
 * SharedPreferences中String类型的操作
 * @author timpkins
 */
public class StringPreferences extends BasePreferences<String> {

    public StringPreferences(PreferencesHelper helper, String key, String defValue) {
        super(helper, key, defValue);
    }

    @Override
    public void put(String value) {
        getEditor().putString(key, value).apply();
    }

    @Override
    public String get() {
        return helper.getPreferences().getString(key, defValue);
    }

    @Override
    public void reset() {
        getEditor().putString(key, defValue).apply();
    }
}
