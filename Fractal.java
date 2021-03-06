package /*package*/;

import javax.swing.*;
import java.awt.*;

public class Fractal {
    private static int x1 = 0, y1;
    private static int x2, y2;
    private static int x3, y3 = 0;
    private static int x, y;

    private static JFrame frame = new JFrame("fd70");

    static class MyCanvas extends Canvas {

        public void paint(Graphics g) {
            g.setColor(Color.LIGHT_GRAY);
            g.drawLine(x1, y1, x2, y2);
            g.drawLine(x2, y2, x3, y3);
            g.drawLine(x3, y3, x1, y1);
        }
    }
    private static void reinit() {
        y1 = frame.getHeight() - 40;
        x2 = frame.getWidth() - 15;
        y2 = frame.getHeight() / 2;
        x3 = frame.getWidth() / 3;
    }
    public static void main(String[] args) {

        MyCanvas canvas = new MyCanvas();
        frame.setSize(200,200);
        frame.add(canvas);
        frame.setVisible(true);

        while (true) {
            reinit();
            int goTo;
            goTo = (int) (Math.random() * 3 + 1);
            switch (goTo) {
                case 1: {
                    x = (int) (x + x1)/2;
                    y = (int) (y + y1)/2;
                    break;
                }
                case 2: {
                    x = (int) (x + x2)/2;
                    y = (int) (y + y2)/2;
                    break;
                }
                case 3: {
                    x = (int) (x + x3)/2;
                    y = (int) (y + y3)/2;
                    break;
                }
                default: System.out.println("smth wrong");
            }
            canvas.getGraphics().drawLine(x,y, x,y);
        }
    }
}
