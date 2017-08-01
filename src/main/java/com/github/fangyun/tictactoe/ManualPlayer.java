/**
 * GPL
 */
package com.github.fangyun.tictactoe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author FangYun
 *
 */
public class ManualPlayer extends AbstractPlayer implements Player {
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

	@Override
	public void play() {
		List<Cell> blankCells = blankCells(this.board);
		Collections.shuffle(blankCells);
		Cell c = blankCells.get(0);
		this.board.updateCell(c.getX(), c.getY(), order.getPreference().getStone(), null);
	}

	public Player clone() {
		return new ManualPlayer();
	}

	public String toString() {
		return "ManualPlayer[" + this.name + "]";
	}
}
