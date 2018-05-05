package FlipGame.GuiCode;

import FlipGame.GuiCode.RoundTotal;

import java.util.HashMap;

public class Character {
    public String name;
    public double income;
    public double cash;
    public double bank;
    public double totalMoney;
    public double scholarship;
    public CreditCard creditCard = CreditCard.defaultCard;
    public HashMap<Stock, Double> stocks;
    public HashMap<ETF, Double> etfs;
    public ETF etf;
    public Vacation vacation;
    public boolean loansMoney;

    public double roundPoints;
    public Character() {
        this("Your Team");
    }

    public Character(String name) {
        this.name = name;
        income = 5000;
    }

    public void pay() {
        cash += income;
        totalMoney = cash;
    }
    public void pay(Double amount) {
        if (amount != null) {
            cash += Math.round(amount)/2;
            payBank(amount/2);
            totalMoney += Math.round(amount);
        }
    }

    public void deposit(Double amount) {
        if (amount != null) {
            bank += amount;
            cash -= amount;
        }
    }

    public void bankMatch() {
        if (bank < 1000) {
            totalMoney += bank;
            bank += bank;
        } else {
            totalMoney += 1000;
            bank += 1000;
        }
    }

    public void withdraw(Double amount) {
        if (amount != null) {
            bank -= amount;
            bank += amount;
        }
    }

    public double giveScholarship(){
        scholarship = 6250 * .02 * roundPoints;
        return scholarship;
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
    public void bankInterest() {
        totalMoney += Math.round(bank * .02);
        bank += Math.round(bank * .02);
    }
    public void payBank(Double amount) {
        if (amount != null) {
            bank += Math.round(amount);
        }
    }
}
