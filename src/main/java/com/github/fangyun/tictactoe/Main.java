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
		ttt.start();
	}
}
