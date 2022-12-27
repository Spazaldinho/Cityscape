import javax.swing.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class main extends JPanel{

	public static int frameWidth = 1020;
	public static int frameHeight = 640;
	private int buildingWidth = 140;
	public static int i = 0;
	private int increment = 160;
	private int startingPoint = 20;
	
	private BuildingObject b1 = new BuildingObject(startingPoint, 240);
	private windows first = new windows(startingPoint, b1.yValue);
	private BuildingObject b2 = new BuildingObject(startingPoint + (i*increment), 320);
	private windows second = new windows(startingPoint + (i*increment), b2.yValue);
	private BuildingObject b3 = new BuildingObject(startingPoint + (i*increment), 280);
	private windows third = new windows(startingPoint + (i*increment), b3.yValue);
	private BuildingObject b4 = new BuildingObject(startingPoint + (i*increment), 360);
	private windows fourth = new windows(startingPoint + (i*increment), b4.yValue);
	private BuildingObject b5 = new BuildingObject(startingPoint + (i*increment), 320);
	private windows fifth = new windows(startingPoint + (i*increment), b5.yValue);
	private BuildingObject b6 = new BuildingObject(startingPoint + (i*increment), 280);
	private windows sixth = new windows(startingPoint + (i*increment), b6.yValue);
	private Background bckd = new Background(frameWidth, frameHeight);
	private UFO[] list = new UFO[4];
	private car cars = new car();

	
	public main() {
		for (int i = 0; i< list.length; i++)
		list[i] = new UFO((int)(600 * Math.random() - 5), (int)(350 * Math.random() - 5));

		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {
			list[0].keyReleased(e);
			}
			@Override
			public void keyPressed(KeyEvent e) {
			list[0].keyPressed(e);
			}
			});
			setFocusable(true);
	}

	
	@Override
	public void paint(Graphics g) {
		super.paint(g);

		Graphics2D g2d = (Graphics2D) g;

		bckd.paint(g2d);
		b1.paint(g2d);
		first.paint(g2d);
		b2.paint(g2d);
		second.paint(g2d);
		b3.paint(g2d);
		third.paint(g2d);
		b4.paint(g2d);
		fourth.paint(g2d);
		b5.paint(g2d);
		fifth.paint(g2d);
		b6.paint(g2d);
		sixth.paint(g2d);	

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
		for (UFO a:list) {
			a.paint(g2d);
		}

		cars.paint(g);
	}

	public void move() {
		
		for (int i = 0; i < list.length; i++) {
			for (int j = i+1; j<list.length; j++) {
				list[i].collision(list[j]);
			}
		}
		for (UFO a:list) {
			a.move();
		}
		cars.move();
		
		if(cars.y <= 560) {
			cars.y += 7;
		} else {
			cars.trapped = false;
		}

		carnapped(list[0], cars);

    }

	public void carnapped(UFO u, car c) {

		boolean touching = (u.x + 35 <= cars.x + cars.width) && (u.x + 185 >= cars.x);

		if (c.y <= u.y + 200) {
			c.visible = false;
		}

		if (u.beam && touching) {
            c.trapped = true;
			if (c.y > u.y + 200) {
				c.y -= 10;
			}
        }
	}

	public static void main(String[] args) throws InterruptedException{
		JFrame frame = new JFrame("Zain's Cityscape");
		main test = new main();
		frame.setSize(frameWidth, frameHeight);
		frame.setVisible(true);
		frame.add(test);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		while (true) {
			test.move();
			test.repaint();
			Thread.sleep(10);
		}
	}
	
}
