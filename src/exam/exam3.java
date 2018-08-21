package exam;

import java.util.*;

/**
 * @author liuzhaolu
 * @version create_time：2018/8/18 类说明:
 */
public class exam3 {

    //去重
    public static ArrayList<Integer> ifRepeat(ArrayList<Integer> arr){
        for(int i = 0; i < arr.size(); i++){
            for(int j=i+1;j<arr.size();j++){
                if(arr.get(i).equals(arr.get(j))){
                    arr.remove(i);
                }
            }
            System.out.println("array:");
            for(int k = 0 ; k < arr.size();k++){
                System.out.print(arr.get(i)+" ");
            }
            System.out.println("");
        }
        return arr;
    }

    private static ArrayList<Integer> shunzi(ArrayList<Integer> a){
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        int index = a.get(0);
        int count = 0;
        //去重
        temp = ifRepeat(a);
        System.out.println("temp:");
        for(int i = 0 ; i < temp.size();i++){
            System.out.print(temp.get(i)+" ");
        }
        for(int i=0;i<a.size();i++){
            if(a.get(i) - index == 1){
                index = a.get(i);
                result.add(index);
                count++;
            } else {
                index = a.get(i);
                result.clear();
                count = 0;
            }
        }
        if(count > 4){
            System.out.println("shunzi:"+result.toString());
            return result;
        } else {
            System.out.println("error");
            return a;
        }
    }

    public static void main(String[] args) {
        String str = "";
        ArrayList<Integer> a = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            str = sc.next();
            char[] c = str.toCharArray();
            for(int i = 0;i<c.length;i++){
                if(c[i] == 'A'){
                    a.add(1);
                } else if(c[i] == 'T'){
                    a.add(10);
                } else if(c[i] == 'J'){
                    a.add(11);
                } else if(c[i] == 'Q'){
                    a.add(12);
                } else if(c[i] == 'K'){
                    a.add(13);
                } else {

                    a.add(Integer.parseInt(String.valueOf(c[i])));
                }
            }
            Collections.sort(a);
            for(int i = 0 ; i < a.size();i++){
                System.out.print(a.get(i)+" ");
            }
            System.out.println("");
            shunzi(a);
        }
    }
}
