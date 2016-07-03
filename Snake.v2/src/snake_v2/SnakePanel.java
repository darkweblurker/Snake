package snake_v2;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Action;

public class SnakePanel extends JPanel implements ActionListener, KeyListener{

	Timer time;
	
	public static int PANEL_HEIGHT = 20;
	public static int PANEL_WIDTH = 20;
	public static int GRID_SIZE = 40;
	
	public boolean changeState = false;
	
	static Food food;
	static Snake snake;
	
	public SnakePanel() {
		
		time = new Timer(40, this);
		time.start();
		
		addKeyListener(this);
		setFocusable(true);
		
		createFood();
		createSnake();
		setupKeyBindings();
		
		setPreferredSize(new Dimension(PANEL_HEIGHT * GRID_SIZE, PANEL_WIDTH* GRID_SIZE));
		
		
	}
	
	private void createSnake() {
		
		snake = new Snake(new Point(PANEL_WIDTH/2, PANEL_HEIGHT/2));
		
	}
	
	public static Food getFood() {
		
		return food;
		
	}
	
	public static void createFood() {
		
		food = new Food();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		changeState = false;
		snake.move();
		
		requestFocus();
		repaint();

	}
	
	
	public void paint(Graphics g) {
		
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		super.setBackground(Color.BLACK);
		
		for(int i = 0; i< snake.getSegmentCount(); i++) {
			
		g2d.setColor(new Color(snake.getSegments().get(i).getRed(), snake.getSegments().get(i).getGreen(), snake.getSegments().get(i).getBlue()));
		
			g2d.setStroke(new BasicStroke(3));;
			g2d.draw(snake.getSegments().get(i).getBounds());
		
		}
		
		g2d.setColor(Color.GREEN);
		
		g2d.draw(food.getBounds());;
		
	}
	
	public void setupKeyBindings() {
		
		this.getInputMap().put(KeyStroke.getKeyStroke("w"),
                "w");

		this.getActionMap().put("w",
                 new UpAction());

		
	}

	
	@Override
	public void keyPressed(KeyEvent e) {
		
		if(!changeState) {
			if(e.getKeyCode() == KeyEvent.VK_W) {
			
				snake.setDirection(Snake.NORTH);
				changeState = true;
			}
		
			if(e.getKeyCode() == KeyEvent.VK_D) {
				
				snake.setDirection(Snake.EAST);
				changeState = true;
			}
	
			if(e.getKeyCode() == KeyEvent.VK_S) {
		
				snake.setDirection(Snake.SOUTH);
				changeState = true;
			}
	
			if(e.getKeyCode() == KeyEvent.VK_A) {
		
				snake.setDirection(Snake.WEST);
				changeState = true;
			}
		
			
			
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}
	
	public static Snake getSnake() {
		
		return snake;
		
	}
	
}
