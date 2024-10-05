package lottery;

import java.util.Random;

public class SuperBet extends Bet {
	private int luckyNb;

	public SuperBet() {
		Random rand = new Random();
		luckyNb = rand.nextInt(10) + 1;
		// remove later fix the lucky nb
//		luckyNb = 8;

	}

	@Override
	public int computeGain(Tolo t) {
		// TODO Auto-generated method stub
//		System.out.println("COMPUTE GAIN t.getluck"+t.getLuck());
//		System.out.println("COMPUTE GAIN this.getluckynb"+this.getLuckyNb());
		if (t.checkCompatibility() == 4 && t.getLuck() == this.getLuckyNb()) {
			return t.getSuperBet().getBetMoney() * 50 * this.getLuckyNb();
		}
		if (t.checkCompatibility() == 3 && t.getLuck() == this.getLuckyNb())
			return t.getSuperBet().getBetMoney() * 5 * this.getLuckyNb();
		return 0;
	}

	public int getLuckyNb() {
		return luckyNb;
	}

	public void setLuckyNb(int luckyNb) {
		this.luckyNb = luckyNb;
	}

}
