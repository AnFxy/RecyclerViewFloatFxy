package jp.co.cte.recyclerviewfloatfxy.recyclerviewitemdecoration;

/**
 * 课题号（GORASA-XXXX)
 * 类或接口的描述信息
 *
 * @author xiaoyun.fangfenrir-inc.com.cn
 * @date 2022/1/10
 */
public interface CacheInterface<T> {

    /**
     * 加入缓存
     * @param position
     * @param t
     */
    void put(int position, T t);

    /**
     * 从缓存中获取
     * @param position
     * @return
     */
    T get(int position);

    /**
     * 移除
     * @param position
     */
    void remove(int position);

    /**
     * 清空缓存
     */
    void clean();

}
