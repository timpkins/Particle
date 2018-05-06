package cn.quark.preferences;

/**
 * SharedPreferences中Long类型的操作
 * @author timpkins
 */
public class LongPreferences extends BasePreferences<Long>{

    public LongPreferences(PreferencesHelper helper, String key, Long defValue) {
        super(helper, key, defValue);
    }

    @Override
    public void put(Long value) {
        getEditor().putLong(key, value).apply();
    }

    @Override
    public Long get() {
        return helper.getPreferences().getLong(key, defValue);
    }

    @Override
    public void reset() {
        getEditor().putLong(key, defValue).apply();
    }
}
