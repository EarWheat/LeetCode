package exam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author liuzhaolu
 * @version create_time：2018/8/11 类说明:
 */
public class Main {

    private static Map<String,Integer> max(ArrayList<Integer> array){
        Map<String,Integer> map = new HashMap<>();
        int max = array.get(0);
        int location = 0;  //最大值所在数组位置
        for(int i=1;i<array.size();i++)
        {
            if(array.get(i)>max)
            {
                max=array.get(i);//如果有比max大的数就让max记录下大的数
                location=i;
            }
        }
        map.put("max",max);
        map.put("location",location);
        return map;
    }

    private static Map<String,Integer> min(ArrayList<Integer> array){
        Map<String,Integer> map = new HashMap<>();
        int min = array.get(0);
        int location = 0;
        for(int i=1;i<array.size();i++)
        {
            if(array.get(i)<min)
            {
                min=array.get(i);
                location=i;
            }
        }
        map.put("min",min);
        map.put("location",location);
        return map;
    }

    private static void showArray(int[] array){
        for(int i = 0; i < array.length;i++){
            System.out.print(array[i] + ",");
        }
        System.out.println("");
    }

    private static int result(ArrayList<Integer> a, ArrayList<Integer> b,int n){
        int result = 0;
        int extra = 0;
        Map<String,Integer> maxMap = new HashMap<>();
        Map<String,Integer> minMap = new HashMap<>();
        maxMap = max(a);
        minMap = min(b);
        if(maxMap.get("max") < minMap.get("min")){
            result = (n+1) * n;
            result = result/2;
            return result;
        } else {
            if(n == 1){
                return 0;
            } else {
                int maxlocation = maxMap.get("location");
                ArrayList<Integer> a1 = new ArrayList<>();
                ArrayList<Integer> a2 = new ArrayList<>();
                ArrayList<Integer> b1 = new ArrayList<>();
                ArrayList<Integer> b2 = new ArrayList<>();
                for(int i = 0 ; i < maxlocation;i++){
                    a1.add(a.get(i));
                    b1.add(b.get(i));
                }
                int k = 0;
                for(int j = maxlocation + 1;j < n;j++){
                    a2.add(a.get(j));
                    b2.add(b.get(j));
                    k++;
                }
                int locationA = a.get(maxlocation);
                int locationB = b.get(maxlocation);
                Map<String,Integer> minb1 = new HashMap<>();
                Map<String,Integer> minb2 = new HashMap<>();
                if(b1.size() != 0){
                    minb1 = min(b1);
                    if(locationA < minb1.get("min")){
                        a1.add(locationA);
                        b1.add(locationB);
                    }
                } else if(b2.size() != 0){
                    minb2 = min(b2);
                    if (locationA < minb2.get("min")){
                        a2.add(locationA);
                        b2.add(locationB);
                    }
                }
                if(locationA < locationB){
                    extra = 1;
                }
                if(maxlocation == 0){
                    result = result(a2,b2,n-maxlocation-1);
                } else if(maxlocation == n-1){
                    result = result(a1,b1,maxlocation);
                } else {
                    result = extra + result(a1,b1,maxlocation) + result(a2,b2,n-maxlocation-1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int n = in.nextInt();
            ArrayList<Integer> a = new ArrayList<>();
            ArrayList<Integer> b = new ArrayList<>();
            for (int i = 0; i< n;i++){
                a.add(in.nextInt());
            }
            for (int i = 0; i< n;i++){
                b.add(in.nextInt());
            }
            System.out.println("result:"+result(a,b,n));
        }
    }
}
