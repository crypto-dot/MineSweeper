package minesweeper;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class GameBoardPanel extends JPanel {
	public static final long serialVersionUID = 1L;
	
	public static final int ROWS = 10;
	public static final int COLS = 10;
	
	public static final int CELL_SIZE = 60;
	public static final int CANVAS_WIDTH = CELL_SIZE * COLS;
	public static final int CANVAS_HEIGHT = CELL_SIZE * ROWS;
	
	Cell cells[][] = new Cell[ROWS][COLS];
	int numberOfMines = 10;
	
	public GameBoardPanel() {
		super.setLayout(new GridLayout(ROWS,COLS,2,2)); //JPanel
		for(int row = 0; row < ROWS; row++) {
			for(int col = 0; col < COLS; col++) {
				cells[row][col] = new Cell(row,col);
				super.add(cells[row][col]);
			}
		}
		
		
		CellMouseListener listener = new CellMouseListener();
		
		for(int row = 0; row < ROWS; row++) {
			for(int col = 0; col < COLS; col++) {
				cells[row][col].addMouseListener(listener);
			}
		}
		
		
		
		// Set the size of the content pane and pack all the components 
		// under this container 
		super.setPreferredSize(new Dimension(CANVAS_WIDTH,CANVAS_HEIGHT));
	}
	public void newGame() {
		MineMap mineMap = new MineMap();
		mineMap.newMineMap(numberOfMines);
		
		for(int row = 0; row < ROWS; row++) {
			for(int col = 0; col < COLS; col++) {
				//Initialize each cell with/without a mine 
				cells[row][col].newGame(mineMap.isMined[row][col]);
			}
		}
	}
	private int getSurroundingMines(int srcRow, int srcCol) {
		int numMines = 0;
		for(int row = srcRow - 1; row <= srcRow + 1; row++) {
			for(int col = srcCol - 1; col <= srcCol + 1; col++) {
				if(row >= 0 && col >= 0 && col < COLS && row < ROWS) {
					if(cells[row][col].isMined) {
						numMines++;
					}
				}
			}
		}
		return numMines;
	}
	
	private void revealCell(int srcRow, int srcCol) {
		int numMines = getSurroundingMines(srcRow,srcCol);
		cells[srcRow][srcCol].setText(numMines + "");
		cells[srcRow][srcCol].isRevealed = true;
		cells[srcRow][srcCol].paint();
		if(numMines == 0) {
			//Recursively reveal mines
			for(int row = srcRow - 1; row <= srcRow +1; row++) {
				for(int col = srcCol - 1; col <= srcCol + 1; col++) {
					if(row >= 0 && col >= 0 && row < ROWS && col < COLS) {
						if(!cells[row][col].isRevealed) {
							revealCell(row,col);
						}
					}
				}
			}
		}
	}
	//checks if player won
	public boolean hasWon() {
		return true;
	}
	
	private class CellMouseListener extends MouseAdapter{
		@Override 
		public void mouseClicked(MouseEvent e) {
			Cell sourceCell = (Cell)e.getSource(); 
			System.out.println("You clicked on (" + sourceCell.row + sourceCell.col + ")");
			if(e.getButton() == MouseEvent.BUTTON1) {
				
				if(sourceCell.isMined) {
					System.out.println("Game Over");
					sourceCell.setText("*");
				} else {
					revealCell(sourceCell.row, sourceCell.col);
				}
			} else if(e.getButton() == MouseEvent.BUTTON3) {
				if(sourceCell.isFlagged) {
					sourceCell.setText(" ");
				} else {
					sourceCell.setText("<");
					sourceCell.isFlagged = true;
				}
			}
			
		}
		
		
	}

	
	
	
	
}
