package FlipGame.GuiCode;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage mainStage;
    public static Scene startScene;
    public static Scene nextScene;
    public static FlipGame.GameCode.Character character = new FlipGame.GameCode.Character("James Thomas");
    private int width = 640;
    private int height = 400;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent startRoot = FXMLLoader.load(getClass().getResource("start_screen.fxml"));
        startScene = new Scene(startRoot, width, height);

        Parent nextRoot = FXMLLoader.load(getClass().getResource("endOfRoundQuestion.fxml"));
        nextScene = new Scene(nextRoot, width, height);

        mainStage = primaryStage;
        primaryStage.setTitle("Flip Competition");
        primaryStage.setScene(startScene);
        primaryStage.show();
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
