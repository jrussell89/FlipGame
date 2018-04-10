package FlipGame.GuiCode;

public class Round2 extends Round {
    public void startNext() {
        Main.mainStage.setScene(EndOfRoundScreen.instance.scene);
    }
}
