/**
 * GPL
 */
package com.github.fangyun.tictactoe;

/**
 * @author FangYun
 *
 */
public class TicTacToe {
	private Player p1 = null;
	private Player p2 = null;
	private Board board;

	public TicTacToe(Option option) {
		PlayerFactory pf = PlayerFactory.newInstance();
		p1 = pf.create(option.getPlayer1Type());
		p2 = pf.create(option.getPlayer2Type());
		board = new Board(option.getBoardSize());
	}

	public void start() {
	}

}
