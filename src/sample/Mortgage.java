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

public class Mortgage extends Application {

    @Override
    public void start(Stage primaryStage2) throws Exception {

        primaryStage2.setTitle("Mortgage Calculator");
        DecimalFormat df = new DecimalFormat("#0.00");

        AnchorPane anchorPane2 = new AnchorPane();
        //anchorPane2.setStyle("-fx-background-image: url('com.jpg')");

        //Create Labels
        Label lblFinance = new Label("Mortgage Calculator");
        lblFinance.setLayoutX(202);
        lblFinance.setLayoutY(33);
        lblFinance.prefWidth(235);
        lblFinance.prefHeight(45);
        lblFinance.setStyle("-fx-font-weight: bold; -fx-font-size: 20;-fx-font-family:'Comic Sans MS'");

        Label lblHP = new Label("Home Price");
        lblHP.setLayoutX(40);
        lblHP.setLayoutY(120);
        lblHP.prefWidth(100);
        lblHP.prefHeight(25);
        lblHP.setStyle("-fx-font-size: 14;-fx-font-family:'Comic Sans MS'");

        Label lblDP = new Label("Down Payment");
        lblDP.setLayoutX(40);
        lblDP.setLayoutY(180);
        lblDP.prefWidth(100);
        lblDP.prefHeight(25);
        lblDP.setStyle("-fx-font-size: 14;-fx-font-family:'Comic Sans MS'");

        Label lblPeriod = new Label("Period");
        lblPeriod.setLayoutX(40);
        lblPeriod.setLayoutY(240);
        lblPeriod.prefWidth(100);
        lblPeriod.prefHeight(25);
        lblPeriod.setStyle("-fx-font-size: 14;-fx-font-family:'Comic Sans MS'");

        Label lblIntRate = new Label("Interest Rate");
        lblIntRate.setLayoutX(40);
        lblIntRate.setLayoutY(300);
        lblIntRate.prefWidth(100);
        lblIntRate.prefHeight(25);
        lblIntRate.setStyle("-fx-font-size: 14;-fx-font-family:'Comic Sans MS'");

        Label lblMonthPay = new Label("Monthly Payment");
        lblMonthPay.setLayoutX(40);
        lblMonthPay.setLayoutY(360);
        lblMonthPay.prefWidth(100);
        lblMonthPay.prefHeight(25);
        lblMonthPay.setStyle("-fx-font-size: 14;-fx-font-family:'Comic Sans MS'");

        //Create TextFields
        TextField txtHP = new TextField();
        txtHP.setLayoutX(160);
        txtHP.setLayoutY(120);
        txtHP.setPromptText("$");
        txtHP.setAlignment(Pos.BASELINE_LEFT);
        txtHP.setStyle("-fx-background-radius: 8");

        TextField txtDP = new TextField();
        txtDP.setLayoutX(160);
        txtDP.setLayoutY(180);
        txtDP.setStyle("-fx-background-radius: 8");

        TextField txtPeriod = new TextField();
        txtPeriod.setLayoutX(160);
        txtPeriod.setLayoutY(240);
        txtPeriod.setPromptText("years");
        txtPeriod.setAlignment(Pos.BASELINE_LEFT);
        txtPeriod.setStyle("-fx-background-radius: 8");

        TextField txtIntRate = new TextField();
        txtIntRate.setLayoutX(160);
        txtIntRate.setLayoutY(300);
        txtIntRate.setPromptText("%");
        txtIntRate.setAlignment(Pos.BASELINE_LEFT);
        txtIntRate.setStyle("-fx-background-radius: 8");

        TextField txtMonthPay = new TextField();
        txtMonthPay.setLayoutX(160);
        txtMonthPay.setLayoutY(360);
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
                primaryStage2.close();
            }
        });

        btnCal.setOnAction(e-> {

            double P;
            double D;
            double t;
            double n = 12;
            double r;
            double M;


            if(txtHP.getText().isEmpty()){
                D = Double.parseDouble(txtDP.getText());
                M=Double.parseDouble(txtMonthPay.getText());
                r = Double.parseDouble(txtIntRate.getText()) / 100;
                t = Double.parseDouble(txtPeriod.getText());

                P = D + ((n * M * (Math.pow((1 + (r / n)), (n * t)) - 1)) / (r * Math.pow((1 + (r / n)), (n * t))));
                txtHP.setText(String.valueOf(Math.round(P * 100.0) / 100.0));
            }
            if(txtMonthPay.getText().isEmpty()){
                D = Double.parseDouble(txtDP.getText());
                P = Double.parseDouble(txtHP.getText());
                r = Double.parseDouble(txtIntRate.getText()) / 100;
                t = Double.parseDouble(txtPeriod.getText());


                M = ((P - D) * (r / n) * Math.pow((1 + (r / n)), n * t)) / (Math.pow((1 + (r / n)), n * t) - 1);
                txtMonthPay.setText(String.valueOf(Math.round(M * 100 ) / 100.0));
            }

            if(txtPeriod.getText().isEmpty()){
                D = Double.parseDouble(txtDP.getText());
                M=Double.parseDouble(txtMonthPay.getText());
                P = Double.parseDouble(txtHP.getText());
                r = Double.parseDouble(txtIntRate.getText()) / 100;

                t = (Math.log((M / (M - ((r/n) * (P - D)))))) /  (n * Math.log(1 + (r/n)));
                txtPeriod.setText(String.valueOf(Math.round(t * 100.0) / 100.0));
            }
            if(txtDP.getText().isEmpty()){
                M=Double.parseDouble(txtMonthPay.getText());
                P = Double.parseDouble(txtHP.getText());
                r = Double.parseDouble(txtIntRate.getText()) / 100;
                t = Double.parseDouble(txtPeriod.getText());

                D = P - ((n * M * (Math.pow((1 + (r / n)), n * t) - 1)) / (r * Math.pow((1 + (r / n)), n * t)));
                txtDP.setText(String.valueOf(Math.round(D * 100.0) / 100.0));
            }
            try {
                FileWrite.Mortgage("mortgagedata", txtHP.getText(), txtDP.getText(), txtPeriod.getText(), txtIntRate.getText(), txtMonthPay.getText());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        txtHP.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Keyboard.keyboardCal(txtHP, anchorPane2);
            }
        });
        txtIntRate.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Keyboard.keyboardCal(txtIntRate, anchorPane2);
            }
        });
        txtDP.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Keyboard.keyboardCal(txtDP, anchorPane2);
            }
        });
        txtPeriod.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Keyboard.keyboardCal(txtPeriod, anchorPane2);
            }
        });
        txtMonthPay.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Keyboard.keyboardCal(txtMonthPay, anchorPane2);
            }
        });


        anchorPane2.getChildren().add(lblFinance);
        anchorPane2.getChildren().add(lblHP);
        anchorPane2.getChildren().add(lblDP);
        anchorPane2.getChildren().add(lblPeriod);
        anchorPane2.getChildren().add(lblIntRate);
        anchorPane2.getChildren().add(lblMonthPay);
        anchorPane2.getChildren().add(txtHP);
        anchorPane2.getChildren().add(txtIntRate);
        anchorPane2.getChildren().add(txtDP);
        anchorPane2.getChildren().add(txtPeriod);
        anchorPane2.getChildren().add(txtMonthPay);
        anchorPane2.getChildren().add(btnCal);
        anchorPane2.getChildren().add(btnBack);

        anchorPane2.getStyleClass().add("root");

        anchorPane2.getStylesheets().add(Home.class.getResource("mortgage.css").toExternalForm());

        primaryStage2.setScene(new Scene(anchorPane2, 650, 500));
        primaryStage2.show();


    }
}
