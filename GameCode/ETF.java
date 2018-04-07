package FlipGame.GameCode;

public enum ETF {
    SocialMediaMania(-8,13), WomenWhoLead(4,17),
    RobotsRising(21,3), CorporateCannabis(-15,6),
    PublicWorks(1,3), RetailTherapy(16,4),
    AllThatGlitters(2,-1), SmallButMighty(8,-3);

    double firstEarnings;
    double secondEarnings;

    ETF(double first, double second){
        firstEarnings = 1 + (first * .01);
        secondEarnings = 1 + (second * .01);
    }
}
