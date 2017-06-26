/**
 * GPL
 */
package com.github.fangyun.tictactoe;

/**
 * @author FangYun
 *
 */
public class PlayerFactory {
	private static PlayerFactory INSTANCE = null;

	public static PlayerFactory newInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PlayerFactory();
		}
		return INSTANCE;
	}

	public Player create(PlayerType playerType) {
		return null;
	}

}
