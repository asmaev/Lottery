package lottery;

import java.util.ArrayList;

public class Bet {
	private ArrayList<Integer> betNumbers;
	private int betMoney;

	public Bet() {
		this.betNumbers = new ArrayList<Integer>(4);
	}

	public int computeGain(Tolo t) {
//		System.out.println("t.getluck" + t.getLuck());
		int compatibility = t.checkCompatibility();
		if (compatibility == 4)
			return t.getBet().betMoney * 50;
		if (compatibility == 3)
			return t.getBet().betMoney * 5;
		else
			return 0;
	}

	// Getters & Setters

	public ArrayList<Integer> getBetNumbers() {
		return betNumbers;
	}

	public void setBetNumbers(ArrayList<Integer> betNumbers) {
		this.betNumbers = betNumbers;
	}

	public int getBetMoney() {
		return betMoney;
	}

	public void setBetMoney(int betMoney) {
		this.betMoney = betMoney;
	}

}
