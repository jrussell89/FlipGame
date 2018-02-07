import java.util.LinkedList;
import java.util.Scanner;

public class Game {
	private static Character character;


	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		character = new Character();
		System.out.print("*********************************" +
				"\n*************READ ME*************\n" +
				"Each of these questions will require you, the facilitator," +
				"\nto input a choice (1, 2, or 3) then press Enter to go to the next scenario.\n" +
				"\nAfter each choice you will be told how much physical cash to take or give " +
                "\nto your group.\n" +
                "\nAt the end of each round your group is to determine if they want to put money" +
				"\ninto or take money out of the the bank based on the money you have in your pile.\n" +
                "\nTo put money into the bank you will enter a positive number less then the amount in the pile." +
                "\nTo take money out of the bank you will enter a negative number more less than the amount in the bank." +
                "\nIF YOU DONT WANT TO PUT OR TAKE MONEY OUT OF THE BANK YOU MUST ENTER A ZERO OR ELSE THE GAME BREAKS!!\n" +
                "\nBut make sure you let them know that the only money they can spend during any " +
                "\nround is from the pile and not the bank. Therefore any money any the bank is unusable.\n" +
                "\nWrite down your groups choices just in the case that the game crashes\n" +
				"\n*************READ ME*************" +
				"\n*********************************\n" +
				"\nPress Enter to start the Game.");
		scan.nextLine();
		printDivider();
		System.out.println("Choose your education:" +
				"\n1.University" +
				"\n2.Trade School" +
				"\n3.No College");
		character.setEducation(Character.Education.values()[getChoiceFromUser()]);
		printDivider();
		System.out.println("Choose your Job:" +
                "\n1.Least Pay/More Free Time" +
				"\n2.Medium Pay/Average Free " +
                "\n3.Most Pay/Little Free Time");
		new Job(character, getChoiceFromUser());
        character.getJob().pay();
        printDivider();
        System.out.println("Please give your group ($" + character.getWage() + "). Tell them this is their " +
                "wage." +
                "\nPress Enter to continue.");
        scan.nextLine();
		int i = 0;
		while(i < 6) {
			printDivider();
            makeRounds(i).action();
			printDivider();
			changeToTheBank();
			printDivider();
			i++;
		}
		printDivider();
		double allMoney = character.getCash() + character.getBankBalance() * 1.10;
		System.out.println("Here is your teams final amount of money overall (" + allMoney + ")" +
                "\nRecord this number and tell a Flip leader." +
                "\nPress Enter to end the game.");
		scan.nextLine();
	}

	private static Round makeRounds(int i) {
        String title;
        Choice choice1, choice2, choice3;
        switch (i) {
            case 0:
                title = "Banking";
                choice1 = new Choice("Put Nothing", 0, 0, 0, 0);
                choice2 = new Choice("Put Half", 0, character.getCash() * .5, 0, 0);
                choice3 = new Choice("Put All", 0, character.getCash(), 0, 0);
                break;
            case 1:
                title = "Investing";
                choice1 = new Choice("Penny", -50, 0, 50, 0);
                choice2 = new Choice("Blue Chip", -50, 0, 50, 0);
                choice3 = new Choice("Start-Up", -50, 0, 50, 0);
                break;
            case 2:
                title = "Credit";
                choice1 = new Choice("$50/now", 0, 0, 0, 0);
                choice2 = new Choice("$30/2 rounds", 0, 0, 0, 0);
                choice3 = new Choice("$25/3 rounds", 0, 0, 0, 0);
                break;
            case 3:
                title = "Stock Credit";
                choice1 = new Choice("Don't Buy Any", 0, 0, 0, 0);
                choice2 = new Choice("Buy $50 Worth", -50, 0, 50, 0);
                choice3 = new Choice("Buy $100 Worth", -100, 0, 100, 0);
                break;
            case 4:
                title = "Save/Spend";
                choice1 = new Choice("Lottery Ticket", -20, 0, 0, 0);
                choice2 = new Choice("Movies", -20, 0, 0, 0);
                choice3 = new Choice("Wait For Bank", 0, 0, 0, 0);
                break;
            default:
                title = "Loans";
                choice1 = new Choice("Bank", 50, 0, 0, 0);
                choice2 = new Choice("Friend of Friend", 5, 0, 0, 0);
                choice3 = new Choice("Lending Tree", 25, 0, 0, 0);
                break;
        }
        return new Round(title,choice1,choice2,choice3,makeEvents(i),character);
	}

    private static Event makeEvents(int i) {
	    String title;
        Choice choice1, choice2;
        switch (i) {
            case 0:
                title = "Bank Match";
                choice1 = null;
                choice2 = null;
                break;
            case 1:
                title = "Stock Market #1";
                choice1 = new Choice("Take Money", 42, 0, -50, 0);
                choice2 = new Choice("Stay In", 50, 0, 0, 0);
                break;
            case 2:
                title = "Work On Saturday";
                choice1 = new Choice("Go To Work", character.getWage() * .5, 0, 0, 0);
                choice2 = new Choice("Don't Go", 0, 0, 0, 0);
                break;
            case 3:
                title = "Stock Market #2";
                choice1 = null;
                choice2 = null;
                break;
            case 4:
                title = "Work Bonus";
                choice1 = new Choice("Ask For Bonus", 100,0,0,0);
                choice2 = new Choice("Don't Ask", 0,0,0,0);
                break;
            default:
                title = "Loan Sharks";
                choice1 = null;
                choice2 = null;
                break;
        }
        return new Event(title, choice1, choice2, character);
    }

	private static void changeToTheBank() {
        System.out.println("Here is you current Cash Amount (" + character.getCash() + ")");
		System.out.println("Here is you current Bank Balance (" + character.getBankBalance() + ")");
		double money = getBankChangeFromUser();
		character.afterRoundChanges(0, money,0,0);
		System.out.println("You Bank Balance is now (" + character.getBankBalance() + ")");
	}
    public static double giveCashAfterRound(double money, double bank, double stock, double credit) {
        Scanner scan = new Scanner(System.in);
        System.out.println("This is a list of all money exchanges that just happened:");
        //bank exchange
        if (bank > 0) {
            System.out.println("\tPut ($" + bank + ") in the bank.");
        } else if (bank < 0) {
            System.out.println("\tTook ($" + bank * -1+ ") out of the bank.");
        }
        money -= bank;
        //stock exchange
        if (stock > 0) {
            System.out.println("\tPut ($" + stock + ") in the stock market.");
        } else if (stock < 0) {
            System.out.println("\tTook ($" + stock * -1 + ") out of the stock market.");
        }
        money -= stock;
        //credit change
        if (credit > 0) {
            System.out.println("\tAdded ($" + credit + ") to your credit card.");
        } else if (credit < 0) {
            System.out.println("\tPaid ($" + credit * -1 + ") on your credit card.");
        }
        //all money exchange
        printDivider();
        if (money < 0){
            System.out.println("Take away ($" + money * -1 + ") from your group.");
        } else if (money > 0) {
            System.out.println("Give your group ($" + money + ").");
        } else {
            System.out.println("No need to give or take money this round.");
        }
        System.out.println("Press Enter to continue.");
        scan.nextLine();
        return money;
    }

	public static double giveCashAfterEvent(double money, double wage, double bank, double stock, double credit) {
        Scanner scan = new Scanner(System.in);
        System.out.println("This is a list of all money exchanges that just happened:");
        //wage pay
        System.out.println("\tGot paid($" + wage + ").");
        money += wage;
        //bank exchange
        if (bank > 0) {
            System.out.println("\tPut ($" + bank + ") in the bank.");
        } else if (bank < 0) {
            System.out.println("\tTook ($" + bank  * -1  + ") out of the bank.");
        }
        //stock exchange
        if (stock > 0) {
            System.out.println("\tPut ($" + stock + ") in the stock market.");
        } else if (stock < 0) {
            System.out.println("\tTook ($" + stock  * -1 + ") out of the stock market.");
        }
        money -= stock;
        //credit change
        if (credit > 0) {
            System.out.println("\tPut ($" + credit + ") onto your credit card.");
        } else if (credit < 0) {
            System.out.println("\tPaid ($" + credit  * -1 + ") on your credit card.");
            money -= credit;
        }
        printDivider();
        //all money exchange
        if (money < 0){
            System.out.println("Take away ($" + money * -1 + ") from your group.");
        } else if (money > 0) {
            System.out.println("Give your group ($" + money + ").");
        } else {
            System.out.println("No need to give or take money this round.");
        }
        System.out.println("Press Enter to continue.");
        scan.nextLine();
        return money;
    }
	public static int getChoiceFromUser() {
		System.out.print("Enter 1, 2, or 3:");
		Scanner scan = new Scanner(System.in);
		int num = -1;
		do {
			try {
				num = Integer.parseInt(scan.nextLine());
			} catch (Exception e) {
				System.out.print("");
			}
			if (!(num == 1 || num == 2 || num == 3)) {
				System.out.print("Please enter a valid choice 1, 2, or 3:");
			}
		} while (!(num == 1 || num == 2 || num == 3));
		return num - 1;
	}
    public static int getChoice2FromUser() {
        System.out.print("Enter 1 or 2:");
        Scanner scan = new Scanner(System.in);
        int num = -1;
        do {
            try {
                num = Integer.parseInt(scan.nextLine());
            } catch (Exception e) {
                System.out.print("");
            }
            if (!(num == 1 || num == 2)) {
                System.out.print("Please enter a valid choice 1 or 2:");
            }
        } while (!(num == 1 || num == 2));
        return num - 1;
    }
	public static double getBankChangeFromUser() {
		System.out.println("Encourage your group to put money into the bank!");
		System.out.print("Enter an amount to put into the bank:");
		Scanner scan = new Scanner(System.in);
		double cash = character.getCash();
		double bankAccount = character.getBankBalance();
		double num = Double.MIN_VALUE;
		do {
			try {
				num = Double.parseDouble(scan.nextLine());
			} catch (Exception e) {
				System.out.print("");
			}
			if (!(num >= -bankAccount && num <= cash)) {
				System.out.print("Please enter a valid amount of money \nto add from your money pile:");
			}
		} while (!(num >= -bankAccount && num <= cash));
		return num;
	}
	public static void printDivider() {
		System.out.println("__________________________________________________________");
	}
}