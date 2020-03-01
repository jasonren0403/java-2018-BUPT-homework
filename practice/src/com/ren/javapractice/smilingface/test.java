package com.ren.javapractice.smilingface;
import javax.swing.*;
import java.awt.*;

/**
 * Draw a smiling face!
 * 尝试在窗体上画一张笑脸
 *
 * @author Jason
 * @Date 2018.5.26
 */


public class test {
    public static void main(String[] args) {
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