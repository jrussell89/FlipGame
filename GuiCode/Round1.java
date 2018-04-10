package FlipGame.GuiCode;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

public class Round1 extends Round {
    @FXML
    private Slider moneySlider;
    @FXML
    private Label moneyView;

    public static Round instance = new Round("round1.fxml");
    public void startNext() {
        Main.mainStage.setScene(EndOfRoundScreen.instance.scene);
    }

    public void slide() {
        moneyView.setText("$" + (int)Math.ceil(moneySlider.getValue()));
    }
}
