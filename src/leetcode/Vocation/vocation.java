package leetcode.Vocation;

import coding.Pack;

import java.util.Scanner;

/*
 * @author:liuzhaolu
 * @createTime: 2020-02-20 16:51
 * @desc:由于业绩优秀，公司给小Q放了 n 天的假，身为工作狂的小Q打算在在假期中工作、锻炼或者休息。他有个奇怪的习惯：不会连续两天工作或锻炼。只有当公司营业时，小Q才能去工作，只有当健身房营业时，小Q才能去健身，小Q一天只能干一件事。给出假期中公司，健身房的营业情况，求小Q最少需要休息几天。
 * @input:
 * 第一行一个整数  表示放假天数
第二行 n 个数 每个数为0或1,第 i 个数表示公司在第 i 天是否营业
第三行 n 个数 每个数为0或1,第 i 个数表示健身房在第 i 天是否营业
（1为营业 0为不营业）
* @output:
* 一个整数，表示小Q休息的最少天数
* @ex:
* in:
* 4
* 1 1 0 0
* 0 1 1 0
* out:
* 2
 */
public class vocation {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int day = scanner.nextInt();
        int[] business = new int[day];
        int[] fitness = new int[day];
        for(int i = 0 ; i < day; i++){
            business[i] = scanner.nextInt();
        }
        for(int i = 0 ; i < day; i++){
            fitness[i] = scanner.nextInt();
        }
        System.out.println(freeDay(day,business,fitness));
    }

    private static int freeDay(int day, int[] business,int[] fitness){
        int[] workFitDay = new int[day];
        for (int i = 0; i< day; i ++){
            if(business[i] == fitness[i] && business[i] != 0){
                workFitDay[i] = 3;   // 3代表工作健身都可以
            } else if(business[i] < fitness[i]){
                workFitDay[i] = 2;  // 2代表只能健身
            } else if(business[i] > fitness[i]){
                workFitDay[i] = 1;  // 1代表只能工作
            } else {
                workFitDay[i] = 0;  // 休息日
            }
        }
        int result = 0;
        boolean isCanWork = true;
        boolean isCanFit = true;
        for(int i = 0; i < day; i++){
            if(workFitDay[i] == 0){
                result++;
                isCanWork = true;
                isCanFit = true;
            }
            // 工作日不能工作
            if(workFitDay[i] == 1 && !isCanWork){
                result++;
                isCanWork = true;
                isCanFit = true;
            }
            // 健身日不能工作
            if(workFitDay[i] == 2 && !isCanFit){
                result++;
                isCanWork = true;
                isCanFit = true;
            }
            // 既能健身又能工作
            if(workFitDay[i] == 3){
                // 能健身不能工作
                if(isCanFit && !isCanWork){
                    isCanFit = false;
                    isCanWork = true;
                } else if(isCanWork && !isCanFit){  // 能工作不能健身
                    isCanFit = true;
                    isCanWork = false;
                } else if(isCanWork && isCanFit){
                    // 看下一个
                    if(workOrFit(workFitDay,i) == 1){
                        isCanFit = true;
                        isCanWork = false;
                    } else if(workOrFit(workFitDay,i) == 2){
                        isCanFit = false;
                        isCanWork = true;
                    }
                }
            }
        }
        return result;
    }

    // 健身还是工作
    private static int workOrFit(int[] workFitDay, int index){
        // 第二天只能工作
        if(workFitDay[index + 1] == 1){
            return 2; // 只能健身
        } else if(workFitDay[index + 1] == 2){  // 第二天只能健身
            return 1; // 只能工作
        } else {
            return 1; // 随便选一个
        }
    }
}
