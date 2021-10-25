package leetcode.One.Thousand.displayTable;

import java.util.*;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/7/6 下午3:00
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        // x号桌子，点了List的菜
        Map<String, Map<String, Integer>> orderMaps = new HashMap<>();
        List<String> foodList = new ArrayList<>();
        foodList.add("Table");
        orders.forEach(order -> {
            if(order.size() == 3){
                String table = order.get(1);
                String food = order.get(2);
                if(!foodList.contains(food)){
                    foodList.add(food);
                }
                orderFood(orderMaps,table,food);
            }
        });
        List<List<String>> result = new ArrayList<>();
        result.addAll(Collections.singleton(foodList));
        orderMaps.forEach((key, value) -> {
            List<String> table = new ArrayList<>();
            table.add(key);  // x号桌
            foodList.forEach(food -> {
                if(value.containsKey(food)){
                    table.add(String.valueOf(value.get(food)));
                } else {
                    if(!food.equalsIgnoreCase("Table")){
                        table.add("0");
                    }
                }
            });
            result.addAll(Collections.singleton(table));
        });
        return result;
    }

    public void orderFood(Map<String, Map<String, Integer>> orderList, String table, String food){
        Map<String, Integer> foodList = orderList.get(table);
        if(Objects.isNull(foodList)){
            foodList = new HashMap<>();
        }
        if(foodList.isEmpty()){
            foodList.put(food,1);
        } else {
            if(foodList.containsKey(food)){
                int num = foodList.get(food);
                foodList.put(food, num + 1);
            } else {
                foodList.put(food,1);
            }
        }
        orderList.put(table, foodList);
    }

    public static void main(String[] args) {
        String[][] strings = new String[][]{{"David","3","Ceviche"},{"Corina","10","Beef Burrito"},{"David","3","Fried Chicken"},{"Carla","5","Water"},{"Carla","5","Ceviche"},{"Rous","3","Ceviche"}};
        List<List<String>> orders = new ArrayList<>();
        Arrays.stream(strings).forEach(strs -> {
            List<String> temp = new ArrayList<>(Arrays.asList(strs));
            orders.add(temp);
        });
        Solution solution = new Solution();
        System.out.println(solution.displayTable(orders));
    }
}
