import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.*;

public class GUI {
	 private JFrame frame;
	 private JLayeredPane  mainPanel;
	 private JPanel  secondaryPanel;
	 private JButton newGame, instructions, highscore, exit;
	 
	 int pagePointer = 0; //Initialize on first page
	 final JPanel instructionsPanel = new JPanel();
	
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
		

		
		gameGUI game = new gameGUI(); 
		frame.setVisible(false);
				
		 WindowListener listener = new WindowAdapter() {
		      public void windowClosing(WindowEvent w) {
		        frame.setVisible(true);;
		
		      }};
		      game.setWindowListener(listener);
		      }
	
	
	private void instructionsActionPerformed(){
		
		//Left/Right will cycle through the available pages.
		
		final JDialog instructionsDialog;
		
		
		
		JLayeredPane instructionsArrowsPanel;
		GridLayout instructionsArrowGrid;
		final JButton leftArrow;
		final JButton rightArrow;
		
		final ArrayList<ImageIcon> instructionsImageList = new ArrayList<ImageIcon>();  	
		
		
		instructionsDialog = new JDialog();
		
		
		instructionsArrowsPanel = new JLayeredPane();
		
		instructionsArrowGrid = new GridLayout(1,2);
		instructionsArrowGrid.setHgap(15);
		instructionsArrowsPanel.setLayout(instructionsArrowGrid);
		leftArrow = new JButton("Prev");
		rightArrow = new JButton("Next");
		instructionsArrowsPanel.add(leftArrow);
		instructionsArrowsPanel.add(rightArrow);
		
		leftArrow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                pagePointer = instructionsArrowActionPerformed(pagePointer, instructionsImageList, evt);
                
            }
            
        });
		
		rightArrow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	pagePointer = instructionsArrowActionPerformed(pagePointer, instructionsImageList, evt);
            	
            }
        });
		
		ImageIcon instructionsImage1 = new ImageIcon("Instructions_1.jpg");		
		instructionsImageList.add(instructionsImage1);
		ImageIcon instructionsImage2 = new ImageIcon("Instructions_2.jpg");
		instructionsImageList.add(instructionsImage2);
		ImageIcon instructionsImage3 = new ImageIcon("Instructions_3.jpg");
		instructionsImageList.add(instructionsImage3);
		ImageIcon instructionsImage4 = new ImageIcon("Instructions_4.jpg");
		instructionsImageList.add(instructionsImage4);
		ImageIcon instructionsImage5 = new ImageIcon("Instructions_5.jpg");
		instructionsImageList.add(instructionsImage5);
		ImageIcon instructionsImage6 = new ImageIcon("Instructions_6.jpg");
		instructionsImageList.add(instructionsImage6);
		
		
		instructionsPanel.add(new JLabel(instructionsImageList.get(pagePointer)));			
		
		
		instructionsDialog.setLayout(new BorderLayout());
		instructionsDialog.add(instructionsArrowsPanel, BorderLayout.CENTER);
		
		
		instructionsArrowsPanel.setBounds(495,600,150,100);
		//495,700,150,100
		instructionsArrowsPanel.setOpaque(true);
		instructionsDialog.add(instructionsPanel, BorderLayout.CENTER);
		//instructionsPanel.setBounds(0, 0, 850, 628);
		
		instructionsDialog.pack();
		instructionsDialog.setTitle("Instructions");
		ImageIcon icon2 = new ImageIcon("info.png");
		instructionsDialog.setIconImage(icon2.getImage());
		instructionsDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		instructionsDialog.setVisible(true);
		instructionsDialog.setPreferredSize(new Dimension(1120,790));

		instructionsDialog.setResizable(true);
		
	}



	private int instructionsArrowActionPerformed(int pagePointer,  ArrayList<ImageIcon> instructionsImageList, ActionEvent evt){
		
		if (evt.getActionCommand().equals("Prev")){
			if (pagePointer > 0 ) { 
				pagePointer--;					
			}
		}
		else
			if(pagePointer < 5){
				pagePointer++;
			}
		
		//Remove the instruction page-image and replace it with the new one
		//This is a waste when the page is not changed, but is chosen over code repetition
		instructionsPanel.removeAll();
		instructionsPanel.add(new JLabel(instructionsImageList.get(pagePointer)));		
		instructionsPanel.revalidate();

		return pagePointer;
	}



	

	private void highscoreActionPerformed(){
	
		JOptionPane.showMessageDialog(frame, "This feature is currently disabled");
		
	}

	private void exitActionPerformed(){
		
		int flag = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
		if (flag == JOptionPane.YES_OPTION) frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));    	
		
	
	}
	
	
	

	
		
}

