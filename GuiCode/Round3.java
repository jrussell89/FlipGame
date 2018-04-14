package FlipGame.GuiCode;

import FlipGame.GameCode.Stock;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.util.HashMap;

public class Round3 extends Round {
    @FXML
    private Label roundTitle, roundText, roundText2,
                  roundText3, yourStock1, yourStock2,
                  share0, share1, share2, share3,
                  share4, share5, share6, share7, currentMoney;
    @FXML
    private TextField stock0, stock1, stock2, stock3,
                      stock4, stock5, stock6, stock7;
    @FXML
    private CheckBox buy0, buy1, buy2, buy3,
                     buy4, buy5, buy6, buy7;
    @FXML
    private HBox box1, box2;

    private static TextField[] stocks;
    public static String[] criteria = {"How does investing work? What are somethings to think about when investing?",
                                       "You pay to own part of a company",
                                       "Money grows or falls based on how the company is doing",
                                       "Think about what the company is doing, or how the current market is doing"};

    public static int times = 0;
    public void startNext() {
        HashMap<Stock, Double> stockMap = new HashMap<>();
        boolean corrupt = false;
        double total = 0;
        stocks = new TextField[]{stock0, stock1, stock2, stock3,
                stock4, stock5, stock6, stock7};
        CheckBox[] buys = {buy0, buy1, buy2, buy3,
                           buy4, buy5, buy6, buy7};
        for (int i = 0; i < stocks.length; i++) {
            try {
                if (times == 1 && buys[i].isSelected()) {
                    Main.character.pay(Main.character.stocks.remove(Stock.values()[i]));
                    buys[i].setSelected(false);
                } else {
                    Double amount = 0.0;
                    if (!"".equals(stocks[i].getText())) {
                        amount = Double.parseDouble(stocks[i].getText());
                        total += amount;
                    }
                    if (times == 1 && !(Main.character.stocks.get(Stock.values()[i]) == null)) {
                        amount += Main.character.stocks.get(Stock.values()[i]);
                    }
                    stockMap.put(Stock.values()[i], Stock.values()[i].earnings[times] * amount);
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
            Main.character.stocks = stockMap;
            Main.character.takeMoney(total);
            if (times == 0) {
                roundTitle.setText("Round 3 - Stocks Second");
                roundText.setText("Enter the amount you would like to invest in these companies");
                roundText2.setText("");
                roundText3.setText("If you want to buy back stock click the button next to the name");
                yourStock1.setText("Your Stock");
                yourStock2.setText("Your Stock");
                box1.setOpacity(1);
                box1.setDisable(false);
                box2.setOpacity(1);
                box2.setDisable(false);
                Label[] shares = {share0, share1, share2, share3,
                                  share4, share5, share6, share7};
                for (int i = 0; i < shares.length; i++) {
                    Double amount = Main.character.stocks.get(Stock.values()[i]);
                    if (amount != null) {
                        shares[i].setText("$" + amount);
                    } else {
                        shares[i].setText("$0");
                    }
                }
                for (TextField tf : stocks) {
                    tf.clear();
                }
                times++;
            } else {
                for (int i = 0; i < stocks.length; i++) {
                    Double amount = Main.character.stocks.get(Stock.values()[i]);
                    Main.character.pay(amount);
                }
                Main.mainStage.setScene(EndOfRoundScreen.instance.scene);
            }
        }
    }
    public void currentMoney() {
        currentMoney.setText("Your Money - $" + Main.character.totalMoney);
    }
}
