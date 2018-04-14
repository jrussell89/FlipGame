package FlipGame.GuiCode;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Round1 extends Round {
    public static Round instance = new Round("round1.fxml");
    public static String[] criteria = {"Your saving account is earning 2% per year and inflation is 4% per year, both compounded annually. After one year, do you have the same buying power as you did before?",
                                       "",
                                       "", ""};

    public void startNext() {
        Main.mainStage.setScene(EndOfRoundScreen.instance.scene);
    }

}
