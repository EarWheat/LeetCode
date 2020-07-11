package leetcode.findInMountainArray;

/*
 * @author:liuzhaolu
 * @createTime: 2020-04-29 09:32
 * @desc:
 */
public class MountainArr implements MountainArray{
    public int[] array;

    public int get(int index) {
        return array[index];
    }

    public int length() {
        return array.length;
    }

    MountainArr(int[] array){
        this.array = array;
    }


}
