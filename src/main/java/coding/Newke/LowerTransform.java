package coding.Newke;

import java.util.Arrays;

/**
 * @author ：liuzhaolu
 * @description：TODO
 * @prd :
 * @date ：2021/12/1 11:26 上午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2021/12/1 11:26 上午     liuzhaolu       firstVersion
 */
public class LowerTransform {
    public static void main(String[] args) {
        String input = "heLLo   WoRld   !  ";
        // 输入的字符串，就是你的b
        char[] inputChars = input.toCharArray();
        // 输出的字符串，就是你的a
        char[] outputChars = new char[inputChars.length];
        // step1:先小写
        for (int i = 0; i < inputChars.length; i++) {
            // 大写的话转小写
            if(inputChars[i] >= 'A' && inputChars[i] <= 'Z'){
                // 用中间变量存变化
                char temp = (char) (inputChars[i] - ('A' - 'a'));
                outputChars[i] = temp;
            }
            // 本身就是小写的话直接赋值
            else {
                outputChars[i] = inputChars[i];
            }
        }
        // 输出是hello   world   !
        System.out.println(Arrays.toString(outputChars));
        // step2：首字母大写；
        // 先定义为true，因为第一个字母如果是字母直接大写
        boolean flag = true;
        // 这里遍历的是输出数组，因为现在只有输出数组是全小写
        for (int i = 0; i < outputChars.length; i++) {
            // 可以大写，且大写的不是空格，是字母，则大写
            if(flag && outputChars[i] != ' ' && outputChars[i] >= 'a' && outputChars[i] <= 'z'){
                outputChars[i] -= 'a' - 'A';
                // 大写完之后flag立即置为false，因为只大写一个字母。
                flag = false;
            }
            // 遇到空格flag置为true；
            else if(outputChars[i] == ' '){
                flag = true;
            }
        }
        // 输出是Hello   World   !
        System.out.println(Arrays.toString(outputChars));
        // step3:取掉空格
        // 再起一个真正的输出数组，这里本质上是可以直接操作outputChars（a）数组的，但是目前来说理解比较困难，就新建一个数组，再做一层转换
        char[] realOutPut = new char[outputChars.length];
        int i = 0;
        int j = 0;
        while (i < outputChars.length){
            // 如果是空格直接跳过
            if(outputChars[i] == ' '){
                // 注意这里，因为是空格，所以realOutPut的j是不需要移动的，而outputChars是需要移动的
                i++;
            }
            // 如果不是空格则复制
            else {
                realOutPut[j] = outputChars[i];
                // 注意这里，j永远指向的是realOutPut数组，每次赋值，outputChars和realOutPut都需要移动
                j++;
                i++;
            }
        }
        // 输出是HelloWorld!
        System.out.println(Arrays.toString(realOutPut));
    }
}
