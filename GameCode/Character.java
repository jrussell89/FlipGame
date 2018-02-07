public class Character {
    
    enum Education {
        UNIVERSITY(1.5),
        TRADESCHOOL(1.2),
        NONE(1);

        private double moneyMultiplier;
        public static String[] colleges = {"University", "Trade School", "None"};
        Education(double moneyMultiplier) {
            this.moneyMultiplier = moneyMultiplier;
        }
        public double getMoneyMultiplyer() { return moneyMultiplier; }
    }
    enum Stock {
        PENNY(.5),
        BLUECHIP(1.25),
        STARTUP(1.5);

        private double firstInvestmentMultiplier;
        public String[] stocks = {"Penny Stock", "Blue Chip", "Start-Up"};
        Stock(double firstInvestmentMultiplier) {
            this.firstInvestmentMultiplier = firstInvestmentMultiplier;
        }

        public double getFirstInvestmentMultiplier() { return firstInvestmentMultiplier; }

    }
    private double cash;
    private Education education;
    //Job
    private Job job;
    private double wage;
    //Stock
    private Stock stock;
    private double stockBalance;
    private double bankBalance;
    private double creditToPay;
    private double creditPayment;
    private double roundsToPay;
    private double creditPayment2;
    private double roundsToPay2;
    private boolean workedOnSat;
    private int loan;


    public Character() {
        this.cash = 0;
        this.bankBalance = 0;
        this.stockBalance = 0;
        this.wage = 0;
        this.job = null;
        
    }
    public void afterRoundChanges(double moneyCost, double bankChange, double stockChange, double creditChange) {
        Game.printDivider();
        moneyCost = Game.giveCashAfterRound(moneyCost, bankChange, stockChange, creditChange);
        cash += moneyCost;
        bankBalance += bankChange;
        stockBalance += stockChange;
        creditToPay += creditChange;
    }
    public void afterEventChanges(double moneyCost, double bankChange, double stockChange) {
        Game.printDivider();
        moneyCost = Game.giveCashAfterEvent(moneyCost, wage, bankChange, stockChange, creditPayment + creditPayment2);
        cash += moneyCost;
        bankBalance += bankChange;
        stockBalance += stockChange;
        if(roundsToPay > 0 || roundsToPay2 > 0) {
            System.out.println("Take ($" + (creditPayment + creditPayment2) + ") for the credit card payment.");
        }
        roundsToPay--;
        roundsToPay2--;
        creditToPay += creditPayment;
        //System.out.println("This is all your current info:\n" + this);
    }
    public void setCreditPaymentPlan(double payment, int rounds) {
        creditPayment = payment;
        roundsToPay = rounds;
    }
    public void setCreditPaymentPlan2(double payment, int rounds) {
        creditPayment2 = payment;
        roundsToPay2 = rounds;
    }
    public void setWorkedOnSat(boolean worked) { workedOnSat = worked; }

    public void addToCash(Double money) { this.cash += money; }
    public void addToBank(Double money) { this.bankBalance += money; }
    public void addToStock(Double money) {
        stockBalance += money;
        this.cash -= money; //group can only use cash for to pay for things
    }
    public void payCredit(Double money) {
        this.cash -= money;
        creditToPay -= money;
    }

    public void setEducation(Education ed) { this.education = ed; }
    public void setJob(Job job) { this.job = job; }
    public void setStock(Stock stock) { this.stock = stock; }
    public void setLoan(int who) { loan = who; }
    public void setWage(double wage) { this.wage =  wage;  }

    public Education getEducation() { return education; }
    public Job getJob() { return job; }
    public Stock getStock() { return stock; }
    public double getWage() { return wage; }
    public double getCash() { return cash; }
    public double getStockBalance() { return  stockBalance; }
    public double getBankBalance() { return bankBalance; }
    public double getCreditToPay() { return creditToPay; }
    public boolean getWorkedOnSat() { return workedOnSat; }
    public int getLoan() { return loan; }

    @Override
    public String toString() {
        return "Cash Amount (" + cash + ")\n" + "Bank Account (" + bankBalance + ")\n";
    }
}