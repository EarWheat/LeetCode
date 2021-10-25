package leetcode.Three.SummaryRanges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/10/9 5:18 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class SummaryRanges {
    List<Integer> list;
    public SummaryRanges() {
        list=new ArrayList<>();
    }

    public void addNum(int val) {
        list.add(val);
    }

    public int[][] getIntervals() {
        if(list.size()==1){return new int[][]{{list.get(0),list.get(0)}};}
        Collections.sort(list);
        List<int[]> intevals=new ArrayList<>();
        int l=list.get(0);
        for(int i=1;i<list.size();i++){
            if(list.get(i)-list.get(i-1)>1){
                intevals.add(new int[]{l,list.get(i-1)});
                l=list.get(i);
            }
        }
        intevals.add(new int[]{l,list.get(list.size()-1)});
        return intevals.toArray(new int[intevals.size()][]);
    }
}
