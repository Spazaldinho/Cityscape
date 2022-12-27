import javax.swing.*;
import java.awt.*;

public class Background {

    private int x;
    private int y;

    public Background(int frameWidth, int frameHeight) {

        this.x = frameWidth;
        this.y = frameHeight;

    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(new Color(32, 23, 71));
        g2d.fillRect(0, 0, x, y);;
    }
    
}
