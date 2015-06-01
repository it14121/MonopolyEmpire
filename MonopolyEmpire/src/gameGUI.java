import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class gameGUI extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame mainGame;
	
	public gameGUI(){
		
		
		
		//Not implemented yet
		//final JFrame mainGame = new JFrame();
		mainGame = new JFrame();
		JPanel boardPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		ImageIcon dices = new ImageIcon("dices.png");
		JButton roll = new JButton(dices);
		JButton exit = new JButton("Exit Game");
		JButton newGameButton = new JButton("New Game");
		JPanel backgroundPanel = new JPanel();
			
		ImageIcon boardImage = new ImageIcon("Board game image.jpg");
		backgroundPanel.add(new JLabel(boardImage));
		backgroundPanel.setBounds(0, 0, 1024, 740);
		ImageIcon board = new ImageIcon("board.jpg");
		boardPanel.add(new JLabel(board));
		boardPanel.setBounds(0, 0, 700, 700);
			
			
		//roll.setBackground(Color.RED);
		//roll.setFont(new Font("Arial", Font.BOLD, 16));
			
		    
		exit.setBackground(Color.LIGHT_GRAY);
		exit.setFont(new Font("Arial", Font.BOLD, 16));
		newGameButton.setBackground(Color.lightGray);
		newGameButton.setFont(new Font("Arial", Font.BOLD, 16));
		buttonPanel.setLayout(new GridLayout(3,1));
		buttonPanel.add(newGameButton);
		buttonPanel.add(roll);
		buttonPanel.add(exit);
			
			
			
		roll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				rollActionPerformed();
	            	}
	        	});
		
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				exitActionPerformed();
	            	}
	        	});
			
		mainGame.add(boardPanel, BorderLayout.CENTER);
		mainGame.add(buttonPanel, BorderLayout.LINE_END);
		mainGame.add(backgroundPanel, BorderLayout.CENTER);
				
		mainGame.setPreferredSize(new Dimension(1024, 740));
		mainGame.pack();
			
		mainGame.setResizable(false);
		mainGame.setVisible(true);
		mainGame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	private void rollActionPerformed(){
		
		
		
	}
	
	private void exitActionPerformed(){
		
		int flag = JOptionPane.showConfirmDialog(mainGame, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
		if (flag == JOptionPane.YES_OPTION) mainGame.dispatchEvent(new WindowEvent(mainGame, WindowEvent.WINDOW_CLOSING));
		
	}
	public void setWindowListener(WindowListener listener){
		mainGame.addWindowListener(listener);
	}
}
