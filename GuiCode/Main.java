package FlipGame.GuiCode;

import FlipGame.GameCode.Character;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage mainStage;
    public static Scene startScene;
    public static Scene nextScene;
    public static Character character;
    public static int width = 640;
    public static int height = 400;

    @Override
    public void start(Stage primaryStage) throws Exception{
        character = new Character();
        Parent startRoot = FXMLLoader.load(getClass().getResource("start_screen.fxml"));
        startScene = new Scene(startRoot, width, height);
        Parent nextRoot = FXMLLoader.load(getClass().getResource("round0.fxml"));
        nextScene = new Scene(nextRoot, width, height);

        mainStage = primaryStage;
        primaryStage.setTitle("Flip Competition");
        primaryStage.setScene(startScene);
        primaryStage.show();
    }

    public void fill(Scene scene) {

    }

    public Stage getMainStage() {
        return mainStage;
    }

    public void populateQuestions() {

    }
//    public static void nextStage() {
//        Parent root;
//        try {
//            root = FXMLLoader.load(getClass().getResource("next.fxml"));
//            mainStage.setScene(new Scene(root, 600, 400));
//        } catch (Exception e) {
//
//        }
//    }

    public static void main(String[] args) {
        launch(args);
    }
}
