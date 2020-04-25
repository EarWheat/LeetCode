package UtilClass;

/*
 * @author:liuzhaolu
 * @createTime: 2020-03-11 15:36
 * @desc:
 */
public class ShowArray {

    public static void ShowArray(int[][] array){
//        System.out.println("array length:" + array.length);
//        System.out.println("array[0] length:" + array[0].length );
        for(int i = 0; i < array.length; i++){
            for (int j = 0; j < array[0].length; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
