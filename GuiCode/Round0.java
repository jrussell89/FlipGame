package FlipGame.GuiCode;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

public class Round0 {
    public static Parent parent;
    public static Scene scene;

    @FXML
    private TextField nameField;

    public void startNext() {
        setName();
        Main.character.pay();
        Main.mainStage.setScene(Round1.instance.scene);
    }

    public void init(String fxml) {
        try {
            parent = FXMLLoader.load(getClass().getResource(fxml));
            scene = new Scene(parent, Main.width, Main.height);
        } catch (java.io.IOException e) {

        }
    }

    public void setName() {
        if (nameField != null) {
            Main.character.name = nameField.getText();
        }
    }


}
