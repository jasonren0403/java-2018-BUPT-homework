package com.ren.javapractice.colorchange;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

/**
 * AWT Event handling
 *
 * @author Jason
 * @Date 2018.6.26
 */


public class ColorTestFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 400;

    public ColorTestFrame() {
        this.setTitle("ColorTest");
        this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        this.setVisible(true);

        add(new ColorTestPanel());
    }
}

class ColorTestPanel extends JPanel {
    private Ellipse2D circle;
    //private JButton RedButton, GreenButton, BlueButton;
    private Color color = getBackground();  //背景色
    private Color color2 = Color.BLACK;     //前景色

    public ColorTestPanel() {
        JButton RedButton = new JButton("Red");
        JButton GreenButton = new JButton("Green");
        JButton BlueButton = new JButton("Blue");

        add(RedButton);
        add(GreenButton);
        add(BlueButton);

        ColorAction redAction = new ColorAction(Color.RED);
        ColorAction greenAction = new ColorAction(Color.GREEN);
        ColorAction blueAction = new ColorAction(Color.BLUE);

        RedButton.addActionListener(redAction);
        BlueButton.addActionListener(blueAction);
        GreenButton.addActionListener(greenAction);

        this.addMouseListener(new MouseHandler());
        this.addMouseMotionListener(new MouseMotionHandler());
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        circle = new Ellipse2D.Double(100 , 100 , 200 , 200);
        if (color2 == Color.BLACK && color == getBackground()) {
            g2.setPaint(color2);
            g2.draw(circle);
            g2.setPaint(color);
            g2.fill(circle);
        } else {
            g2.setPaint(color2);
            g2.fill(circle);
        }
    }

    public boolean find(Point2D p) {
        return circle.contains(p.getX() , p.getY());
    }

    public void setColor(Color c) {
        if (c == Color.BLACK) {
            color = getBackground();
        } else {
            color = c;
        }
        color2 = c;
        repaint();
    }

    class ColorAction implements ActionListener {
        private Color to_fill;

        public ColorAction(Color c) {
            to_fill = c;
        }

        public void actionPerformed(ActionEvent event) {
            setColor(to_fill);
        }
    }

    private class MouseHandler extends MouseAdapter {
        private int clickCount = 0;

        public void mouseClicked(MouseEvent event) {
            if (find(event.getPoint())) {
                clickCount++;
                switch (clickCount % 4) {
                    case 0: {
                        setColor(Color.BLACK);
                        break;
                    }
                    case 1: {
                        setColor(Color.RED);
                        break;
                    }
                    case 2: {
                        setColor(Color.GREEN);
                        break;
                    }
                    case 3: {
                        setColor(Color.BLUE);
                        break;
                    }
                }
            }
        }
    }

    private class MouseMotionHandler extends MouseMotionAdapter {
        public void mouseMoved(MouseEvent event) {
            Point2D p = event.getPoint();
            if (!find(p)) setCursor(Cursor.getDefaultCursor());
            else setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        }
    }
}





