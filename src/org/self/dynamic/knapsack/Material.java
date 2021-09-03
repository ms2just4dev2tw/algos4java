package org.self.dynamic.knapsack;

public class Material {

	// 物品序列号
	private int number;
	// 物品价值
	private int value;
	// 物品体积
	private int volume;

	public Material(int number, int value, int volume) {
		this.number = number;
		this.value = value;
		this.volume = volume;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

}
