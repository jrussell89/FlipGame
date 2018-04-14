package FlipGame.GuiCode;
import FlipGame.GuiCode.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class EndOfRoundScreen extends Round {
    @FXML
    private CheckBox crit0, crit1, crit2;
    @FXML
    private Label criteria, question;
    @FXML
    private Text criteria0, criteria1, criteria2;

    public static Round instance = new Round("endOfRoundQuestion.fxml");

    public void startNextRound() {
        selected(crit0);
        selected(crit1);
        selected(crit2);
        Main.mainStage.setScene(RoundTotal.instance.scene);
    }
    public void selected(CheckBox checkBox) {
        if (checkBox.isSelected()) {
            Main.character.roundPoints++;
        }
        checkBox.setSelected(false);
    }
    public void init() {
        String[] criteria = {"","",""};
        switch (RoundTotal.round) {
            case 0:
                criteria = Round1.criteria;
                break;
            case 1:
                criteria = Round2.criteria;
                break;
            case 2:
                criteria = Round3.criteria;
                break;
            case 3:
                criteria = Round4.criteria;
                break;
            case 5:
                criteria = Round6.criteria;
                break;
        }
        question.setText("Question: " + criteria[0]);
        criteria0.setText(criteria[1]);
        criteria1.setText(criteria[2]);
        criteria2.setText(criteria[3]);
    }
}
