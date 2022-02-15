import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class modeHandler implements ActionListener{
	private mainMenuPanel panel;
	private JButton gm1;
	private JButton gm2;
	private JButton gm3;
	private JButton gm4;
	private JButton gm5;
	private JLabel l;
	
	public modeHandler(mainMenuPanel panel,JLabel l, JButton gm1, JButton gm2, JButton gm3, JButton gm4, JButton gm5) {
		this.panel = panel;
		this.l = l;
		this.gm1 = gm1;
		this.gm2 = gm2;
		this.gm3 = gm3;
		this.gm4 = gm4;
		this.gm5 = gm5;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		gm1.setVisible(false);
		gm2.setVisible(false);
		gm3.setVisible(false);
		gm4.setVisible(false);
		gm5.setVisible(false);
		l.setVisible(false);
		
		panel.gameMode1();
		panel.repaint();
		panel.invalidate();
	}

}
