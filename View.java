// Jordan Lyle, 9/24/2022, View.java for Assignment 3

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import javax.swing.JButton;
import java.awt.Color;

class View extends JPanel
{
	BufferedImage pipe_image;
	Model model;
	Controller controller;
	int scrollPos = 0;

	View(Controller c, Model m)
	{
		model = m;
		controller = c;
		try
		{
			this.pipe_image = ImageIO.read(new File("pipe.png"));
		}
		catch(Exception e)
		{
			e.printStackTrace(System.err);
			System.exit(1);
		}
		c.setView(this);
		scrollPos = controller.scrollContPos;
	}

	void setModel(Model m)
	{
		model = m;
	}
	
	public void paintComponent(Graphics g)
	{
		setModel(controller.model);
		scrollPos = controller.scrollContPos;
		g.setColor(new Color(128, 255, 255));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		for(int i = 0; i < model.pipes.size(); i++)
		{
			Pipe p = model.pipes.get(i);
			g.drawImage(pipe_image, p.x - scrollPos, p.y, null);
		}
	}
}
