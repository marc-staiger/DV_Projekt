import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Canvas extends JPanel 
{
	private static final long serialVersionUID = 1L;
	
	private int width = 500;
	private int height = 400;
	
	private BufferedImage logo;
	
	Canvas()
	{
		this.setBackground(Color.WHITE);
		try 
		{
		    logo = ImageIO.read(new File("HFU-Logo.png"));
		} 
		catch (Exception e) { e.printStackTrace(); }
	}
	
	@Override
    public Dimension getPreferredSize() {
		return new Dimension(this.width, this.height);
    }

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//--- draw rocket ---//
		int x = 300;
		int y = 75-Runner.count*2;
		int w = 50;
		int h = 250;

		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(x, y, w, h);
		g.setColor(new Color(150,0,0));
		g.fillPolygon(new int[]{x, x+w, x+w/2}, new int[]{y,y, y-70}, 3);
		g.setColor(Color.GRAY);
		g.fillPolygon(new int[]{x, x-30, x}, new int[]{y+h,y+h, y+h-70}, 3);
		g.fillPolygon(new int[]{x+w, x+w+30, x+w}, new int[]{y+h,y+h, y+h-70}, 3);
		g.setColor(Color.ORANGE);
		g.fillPolygon(new int[]{x+15, x+w-15, x+w/2}, new int[]{y+h,y+h, y+h+70}, 3);
		g.setColor(new Color(100, 149, 237));
		g.fillOval(x+w/2-15, y+15, 30, 30);
		g.fillOval(x+w/2-15, y+55, 30, 30);
		g.fillOval(x+w/2-15, y+95, 30, 30);
		
		//--- draw logo ---//
		g.drawImage(this.logo, 0,0, this.logo.getWidth(), this.logo.getHeight(), null);
		
		//--- draw counter ---//
		g.setFont(new Font("Arial", Font.PLAIN, 20));
		g.drawString(Runner.count+"x", this.width-60, this.height-10);
	}
}
