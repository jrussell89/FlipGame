package FlipGame.GuiCode;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class RoundTotal {
    public static Round instance = new Round("roundTotal.fxml");
    private static int round = 0;

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
