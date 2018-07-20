package lab3;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.Random;

class MyPanel extends JPanel
{
	Random rand = new Random();

	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(5f));
		g2.setRenderingHint(
				RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		for (int i = 0; i < 12; i++)
		{
			g2.setColor(new Color(rand.nextInt(0x00FFFFFF)));
			int x = rand.nextInt(getWidth() / 2);
			int y = rand.nextInt(getHeight() / 2);
			int w = rand.nextInt(getWidth() - x + 1);
			int h = rand.nextInt(getHeight() - y + 1);
			Shape shape = null;
			switch (rand.nextInt(3))
			{
				case 0:
					shape = new Ellipse2D.Float(x, y, w, h);
					break;
				case 1:
					shape = new Rectangle(x, y, w, h);
					break;
				case 2:
					shape = new Line2D.Float(
							rand.nextInt(getWidth()), rand.nextInt(getHeight()),
							rand.nextInt(getWidth()), rand.nextInt(getHeight()));
					break;
			}
			g2.draw(shape);
		}
	}
}

public class DrawTest extends JFrame
{
	public DrawTest()
	{
		super("DrawTest");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(400, 400);
		JPanel panel = new MyPanel();
		panel.setLayout(null);
		setContentPane(panel);
		setVisible(true);
	}

	public static void main(String[] args)
	{
		new DrawTest();
	}
}
