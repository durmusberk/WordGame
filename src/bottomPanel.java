

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class bottomPanel extends JPanel{
    private centerPanel center;
    private infopanel infoPanel;
    private JTextField textField = new JTextField(10);
    private JButton onay = new JButton();
    private ImageIcon ok = new ImageIcon("icons//okbutton.png");
    private ImageIcon textPng = new ImageIcon("icons//textField.png");

    
    public bottomPanel(centerPanel center,infopanel infoPanel){
        this.center=center;
        this.infoPanel = infoPanel;
        textField.setOpaque(false);
        textField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel label = new JLabel(textPng);
        label.setLayout(new BorderLayout());
        label.add(textField);
        this.add(label);
        
        onay.setIcon(ok);
        onay.setBorderPainted(false); 
        onay.setContentAreaFilled(false); 
        onay.setFocusPainted(false); 
        this.add(onay);
        ActionListener buttonHandler = new buttonHandler(textField,infoPanel,center);
        onay.addActionListener(buttonHandler);
        textField.addActionListener(buttonHandler);

    }
    
    
    
}
