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

public class Compound_Interest extends Application {

    @Override
    public void start(Stage primaryStage4) throws Exception {

        primaryStage4.setTitle("Compound Interest Calculator");
        DecimalFormat df = new DecimalFormat("#0.00");

        AnchorPane anchorPane4 = new AnchorPane();
        //anchorPane4.setStyle("-fx-background-image: url('mor.jpg')");

        //Create Labels
        Label lblFinance = new Label("Compound Interest Calculator");
        lblFinance.setLayoutX(202);
        lblFinance.setLayoutY(33);
        lblFinance.prefWidth(235);
        lblFinance.prefHeight(45);
        lblFinance.setStyle("-fx-font-weight: bold; -fx-font-size: 20;-fx-font-family:'Comic Sans MS'");

        Label lblPV = new Label("Present Value");
        lblPV.setLayoutX(40);
        lblPV.setLayoutY(120);
        lblPV.prefWidth(100);
        lblPV.prefHeight(25);
        lblPV.setStyle(" -fx-font-size: 14;-fx-font-family:'Comic Sans MS'");

        Label lblFV = new Label("Future Value");
        lblFV.setLayoutX(40);
        lblFV.setLayoutY(180);
        lblFV.prefWidth(100);
        lblFV.prefHeight(25);
        lblFV.setStyle("-fx-font-size: 14;-fx-font-family:'Comic Sans MS'");

        Label lblPeriod = new Label("Period");
        lblPeriod.setLayoutX(40);
        lblPeriod.setLayoutY(240);
        lblPeriod.prefWidth(100);
        lblPeriod.prefHeight(25);
        lblPeriod.setStyle(" -fx-font-size: 14;-fx-font-family:'Comic Sans MS'");

        Label lblIntRate = new Label("Interest Rate");
        lblIntRate.setLayoutX(40);
        lblIntRate.setLayoutY(300);
        lblIntRate.prefWidth(100);
        lblIntRate.prefHeight(25);
        lblIntRate.setStyle(" -fx-font-size: 14;-fx-font-family:'Comic Sans MS'");

        Label lblMonthPay = new Label("Monthly Payment");
        lblMonthPay.setLayoutX(40);
        lblMonthPay.setLayoutY(360);
        lblMonthPay.prefWidth(100);
        lblMonthPay.prefHeight(25);
        lblMonthPay.setStyle("-fx-font-size: 14;-fx-font-family:'Comic Sans MS'");

        //Create TextFields
        TextField txtPV = new TextField();
        txtPV.setLayoutX(160);
        txtPV.setLayoutY(120);
        txtPV.setPromptText("$");
        txtPV.setAlignment(Pos.BASELINE_LEFT);
        txtPV.setStyle("-fx-background-radius: 8");

        TextField txtFV = new TextField();
        txtFV.setLayoutX(160);
        txtFV.setLayoutY(180);
        txtFV.setStyle("-fx-background-radius: 8");

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
                primaryStage4.close();
            }
        });

        btnCal.setOnAction(e-> {

            double P;
            double r;
            double t;
            double n = 12;
            double A;
            double M;

            if (txtFV.getText().isEmpty()){
                P = Double.parseDouble(txtPV.getText());
                M=Double.parseDouble(txtMonthPay.getText());
                r = Double.parseDouble(txtIntRate.getText()) / 100;
                t = Double.parseDouble(txtPeriod.getText());


                A = (P * Math.pow((1 + (r / n)), (n * t))) + (M * ((Math.pow((1 + (r / n)), (n * t)) - 1) / (r/n)));
                txtFV.setText(String.valueOf(Math.round(A * 100.0) / 100.0));
            }
            if(txtMonthPay.getText().isEmpty()){
                P = Double.parseDouble(txtPV.getText());
                A = Double.parseDouble(txtFV.getText());
                t = Double.parseDouble(txtPeriod.getText());
                r = Double.parseDouble(txtIntRate.getText()) / 100;

                M = (A - (P * Math.pow((1 + (r / n)), (n * t)))) / ((Math.pow((1 + (r / n)), (n * t)) - 1) / (r / n));
                txtMonthPay.setText(String.valueOf(Math.round(M * 100 ) / 100.0));
            }

            if(txtPV.getText().isEmpty()){
                r = Double.parseDouble(txtIntRate.getText()) / 100;
                A = Double.parseDouble(txtFV.getText());
                t = Double.parseDouble(txtPeriod.getText());
                M=Double.parseDouble(txtMonthPay.getText());

                P = (A - (M * ((Math.pow((1 + (r/n)), n * t) - 1) / (r/n))))/ (Math.pow((1 + (r/n)), n * t));
                txtPV.setText(String.valueOf(Math.round(P * 100.0) / 100.0));
            }
            if(txtPeriod.getText().isEmpty()){
                P = Double.parseDouble(txtPV.getText());
                r = Double.parseDouble(txtIntRate.getText()) / 100;
                A = Double.parseDouble(txtFV.getText());
                M=Double.parseDouble(txtMonthPay.getText());


                t = Math.log(((((r * A) / n) + M) / (((P * r) / n) + M))) / (n * Math.log(1 + (r/n)));
                txtPeriod.setText(String.valueOf(Math.round(t * 100.0) / 100.0));
            }
            try {
                FileWrite.Compound_Interest("compounddata",txtFV.getText(),txtPV.getText(),txtPeriod.getText(),txtIntRate.getText(), txtMonthPay.getText());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });


        txtPV.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Keyboard.keyboardCal(txtPV, anchorPane4);
            }
        });
        txtIntRate.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Keyboard.keyboardCal(txtIntRate, anchorPane4);
            }
        });
        txtFV.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Keyboard.keyboardCal(txtFV, anchorPane4);
            }
        });
        txtPeriod.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Keyboard.keyboardCal(txtPeriod, anchorPane4);
            }
        });
        txtMonthPay.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Keyboard.keyboardCal(txtMonthPay, anchorPane4);
            }
        });

        anchorPane4.getChildren().add(lblFinance);
        anchorPane4.getChildren().add(lblPV);
        anchorPane4.getChildren().add(lblFV);
        anchorPane4.getChildren().add(lblPeriod);
        anchorPane4.getChildren().add(lblIntRate);
        anchorPane4.getChildren().add(lblMonthPay);
        anchorPane4.getChildren().add(txtPV);
        anchorPane4.getChildren().add(txtIntRate);
        anchorPane4.getChildren().add(txtFV);
        anchorPane4.getChildren().add(txtPeriod);
        anchorPane4.getChildren().add(txtMonthPay);
        anchorPane4.getChildren().add(btnCal);
        anchorPane4.getChildren().add(btnBack);

        anchorPane4.getStyleClass().add("root");

        anchorPane4.getStylesheets().add(Home.class.getResource("compound.css").toExternalForm());

        primaryStage4.setScene(new Scene(anchorPane4, 650, 500));
        primaryStage4.show();

    }
}


