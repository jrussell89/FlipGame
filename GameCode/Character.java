package FlipGame.GameCode;

public class Character {
    public static String name;
    public static double income;
    public static double cash;
    public static double bank;
    public static double totalMoney;
    public static CreditCard creditCard;
    public static Stock stock;
    public static ETF etf;

    public double roundPoints;
    public Character() {
        this("First Last");
    }

    public Character(String name) {
        this.name = name;
    }

    public void pay(double amount) {
        cash = amount;
        totalMoney = amount;
    }

    public void deposit(double amount) {
        bank += amount;
        cash -= amount;
    }

    public void withdraw(double amount) {
        bank -= amount;
        bank += amount;
    }

    public void giveScholarship(){
        double scholarshipAmount = 10000 * .10 * roundPoints;

    }
}
