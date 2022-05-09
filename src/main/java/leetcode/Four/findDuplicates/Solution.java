package leetcode.Four.findDuplicates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/5/8 11:14 AM
 * @Version: 1.initial version; 2022/5/8 11:14 AM
 */
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int[] n = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            n[nums[i] - 1] ++;
        }
        for (int i = 0; i < n.length; i++) {
            if(n[i] > 1){
                result.add(i + 1);
            }
        }
        return result;
    }

    private static class Item{
        int id;
        String name;

        public Item(int id) {
            this.id = id;
        }

        public Item(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Item item1 = new Item(1);
        Item item2 = new Item(2);
        Item item3 = new Item(3);
        Item item4 = new Item(4);
        Item item5 = new Item(5);


        List<Item> itemList = new ArrayList<>();
        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);
        itemList.add(item5);
        System.out.println("total:"+  Arrays.toString(itemList.toArray()));
        itemList = itemList.subList(itemList.size() - 3, itemList.size());
        System.out.println("3:" + Arrays.toString(itemList.toArray()));
    }
}
