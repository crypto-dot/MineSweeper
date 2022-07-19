package minesweeper;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

public class Cell extends JButton {
	private static final long serialVersionUID = 1L;
	
	public static final Color BG_NOT_REVEALED = Color.GRAY;
	public static final Color FG_NOT_REVEALED = Color.RED;
	public static final Color BG_REVEALED = Color.DARK_GRAY;
	public static final Color FG_REVEALED = Color.YELLOW;
	public static final Font FONT_NUMBERS = new Font("Monosapced", Font.BOLD, 20);
	
	int row, col;
	boolean isRevealed;
	boolean isMined;
	boolean isFlagged;
	
	public Cell(int row, int col) {
		this.row = row;
		this.col = col;
		
		super.setFont(FONT_NUMBERS);
	}
	
	public void newGame(boolean isMined) {
		this.isFlagged = false;
		this.isRevealed = false;
		this.isMined = isMined;
		super.setEnabled(true);
		super.setText("");
		paint();
	}
	
	public void paint() {
		super.setForeground(isRevealed ? FG_REVEALED : FG_NOT_REVEALED );
		super.setBackground(isRevealed ? BG_REVEALED : BG_NOT_REVEALED);
	}
	
	
}
