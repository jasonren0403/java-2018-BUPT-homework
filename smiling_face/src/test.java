/**
 * Draw a smiling face!
 * 尝试在窗体上画一张笑脸
 * @Date 2018.5.26
 * @author Jason
 */

import javax.swing.*;
import java.awt.*;

public class test {
    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame f = new SmilingFaceFrame();
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setTitle("A Smiling Face!");
                f.setVisible(true);
                f.setResizable(true);
            }
        });
    }
}