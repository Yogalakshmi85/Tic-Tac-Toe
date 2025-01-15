package tictactoe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tictactoe implements ActionListener, KeyListener{
	
	Random random=new Random();
	JFrame frame=new JFrame();
	JPanel titlePanel=new JPanel();
	JPanel buttonPanel =new JPanel();
	JLabel label=new JLabel();
	JButton[] button=new JButton[9];
	boolean player1_turn;
	
	public Tictactoe() {
		frame.setSize(300,300);
		frame.setTitle("Tic-Tac-Toe");
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(new BorderLayout());
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		label.setBackground(new Color(25,25,25));
		label.setForeground(new Color(25,255,0));
		label.setFont(new Font("Ink Free", Font.BOLD, 25));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setText("Tic-Tac-Toe");
		label.setOpaque(true);
		
		titlePanel.setLayout(new BorderLayout());
		titlePanel.setBounds(0, 1, 200, 100);
		
		buttonPanel.setLayout(new GridLayout(3,3));
		buttonPanel.setBackground(new Color(150,150,150));
		
		for(int i=0;i<9;i++) {
			button[i]=new JButton();
			buttonPanel.add(button[i]);
			button[i].setBackground(new Color(233, 245, 248));
			button[i].setFont(new Font("MV Boli", Font.BOLD, 40));
			button[i].setFocusable(false);
			button[i].addActionListener(this);
		}
		
		titlePanel.add(label);
		frame.add(titlePanel,BorderLayout.NORTH);
		frame.add(buttonPanel);
		frame.addKeyListener(this);
		
		FirstTurn();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<9;i++) {
			if(e.getSource()==button[i]) {
				if(player1_turn) {
					if(button[i].getText()=="") {
						button[i].setForeground(new Color(255,0,0));
						button[i].setBackground(new Color(233, 245, 248));
						button[i].setText("X");
						player1_turn=false;
						label.setText("Player Y turn");
						check();
					}
				}
				else {
					if(button[i].getText()=="") {
						button[i].setForeground(new Color(0,0,255));
						button[i].setBackground(new Color(233, 245, 248));
						button[i].setText("O");
						player1_turn=true;
						label.setText("Player X turn");
						check();
					}
				}
			}
		}
		
	}
	
	public void FirstTurn() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(random.nextInt(2)==0) {
			player1_turn=true;
			label.setText("Player X turn");
		}
		else {
			player1_turn=false;
			label.setText("Player Y turn");
		}
	}
	
	public void check() {
		
		//X Win Condition
		if((button[0].getText()=="X") && (button[1].getText()=="X") && (button[2].getText()=="X")) XWins(0, 1, 2);
		
		if((button[3].getText()=="X") && (button[4].getText()=="X") && (button[5].getText()=="X")) XWins(3, 4, 5);
		
		if((button[6].getText()=="X") && (button[7].getText()=="X") && (button[8].getText()=="X")) XWins(6, 7, 8);
		
		if((button[0].getText()=="X") && (button[3].getText()=="X") && (button[6].getText()=="X")) XWins(0, 3, 6);
		
		if((button[1].getText()=="X") && (button[4].getText()=="X") && (button[7].getText()=="X")) XWins(1, 4, 7);
		
		if((button[2].getText()=="X") && (button[5].getText()=="X") && (button[8].getText()=="X")) XWins(2, 5, 8);
		
		if((button[0].getText()=="X") && (button[4].getText()=="X") && (button[8].getText()=="X")) XWins(0, 4, 8);
		
		if((button[2].getText()=="X") && (button[4].getText()=="X") && (button[6].getText()=="X")) XWins(2, 4, 6);
		
		
		//X Win Condition
		if((button[0].getText()=="O") && (button[1].getText()=="O") && (button[2].getText()=="O")) YWins(0, 1, 2);

		if((button[3].getText()=="O") && (button[4].getText()=="O") && (button[5].getText()=="O")) YWins(3, 4, 5);
				
		if((button[6].getText()=="O") && (button[7].getText()=="O") && (button[8].getText()=="O")) YWins(6, 7, 8);
				
		if((button[0].getText()=="O") && (button[3].getText()=="O") && (button[6].getText()=="O")) YWins(0, 3, 6);
				
		if((button[1].getText()=="O") && (button[4].getText()=="O") && (button[7].getText()=="O")) YWins(1, 4, 7);
				
		if((button[2].getText()=="O") && (button[5].getText()=="O") && (button[8].getText()=="O")) YWins(2, 5, 8);
				
		if((button[0].getText()=="O") && (button[4].getText()=="O") && (button[8].getText()=="O")) YWins(0, 4, 8);
				
		if((button[2].getText()=="O") && (button[4].getText()=="O") && (button[6].getText()=="O")) YWins(2, 4, 6);
		
	}
	
	public void XWins(int a,int b, int c) {
		button[a].setBackground(Color.ORANGE);
		button[b].setBackground(Color.ORANGE);
		button[c].setBackground(Color.ORANGE);
		
		for(int i=0;i<9;i++) {
			button[i].setEnabled(false);
		}
		
		label.setText("Player X Wins");
		
	}
	
	public void YWins(int a,int b, int c) {
		button[a].setBackground(Color.ORANGE);
		button[b].setBackground(Color.ORANGE);
		button[c].setBackground(Color.ORANGE);
		
		for(int i=0;i<9;i++) {
			button[i].setEnabled(false);
		}
		
		label.setText("Player Y Wins");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			
			FirstTurn();
			
			for(int i=0;i<9;i++) {
				button[i].setText("");
				button[i].setEnabled(true);
				button[i].setBackground(new Color(233, 245, 248));
				button[i].addActionListener(this);
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
		
}

