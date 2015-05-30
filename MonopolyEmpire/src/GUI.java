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
import javax.swing.plaf.basic.BasicArrowButton;

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
		
		newGame = new  JButton(" New Game");
		newGame.setBackground(Color.LIGHT_GRAY);
		newGame.setFont(new Font("Arial", Font.BOLD, 16));
		instructions = new  JButton("Instructions");
		instructions.setBackground(Color.LIGHT_GRAY);
		instructions.setFont(new Font("Arial", Font.BOLD, 16));
		highscore = new  JButton("Highscore");
		highscore.setBackground(Color.LIGHT_GRAY);
		highscore.setFont(new Font("Arial", Font.BOLD, 16));
		exit = new  JButton("Exit");
		exit.setBackground(Color.LIGHT_GRAY);
		exit.setFont(new Font("Arial", Font.BOLD, 16));
		
		
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
        mainPanel.setBounds(360, 370, 150, 110);
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
		//Incomplete. Need to fix it so that the instructions appear properly on screen.
		//Arrows should be located near the bottom middle. 
		//Left/Right will cycle through the available pages.
		
		JDialog instructionsDialog;
		JPanel secondaryPanel;
		JLayeredPane mainPanel;
		BasicArrowButton leftArrow, rightArrow;
		ArrayList<ImageIcon> instructionsImageList = new ArrayList<ImageIcon>(); 
		final int pagePointer = 0; 	//Initialize on first page
		
		
		instructionsDialog = new JDialog();
		secondaryPanel = new JPanel();
		
		mainPanel = new JLayeredPane();
		mainPanel.setLayout(new GridLayout(1,2));
		leftArrow = new BasicArrowButton(BasicArrowButton.WEST);
		rightArrow = new BasicArrowButton(BasicArrowButton.EAST);
		leftArrow.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(pagePointer<6)
					increasePage(pagePointer);			
			}			
		});
		rightArrow.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(pagePointer>0)
					decreasePage(pagePointer);			
			}			
		});
		mainPanel.add(leftArrow);
		mainPanel.add(rightArrow);
		
		ImageIcon instructionsImage1 = new ImageIcon("Instructions1.jpg");
		instructionsImageList.add(instructionsImage1);
		ImageIcon instructionsImage2 = new ImageIcon("Énstructions2.jpg");
		instructionsImageList.add(instructionsImage2);
		ImageIcon instructionsImage3 = new ImageIcon("Instructions3.jpg");
		instructionsImageList.add(instructionsImage3);
		ImageIcon instructionsImage4 = new ImageIcon("Instructions4.jpg");
		instructionsImageList.add(instructionsImage4);
		ImageIcon instructionsImage5 = new ImageIcon("Instructions5.jpg");
		instructionsImageList.add(instructionsImage5);
		ImageIcon instructionsImage6 = new ImageIcon("Instructions6.jpg");
		instructionsImageList.add(instructionsImage6);
		
		secondaryPanel.add(new JLabel(instructionsImageList.get(pagePointer)));			
		
		instructionsDialog.setLayout(new BorderLayout());
		instructionsDialog.add(secondaryPanel, BorderLayout.CENTER);
		secondaryPanel.setBounds(0, 0, 700, 500);
		instructionsDialog.add(mainPanel, BorderLayout.PAGE_END);
		
		instructionsDialog.pack();
		instructionsDialog.setTitle("Instructions");
		instructionsDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		instructionsDialog.setVisible(true);
		instructionsDialog.setSize(750, 510);
		instructionsDialog.setResizable(false);
		
		ImageIcon icon = new ImageIcon("Info.png");
		instructionsDialog.setIconImage(icon.getImage());
		
	}
	
	private void increasePage(int pagePointer){
		pagePointer++;
	}

	private void decreasePage(int pagePointer){
		pagePointer--;
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

