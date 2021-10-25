package coding.MyHashMap;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/9/4 7:48 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public interface IMap<K, V> {
    /**
     * get方法
     * @param k
     * @return
     */
    V get(K k);

    /**
     * put方法
     * @param k
     * @param v
     */
    void put(K k, V v);

}