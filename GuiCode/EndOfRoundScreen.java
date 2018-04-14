package FlipGame.GuiCode;
import FlipGame.GuiCode.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class EndOfRoundScreen extends Round {
    @FXML
    private CheckBox crit0, crit1, crit2;
    @FXML
    private Label criteria;
    @FXML
    private Text criteria0, criteria1, criteria2;

    public static Round instance = new Round("endOfRoundQuestion.fxml");

    public void startNextRound() {
        selected(crit0);
        selected(crit1);
        selected(crit2);
        Main.mainStage.setScene(RoundTotal.instance.scene);
    }
    public void selected(CheckBox checkBox) {
        if (checkBox.isSelected()) {
            Main.character.roundPoints++;
        }
        checkBox.setSelected(false);
    }
}
