/**
 * GPL
 */
package com.github.fangyun.tictactoe;

/**
 * 执X棋或是执O棋
 * 
 * @author FangYun
 */
public enum Order {
	FIRST(Preference.MAX), SECOND(Preference.MIN);

	private Preference preference;

	private Order(Preference pf) {
		this.preference = pf;
	}

	public Preference getPreference() {
		return preference;
	}
}
