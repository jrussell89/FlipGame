package FlipGame.GuiCode;

public class Round3 extends Round {
    public void startNext() {
        Main.mainStage.setScene(EndOfRoundScreen.instance.scene);
    }
}
