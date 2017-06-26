/**
 * GPL
 */
package com.github.fangyun.tictactoe;

/**
 * @author FangYun
 * 
 */
public class Cell {
	private int x;
	private int y;
	private Value value;

	public enum Value {
		X, O;
	}

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

	public String getValue() {
		return value == null ? " " : value.name();
	}

	public String toString() {
		return String.format("(%s,%s,%s)", Cell.labelX(x), Cell.labelY(y), getValue());
	}

	public static String labelX(int x) {
		return String.valueOf((char) (((int) 'A') + x));
	}

	public static String labelY(int y) {
		return String.valueOf((y + 1));
	}
}
