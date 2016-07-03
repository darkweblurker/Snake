package snake_v2;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class UpAction extends AbstractAction{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		SnakePanel.getSnake().setDirection(1);
		
		System.out.println("ff");
		
	}

}
