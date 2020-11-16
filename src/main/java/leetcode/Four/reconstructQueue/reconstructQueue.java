package leetcode.Four.reconstructQueue;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-11-16 10:35
 * @desc 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 *
 * 注意：
 * 总人数少于1100人。
 *
 * 示例
 *
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

 * 链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class reconstructQueue {
    /**
     * 插入排序
     * 1、[[7,0],[7,1],[6,1],[5,0],[5,2],[4,4]]
     * 2、[[7,0],[6,1],[7,1],[5,0],[5,2],[4,4]]
     * 3、[[5,0],[7,0],[6,1],[7,1],[5,2],[4,4]]
     * 4、[[5,0],[7,0],[5,2],[6,1],[7,1],[4,4]]
     * 5、[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
     * @param people
     * @return
     */
    public static int[][] reconstructQueue(int[][] people) {
        // 先按身高最高到矮，位置从小到大排序
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1.length <= 1 || o2.length <= 1){
                    return 0;
                } if(o1[0] > o2[0]){
                    return -1;
                } else if(o1[0] == o2[0]){
                    if(o1[1] > o2[1]){
                        return 1;
                    } else {
                        return -1;
                    }
                }
                else {
                    return 1;
                }
            }
        });
        // 身高从高到低排，当前位置一定是相对正确的，只需要调整k满足i即可
        for(int i = 1;i < people.length;i++){
            int k = people[i][1];
            if(k != i){ // 插入
                insertPeople(i,k,people);
            }
        }
        return people;
    }

    public static void insertPeople(int location, int index,int[][] people){
        int[] temp = people[location];
        for(int i = location; i > index;i--){
            people[i] = people[i - 1];
        }
        people[index] = temp;
    }

    public static void main(String[] args) {
        int[][] people = new int[][]{{7,0},{4,4},{7,1},{5,3},{6,1},{5,2}};
        System.out.println(JSONObject.toJSONString(reconstructQueue(people)));
    }
}
