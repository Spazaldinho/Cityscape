import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.*;
import java.awt.*;


public class car {

    public int width = 110;
    public int height = 40;
    private int xSpeed = 3;
    public int x = 0;
    public int y = main.frameHeight - 2*height;
    private boolean direction = true;
    private BufferedImage img = null;
    public boolean trapped = false;
    public boolean visible = true;

    //okokokok

    public car () {
        try {
            img = ImageIO.read(new File("B:\\My Documents\\Downloads\\LastDayInClass\\Graphics\\Graphics\\GraphicsTrolling\\car.png"));
        } catch (IOException e) { 
            System.out.println("No Image");
        }
    }

    public void paint(Graphics g) {
        if (visible) {
            if (direction) {    
                g.drawImage(this.img, x, y, width, height, null);
            } else {
                g.drawImage(this.img, x + width, y, -1 * width, height, null);
            }
        }
    }
    
    public void move() {

        if(x + xSpeed < 0) {
            xSpeed = 3;
            direction = true;
        }
        if(x + xSpeed > main.frameWidth - 135) {
            xSpeed = -3;
            direction = false;
        }
        if (!trapped) {
        x += xSpeed;
        }

    }

}
