package FlipGame.GameCode;

import java.util.HashMap;

public class Character {
    public String name;
    public double income;
    public double cash;
    public double bank;
    public double totalMoney;
    public CreditCard creditCard;
    public HashMap<Stock, Double> stocks;
    public HashMap<ETF, Double> etfs;
    public ETF etf;
    public Vacation vacation;

    public double roundPoints;
    public Character() {
        this("Your Team");
    }

    public Character(String name) {
        this.name = name;
        income = 14000;
    }

    public void pay() {
        cash = income / 7;
        totalMoney = income / 7;
    }
    public void pay(Double amount) {
        if (amount != null) {
            cash += Math.round(amount);
            totalMoney += Math.round(amount);
        }
    }

    public void deposit(Double amount) {
        if (amount != null) {
            bank += amount;
            cash -= amount;
        }
    }

    public void withdraw(Double amount) {
        if (amount != null) {
            bank -= amount;
            bank += amount;
        }
    }

    public double giveScholarship(){
        double scholarshipAmount = 6250 * .02 * roundPoints;
        return scholarshipAmount;
    }

    public void takeMoney(double amount) {
        if (cash > 0) {
            cash -= amount;
            if (cash < 0) {
                takeMoney(-cash);
                cash = 0;
            }
        } else {
            bank -= amount;
        }
        totalMoney = bank + cash;
    }
}
