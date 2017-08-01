/**
 * GPL
 */
package com.github.fangyun.tictactoe;

/**
 * @author FangYun
 * 
 */
public class Cell {
	private final int x;
	private final int y;
	private Stone stone;
	private Integer utility;

	public Cell(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Integer getUtility() {
		return utility;
	}

	public void setUtility(Integer utility) {
		this.utility = utility;
	}

	public String getStoneValue() {
		return this.stone == null ? " " : this.stone.name();
	}

	public String toString() {
		return String.format("(%s,%s,%s)", Cell.labelX(x), Cell.labelY(y), getStoneValue());
	}

	public static String labelX(int x) {
		return String.valueOf((char) (((int) 'A') + x));
	}

	public static String labelY(int y) {
		return String.valueOf((y + 1));
	}

	public Cell clone() {
		Cell nc = new Cell(this.x, this.y);
		nc.setUtility(this.utility);
		nc.setStone(this.stone);
		return nc;
	}

	public void setStone(Stone stone) {
		this.stone = stone;
	}

	public Stone getStone() {
		return this.stone;
	}

	public String getUtilityValue() {
		return this.utility == null ? " " : this.utility.toString();
	}
}
