package FlipGame.GuiCode;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Round2 extends Round {
    @FXML
    private Label moneyLabel;
    @FXML
    private TextField moneyField;

    public void startNext() {
        try {
            if (!"".equals(moneyField.getText())) {
                Double amount = Double.parseDouble(moneyField.getText());
                if (amount != null) {
                    if (amount > Main.character.cash) {
                        throw new Exception("Number too Large");
                    } else if (amount < 0) {
                        throw new Exception("Number is Negative");
                    }
                    Main.character.deposit(amount);
                }
            }
            Main.mainStage.setScene(EndOfRoundScreen.instance.scene);
        } catch (Exception e) {
            moneyLabel.setText("Type integer number between $0 and $" + Main.character.cash + "!");
        }
    }
}
