/**
 * GPL
 */
package com.github.fangyun.tictactoe;

/**
 * @author FangYun
 *
 */
public enum PlayerType {
	System(SystemPlayer.class), Manual(ManualPlayer.class);

	private Class<? extends Player> playerClass;

	private PlayerType(Class<? extends Player> playerClass) {
		this.playerClass = playerClass;
	}

	public Class<? extends Player> getPlayerClass() {
		return this.playerClass;
	}
}
