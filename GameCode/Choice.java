import java.util.ArrayList;

public class Choice {

	private String title;
	private double moneyChange;
	private double creditChange;
	private double bankChange;
	private double stockChange;

	public Choice(String title, double moneyChange, double bankChange, double stockChange, double creditChange) {
		this.title = title;
		this.moneyChange = moneyChange;
		this.bankChange = bankChange;
		this.stockChange = stockChange;
		this.creditChange = creditChange;
	}

	public double getMoneyChange() { return moneyChange; }

	public double getBankChange() { return bankChange; }

	public double getCreditChange() {return creditChange; }

	public double getStockChange() { return creditChange; }

	public String toString() {
		return title;/* +
				"\n" + ((moneyChange != 0.0) ? "Cost: $" + (moneyChange * ((moneyChange < 0)? -1:1)) + "\n": "") +
				((bankChange != 0) ? "Bank Change: " + (bankChange * ((bankChange < 0)? -1:1)) + "\n": "") +
				((stockChange != 0.0) ? "Credit Change: " + (stockChange * ((stockChange < 0)? -1:1)) + "\n" : "") +
				((creditChange != 0.0) ? "Credit Change: " + (creditChange * ((creditChange < 0)? -1:1) ) + "\n" : "");*/
	}
}