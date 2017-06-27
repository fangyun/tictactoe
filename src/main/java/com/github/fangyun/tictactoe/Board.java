/**
 * GPL
 */
package com.github.fangyun.tictactoe;

import java.util.Arrays;

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
		System.out.println(this.prettyString());
	}

	public String prettyString() {
		StringBuilder sb = new StringBuilder();
		sb.append(" ");
		for (int i = 0; i < boardSize; i++) {
			sb.append("  ").append(Cell.labelX(i));
		}
		sb.append("\n");
		for (int i = 0; i < boardSize; i++) {
			String y = Cell.labelY(i);
			sb.append(y);
			char[] padding = new char[3 - y.length()];
			Arrays.fill(padding, ' ');
			sb.append(new String(padding)).append(cells[i][0].getValue());
			for (int j = 1; j < boardSize; j++) {
				sb.append("  ").append(cells[i][j].getValue());
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
