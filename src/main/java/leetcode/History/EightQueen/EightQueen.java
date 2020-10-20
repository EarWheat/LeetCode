package leetcode.History.EightQueen;

import UtilClass.ShowArray;

/*
 * @author:liuzhaolu
 * @createTime: 2020-03-15 09:08
 * @desc:八皇后问题
 */
public class EightQueen extends ShowArray {
    public static void main(String[] args){
        int eight = 8;
        int[] queen = new int[eight];
        ShowArray(eightQueen(eight));
    }

    private static int[][] eightQueen(int eight){
        int[][] result = new int[eight][eight];
        for(int i = 0; i < eight; i++){
            // 确定第i行Q的位置

        }
        return result;
    }

    // 将斜线占满
    private static int[][] angela(int eight, int i, int j, int[][] result){
        result[i][j] = 1;
        // 8皇后问题，一共斜线7个
        // 右下斜线
        for(int p = i, q = j; p < eight - 1 && q < eight - 1; p++, q++){
           result[p + 1][q + 1] = 2;
        }
        // 左上斜线
        for(int p = i, q = j; p > 0 && q > 0; p--, q--){
            result[p - 1][q - 1] = 2;
        }
        // 左下斜线
        for(int p = i, q = j; p < eight - 1 && q > 0; p++, q--){
            result[p + 1][q - 1] = 2;
        }
        // 右上斜线
        for(int p = i, q = j; p > 0 && q >= 0 && q < eight - 1; p--, q++){
            result[p - 1][q + 1] = 2;
        }
        // 上下
        for (int k = 0; k < 8; k++) {
            if (k != i) {
                result[k][j] = 2;
            }
        }
        return result;
    }

    // 对于二位数组，如果i - j相等则右下斜对角相等
//    private static boolean check(int i, int[] Queen){
//        for(int j = 0; j < Queen.length; j ++){
//            if(i - j == Queen[])
//        }
//    }

}
