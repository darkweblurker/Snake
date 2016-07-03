package snake_v2;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameOverPanel{

	GameOverPanel(int score) {
		
		JOptionPane.showMessageDialog(null,"Score:"+score*10,"Game Over!",JOptionPane.INFORMATION_MESSAGE);
		
		System.exit(0);
		
	}
	
}
