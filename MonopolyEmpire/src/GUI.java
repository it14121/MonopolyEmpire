import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.*;
import java.io.*;

import javax.imageio.*;
import javax.swing.*;

public class GUI {
	 private JFrame frame;
	 private JLayeredPane  mainPanel;
	 private JPanel  secondaryPanel;
	 private JButton newGame, instructions, highscore, exit;
	 private BufferedImage image;
	
	public void createGUI() {
		
		
		frame = new JFrame();
		mainPanel = new JLayeredPane();
		mainPanel.setLayout(new GridLayout(4,1));
		secondaryPanel = new JPanel();
		
		newGame = new JButton(new ImageIcon("new.png"));
	    
		instructions = new  JButton(new ImageIcon("instructions.png"));
		highscore = new  JButton(new ImageIcon("high.png"));
		exit = new  JButton(new ImageIcon("exit.png"));
		
		mainPanel.add(newGame);
		mainPanel.add(instructions);	
		mainPanel.add(highscore);	
		mainPanel.add(exit);
		
		ImageIcon pic = new ImageIcon("Background.jpg");
	    secondaryPanel.add(new JLabel(pic));
		
		
		frame.setLayout(new BorderLayout());
		frame.add(mainPanel, BorderLayout.CENTER);
        mainPanel.setBounds(360, 370, 150, 100);
        mainPanel.setOpaque(true);
        frame.add(secondaryPanel, BorderLayout.CENTER);
        secondaryPanel.setBounds(0, 0, 850, 628);
		frame.pack();
		frame.setTitle("MONOPOLY EMPIRE");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setPreferredSize(new Dimension(850, 628));
		frame.setResizable(false);
		ImageIcon icon1 = new ImageIcon("Icon.jpg");
		frame.setIconImage(icon1.getImage());
		
		
	}
	
	/*public class ImagePanel extends JPanel{

	    private BufferedImage image;

	    public ImagePanel() {
	       try {                
	          image = ImageIO.read(new File("Background.jpg"));
	       } catch (IOException ex) {
	            ex.printStackTrace();
	       }
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.drawImage(image, 850, 628, null);            
	    }

	}*/
		
}

