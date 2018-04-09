package FlipGame.GuiCode;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

public class Round {
    Parent parent;

    public Round(String screenFXML) {
        try {
            parent = FXMLLoader.load(getClass().getResource(screenFXML));
        } catch (java.io.IOException e) {

        }
    }

}
