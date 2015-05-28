import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowEvent;
import java.awt.image.*;
import java.io.*;
import java.util.ArrayList;

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
		
		
		//Add Action Listeners for the 4 available buttons when you open the game
		newGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                newGameActionPerformed();
            }
        });
		
		instructions.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	instructionsActionPerformed();
            }
        });
		
		highscore.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	highscoreActionPerformed();
            }
        });
		
		exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	exitActionPerformed();
            }
        });
		
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
	
	private void newGameActionPerformed(){
		
		//Not implemented yet
	}
	
	private void instructionsActionPerformed(){
		//Incomplete. Need to fix it so that the instructions appear properly on screen. Arrows should be located near the bottom middle. 
		//Left/Right will cycle through the available pages.
		
		JDialog instructionsDialog;
		JPanel instructionsPanel;
		JLayeredPane instructionsArrowsPanel;
		JButton leftArrow, rightArrow;
		int pagePointer;
		ArrayList<ImageIcon> instructionsImageList = new ArrayList<ImageIcon>();  	
		
		
		instructionsDialog = new JDialog();
		instructionsPanel = new JPanel();
		
		instructionsArrowsPanel = new JLayeredPane();
		instructionsArrowsPanel.setLayout(new GridLayout(1,2));
		leftArrow = new JButton("Prev");
		rightArrow = new JButton("Next");
		instructionsArrowsPanel.add(leftArrow);
		instructionsArrowsPanel.add(rightArrow);
		
		ImageIcon instructionsImage1 = new ImageIcon("Images/Screenshot_1.jpg");
		
		instructionsImageList.add(instructionsImage1);
		ImageIcon instructionsImage2 = new ImageIcon("Images/Screenshot_2.jpg");
		instructionsImageList.add(instructionsImage2);
		ImageIcon instructionsImage3 = new ImageIcon("Images/Screenshot_3.jpg");
		instructionsImageList.add(instructionsImage3);
		ImageIcon instructionsImage4 = new ImageIcon("Images/Screenshot_4.jpg");
		instructionsImageList.add(instructionsImage4);
		ImageIcon instructionsImage5 = new ImageIcon("Images/Screenshot_5.jpg");
		instructionsImageList.add(instructionsImage5);
		
		pagePointer = 0; //Initialize on first page
		instructionsPanel.add(new JLabel(instructionsImageList.get(pagePointer)));			
		
		instructionsDialog.setLayout(new BorderLayout());
		instructionsDialog.add(instructionsPanel, BorderLayout.CENTER);
		
		
		instructionsArrowsPanel.setBounds(360, 370, 150, 100);
		instructionsArrowsPanel.setOpaque(true);
		instructionsDialog.add(instructionsArrowsPanel, BorderLayout.CENTER);
		instructionsArrowsPanel.setBounds(0, 0, 850, 628);
		
		instructionsDialog.pack();
		instructionsDialog.setTitle("Instructions");
		instructionsDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		instructionsDialog.setVisible(true);
		instructionsDialog.setPreferredSize(new Dimension(1120, 790));

		//instructionsDialog.setResizable(false);
		
	}

	private void highscoreActionPerformed(){
	
		JOptionPane.showMessageDialog(frame, "This feature is currently disabled");
		
		
	}

	private void exitActionPerformed(){
		
		int flag = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
		if (flag == JOptionPane.YES_OPTION) frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));    	
		
	
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

