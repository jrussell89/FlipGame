package FlipGame.GuiCode;

public class Round4 extends Round {
    public void startNext() {
        Main.mainStage.setScene(EndOfRoundScreen.instance.scene);
    }
}
