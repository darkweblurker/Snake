package snake_v2;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static java.lang.System.out;

public class Snake {
	
	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;
	
	private static final int COLOUR_ITERATIONS = 15;
	private static final int COLOUR_LIMIT = 255;
	
	private int currentRed=255, currentGreen=0, currentBlue=0;
	private int direction = 1;
	
	private boolean addSegment = false;
	
	private int score = 0;
	
	private Vector<SnakeSegment> snakeParts = new Vector<SnakeSegment>();
	
	private Point headPosision;
	
	Snake(Point startPosision) {

		this.headPosision = startPosision;
		out.print(startPosision.y);
		addSegment();
		move();
		addSegment();
		move();
		addSegment();
		move();
		
	}

	
		
	public void move() {
		
		switch(direction) {
		
		case 0:
			headPosision.y--;
			break;
		
		case 1:
			headPosision.x++;
			break;
			
		case 2:
			headPosision.y++;
			break;
			
		case 3:
			headPosision.x--;
			break;
		
		}
		
		
		if (headPosision.x >= SnakePanel.PANEL_WIDTH) {
			
			headPosision.x = 0;
			
		}
		
		if(headPosision.x < 0) {
			
			headPosision.x = SnakePanel.PANEL_WIDTH-1;
			
		}
		
		if (headPosision.y >= SnakePanel.PANEL_HEIGHT) {
			
			headPosision.y = 0;
			
		}
		
		if(headPosision.y < 0) {
			
			headPosision.y = SnakePanel.PANEL_HEIGHT-1;
			
		}
		
		addSegment();
		checkCollsision();
		discardLastSegment();
		
		addSegment = false;
		
	}
	
	public void checkCollsision() {
		for(int i = 0; i< snakeParts.size()- 1; i++) {
			if(headPosision.x == snakeParts.get(i).getX() && headPosision.y == snakeParts.get(i).getY()) {
			
			 	new GameOverPanel(score);
			
			}
		}
		if(snakeParts.firstElement().getX() == SnakePanel.getFood().getX() && snakeParts.firstElement().getY() == SnakePanel.getFood().getY()) {
			
			SnakePanel.createFood();
			
			score++;
			
			addSegment = true;
			
			
			
		}
		
	}
	

	
	public List<SnakeSegment> getSegments() {
		
		return snakeParts;
		
	}
	
	public int getSegmentCount() {
		
		return snakeParts.size();
		
	}
	
	public void addSegment() {
		
		snakeParts.addElement(new SnakeSegment(headPosision, currentRed, currentGreen, currentBlue));
		
		nextColour();
		
	}
	
	public void discardLastSegment() {
		if(!addSegment) {

			snakeParts.removeElement(snakeParts.firstElement());
			
		}
	}
	
	public void setDirection(int direction) {
		
		boolean changeDirection = true;
		
		if(this.direction <= 1 && direction == this.direction + 2) {
		
		changeDirection = false;
		
		} else if((this.direction == 3 && direction == 1) ||( this.direction == 2 && direction == 0)) {
			
			changeDirection = false;
			
			
		}
		
		if(changeDirection) {
			
			this.direction = direction;
			
		}
		
	}
	
	public void nextColour() {
		
		if(currentRed == COLOUR_LIMIT && currentGreen < COLOUR_LIMIT && currentBlue == 0) {
			
			increaseGreen();
			
		}
		
		if(currentRed > 0 && currentGreen == COLOUR_LIMIT && currentBlue == 0) {
			
			decreaseRed();
			
		}
		
		if(currentRed == 0 && currentGreen == COLOUR_LIMIT && currentBlue < COLOUR_LIMIT) {
			
			increaseBlue();
			
		}
		
		if(currentRed == 0 && currentGreen > 0 && currentBlue == COLOUR_LIMIT) {
			
			decreaseGreen();
			
		}
		
		if(currentRed < COLOUR_LIMIT && currentGreen == 0 && currentBlue == COLOUR_LIMIT) {
			
			increaseRed();
			
		}
		
		if(currentRed == COLOUR_LIMIT && currentGreen == 0 && currentBlue > 0) {
			
			decreaseBlue();
			
		}
		
		
	}
	


	public void increaseGreen() {
		
		currentGreen = currentGreen + COLOUR_ITERATIONS;
		
	}
	
	public void decreaseRed() {
		
		currentRed = currentRed - COLOUR_ITERATIONS;
		
	}
	
	private void increaseBlue() {

		currentBlue = currentBlue + COLOUR_ITERATIONS;
		
	}
	
	public void decreaseGreen() {
		
		currentGreen = currentGreen - COLOUR_ITERATIONS;
		
	}
	
	public void increaseRed() {
		
		currentRed = currentRed + COLOUR_ITERATIONS;
		
	}
	
	private void decreaseBlue() {

		currentBlue = currentBlue - COLOUR_ITERATIONS;
		
	}

	
}
