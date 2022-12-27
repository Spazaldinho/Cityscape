import java.awt.*;
import javax.swing.*;

public class windows {

    private int buildingX;
    private int buildingY;
    private int buildingHeight;
    private int spacing = 8;
    private int side = 25;
    private int yDifference = 9;
    private boolean status = true;
    private boolean[][] light;
    
    public boolean lightOn() {
        int x = (int) Math.floor(Math.random() * (12));
        return x % 2 == 0;
    }

    public windows(int bx, int by) {
        buildingX = bx;
        buildingY = by;
        buildingHeight = 640 - by;
        yDifference = (buildingHeight - 100) / 30;
        main.i++;
        light = new boolean[4][yDifference];
    }

    
    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        for (int j = 0; j < yDifference; j++) {

            for (int i = 0; i < 4; i++) {

                if(status) {
                    if (lightOn()) {
                        g2d.setColor(Color.yellow);
                        light[i][j] = true;
                    } else {
                        g2d.setColor(Color.gray);
                        light[i][j] = false;
                    }
                } else {
                    if (light[i][j]) {
                        g2d.setColor(Color.yellow);
                    } else {
                        g2d.setColor(Color.gray);
                    }
                }
                g2d.fillRect(buildingX + (side*i) + (spacing * (i + 1)), buildingY + (side * j) + (spacing * (j + 1)), side, side);
            }
        }
        status = false;
    }
}
    

