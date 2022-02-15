import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class infopanel extends JPanel {
  private int beginning = 0;
  private static int TIME = 300;
  private JLabel timeLabel = new JLabel(""+TIME);
  private static Timer timer = new Timer();
  private JButton mainMenuButton = new JButton();
  private JLabel score = new JLabel();
  private mainMenuPanel mainMenu;

  ImageIcon icon = new ImageIcon("icons//resizedIcon.png");
  
  public infopanel(mainMenuPanel mainMenuPanel) {
        this.mainMenu = mainMenuPanel;
	  	mainMenuButton.setIcon(icon);
        mainMenuButton.setBorderPainted(false); 
        mainMenuButton.setContentAreaFilled(false); 
        mainMenuButton.setFocusPainted(false); 
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 80, 0));
        score.setText(String.valueOf(beginning));
        this.add(timeLabel);
        this.add(mainMenuButton);
        this.add(score);

        timer.scheduleAtFixedRate(new TimerTask() {

          public void run() {
              timeLabel.setText(""+setTime());
  
          }
      }, 1000, 1000);
      
  }
    
    public void plusTextField() {
    	beginning++;
    	score.setText(String.valueOf(beginning));
    }
    private int setTime() {
      if (TIME == 1){
        timer.cancel();

        JDialog dialog = new JDialog(new JFrame(), "Warning");

        dialog.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                System.exit(0);
            }
        });
        JPanel top = new JPanel();
        JLabel l = new JLabel("                      Your time is over, restart?" , SwingConstants.CENTER);
        JLabel lE = new JLabel("                  ");
        JButton b1 = new JButton("Restart");
        JButton b2 = new JButton("Quit");
        JPanel bPanel = new JPanel();
        
        top.add(lE);
        top.add(l);
        top.add(lE);

        dialog.setSize(400,200);
        dialog.setLocationRelativeTo(null);
        dialog.setLayout(new BorderLayout());

        dialog.add(top , BorderLayout.NORTH);
        bPanel.add(b1);
        bPanel.add(b2);
        dialog.add(bPanel, BorderLayout.SOUTH);
        dialog.pack();

        ImageIcon icon = new ImageIcon("icons//icon.png");
        
        dialog.setIconImage(icon.getImage());
       
      
        dialog.setVisible(true);
      }
      return --TIME;
  }

}
