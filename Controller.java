// Jordan Lyle, 9/24/2022, Controller.java for Assignment 3

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

class Controller extends JPanel implements ActionListener, MouseListener, KeyListener
{
	boolean keyLeft;
	boolean keyRight;
	boolean keyUp;
	boolean keyDown;
	View view;
	Model model;
	int scrollContPos = 0;
	Controller(Model m)
	{
		model = m;
	}

	void setView(View v)
	{
    	view = v;
	}

	void setModel(Model m)
	{
		model = m;
	}

	public void mousePressed(MouseEvent e)
	{
		int count = 0;
		for(int i = 0; i < model.pipes.size(); i++)
		{
			Pipe p = model.pipes.get(i);
			if (p.onUserClickLocation(e.getX() + scrollContPos, e.getY()) == 10)
			{
				count = 1;
				model.pipes.remove(p);
			}
			else if (p.onUserClickLocation(e.getX() + scrollContPos,e.getY()) == 5)
			{
				count = 1;
			}
		}
		if (count == 0)
		{
			Pipe p = new Pipe(e.getX() + scrollContPos, e.getY());
			model.pipes.add(p);
		}
	}

	public void mouseReleased(MouseEvent e) {    }
	public void mouseEntered(MouseEvent e) {    }
	public void mouseExited(MouseEvent e) {    }
	public void mouseClicked(MouseEvent e) {    }

	public void keyPressed(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_RIGHT: keyRight = true; break;
			case KeyEvent.VK_LEFT: keyLeft = true; break;
			case KeyEvent.VK_UP: keyUp = true; break;
			case KeyEvent.VK_DOWN: keyDown = true; break;

		}

		if (((e.getKeyCode()) == (KeyEvent.VK_ESCAPE)) || ((e.getKeyCode()) == (KeyEvent.VK_Q)))
		{
			System.exit(0);
		}

		if (e.getKeyCode() == KeyEvent.VK_S)
		{
			model.marshal();
		}

		if (e.getKeyCode() == KeyEvent.VK_L)
		{
			Json ob = Json.newObject();
			model = new Model(ob);
			setModel(model);
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_RIGHT: keyRight = false; break;
			case KeyEvent.VK_LEFT: keyLeft = false; break;
			case KeyEvent.VK_UP: keyUp = false; break;
			case KeyEvent.VK_DOWN: keyDown = false; break;
		}
	}

	public void keyTyped(KeyEvent e)
	{
	}

	void update()
	{
		if(keyRight) 
		{
			scrollContPos += 4;
		}
		if(keyLeft) 
		{
			scrollContPos -= 4;
		}
		if(keyDown) 
		{
		}
		if(keyUp) 
		{
		}
	}

	public void actionPerformed(ActionEvent e)
	{
	}
}
