package FlipGame.GuiCode;
import FlipGame.GuiCode.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;

public class EndOfRoundScreen {
    @FXML
    private CheckBox crit1;
    @FXML
    private CheckBox crit2;
    @FXML
    private CheckBox crit3;

    public void start() {
        selected(crit1);
        selected(crit2);
        selected(crit3);
    }
    public void selected(CheckBox checkBox) {
        if (checkBox.isSelected()) {
            Main.character.roundPoints++;
            Main.mainStage.setTitle("" + Main.character.roundPoints);
        }
    }
}
