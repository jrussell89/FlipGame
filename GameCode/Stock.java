package FlipGame.GameCode;

public enum Stock {
    Netflix(11, -1),ExxonMobile(-1,-10),
    Facebook(11,-15), Amazon(13, 20),
    Apple(15,-9), Boeing(4,-5),
    CocaCola(7,10), WaltDisneyCompany(8,8);

    double firstEarnings;
    double secondEarnings;

    Stock(double first, double second){
        firstEarnings = 1 + (first * .01);
        secondEarnings = 1 + (second * .01);
    }
}
