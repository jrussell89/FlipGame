public class Event {
	private String title;
	private Choice[] choices;
	private double stockMultiplyer;
	private int went;
    private Character character;

	public Event(String title, Choice c1, Choice c2, Character character) {
		this.title = title;
		choices = new Choice[]{c1,c2};
		stockMultiplyer = 1;
		went = 1;
		this.character = character;
	}

	public void action() {
	    Game.printDivider();
		System.out.println(this);
		if (choices[0] != null) {
            int which = Game.getChoice2FromUser();
            Choice choice = choices[which];
            modify(which);
            character.afterEventChanges(choice.getMoneyChange() * went * stockMultiplyer, choice.getBankChange(),
                    choice.getStockChange());
        }

        switch (title) {
            case "Bank Match":
                character.afterEventChanges(0,
                        character.getBankBalance() + 5, 0);
                break;
            case "Stock Market #2":
                character.afterEventChanges(character.getStockBalance() * .9, 0, character.getStockBalance());
                break;
            case "Loan Sharks":
                if (character.getLoan() == 1 || character.getLoan() == 2) {
                    character.afterEventChanges(-100, 0, 0);
                }
                break;
        }
	}
    private void modify(int choice) {
        if (title.equals("Stock Market #1")) {
            stockMultiplyer = character.getStock().getFirstInvestmentMultiplier();
        } else if (title.equals("Work On Saturday")) {
            character.setWorkedOnSat(choice == 0);

        } else if (title.equals("Work Bonus")) {
            if (!character.getWorkedOnSat()) {
                went = 0;
            }
        }
    }

	@Override
	public String toString() {
		return title +
				"\n" + "1." +((choices[0] == null) ? "No Choice" : choices[0]) +
				"\n" + "2." + ((choices[1] == null) ? "No Choice" : choices[1]);
	}
}
