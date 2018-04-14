package FlipGame.GuiCode;

import FlipGame.GameCode.Vacation;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

import java.util.ArrayList;

public class Round7 extends Round {
    @FXML
    private RadioButton dest0, dest1, dest2, dest3, dest4, dest5,
                        hot0, hot1, hot2, hot3;
    @FXML
    private CheckBox rest0, rest1, rest2,
                     rest3, rest4, rest5,
                     act0, act1, act2, act3, act4,
                     act5, act6, act7, act8, act9;

    public void startNext() {
        RadioButton[] dests = {dest0, dest1, dest2, dest3, dest4, dest5};
        RadioButton[] hots = {hot0, hot1, hot2, hot3};
        CheckBox[] rests = {rest0, rest1, rest2, rest3, rest4, rest5};
        CheckBox[] acts = {act0, act1, act2, act3, act4, act5, act6, act7, act8, act9};
        int whichDest = 0;
        while (!dests[whichDest].isSelected()) {
            whichDest++;
        }
        int whichHot = 0;
        while (!hots[whichHot].isSelected()) {
            whichHot++;
        }
        ArrayList<Integer> whichRests =  new ArrayList<>();
        for (int i = 0; i < rests.length; i++) {
            if (rests[i].isSelected()) {
                whichRests.add(i);
            }
        }
        ArrayList<Integer> whichActs = new ArrayList<>();
        for (int i = 0; i < acts.length; i++) {
            if (acts[i].isSelected()) {
                whichActs.add(i);
            }
        }
        Main.character.vacation = new Vacation(whichDest, whichHot, whichRests, whichActs);
        Main.character.takeMoney(Main.character.vacation.sumVacation());
        Main.mainStage.setScene(EndOfRoundScreen.instance.scene);
    }
}
