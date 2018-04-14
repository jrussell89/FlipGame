package FlipGame.GuiCode;

import FlipGame.GameCode.ETF;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.util.HashMap;

public class Round4 extends Round {
    @FXML
    private Label roundTitle, roundText, roundText2,
            roundText3, yourETF1, yourETF2,
            share0, share1, share2, share3,
            share4, share5, share6, share7;
    @FXML
    private TextField stock0, stock1, stock2, stock3,   //actually etfs
            stock4, stock5, stock6, stock7;
    @FXML
    private CheckBox buy0, buy1, buy2, buy3,
            buy4, buy5, buy6, buy7;
    @FXML
    private HBox box1, box2;

    private static TextField[] etfs;

    public static int times = 0;
    public void startNext() {
        HashMap<ETF, Double> stockMap = new HashMap<>();
        boolean corrupt = false;
        double total = 0;
        etfs = new TextField[]{stock0, stock1, stock2, stock3,
                stock4, stock5, stock6, stock7};
        CheckBox[] buys = {buy0, buy1, buy2, buy3,
                buy4, buy5, buy6, buy7};
        for (int i = 0; i < etfs.length; i++) {
            try {
                if (times == 1 && buys[i].isSelected()) {
                    Main.character.pay(Main.character.etfs.remove(ETF.values()[i]));
                    buys[i].setSelected(false);
                } else {
                    Double amount = 0.0;
                    if (!"".equals(etfs[i].getText())) {
                        amount = Double.parseDouble(etfs[i].getText());
                        total += amount;
                    }
                    if (times == 1 && !(Main.character.etfs.get(ETF.values()[i]) == null)) {
                        amount += Main.character.etfs.get(ETF.values()[i]);
                    }
                    stockMap.put(ETF.values()[i], ETF.values()[i].earnings[times] * amount);
                }
            } catch (Exception e) {
                roundText.setText("Please make sure you only use positive integers!!");
                corrupt = true;
                break;
            }
        }
        if (total > Main.character.totalMoney) {
            roundText2.setText("Make sure all of your investments are less that your total money!");
        }
        if (!corrupt && total >= 0 && total <= Main.character.totalMoney) {
            Main.character.etfs = stockMap;
            Main.character.takeMoney(total);
            if (times == 0) {
                roundTitle.setText("Round 4 - ETFs Second");
                roundText.setText("Enter the amount you would like to invest in these companies");
                roundText2.setText("");
                roundText3.setText("If you want to buy back stock click the button next to the name");
                yourETF1.setText("Your ETFs");
                yourETF2.setText("Your ETFs");
                box1.setOpacity(1);
                box1.setDisable(false);
                box2.setOpacity(1);
                box2.setDisable(false);
                Label[] shares = {share0, share1, share2, share3,
                        share4, share5, share6, share7};
                for (int i = 0; i < shares.length; i++) {
                    Double amount = Main.character.etfs.get(ETF.values()[i]);
                    if (amount != null) {
                        shares[i].setText("$" + amount);
                    } else {
                        shares[i].setText("$0");
                    }
                }
                for (TextField tf : etfs) {
                    tf.clear();
                }
                times++;
            } else {
                for (int i = 0; i < etfs.length; i++) {
                    Double amount = Main.character.etfs.get(ETF.values()[i]);
                    Main.character.pay(amount);
                }
                Main.mainStage.setScene(EndOfRoundScreen.instance.scene);
            }
        }
    }
}
