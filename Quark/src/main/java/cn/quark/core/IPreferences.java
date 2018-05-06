package cn.quark.core;

/**
 * SharedPreferences操作
 * @author timpkins
 */
public interface IPreferences<T> {

    /**
     * 保存数据到SharedPreferences
     * @param value 待保存数据
     */
    void put(T value);

    /**
     * 从SharedPreferences中通过key获取数据
     * @return 待获取数据
     */
    T get();

    /**
     * 从SharedPreferences中通过删除数据
     */
    void remove();

    /**
     * 删除SharedPreferences中所有数据
     */
    void clear();

    /**
     * SharedPreferences中是否包含对应的key
     * @return true表示包含key，反之则不包含
     */
    boolean isContains();

    /**
     * 获取当前key对应的默认值
     * @return key对应的默认值
     */
    T getDefValue();

    /**
     * 将当前key重置为默认值
     */
    void reset();
}
