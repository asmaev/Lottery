package lottery;

import java.util.ArrayList;
import java.util.Random;

public class Tolo {
	private ArrayList<Integer> drawnNumbers;

	private Bet bet;
	private SuperBet superBet;
	private int luck;

	public Tolo() {
		this.drawnNumbers = new ArrayList<Integer>(4);
		this.bet = new Bet();
		this.superBet = new SuperBet();
		//luck = this.superBet.getLuckyNb();
		//this.superBet.setLuckyNb(5);
//		System.out.println("TOLO LUCK luckyNb : " + this.getSuperBet().getLuckyNb());
//		System.out.println("Tolo luck luck    : "+ this.getLuck());

	}

	public void createBet(int n1, int n2, int n3, int n4, int betMoney) {

		ArrayList<Integer> nbList = new ArrayList<Integer>(4);
		Random rand = new Random();
		int rndNb;

		while (this.drawnNumbers.size() < 4) {
			rndNb = rand.nextInt(20) + 1;
			if (!this.drawnNumbers.contains(rndNb)) {
				this.drawnNumbers.add(rndNb);
			}
		}
		// remove later fix the winning nb
//		this.drawnNumbers.removeAll(drawnNumbers);
//		this.drawnNumbers.add(1);
//		this.drawnNumbers.add(2);
//		this.drawnNumbers.add(3);
//		this.drawnNumbers.add(4);

		nbList.add(n1);
		nbList.add(n2);
		nbList.add(n3);
		nbList.add(n4);

		this.bet.setBetNumbers(nbList);
		this.bet.setBetMoney(betMoney);

	}

	public void createBet(int n1, int n2, int n3, int n4, int luckyNb, int betMoney) {
		this.createBet(n1, n2, n3, n4, betMoney);
		//this.superBet.setLuckyNb(luckyNb);
		this.luck = luckyNb;
//		System.out.println("luck from createBet"+this.luck);
//		System.out.println("luck from superbet random "+ this.getSuperBet().getLuckyNb());
	}


	public int checkCompatibility(/* ArrayList<Integer> list1, ArrayList<Integer> list2 */) {
		int acc = 0;
		for (int i = 0; i < 4; i++) {
			if (this.getDrawnNumbers().get(i) == this.getBet().getBetNumbers().get(i)) {
				acc++;
			}
		}
		return acc;
	}
	
	// Getters & Setters

	public ArrayList<Integer> getDrawnNumbers() {
		return drawnNumbers;
	}

	public void setDrawnNumbers(ArrayList<Integer> drawnNumbers) {
		this.drawnNumbers = drawnNumbers;
	}

	public Bet getBet() {
		return bet;
	}

	public void setBet(Bet bet) {
		this.bet = bet;
	}

	public SuperBet getSuperBet() {
		return superBet;
	}

	public void setSuperBet(SuperBet superBet) {
		this.superBet = superBet;
	}

	public int getLuck() {
		return luck;
	}

	public void setLuck(int luck) {
		this.luck = luck;
	}

}
