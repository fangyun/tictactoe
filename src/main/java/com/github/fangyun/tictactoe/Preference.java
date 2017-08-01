/**
 * GPL
 */
package com.github.fangyun.tictactoe;

/**
 * @author FangYun
 *
 */
public enum Preference {
	MAX(Stone.X), MIN(Stone.O);

	private Stone stone;

	private Preference(Stone s) {
		this.stone = s;
	}

	public Stone getStone() {
		return stone;
	}
}
