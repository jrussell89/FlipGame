package FlipGame.GameCode;

public enum ETF {
    SocialMediaMania(-8,13), WomenWhoLead(4,17), RobotsRising(21,3), CorporateCannabis(-15,6),
    PublicWorks(1,3), RetailTherapy(16,4), AllThatGlitters(2,-1), SmallButMighty(8,-3);

    double day1Earnings;
    double day2Earnings;

    ETF(double day1, double day2){
        day1Earnings = 1 + (day1 * .01);
        day2Earnings = 1 + (day2 * .01);
    }
}
