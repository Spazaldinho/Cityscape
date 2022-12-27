import javax.swing.*;
import java.awt.*;

public class HappyFace {
	
	private int x = 0;
	private int y = 0;
	
	public HappyFace(int x, int y) {
		this.x = x + 100;
		this.y = y + 80;
	}
	
	public void paint(Graphics g){
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(new Color(68, 179, 125));
		g2d.fillOval(x + 100, y + 80, 20, 20);
		
		g2d.setColor(Color.DARK_GRAY);
		g2d.fillOval(x + 102, y + 82, 5, 10);
		g2d.fillOval(x + 110, y + 82, 5, 10);
	}

}
