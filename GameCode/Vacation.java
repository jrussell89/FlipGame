package FlipGame.GameCode;

import java.util.ArrayList;

public class Vacation {
    enum Location {
        Option1("Hawaii", 180), Option2("Rio", 320), Option3("France", 250);

        public String name;
        public double price;
        Location(String n, double p) {
            name = n;
            price = p;
        }
    }
    enum Hotel {
        Option1("Ritz Carlton", 700), Option2("Motel 6", 150), Option3("Hilton", 360);

        String name;
        double price;
        Hotel(String n, double p) {
            name = n;
            price = p;
        }
    }
    enum Restaurant {
        Option1("Gormet Pizza", 22), Option2("Sushi", 33), Option3("5-Star Steak", 42);

        String name;
        double price;
        Restaurant(String n, double p) {
            name = n;
            price = p;
        }
    }
    enum Activity {
        Option1("Bike riding", 35), Option2("Segway Tour", 45), Option3("Hot Air Balloon", 60),
        Option4("Scuba Diving", 130), Option5("Music Festival", 120), Option6("Bungee jump", 105);

        String name;
        double price;
        Activity(String n, double p) {
            name = n;
            price = p;
        }
        public static double cost(ArrayList<Activity> activities) {
            double cost = 0;
            for (Object act : activities.toArray()) {
                cost += ((Activity) act).price;
            }
            return cost;
        }

    }

    public static Location location;
    public static Hotel hotel;
    public static Restaurant restaurant;
    public static ArrayList<Activity> activities;

    public Vacation(int whichLoc, int whichHot, int whichRest,
                   int[] whichAct) {
        location = Location.values()[whichLoc];
        hotel = Hotel.values()[whichHot];
        restaurant = Restaurant.values()[whichRest];
        for (int actNum : whichAct) {
            activities.add(Activity.values()[actNum]);
        }
    }

    public static double sumVacation() {
        double sum = location.price + hotel.price + restaurant.price
                + Activity.cost(activities);

        return sum;

    }
}
