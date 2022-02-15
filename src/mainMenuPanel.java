import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class mainMenuPanel extends JPanel {
	
	private JFrame frame;
	private JLabel gameLabel = new JLabel("Kelime Oyunu");
	private JButton b1;
	private JButton b2;
	private JButton b3;
	
	public mainMenuPanel(JFrame main) {
		this.frame = main;
		this.setLayout(null);
		gameLabel.setBounds(150, 75, 100, 50);
		b1 = new JButton();
		b1.setBounds(150, 200, 90, 90);
		b1.setText("Oyna");
		b2 = new JButton();
		b2.setBounds(150, 300, 90, 90);
		b2.setText("Ayarlar");
		b3 = new JButton();
		b3.setBounds(150, 400, 90, 90);
		b3.setText("Çıkış");
		

		this.add(gameLabel);
		this.add(b1);
		this.add(b2);
		this.add(b3);
		
		
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				b1.setVisible(false);
				
			
				b2.setVisible(false);
				
				b3.setVisible(false);
				
				
				gameModes();
				
			}
			
			
			
		});
		
		b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
			
			
			
		});
		
		
		
	}
	public void gameMode1() {
		
		infopanel infoPanel = new infopanel(this);
		centerPanel center = new centerPanel();
		JPanel bottom = new bottomPanel(center,infoPanel);
    
	    frame.add(infoPanel, BorderLayout.NORTH);
	    frame.add(bottom, BorderLayout.SOUTH);
	    frame.add(center, BorderLayout.CENTER);
	    
	    bottom.revalidate();
	    bottom.repaint();
	    
	    center.revalidate();
	    center.repaint();
        
	}
	public void gameModes() {
		JButton gm1 = new JButton("Mod1");
		JButton gm2 = new JButton("Mod2");
		JButton gm3 = new JButton("Mod3");
		JButton gm4 = new JButton("Mod4");
		JButton gm5 = new JButton("Geri");
		
		
		gm1.setBounds(100, 200, 100, 100);
		
		gm1.addActionListener(new modeHandler(this,gameLabel, gm1, gm2, gm3, gm4, gm5));
		gm2.setBounds(200, 200, 100, 100);
		gm3.setBounds(100, 300, 100, 100);
		gm4.setBounds(200, 300, 100, 100);
		gm5.setBounds(300, 480, 70, 70);
		
		this.add(gm1);
		this.add(gm2);
		this.add(gm3);
		this.add(gm4);
		this.add(gm5);
		
		
		gm5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gm1.setVisible(false);
				gm2.setVisible(false);
				gm3.setVisible(false);
				gm4.setVisible(false);
				gm5.setVisible(false);
				
				b1.setVisible(true);
				
				
				b2.setVisible(true);
				
				b3.setVisible(true);
				
				
			}
		});
		
		this.repaint();
		this.invalidate();
	}
	
	
}
