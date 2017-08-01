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

	public Player create(PlayerType playerType, Order order, String string) {
		try {
			Player p = (Player) playerType.getPlayerClass().newInstance();
			p.setOrder(order);
			p.setName(string);
			return p;
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

}
