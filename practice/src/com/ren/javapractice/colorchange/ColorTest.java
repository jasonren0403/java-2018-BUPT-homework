package com.ren.javapractice.colorchange;

import javax.swing.*;
import java.awt.*;

/**
 * 编程实现以下功能:
 * 当点击不同的按钮时,圆的填充颜色会随之改变;
 * 用鼠标点击圆内部时,圆的 填充颜色会依照”面板背景色-红色-绿色-蓝色”循环改变;
 * 鼠标移到圆内时,光标变成十字形;
 */


public class ColorTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame f = new ColorTestFrame();
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setVisible(true);
            }
        });
    }
}
