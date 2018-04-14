package FlipGame.GuiCode;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class RoundTotal {
    public static Round instance = new Round("roundTotal.fxml");
    public static int round = 0;
    @FXML
    private Label header, reportText, cashText, bankText,
                  totalText, pointsText, cardText, currentMoney, currentMoney2;
    @FXML
    private Button next;
    @FXML
    private CheckBox yes;

    public void init() {
        if (round == 5) {
            header.setText("End of Round " + round);
        } else if (round < 7) {
            header.setText("End of Round " + (round + 1));
        } else {
            next.setOpacity(0);
            header.setText("This is the final Screen!!!");
        }
        reportText.setText("Round Report");
        cashText.setText("Cash - $" + Main.character.cash);
        bankText.setText("Bank Balance - $" + Main.character.bank);
        totalText.setText("Total Money - $" + Main.character.totalMoney);
        pointsText.setText("Question Points - " + Main.character.roundPoints);
        if (round > 4) {
            cardText.setText("Credit Card - " + Main.character.creditCard);
        }
    }

    public void startNext() {
        Scene nextScene = null;
        String nextFxml = "";
        round++;
        switch (round) {
            case 1:
                nextFxml = "round2.fxml";
                break;
            case 2:
                nextFxml = "round3.fxml";
                break;
            case 3:
                nextFxml = "round4.fxml";
                break;
            case 4:
                nextFxml = "roundLoan.fxml";
                break;
            case 5:
                loans();
                nextFxml = "round6.fxml";
                break;
            case 6:
                nextFxml = "roundLoan2.fxml";
                break;
            case 7 :
                loans2();
                nextFxml = "round5.fxml";
                break;
            case 8:
                nextFxml = "roundTotal.fxml";
                break;
        }
        try {
            Parent nextRoot = FXMLLoader.load(getClass().getResource(nextFxml));
            nextScene = new Scene(nextRoot, Main.width, Main.height);
        } catch (java.io.IOException e) {

        }
        Main.character.bankInterest();
        Main.mainStage.setScene(nextScene);
    }

    private void loans() {
        Main.character.loansMoney = yes.isSelected();
        if (Main.character.loansMoney)
        Main.character.takeMoney(1000);
    }
    private void loans2() {
        if (Main.character.loansMoney)
        Main.character.pay(500.0);
    }
    public void currentMoney() {
        currentMoney.setText("Your Money - $" + Main.character.totalMoney);
    }
    public void currentMoney2() {
        currentMoney2.setText("Your Money - $" + Main.character.totalMoney);
    }

}
