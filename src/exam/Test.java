package exam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author liuzhaolu
 * @version create_time：2018/8/11 类说明:
 */
public class Test {

    private static Map<String,Integer> max(int[] array){
        Map<String,Integer> map = new HashMap<>();
        int max = array[0];
        int location = 0;  //最大值所在数组位置
        for(int i=1;i<array.length;i++)
        {
            if(array[i]>max)
            {
                max=array[i];//如果有比max大的数就让max记录下大的数
                location=i;
            }
        }
        map.put("max",max);
        map.put("location",location);
        return map;
    }

    private static Map<String,Integer> min(int[] array){
        Map<String,Integer> map = new HashMap<>();
        int min = array[0];
        int location = 0;
        for(int i=1;i<array.length;i++)
        {
            if(array[i]<min)
            {
                min=array[i];
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

    private static int result(int[] a, int[] b,int n){
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
                System.out.println("maxlocation:"+maxlocation);
                System.out.println("n:"+n);
                int[] a1 = new int[maxlocation];
                int[] a2 = new int[n - maxlocation - 1];
                int[] b1 = new int[maxlocation];
                int[] b2 = new int[n - maxlocation - 1];
                for(int i = 0 ; i < maxlocation;i++){
                    a1[i] = a[i];
                    b1[i] = b[i];
                }
                int k = 0;
                for(int j = maxlocation + 1;j < n;j++){
                    a2[k] = a[j];
                    b2[k] = b[j];
                    k++;
                }
                int locationA = a[maxlocation];
                int locationB = b[maxlocation];
                if(locationA < locationB){
                    extra += 1;
                }
                Map<String,Integer> maxa1 = new HashMap<>();
                Map<String,Integer> maxa2 = new HashMap<>();
                Map<String,Integer> minb1 = new HashMap<>();
                Map<String,Integer> minb2 = new HashMap<>();
                maxa1 = max(a1);
                maxa2 = max(a2);
                minb1 = min(b1);
                minb2 = min(b2);
                if(locationA < minb1.get("min")){
                    int[] tempA = new int[a1.length + 1];
                    int[] tempB = new int[b1.length + 1];
                    for(int i = 0;i<a1.length;i++){
                        tempA[i] = a1[i];
                    }
                    tempA[a1.length] = locationA;


                }
                System.out.println("a1:");
                showArray(a1);
                System.out.println("a2:");
                showArray(a2);
                System.out.println("b1");
                showArray(b1);
                System.out.println("b2");
                showArray(b2);
                if(maxlocation == 0){
                    result = result(a2,b2,n-maxlocation-1);
                } else if(maxlocation == n-1){
                    result = result(a1,b1,maxlocation);
                } else {
                    result = result(a1,b1,maxlocation) + result(a2,b2,n-maxlocation-1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int n = in.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i< n;i++){
                a[i] = in.nextInt();
            }
            for (int i = 0; i< n;i++){
                b[i] = in.nextInt();
            }
            System.out.println("result:"+result(a,b,n));
        }
    }
}
