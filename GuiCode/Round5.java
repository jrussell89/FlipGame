package FlipGame.GuiCode;

public class Round5 extends Round {
    public void startNext() {
        Main.mainStage.setScene(EndOfRoundScreen.instance.scene);
    }
}
