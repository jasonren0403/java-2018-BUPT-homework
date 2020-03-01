package com.ren.javapractice.smilingface;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

class SmilingFaceComponent extends JComponent {
    public static final int DEFAULT_WIDTH = 400;
    public static final int DEFAULT_HEIGHT = 400;
    //在计算好文字位置后将注释掉以下两行，大概是这两个数
    //public static final int MESSAGE_X=160;
    //public static final int MESSAGE_Y=350;

    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        //now draw the face...
        //start with the outer circle
        Ellipse2D e1 = new Ellipse2D.Double(100, 100, 200, 200);
        g2.setPaint(Color.YELLOW);
        g2.fill(e1);

        double centerX = e1.getCenterX();
        double centerY = e1.getCenterY();
        /* 辅助长方形
        System.out.println(centerX);
        System.out.println(centerY);
        Rectangle2D r=new Rectangle2D.Double(centerX-50,centerY-50,100,100);g2.setPaint(Color.BLACK);g2.draw(r);
        */
        //here come two eyes
        double eyeradius = 12;
        double spaces = 50;
        Ellipse2D eleft = new Ellipse2D.Double(centerX - spaces - 0.5 * eyeradius, centerY - spaces - 0.5 * eyeradius, 2 * eyeradius, 2 * eyeradius);
        g2.setPaint(Color.BLACK);
        g2.fill(eleft);
        Ellipse2D eright = new Ellipse2D.Double(centerX + spaces - 0.5 * eyeradius, centerY - spaces - 0.5 * eyeradius, 2 * eyeradius, 2 * eyeradius);
        g2.setPaint(Color.BLACK);
        g2.fill(eright);
        //g2.draw(eleft);g2.draw(eright);

        //and a big mouth!
        Arc2D m2 = new Arc2D.Double(150, 200, 100, 75, -180, 180, Arc2D.OPEN);
        g2.setPaint(Color.BLACK);
        g2.draw(m2);

        //now write the word...
        String message = "Smiling...";
        Font a = new Font("SansSerif", Font.ITALIC, 20);
        g2.setFont(a);
        g2.setPaint(Color.BLUE);

        //decide where to put the word
        FontRenderContext context = g2.getFontRenderContext();
        Rectangle2D bounds = a.getStringBounds(message, context);
        double x = (getWidth() - bounds.getWidth()) / 2;
        double y = (getHeight() - bounds.getWidth()) / 2;
        double baseY = y + (getHeight() >> 1);
        g2.drawString(message, (int) x, (int) baseY);
    }
}
