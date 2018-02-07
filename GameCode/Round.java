public class Round {
	private String title;
    private Choice[] choices;
    private Event event;
    private Character character;

	public Round(String title, Choice c1, Choice c2, Choice c3, Event event, Character character) {
		this.title = title;
		choices = new Choice[]{c1, c2, c3};
		this.event = event;
		this.character = character;
	}

	public void action() {
	    Game.printDivider();
		System.out.println(this);
		int which = Game.getChoiceFromUser();
		Choice choice = choices[which];
		modify(which);
        character.afterRoundChanges(choice.getMoneyChange(),choice.getBankChange(),
                                    choice.getStockChange(),choice.getCreditChange());
        event.action();
	}

    private void modify(int choice) {
        if (title.equals("Investing")) {
            character.setStock(Character.Stock.values()[choice]);
	    } else if (title.equals("Credit")) {
            if (choice == 0) {
                character.setCreditPaymentPlan(50, 1);
            } else if (choice == 1) {
                character.setCreditPaymentPlan(30, 2);
            } else {
                character.setCreditPaymentPlan(25, 3);
            }
        } else if (title.equals("Stock Credit")) {
            if (choice == 0) {
                character.setCreditPaymentPlan2(0, 0);
            } else if (choice == 1) {
                character.setCreditPaymentPlan2(25, 2);
            } else {
                character.setCreditPaymentPlan2(50, 2);
            }
        } else if (title.equals("Loans")) {
            character.setLoan(choice);
        }
    }

    @Override
    public String toString() {
        return title + "\n1." + choices[0] + "\n2."+ choices[1] + "\n3." + choices[2];
    }
}
