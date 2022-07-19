package minesweeper;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MineSweeperMain extends JFrame {
	private static final long serialVersionUID = 1L;
	
	GameBoardPanel gameBoardPanel = new GameBoardPanel();
	JButton btnNewGame = new JButton("New Game");
	
	public MineSweeperMain() {
		Container cp = this.getContentPane(); //JFrame Content pane
		cp.setLayout(new BorderLayout()); // 10x10 grid layout 
		cp.add(gameBoardPanel, BorderLayout.CENTER);
		cp.add(btnNewGame, BorderLayout.SOUTH);
		
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameBoardPanel.newGame();
			}
		});
		gameBoardPanel.newGame();
		
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("MineSweeper");
		setVisible(true);
	}
	public static void main(String[] args) {
		new MineSweeperMain();
	}
}
