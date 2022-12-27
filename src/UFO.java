import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UFO {

    public int x = 0;
    public int y = 0;
    private int xBound = 3;
    private int yBound = 1;
    private HappyFace alien;
    private int max = 254;
    private int min = 0;
    public boolean right = false, left = false, up = false, down = false, beam = false, ghosting = false;

    public UFO(int x, int y) {
        this.x = x;
        this.y = y;
        alien = new HappyFace(x, y);
    }

    public Color randomColor() {
        int R = (int) Math.floor(Math.random() * (max + 1));
        int B = (int) Math.floor(Math.random() * (max + 1));
        int C = (int) Math.floor(Math.random() * (max + 1));
        return new Color(R, B, C);
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;


        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fillOval(x + 95, y + 75, 30, 40);

        g2d.setColor(randomColor());
        g2d.fillOval(x + 100, y + 80, 20, 20);

        g2d.setColor(Color.BLACK);
        g2d.fillOval(x + 102, y + 82, 5, 10);
        g2d.fillOval(x + 110, y + 82, 5, 10);

        g2d.setColor(Color.gray);
        g2d.fillOval(x + 70, y + 100, 80, 20);

        if (beam) {
            g2d.setColor(new Color(0.2f,1f,0.4f,0.3f));
            g2d.fillArc(x + 35 , y + 110, 150, 1200, 0, 180);
        }
    }

    public void move() {

        if(x + xBound < -75) {xBound = 3;}
        if(x + xBound > main.frameWidth - 135) {xBound = -3;}

        if(y + yBound < -60) {yBound = 1;}
        if(y + yBound > main.frameHeight - 535) {yBound = -1;}

        x += xBound;
        y += yBound;

    }

    public void collision(UFO a) {

        if(!ghosting) {
            int dx = (x-a.x) + (xBound-a.xBound);
            int dy = (y-a.y) + (yBound-a.yBound);
            //if the balls collide...
            if (Math.sqrt(dx*dx+dy*dy)<=55) {
                //switch velocities
                int tempxa = xBound;
                int tempya = yBound;
                xBound = a.xBound;
                yBound = a.yBound;
                a.xBound = tempxa;
                a.yBound = tempya;
            }
        }

    }

    public void keyPressed(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_A){
            left = true;
            xBound = -5;
        }
        if (e.getKeyCode() == KeyEvent.VK_D){
            right = true;
            xBound = 5;
        }
        if (e.getKeyCode() == KeyEvent.VK_W){
            up = true;
            yBound = -5;
        }
        if (e.getKeyCode() == KeyEvent.VK_S){
            down = true;
            yBound = 5;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            beam = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_G){
            ghosting = !ghosting;
        }
    }

    public void keyReleased(KeyEvent e){

        if (e.getKeyCode() == KeyEvent.VK_A){
            left = false;
            xBound=0;
        }
        if (e.getKeyCode() == KeyEvent.VK_D){
            right = false;
            xBound=0;
        }
        if (e.getKeyCode() == KeyEvent.VK_W){
            up = false;
            yBound=0;
        }
        if (e.getKeyCode() == KeyEvent.VK_S){
            down = false;
            yBound=0;
            }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            beam = false;
        }

    }
        
}
