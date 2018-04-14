package FlipGame.GuiCode;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Round5 extends Round {
    @FXML
    private Label roundText1;

    public void startNext() {
        Main.mainStage.setScene(EndOfRoundScreen.instance.scene);
    }
    public void update() {
        roundText1.setText("Your team has been awarded $" + Main.character.giveScholarship()
                            + " in Scholarship funds");
    }

}
