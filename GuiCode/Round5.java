package FlipGame.GuiCode;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Round5 extends Round {
    @FXML
    private Label roundText1, roundText12, currentMoney;
    public static String[] criteria = {"How does a loan normally work? What is the difference between a student loan and a normal loan?",
            "Someone (a bank) give another person money with the intent that it will be paid back",
            "loans accumulate interest",
            "Student loans defer payment until the receiver is out of college"};

    public void startNext() {
        Main.character.pay(Main.character.scholarship + 5000);
        Main.mainStage.setScene(EndOfRoundScreen.instance.scene);
    }
    public void update() {
        currentMoney.setText("Your Money - $" + Main.character.totalMoney);
        roundText1.setText("Your team has been awarded $" + Main.character.giveScholarship()
                            + " in Scholarship funds");
        double expense = 10000 - Main.character.scholarship - 5000;
        roundText12.setText("You still need to pay $" + expense);
    }
}
