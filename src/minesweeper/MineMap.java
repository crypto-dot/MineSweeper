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
		isMined[3][3] = true;
		isMined[7][7] = true;
		isMined[8][8] = true;
		isMined[9][9] = true;
		isMined[2][2] = true;
		isMined[1][1] = true;
		isMined[4][4] = true;
		isMined[5][5] = true;
		isMined[6][6] = true;
		
	}
}
