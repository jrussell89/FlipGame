package FlipGame.GuiCode;
import FlipGame.GuiCode.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class EndOfRoundScreen extends Round {
    @FXML
    private CheckBox crit1;
    @FXML
    private CheckBox crit2;
    @FXML
    private CheckBox crit3;
    @FXML
    private Label criteria;

    public static Round instance = new Round("endOfRoundQuestion.fxml");

    public void startNextRound() {
        selected(crit1);
        selected(crit2);
        selected(crit3);
        Main.mainStage.setScene(RoundTotal.instance.scene);
    }
    public void selected(CheckBox checkBox) {
        if (checkBox.isSelected()) {
            Main.character.roundPoints++;
        }
        checkBox.setSelected(false);
    }
}
