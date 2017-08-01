/**
 * GPL
 */
package com.github.fangyun.tictactoe;

/**
 * @author FangYun
 *
 */
public interface Player {

	Player clone();

	void setBoard(Board board);

	void setReferee(Referee referee);

	void play();

	void setOrder(Order order);

	void setName(String string);

}
