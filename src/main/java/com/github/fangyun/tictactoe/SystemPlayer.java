/**
 * GPL
 */
package com.github.fangyun.tictactoe;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author FangYun
 *
 */
public class SystemPlayer extends AbstractPlayer implements Player {
	private static final Logger log = LoggerFactory.getLogger("utility");

	@Override
	public void play() {
		Cell c = deduct(this.board, this.order);
		this.board.updateCell(c.getX(), c.getY(), order.getPreference().getStone(), c.getUtility());
		log.debug("Utilities: \n " + board.outputUtilities());
	}

	private Cell deduct(Board board, Order order) {
		Board cb = board.clone();
		if (order.getPreference() == Preference.MAX) {
			return tryMax(cb);
		} else {
			return tryMin(cb);
		}
	}

	private Cell tryMin(Board cb) {
		List<Cell> blankCells = blankCells(cb);
		Cell minCell = null;
		for (Cell c : blankCells) {
			if (c.getStone() != null) {
				break;
			}
			cb.updateCell(c.getX(), c.getY(), Preference.MIN.getStone(), null);
			if (cb.getReferee().testTerminal()) {
				c.setUtility(cb.getReferee().getLastUtility());
				break;
			} else if (tryMax(cb) != null) {
				break;
			}
		}
		for (Cell c : blankCells) {
			if (c.getUtility() != null && minCell == null) {
				minCell = c;
			} else if (c.getUtility() != null && c.getUtility() < minCell.getUtility()) {
				minCell = c;
			}
		}
		return minCell;
	}

	private Cell tryMax(Board cb) {
		List<Cell> blankCells = blankCells(cb);
		for (Cell c : blankCells) {
			if (c.getStone() != null) {
				break;
			}
			cb.updateCell(c.getX(), c.getY(), Preference.MAX.getStone(), null);
			if (cb.getReferee().testTerminal()) {
				c.setUtility(cb.getReferee().getLastUtility());
				break;
			} else if (tryMin(cb) != null) {
				break;
			}
		}
		Cell maxCell = null;
		for (Cell c : blankCells) {
			if (c.getUtility() != null && maxCell == null) {
				maxCell = c;
			} else if (c.getUtility() != null && c.getUtility() > maxCell.getUtility()) {
				maxCell = c;
			}
		}
		return maxCell;
	}

	private List<Cell> blankCells(Board cb) {
		Cell[][] cs = cb.getCells();
		List<Cell> ls = new ArrayList<>();
		for (int i = 0; i < cs.length; i++) {
			for (int j = 0; j < cs[i].length; j++) {
				Cell c = cs[i][j];
				if (c.getStone() == null) {
					ls.add(c);
				}
			}
		}
		return ls;
	}

	public Player clone() {
		return new SystemPlayer();
	}

	public String toString() {
		return "SystemPlayer[" + this.name + "]";
	}
}
