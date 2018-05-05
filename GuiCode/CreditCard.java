package FlipGame.GuiCode;

public enum CreditCard {
    CARD1(95,15), CARD2(75,10), CARD3(60,20), defaultCard(0,0);

    public double annualFee;
    double interest;

    CreditCard(double annualFee, double interest) {
        this.annualFee = annualFee;
        this.interest = interest;
    }
}

