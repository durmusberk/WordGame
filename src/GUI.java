
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI {
	private static JFrame mainFrame;
	
	public static void main(String[] args) {
    
		mainFrame = new JFrame("Kelime Oyunu");
        ImageIcon bg = new ImageIcon("icons//arkaplan.jpg");
          /*Background
          JLabel label = new JLabel(bg);
          mainFrame.add(label, BorderLayout.CENTER);
          */
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(400,600);
		mainFrame.setVisible(true);
        mainFrame.setLocationRelativeTo(null);
		//mainFrame.setLayout(new BorderLayout());
		ImageIcon icon = new ImageIcon("icons//icon.png");
		mainFrame.setIconImage(icon.getImage());
		mainMenuPanel panel = new mainMenuPanel(mainFrame);
		mainFrame.add(panel, BorderLayout.CENTER);
	    mainFrame.setVisible(true);

}
	
	

}

