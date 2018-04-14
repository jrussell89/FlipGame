package FlipGame.GuiCode;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Round1 extends Round {
    public static Round instance = new Round("round1.fxml");
    public void startNext() {
        Main.mainStage.setScene(EndOfRoundScreen.instance.scene);
    }

}
