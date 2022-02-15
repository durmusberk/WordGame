

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class centerPanel extends JPanel{
    private JButton[][] buttons = new JButton[6][2];
    
    public centerPanel() {
    	this.setLayout(new GridLayout(6,2));
       // this.setBackground(Color.BLACK);
    	iconSetter();
        
    }
        public void iconSetter() {
        	
        	for(int i = 0; i < 6; i++){
                 for(int k = 0; k < 2; k++){
                     JButton button = new JButton();
                     button.setContentAreaFilled(false);
                     button.setBorderPainted(false);
                     button.setFocusPainted(false); 
                     button.setHorizontalTextPosition(JButton.CENTER);
                     button.setVerticalTextPosition(JButton.CENTER);
                     buttons[i][k] = button;
                     this.add(button);
                     
                 }
             }
        }
        
        public JButton getButton(int i,int j) {
        	return buttons[i][j];
        }
        
    
}
