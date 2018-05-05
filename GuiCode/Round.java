package FlipGame.GuiCode;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Round {
    Parent parent;
    Scene scene;
    public Round() {}
    protected Round(String screenFXML) {
        try {
            parent = FXMLLoader.load(getClass().getResource(screenFXML));
            scene = new Scene(parent, Main.width, Main.height);
        } catch (java.io.IOException e) {

        }
    }


}
