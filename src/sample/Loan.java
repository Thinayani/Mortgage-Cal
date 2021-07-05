package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.DecimalFormat;

public class Loan extends Application {

    @Override
    public void start(Stage primaryStage3) throws Exception {

        primaryStage3.setTitle("Loan Calculator");
        DecimalFormat df = new DecimalFormat("#0.00");

        AnchorPane anchorPane3 = new AnchorPane();
       // anchorPane3.setStyle("-fx-background-image: url('loan.png')");

        //Create Labels
        Label lblLoan = new Label("Loan Calculator");
        lblLoan.setLayoutX(202);
        lblLoan.setLayoutY(33);
        lblLoan.prefWidth(235);
        lblLoan.prefHeight(45);
        lblLoan.setStyle("-fx-font-weight: bold; -fx-font-size: 20 ;-fx-font-family:'Comic Sans MS'");

        Label lblHP = new Label("Home Price");
        lblHP.setLayoutX(40);
        lblHP.setLayoutY(120);
        lblHP.prefWidth(100);
        lblHP.prefHeight(25);
        lblHP.setStyle("-fx-font-size: 14;-fx-font-family:'Comic Sans MS'");

        Label lblLTerm = new Label("Loan Term");
        lblLTerm.setLayoutX(40);
        lblLTerm.setLayoutY(180);
        lblLTerm.prefWidth(100);
        lblLTerm.prefHeight(25);
        lblLTerm.setStyle("-fx-font-size: 14;-fx-font-family:'Comic Sans MS'");

        Label lblIntRate = new Label("Interest Rate");
        lblIntRate.setLayoutX(40);
        lblIntRate.setLayoutY(240);
        lblIntRate.prefWidth(100);
        lblIntRate.prefHeight(25);
        lblIntRate.setStyle("-fx-font-size: 14;-fx-font-family:'Comic Sans MS'");

        Label lblMonthPay = new Label("Monthly Payment");
        lblMonthPay.setLayoutX(40);
        lblMonthPay.setLayoutY(300);
        lblMonthPay.prefWidth(100);
        lblMonthPay.prefHeight(25);
        lblMonthPay.setStyle("-fx-font-size: 14;-fx-font-family:'Comic Sans MS'");

        //Create TextFields
        TextField txtHP = new TextField();
        txtHP.setLayoutX(160);
        txtHP.setLayoutY(120);
        txtHP.setText(" ");
        txtHP.setPromptText("$");
        txtHP.setAlignment(Pos.BASELINE_LEFT);
        txtHP.setStyle("-fx-background-radius: 8");

        TextField txtLTerm = new TextField();
        txtLTerm.setLayoutX(160);
        txtLTerm.setLayoutY(180);
        txtLTerm.setText(" ");
        txtLTerm.setPromptText("months");
        txtLTerm.setAlignment(Pos.BASELINE_LEFT);
        txtLTerm.setStyle("-fx-background-radius: 8");

        TextField txtIntRate = new TextField();
        txtIntRate.setLayoutX(160);
        txtIntRate.setLayoutY(240);
        txtIntRate.setText(" ");
        txtIntRate.setPromptText("%");
        txtIntRate.setAlignment(Pos.BASELINE_LEFT);
        txtIntRate.setStyle("-fx-background-radius: 8");

        TextField txtMonthPay = new TextField();
        txtMonthPay.setLayoutX(160);
        txtMonthPay.setLayoutY(300);
        txtMonthPay.setStyle("-fx-background-radius: 8");

        //Create calculate button
        Button btnCal = new Button("Calculate");
        btnCal.setPrefHeight(33);
        btnCal.setPrefWidth(81);
        btnCal.setLayoutX(448);
        btnCal.setLayoutY(350);
        btnCal.setStyle("-fx-background-color: #9a9797; -fx-background-radius: 12; -fx-font-weight: bold;-fx-font-family:'Comic Sans MS'");

        //create back button
        Button btnBack = new Button("Back");
        btnBack.setPrefWidth(60);
        btnBack.setPrefHeight(33);
        btnBack.setLayoutX(10);
        btnBack.setLayoutY(10);
        btnBack.setStyle("-fx-background-color: #9a9797; -fx-background-radius: 12; -fx-font-weight: bold;-fx-font-family:'Comic Sans MS'");

        btnBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage primaryStage = new Stage();
                Home home = new Home();
                try {
                    home.start(primaryStage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                primaryStage.show();
                primaryStage3.close();
            }
        });

        btnCal.setOnAction(e-> {
            double L;
            double r;
            double t;
            double M;


            if(txtLTerm.getText().isEmpty()){
                M=Double.parseDouble(txtMonthPay.getText());
                r = Double.parseDouble(txtIntRate.getText()) / 100;
                L = Double.parseDouble(txtHP.getText());

                t = Math.log((M / r) / ((M / r) - L)) / Math.log(1 + r);
                txtLTerm.setText(String.valueOf(Math.round(t*100.0)/100.0));
            }
            if(txtMonthPay.getText().isEmpty()){
                r = Double.parseDouble(txtIntRate.getText()) / 100;
                t = Double.parseDouble(txtLTerm.getText());
                L = Double.parseDouble(txtHP.getText());

                M = (L * r) / (1 - (1 / Math.pow((1 + r), t)));
                txtMonthPay.setText(String.valueOf(Math.round(M * 100 ) / 100.0));
            }

            if(txtHP.getText().isEmpty()){
                M=Double.parseDouble(txtMonthPay.getText());
                r = Double.parseDouble(txtIntRate.getText()) / 100;
                t = Double.parseDouble(txtLTerm.getText());

                L =  (M / r) * (1 - (1 / Math.pow((1 + r), t)));
                txtHP.setText(String.valueOf(Math.round(L * 100.0) / 100.0));
            }

            try {
                FileWrite.Loan("loandata",txtHP.getText(),txtLTerm.getText(),txtIntRate.getText(), txtMonthPay.getText());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }


        });

        txtHP.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Keyboard.keyboardCal(txtHP, anchorPane3);
            }
        });
        txtIntRate.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Keyboard.keyboardCal(txtIntRate, anchorPane3);
            }
        });
        txtMonthPay.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Keyboard.keyboardCal(txtMonthPay, anchorPane3);
            }
        });
        txtLTerm.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Keyboard.keyboardCal(txtLTerm, anchorPane3);
            }
        });


        anchorPane3.getChildren().add(lblLoan);
        anchorPane3.getChildren().add(lblHP);
        anchorPane3.getChildren().add(lblMonthPay);
        anchorPane3.getChildren().add(lblLTerm);
        anchorPane3.getChildren().add(lblIntRate);
        anchorPane3.getChildren().add(txtHP);
        anchorPane3.getChildren().add(txtIntRate);
        anchorPane3.getChildren().add(txtMonthPay);
        anchorPane3.getChildren().add(txtLTerm);
        anchorPane3.getChildren().add(btnCal);
        anchorPane3.getChildren().add(btnBack);

        anchorPane3.getStyleClass().add("root");

        anchorPane3.getStylesheets().add(Home.class.getResource("loan.css").toExternalForm());

        primaryStage3.setScene(new Scene(anchorPane3, 650, 500));
        primaryStage3.show();


    }
}
