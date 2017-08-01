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
		int plus = 0;
		int neg = 0;
		int zero = 0;
		for (int i = 0; i < 1; i++) {
			TicTacToe ttt = new TicTacToe(option);
			Integer utility = ttt.play();
			switch (utility) {
			case 0:
				zero++;
				break;
			case 1:
				plus++;
				break;
			case -1:
				neg++;
				break;
			}
		}
		System.out.println(String.format("First=%d , Second=%d, Zero=%d", plus, neg, zero));
	}
}
