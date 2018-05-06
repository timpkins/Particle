package cn.quark.preferences;

/**
 * SharedPreferences中Float类型的操作
 * @author timpkins
 */
public class FloatPreferences extends BasePreferences<Float> {

    public FloatPreferences(PreferencesHelper helper, String key, Float defValue) {
        super(helper, key, defValue);
    }

    @Override
    public void put(Float value) {
        getEditor().putFloat(key, value).apply();
    }

    @Override
    public Float get() {
        return helper.getPreferences().getFloat(key, defValue);
    }

    @Override
    public void reset() {
        getEditor().putFloat(key, defValue).apply();
    }
}
