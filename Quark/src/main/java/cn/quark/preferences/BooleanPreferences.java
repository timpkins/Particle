package cn.quark.preferences;

/**
 * SharedPreferences中boolean类型的操作
 * @author timpkins
 */
public class BooleanPreferences extends BasePreferences<Boolean>{

    public BooleanPreferences(PreferencesHelper helper, String key, Boolean defValue) {
        super(helper, key, defValue);
    }

    @Override
    public void put(Boolean value) {
        getEditor().putBoolean(key, value).apply();
    }

    @Override
    public Boolean get() {
        return helper.getPreferences().getBoolean(key, defValue);
    }

    @Override
    public void reset() {
        getEditor().putBoolean(key, defValue).apply();
    }
}
