/**
 * GPL
 */
package com.github.fangyun.tictactoe;

/**
 * @author FangYun
 *
 */
public abstract class AbstractPlayer implements Player {
	protected Board board;
	protected Referee referee;
	protected Order order;
	protected String name;

	@Override
	public void setBoard(Board board) {
		this.board = board;
	}

	@Override
	public void setReferee(Referee referee) {
		this.referee = referee;
	}

	@Override
	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public void setName(String string) {
		this.name = string;
	}

	public abstract Player clone();
}
