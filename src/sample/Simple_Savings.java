package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.DecimalFormat;

public class Simple_Savings extends Application {

    @Override
    public void start(Stage primaryStage1) throws Exception {

        primaryStage1.setTitle("Simple Savings Calculator");
        DecimalFormat df = new DecimalFormat("#0.00");

        //Create AnchorPane
        AnchorPane anchorPane1 = new AnchorPane();

        //Create Labels
        Label lblFinance = new Label("Simple Savings Calculator");
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

        Label lblPeriod = new Label("Period");
        lblPeriod.setLayoutX(40);
        lblPeriod.setLayoutY(180);
        lblPeriod.prefWidth(100);
        lblPeriod.prefHeight(25);
        lblPeriod.setStyle("-fx-font-size: 14;-fx-font-family:'Comic Sans MS'");

        Label lblIntRate = new Label("Interest Rate");
        lblIntRate.setLayoutX(40);
        lblIntRate.setLayoutY(240);
        lblIntRate.prefWidth(100);
        lblIntRate.prefHeight(25);
        lblIntRate.setStyle("-fx-font-size: 14;-fx-font-family:'Comic Sans MS'");

        Label lblFV = new Label("Future Value");
        lblFV.setLayoutX(40);
        lblFV.setLayoutY(300);
        lblFV.prefWidth(100);
        lblFV.prefHeight(25);
        lblFV.setStyle("-fx-font-size: 14;-fx-font-family:'Comic Sans MS'");

        //Create TextFields
        TextField txtPV = new TextField();
        txtPV.setLayoutX(160);
        txtPV.setLayoutY(120);
        txtPV.setPromptText("$");
        txtPV.setAlignment(Pos.BASELINE_LEFT);
        txtPV.setStyle("-fx-background-radius: 8");

        TextField txtPeriod = new TextField();
        txtPeriod.setLayoutX(160);
        txtPeriod.setLayoutY(180);
        txtPeriod.setPromptText("years");
        txtPeriod.setAlignment(Pos.BASELINE_LEFT);
        txtPeriod.setStyle("-fx-background-radius: 8");

        TextField txtIntRate = new TextField();
        txtIntRate.setLayoutX(160);
        txtIntRate.setLayoutY(240);
        txtIntRate.setPromptText("%");
        txtIntRate.setAlignment(Pos.BASELINE_LEFT);
        txtIntRate.setStyle("-fx-background-radius: 8");

        TextField txtFV = new TextField();
        txtFV.setLayoutX(160);
        txtFV.setLayoutY(300);
        txtFV.setStyle("-fx-background-radius: 8");

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
                primaryStage1.close();
            }
        });

        btnCal.setOnAction(e-> {
                double n = 12;
                double P;
                double r;
                double t;
                double A;

                if(txtFV.getText().isEmpty()){
                    P = Double.parseDouble(txtPV.getText());
                    r = Double.parseDouble(txtIntRate.getText()) / 100;
                    t = Double.parseDouble(txtPeriod.getText());

                    A = P * (Math.pow((1 + (r / n)), (n * t)));
                    txtFV.setText(String.valueOf(Math.round(A * 100.0) / 100.0));
                }
                if(txtIntRate.getText().isEmpty()){
                    P = Double.parseDouble(txtFV.getText());
                    A = Double.parseDouble(txtPV.getText());
                    t = Double.parseDouble(txtPeriod.getText());

                    r = n * ((Math.pow((A / P), (1 / (n * t)))) - 1);
                    txtIntRate.setText(String.valueOf(Math.round(r * 100 * 100) / 100.0));
                }

                if(txtPV.getText().isEmpty()){
                    r = Double.parseDouble(txtIntRate.getText()) / 100;
                    A = Double.parseDouble(txtFV.getText());
                    t = Double.parseDouble(txtPeriod.getText());

                    P = A / (Math.pow((1 + (r / n)), n * t));
                    txtPV.setText(String.valueOf(Math.round(P * 100.0) / 100.0));
                }
                if(txtPeriod.getText().isEmpty()){
                    P = Double.parseDouble(txtPV.getText());
                    r = Double.parseDouble(txtIntRate.getText()) / 100;
                    A = Double.parseDouble(txtFV.getText());

                    t = (Math.log(A / P)) / (n * (Math.log(1 + (r / n))));
                    txtPeriod.setText(String.valueOf(Math.round(t * 100.0) / 100.0));
                }
            try {
                FileWrite.Simple_Savings("savings", txtFV.getText(), txtPeriod.getText(), txtPV.getText(), txtIntRate.getText());
            } catch (IOException z) {
                z.printStackTrace();
            }
            });


        txtPeriod.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Keyboard.keyboardCal(txtPeriod, anchorPane1);
            }
        });
        txtIntRate.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Keyboard.keyboardCal(txtIntRate, anchorPane1);
            }
        });
        txtFV.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Keyboard.keyboardCal(txtFV, anchorPane1);
            }
        });
        txtPV.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Keyboard.keyboardCal(txtPV, anchorPane1);
            }
        });





        anchorPane1.getChildren().add(lblFinance);
        anchorPane1.getChildren().add(lblPV);
        anchorPane1.getChildren().add(lblFV);
        anchorPane1.getChildren().add(lblPeriod);
        anchorPane1.getChildren().add(lblIntRate);
        anchorPane1.getChildren().add(txtPeriod);
        anchorPane1.getChildren().add(txtIntRate);
        anchorPane1.getChildren().add(txtFV);
        anchorPane1.getChildren().add(txtPV);
        anchorPane1.getChildren().add(btnCal);
        anchorPane1.getChildren().add(btnBack);

        anchorPane1.getStyleClass().add("root");

        anchorPane1.getStylesheets().add(Home.class.getResource("savings.css").toExternalForm());


        primaryStage1.setScene(new Scene(anchorPane1, 650, 500));
        primaryStage1.show();

    }
}