package exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


/**
 * @author liuzhaolu
 * @version create_time：2018/8/18 类说明:
 */
public class exam4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = Integer.parseInt(in.nextLine());
        ArrayList<Interval> input = new ArrayList<>();

        for(int i = 0; i < m; i++){
            String[] errorsClassifiedByEditors = in.nextLine().split(";");
            for(int j = 0; j < errorsClassifiedByEditors.length; j++){
                String[] errors = errorsClassifiedByEditors[j].split(",");
                input.add(new Interval(Integer.parseInt(errors[0]), Integer.parseInt(errors[1])));
            }
        }
        in.close();

        Collections.sort(input,new Comparator<Interval>(){

            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        Interval prev = null;
        ArrayList<Interval> results = new ArrayList<>();
        for(Interval item : input){
            if(prev == null || item.start > prev.end){
                results.add(item);
                prev = item;
            }else if(prev.end < item.end){
                prev.end = item.end;
            }
        }

        int count = 0;

        for(Interval item : results){
            if(count == results.size() - 1){
                System.out.print(item.start + "," + item.end);
            }else{
                System.out.print(item.start + "," + item.end + ";");
            }
            count ++;
        }


    }
}

class Interval{
    int start;
    int end;

    public Interval(int start, int end){
        this.start = start;
        this.end = end;
    }
}