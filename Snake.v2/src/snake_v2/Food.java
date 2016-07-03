package snake_v2;

import java.awt.Rectangle;
import java.util.Random;

public class Food {

	private final int X, Y;
	
	private static int FOOD_SIZE = 20;
	private static int GAP = (SnakePanel.GRID_SIZE - FOOD_SIZE)/2;
	
	Food() {
		
		Random r = new Random();
		
		X = r.nextInt(SnakePanel.PANEL_WIDTH);
		Y = r.nextInt(SnakePanel.PANEL_HEIGHT);
	
	
	}
	
	public Rectangle getBounds() {
		
		return new Rectangle(SnakePanel.GRID_SIZE*X + GAP, SnakePanel.GRID_SIZE*Y + GAP, FOOD_SIZE, FOOD_SIZE);
		
	}
	
	public int getX() {
		
		return X;
		
	}
	
	public int getY() {
		
		return Y;
		
	}
	
}
