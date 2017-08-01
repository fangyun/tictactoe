/**
 * GPL
 */
package com.github.fangyun.tictactoe;

/**
 * @author FangYun
 *
 */
public class TicTacToe {
	private final Player player1;
	private final Player player2;
	private final Board board;
	private final Referee referee;

	public TicTacToe(Option option) {
		PlayerFactory pf = PlayerFactory.newInstance();
		player1 = pf.create(option.getPlayer1Type(), option.getPlayer1Order(), "Player1");
		player2 = pf.create(option.getPlayer2Type(), option.getPlayer2Order(), "Player2");
		board = new Board(option.getBoardSize(), player1, player2);
		referee = new Referee(board, player1, player2);
	}

	public Integer play() {
		while (true) {
			if (referee.testTerminal()) {
				break;
			} else {
				player1.play();
				referee.report();
			}
			if (referee.testTerminal()) {
				break;
			} else {
				player2.play();
				referee.report();
			}
		}
		return referee.getLastUtility();
	}
}
