package FlipGame.GameCode;

public enum Stock {
    Netflix(11, -1),ExxonMobile(-1,-10),
    Facebook(11,-15), Amazon(13, 20),
    Apple(15,-9), Boeing(4,-5),
    CocaCola(7,10), WaltDisneyCompany(8,8);

    public double[] earnings;

    Stock(double first, double second){
        earnings = new double[2];
        earnings[0] = 1 + (first * .01);
        earnings[1] = 1 + (second * .01);
    }
}
