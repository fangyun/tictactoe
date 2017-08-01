/**
 * GPL
 */
package com.github.fangyun.tictactoe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author FangYun
 *
 */
public class Referee {
	private final Board board;
	private final Player player1;
	private final Player player2;
	private Integer lastUtility = null;
	private static final Logger log = LoggerFactory.getLogger("report");

	public Referee(Board board, Player player1, Player player2) {
		this.board = board;
		this.player1 = player1;
		this.player2 = player2;
		this.player1.setReferee(this);
		this.player2.setReferee(this);
		this.board.setReferee(this);
	}

	public void report() {
		log.info("Reporting: \n " + board.outputStones());
	}

	public boolean testTerminal() {
		if (board.isFull()) {
			lastUtility = 0;
			return true;
		}
		Cell c = board.getLastUpdatedCell();
		if (c == null) {
			return false; // not started
		}
		if (testHorizontal() || testVertical() || testCross() || testBackCross()) {
			if (c.getStone() == Stone.X) {
				this.lastUtility = 1;
			} else {
				this.lastUtility = -1;
			}
			return true;
		}
		return false;
	}

	private boolean testBackCross() {
		Cell c = board.getLastUpdatedCell();
		int by = (board.getBoardSize() - 1) - c.getY();
		if (c.getX() == by) {
			Stone cs = c.getStone();
			for (int i = 0; i < board.getBoardSize(); i++) {
				by = (board.getBoardSize() - 1) - i;
				if (board.getCell(i, by).getStone() != cs) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	private boolean testCross() {
		Cell c = board.getLastUpdatedCell();
		if (c.getX() == c.getY()) {
			Stone cs = c.getStone();
			for (int i = 0; i < board.getBoardSize(); i++) {
				if (board.getCell(i, i).getStone() != cs) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	private boolean testVertical() {
		Cell c = board.getLastUpdatedCell();
		int y = c.getY();
		Stone cs = c.getStone();
		for (int i = 0; i < board.getBoardSize(); i++) {
			if (board.getCell(i, y).getStone() != cs) {
				return false;
			}
		}
		return true;
	}

	private boolean testHorizontal() {
		Cell c = board.getLastUpdatedCell();
		int x = c.getX();
		Stone cs = c.getStone();
		for (int i = 0; i < board.getBoardSize(); i++) {
			if (board.getCell(x, i).getStone() != cs) {
				return false;
			}
		}
		return true;
	}

	public Integer getLastUtility() {
		return lastUtility;
	}
}
