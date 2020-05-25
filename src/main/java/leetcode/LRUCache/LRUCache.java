package leetcode.LRUCache;

import java.util.HashMap;
import java.util.Map;

/*
 * @author:liuzhaolu
 * @createTime: 2020-05-25 14:47
 * @desc:运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。

获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。

 

进阶:

你是否可以在 O(1) 时间复杂度内完成这两种操作？

思路：用StringBuilder来存储值，
* 1、每次put先出队，更新新值；
* 2、每次get队列中，队列中对应的key重新入队

示例:

LRUCache cache = new LRUCache( 2 ); 2 为缓存容量

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4
 */
public class LRUCache {
    private int capacity;
    private Map<Integer, Integer> map;
    private StringBuilder stringBuilder;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.stringBuilder = new StringBuilder();
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        } else {
            // 删除原来的key
            int index = stringBuilder.indexOf(String.valueOf(key));
            stringBuilder.deleteCharAt(index);
            // 将key更新到末尾
            stringBuilder.append(key);
            // 返回值
            return map.get(key);
        }
    }

    public void put(int key, int value) {
        if(map.size() < capacity){
            map.put(key, value);
            stringBuilder.append(key);
        } else {
            if(map.containsKey(key)){
                // 删除原来的key
                int index = stringBuilder.indexOf(String.valueOf(key));
                stringBuilder.deleteCharAt(index);
                // 将key更新到末尾
                stringBuilder.append(key);
                // 更新操作
                map.remove(key);
                map.put(key,value);
            } else {
                // 删除最久未使用
                int deleteKey = Integer.parseInt(String.valueOf(stringBuilder.charAt(0)));
                map.remove(deleteKey);
                stringBuilder.deleteCharAt(0);
                // 添加最新的
                map.put(key,value);
                stringBuilder.append(key);
            }
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 10);
        cache.put(10,13);
        cache.put(3,17);
        cache.put(6,11);
        cache.put(10,5);
        cache.put(9,10);
        System.out.println(cache.get(13));
        cache.put(2,19);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        cache.put(5,25);
        System.out.println(cache.get(8));
        cache.put(9,22);
        cache.put(5,5);
        cache.put(1,30);
        System.out.println(cache.get(11));       // 返回  1
        cache.put(9,12);
        System.out.println(cache.get(7));       // 返回 -1 (未找到)
        System.out.println(cache.get(5));       // 返回 -1 (未找到)
        System.out.println(cache.get(8));       // 返回 -1 (未找到)
        System.out.println(cache.get(9));       // 返回 -1 (未找到)
        cache.put(4,30);
        cache.put(9,3);
        System.out.println(cache.get(9));       // 返回 -1 (未找到)
        System.out.println(cache.get(10));       // 返回 -1 (未找到)
        System.out.println(cache.get(10));       // 返回 -1 (未找到)
        cache.put(6,14);
        cache.put(3,1);
        System.out.println(cache.get(3));
        cache.put(10,11);
        System.out.println(cache.get(8));       // 返回 -1 (未找到)
    }

}
