/**
 * GPL
 */
package com.github.fangyun.tictactoe;

/**
 * @author FangYun
 *
 */
public class Option {
	private PlayerType player1Type = PlayerType.System;
	private PlayerType player2Type = PlayerType.System;
	private int boardSize = 3;

	public Option(String[] args) {

	}

	public PlayerType getPlayer1Type() {
		return player1Type;
	}

	public PlayerType getPlayer2Type() {
		return player2Type;
	}

	public int getBoardSize() {
		return boardSize;
	}

	public Order getPlayer1Order() {
		return Order.FIRST;
	}

	public Order getPlayer2Order() {
		return Order.SECOND;
	}
}
