package FlipGame.GuiCode;

public enum ETF {
    SocialMediaMania(-8,13), WomenWhoLead(4,17),
    RobotsRising(21,3), YoungMoney(-15,6),
    PublicWorks(1,3), RetailTherapy(16,4),
    AllThatGlitters(2,-1), SmallButMighty(8,-3);

    public double[] earnings;

    ETF(double first, double second){
        earnings = new double[2];
        earnings[0] = 1 + (first * .01);
        earnings[1] = 1 + (second * .01);
    }
}
