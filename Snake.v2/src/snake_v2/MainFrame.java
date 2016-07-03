package snake_v2;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame {

	private static JFrame frame;
	
	private static SnakePanel snakePanel;
	
	public static void main(String[] args) {
		
		setupFrame();
	}
	
	private static void setupFrame() {
		
		frame = new JFrame("Snake");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setVisible(true);
		
		setupGame();
		
		frame.pack();
		
	}
	
	private static void addGame(JPanel panel) {
		
		frame.setContentPane(panel);

	}
	
	private static void setupGame() {
		
		snakePanel = new SnakePanel();
		
		addGame(snakePanel);
		
	}
	
}
