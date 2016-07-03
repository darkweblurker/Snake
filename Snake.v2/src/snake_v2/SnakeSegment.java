package snake_v2;

import java.awt.Point;
import java.awt.Rectangle;

public class SnakeSegment {

	private final static byte SEGMENT_SIZE = 40;
	private final Rectangle segment;
	private final int x, y;
	private final int r, g, b;
	
	
	
	SnakeSegment(Point p, int r, int g, int b) {
		
		this.r = r;
		this.g = g;
		this.b = b;
		
		this.x = p.x;
		this.y = p.y;
		
		segment = new Rectangle(x*SEGMENT_SIZE, y*SEGMENT_SIZE, SEGMENT_SIZE, SEGMENT_SIZE);
		
	}
	
	public Rectangle getBounds() {
		System.out.println(x*SEGMENT_SIZE);
		return segment;
		
	}
	
	public int getRed() {
		
		return r;
		
	}
	
	public int getGreen() {
		
		return g;
		
	}

	public int getBlue() {
	
	return b;
	
	}
	
	public int getX() {
		
		return x;
		
	}
	
	public int getY() {
		
		return y;
		
	}
	
}
