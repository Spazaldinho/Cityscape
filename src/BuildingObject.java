import javax.swing.*;
import java.awt.*;

public class BuildingObject {
	private int x = 0;
	private int y = 0;
	private int w = 140;
	private int h = 0;
	public final int yValue;
	
	public BuildingObject(int x, int y) {
		
		this.x = x;
		this.y = y;
		this.h = 640 - y;
		yValue = y;
		
	}
	
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(new Color(67, 49, 102));
		g2d.fillRect(x, y, w, h);
		
	}

}
