package coding.test;

import com.alibaba.fastjson.JSONObject;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2023/2/14 3:57 PM
 * @Version: 1.initial version; 2023/2/14 3:57 PM
 */
public class ScriptTest {
    public static void main(String[] args) throws AWTException {
        Robot robot = new Robot();
        int mask = InputEvent.BUTTON1_MASK;
//        // 打开音乐app
//        robot.mouseMove(1150, 1070);
//        robot.mousePress(mask);
//        robot.setAutoDelay(500);
//        robot.mouseRelease(mask);
//
//        // 播放音乐
//        robot.mouseMove(890, 880);
//        robot.mousePress(mask);
//        robot.setAutoDelay(500);
//        robot.mouseRelease(mask);


//        Rectangle rectangle = new Rectangle(0, 0, 100, 100);
//        BufferedImage screenCapture = robot.createScreenCapture(rectangle);
//        ColorModel colorModel = screenCapture.getColorModel();

        Color pixelColor = robot.getPixelColor(100, 150);
        System.out.println(JSONObject.toJSONString(pixelColor.getRGB()));
    }
}
