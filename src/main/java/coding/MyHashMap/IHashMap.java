package coding.MyHashMap;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.HashMap;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/9/4 7:48 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class IHashMap<K, V> implements IMap<K, V> {
    public Node<K, V>[] table;
    public int threshold;
    public int initialCapacity;
    /**
     * 默认大小
     */
    public static final int DEFAULT_CAPACITY = 8;

    @Data
    @Builder
    @AllArgsConstructor
    public static class Node<K, V>{
        private int hash;
        private K key;
        private V value;
        private Node<K, V> next;
    }

    /**
     * 无参构造
     */
    public IHashMap() {
        initialCapacity = DEFAULT_CAPACITY;
        table = new Node[initialCapacity];
    }


    /**
     * 初始化大小, 有参数构造
     * @param initialCapacity
     */
    public IHashMap(int initialCapacity) {
        this.initialCapacity = initialCapacity;
        table = new Node[initialCapacity];
    }

    /**
     * get方法
     * @param k
     * @return
     */
    @Override
    public V get(K k) {
        int index = hashCode(k);
        Node<K, V> node = table[index];
        while (node != null){
            if(node.key == k){
                return node.value;
            } else {
                node = node.next;
            }
        }
        return null;
    }

    /**
     * put方法
     * @param k
     * @param v
     */
    @Override
    public void put(K k, V v) {
        int index = hashCode(k);
        Node<K, V> node = table[index];
        Node<K, V> newNode = new Node<K,V>(hashCode(k),k,v,null);
        if (node != null) {
            newNode.next = node;
        }
        table[index] = newNode;
    }

    /**
     * 返回HashCode索引
     * @param k
     * @return
     */
    private int hashCode(K k){
        return k.hashCode() % initialCapacity;
    }


    public static void main(String[] args) {
        IMap<String, String> map = new IHashMap<>();
        map.put("hello","world!");
        map.put("try","everything");
        System.out.println(map.get("try"));
        System.out.println(map.get("hello"));
    }
}
