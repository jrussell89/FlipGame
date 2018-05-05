package FlipGame.GuiCode;

import java.util.ArrayList;

public class Vacation {
    public enum Destination {
        Option1("Hawaii", 255), Option2("Rio", 275), Option3("France", 280),
        Option4("Australia", 300), Option5("Spain", 280), Option("Greece", 300);

        public String name;
        public double price;
        Destination(String n, double p) {
            name = n;
            price = p;
        }
    }
    public enum Hotel {
        Option1("Ritz Carlton", 700), Option2("Motel 6", 150), Option3("Hilton", 360),
        Option4("Holiday Inn", 270);

        String name;
        double price;
        Hotel(String n, double p) {
            name = n;
            price = p;
        }
    }
    public enum Restaurant {
        Option1("Hot Wings", 17), Option2("Snow Crab", 25), Option3("5-Star Steak", 42),
        Option4("Sushi", 33), Option5("Pork Luau", 29), Option6("Gourmet Pizza", 20);

        String name;
        double price;
        Restaurant(String n, double p) {
            name = n;
            price = p;
        }
        public static double cost(ArrayList<Restaurant> restaurants) {
            double cost = 0;
            for (Restaurant rest : restaurants) {
                cost += rest.price;
            }
            return cost;
        }
    }
    public enum Activity {
        Option1("Bike riding", 35), Option2("Music Festival", 120), Option3("Hot Air Balloon", 60),
        Option4("Scuba Diving", 115), Option5("Movies", 12), Option6("Bungee jump", 105),
        Option7("Segway Tour", 45), Option8("Landmark Visit", 30), Option9("Plane Tour",70),
        Option10("Jet Ski", 100);

        String name;
        double price;
        Activity(String n, double p) {
            name = n;
            price = p;
        }
        public static double cost(ArrayList<Activity> activities) {
            double cost = 0;
            for (Activity act : activities) {
                cost += act.price;
            }
            return cost;
        }

    }

    public Destination destination;
    public Hotel hotel;
    public ArrayList<Restaurant> restaurants;
    public ArrayList<Activity> activities;

    public Vacation(int whichDest, int whichHot, ArrayList<Integer> whichRest,
                   ArrayList<Integer> whichAct) {
        destination = Destination.values()[whichDest];
        hotel = Hotel.values()[whichHot];
        for (int restNum : whichRest) {
            restaurants.add(Restaurant.values()[restNum]);
        }
        for (int actNum : whichAct) {
            activities.add(Activity.values()[actNum]);
        }
    }

    public double sumVacation() {
        double sum = destination.price + hotel.price + Restaurant.cost(restaurants) +
                + Activity.cost(activities);
        return sum;
    }
}
