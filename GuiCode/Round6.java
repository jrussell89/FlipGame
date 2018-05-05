package FlipGame.GuiCode;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

public class Round6 extends Round {
    @FXML
    private Toggle card1, card2, card3;
    @FXML
    private ToggleGroup cards;
    @FXML
    private Label roundText1, currentMoney;
    public static String[] criteria = {"What are different things that could impact your credit score?",
            "Overspending, unwise spending",
                                       "Not paying bills on time, not paying loans",
                                       "Mentioning something about interest rates"};

    public void startNext() {
        if (card1.isSelected()) {
            Main.character.creditCard = CreditCard.CARD1;
            Main.character.pay(75.0);
        } else if (card2.isSelected()) {
            Main.character.creditCard = CreditCard.CARD2;
        } else if (card3.isSelected()) {
            Main.character.creditCard = CreditCard.CARD3;
        }
        Main.character.takeMoney(Main.character.creditCard.annualFee);
        if (cards.getSelectedToggle() != null) {
            Main.mainStage.setScene(EndOfRoundScreen.instance.scene);
        } else {
            roundText1.setText("Please pick a card!");
        }
    }
    public void currentMoney() {
        currentMoney.setText("Your Money - $" + Main.character.totalMoney);
    }
}
