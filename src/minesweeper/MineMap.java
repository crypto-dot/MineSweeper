package minesweeper;

public class MineMap {
	int numMines;
	
	boolean[][] isMined = new boolean[GameBoardPanel.ROWS][GameBoardPanel.COLS];
	
	public MineMap() {
		super();
	}
	public void newMineMap(int numMines) {
		this.numMines = numMines;
		
		isMined[0][0] = true;
		isMined[2][4] = true;
		isMined[1][3] = true;
		isMined[3][8] = true;
		isMined[3][6] = true;
		isMined[3][5] = true;
		isMined[2][8] = true;
		isMined[3][9] = true;
		isMined[4][5] = true;
		isMined[4][6] = true;
		
	}
}
