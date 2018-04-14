package FlipGame.GuiCode;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class RoundTotal {
    public static Round instance = new Round("roundTotal.fxml");
    public static RoundTotal thisInstance = new RoundTotal();
    private static int round = 0;
    @FXML
    private Label header, reportText, cashText, bankText,
                  totalText, pointsText, cardText;

    public void init() {
        header.setText("End of Round " + (round + 1));
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
                nextFxml = "round5.fxml";
                break;
            case 5:
                nextFxml = "round6.fxml";
                break;
            case 6:
                nextFxml = "round7.fxml";
                break;
            case 7:
                nextFxml = "gameEnd.fxml";
                break;
        }
        try {
            Parent nextRoot = FXMLLoader.load(getClass().getResource(nextFxml));
            nextScene = new Scene(nextRoot, Main.width, Main.height);
        } catch (java.io.IOException e) {

        }
        Main.mainStage.setScene(nextScene);
    }
}
