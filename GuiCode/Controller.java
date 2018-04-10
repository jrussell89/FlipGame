package FlipGame.GuiCode;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.stage.Stage;

public class Controller {
    Stage mainStage;

    public void startRound0() {
        mainStage = Main.mainStage;

        mainStage.setScene(Main.nextScene);
    }
}
