/**
 * GPL
 */
package com.github.fangyun.tictactoe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author FangYun
 *
 */
public class Board {
	private static final Logger log = LoggerFactory.getLogger("search");
	private final int boardSize;

	private final Cell[][] cells;
	private final Player player1;
	private final Player player2;
	private Referee referee;
	private int scale = 0;
	private final int MAX_SCALE;
	private Cell lastUpdatedCell = null;

	public Board(int boardSize, Player p1, Player p2) {
		if (boardSize < 3 || boardSize > 26) {
			throw new IllegalArgumentException("Valid board size= [3,26]");
		}
		this.boardSize = boardSize;
		cells = new Cell[boardSize][boardSize];
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				Cell c = new Cell(i, j);
				cells[i][j] = c;
			}
		}
		this.player1 = p1;
		this.player2 = p2;
		this.player1.setBoard(this);
		this.player2.setBoard(this);
		MAX_SCALE = this.boardSize * this.boardSize;
	}

	public String outputStones() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < boardSize; i++) {
			sb.append("  ").append(Cell.labelX(i));
		}
		sb.append("\n");
		String[] padding = { "   ", "  ", " " };
		for (int i = 0; i < boardSize; i++) {
			String y = Cell.labelY(i);
			sb.append(y);
			sb.append(padding[y.length()]).append(cells[i][0].getStoneValue());
			for (int j = 1; j < boardSize; j++) {
				sb.append("  ").append(cells[i][j].getStoneValue());
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public String outputUtilities() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < boardSize; i++) {
			sb.append("  ").append(Cell.labelX(i));
		}
		sb.append("\n");
		String[] padding = { "   ", "  ", " " };
		for (int i = 0; i < boardSize; i++) {
			String y = Cell.labelY(i);
			sb.append(y);
			sb.append(padding[y.length()]).append(cells[i][0].getUtilityValue());
			for (int j = 1; j < boardSize; j++) {
				sb.append("  ").append(cells[i][j].getUtilityValue());
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public Cell[][] getCells() {
		return cells;
	}

	public Cell getCell(int x, int y) {
		return cells[x][y];
	}

	public Board clone() {
		Board nb = new Board(this.boardSize, this.player1.clone(), this.player2.clone());
		Cell[][] c = nb.getCells();
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[i].length; j++) {
				c[i][j] = this.getCells()[i][j].clone();
			}
		}
		nb.scale = this.scale;
		Referee rf = new Referee(nb, nb.player1, nb.player2);
		nb.setReferee(rf);
		return nb;
	}

	public void updateCell(int x, int y, Stone s, Integer utility) {
		Cell mc = getCell(x, y);
		if (mc.getStone() != null) {
			throw new IllegalStateException(String.format("Cell at [%s, %s] had a stone %s", Cell.labelX(x),
					Cell.labelY(y), mc.getStone().toString()));
		}
		mc.setStone(s);
		mc.setUtility(utility);
		this.scale++;
		this.lastUpdatedCell = mc;
		log.debug("Searching: \n " + this.outputStones());
	}

	public void setReferee(Referee referee) {
		this.referee = referee;
	}

	public Referee getReferee() {
		return this.referee;
	}

	public boolean isFull() {
		return scale == MAX_SCALE;
	}

	public Cell getLastUpdatedCell() {
		return this.lastUpdatedCell;
	}

	public int getBoardSize() {
		return boardSize;
	}
}
