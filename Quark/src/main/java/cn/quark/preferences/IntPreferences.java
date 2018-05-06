package cn.quark.preferences;

/**
 * SharedPreferences中int类型的操作
 * @author timpkins
 */
public class IntPreferences extends BasePreferences<Integer>{

    public IntPreferences(PreferencesHelper helper, String key, int defValue) {
        super(helper, key, defValue);
    }

    @Override
    public void put(Integer value) {
        getEditor().putInt(key, value).apply();
    }

    @Override
    public Integer get() {
        return helper.getPreferences().getInt(key, defValue);
    }

    @Override
    public void reset() {
        getEditor().putInt(key, defValue).apply();
    }
}
