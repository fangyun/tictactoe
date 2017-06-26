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
	private static final Logger log = LoggerFactory.getLogger(Board.class);
	private final int boardSize;

	private Cell[][] cells;

	public Board(int boardSize) {
		if (boardSize < 3 || boardSize > 26) {
			throw new IllegalArgumentException("Valid board size= [3,26]");
		}
		this.boardSize = boardSize;
		init();
	}

	private void init() {
		cells = new Cell[boardSize][boardSize];
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				Cell c = new Cell(i, j);
				cells[i][j] = c;
			}
		}
		log.debug(this.prettyString());
	}

	public String prettyString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < boardSize; i++) {
			sb.append("\t").append(Cell.labelX(i));
		}
		for (int i = 0; i < boardSize; i++) {
			int j = 0;
			sb.append(Cell.labelY(j));
			for (; j < boardSize; j++) {
				sb.append("\t").append(cells[i][j].getValue());
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
