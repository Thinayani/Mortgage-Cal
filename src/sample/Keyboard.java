package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class Keyboard {

    public static void keyboardCal(TextField txtf, AnchorPane anchorPane1) {

        Button btn1 = new Button("1");
        btn1.setPrefHeight(44);
        btn1.setPrefWidth(52);
        btn1.setLayoutX(400);
        btn1.setLayoutY(140);
        btn1.setStyle("-fx-background-color: #9a9797; -fx-background-radius: 12; -fx-font-weight: bold;-fx-font-family:'Comic Sans MS';-fx-font-size: 14");

        Button btn2 = new Button("2");
        btn2.setPrefHeight(44);
        btn2.setPrefWidth(52);
        btn2.setLayoutX(462);
        btn2.setLayoutY(140);
        btn2.setStyle("-fx-background-color: #9a9797; -fx-background-radius: 12; -fx-font-weight: bold;-fx-font-family:'Comic Sans MS';-fx-font-size: 14");

        Button btn3 = new Button("3");
        btn3.setPrefHeight(44);
        btn3.setPrefWidth(52);
        btn3.setLayoutX(521);
        btn3.setLayoutY(140);
        btn3.setStyle("-fx-background-color: #9a9797; -fx-background-radius: 12; -fx-font-weight: bold;-fx-font-family:'Comic Sans MS';-fx-font-size: 14");

        Button btn4 = new Button("4");
        btn4.setPrefHeight(44);
        btn4.setPrefWidth(52);
        btn4.setLayoutX(400);
        btn4.setLayoutY(190);
        btn4.setStyle("-fx-background-color: #9a9797; -fx-background-radius: 12; -fx-font-weight: bold;-fx-font-family:'Comic Sans MS';-fx-font-size: 14");

        Button btn5 = new Button("5");
        btn5.setPrefHeight(44);
        btn5.setPrefWidth(52);
        btn5.setLayoutX(462);
        btn5.setLayoutY(190);
        btn5.setStyle("-fx-background-color: #9a9797; -fx-background-radius: 12; -fx-font-weight: bold;-fx-font-family:'Comic Sans MS';-fx-font-size: 14");

        Button btn6 = new Button("6");
        btn6.setPrefHeight(44);
        btn6.setPrefWidth(52);
        btn6.setLayoutX(521);
        btn6.setLayoutY(190);
        btn6.setStyle("-fx-background-color: #9a9797; -fx-background-radius: 12; -fx-font-weight: bold;-fx-font-family:'Comic Sans MS';-fx-font-size: 14");

        Button btn7 = new Button("7");
        btn7.setPrefHeight(44);
        btn7.setPrefWidth(52);
        btn7.setLayoutX(400);
        btn7.setLayoutY(240);
        btn7.setStyle("-fx-background-color: #9a9797; -fx-background-radius: 12; -fx-font-weight: bold;-fx-font-family:'Comic Sans MS';-fx-font-size: 14");

        Button btn8 = new Button("8");
        btn8.setPrefHeight(44);
        btn8.setPrefWidth(52);
        btn8.setLayoutX(462);
        btn8.setLayoutY(240);
        btn8.setStyle("-fx-background-color: #9a9797; -fx-background-radius: 12; -fx-font-weight: bold;-fx-font-family:'Comic Sans MS';-fx-font-size: 12");

        Button btn9 = new Button("9");
        btn9.setPrefHeight(44);
        btn9.setPrefWidth(52);
        btn9.setLayoutX(521);
        btn9.setLayoutY(240);
        btn9.setStyle("-fx-background-color: #9a9797; -fx-background-radius: 12; -fx-font-weight: bold;-fx-font-family:'Comic Sans MS';-fx-font-size: 14");

        Button btn0 = new Button("0");
        btn0.setPrefHeight(44);
        btn0.setPrefWidth(52);
        btn0.setLayoutX(462);
        btn0.setLayoutY(291);
        btn0.setStyle("-fx-background-color: #9a9797; -fx-background-radius: 12; -fx-font-weight: bold;-fx-font-family:'Comic Sans MS';-fx-font-size: 14");

        Button btnDot = new Button(".");
        btnDot.setPrefHeight(44);
        btnDot.setPrefWidth(52);
        btnDot.setLayoutX(400);
        btnDot.setLayoutY(291);
        btnDot.setStyle("-fx-background-color: #9a9797; -fx-background-radius: 12; -fx-font-weight: bold;-fx-font-family:'Comic Sans MS';-fx-font-size: 14");

        Button btnClear = new Button("\uD83E\uDC34");
        btnClear.setPrefHeight(44);
        btnClear.setPrefWidth(52);
        btnClear.setLayoutX(521);
        btnClear.setLayoutY(291);
        btnClear.setStyle("-fx-background-color: #9a9797; -fx-background-radius: 12; -fx-font-weight: bold;-fx-font-family:'Comic Sans MS';-fx-font-size: 14");

        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                txtf.appendText("1");
            }
        });

        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                txtf.appendText("2");
            }
        });

        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                txtf.appendText("3");
            }
        });

        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                txtf.appendText("4");
            }
        });

        btn5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                txtf.appendText("5");
            }
        });

        btn6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                txtf.appendText("6");
            }
        });

        btn7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                txtf.appendText("7");
            }
        });

        btn8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                txtf.appendText("8");
            }
        });

        btn9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                txtf.appendText("9");
            }
        });

        btn0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                txtf.appendText("0");
            }
        });

        btnDot.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                txtf.appendText(".");
            }
        });

        btnClear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                txtf.setText(txtf.getText().substring(0, txtf.getText().length()-1));
            }
        });

        anchorPane1.getChildren().add(btn0);
        anchorPane1.getChildren().add(btn1);
        anchorPane1.getChildren().add(btn2);
        anchorPane1.getChildren().add(btn3);
        anchorPane1.getChildren().add(btn4);
        anchorPane1.getChildren().add(btn5);
        anchorPane1.getChildren().add(btn6);
        anchorPane1.getChildren().add(btn7);
        anchorPane1.getChildren().add(btn8);
        anchorPane1.getChildren().add(btn9);
        anchorPane1.getChildren().add(btnDot);
        anchorPane1.getChildren().add(btnClear);

    }

}
