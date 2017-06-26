/**
 * GPL
 */
package com.github.fangyun.tictactoe;

/**
 * @author FangYun
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Option option = new Option(args);
		TicTacToe ttt = new TicTacToe(option);
		Timer t = ttt.start();
		try {
			t.wait(option.getGameMaxDuration());
		} catch (InterruptedException e) {
			System.err.println("Game time is over!");
		}
	}
}
