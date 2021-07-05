package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Home extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Home");

        AnchorPane anchorPane6 = new AnchorPane();
        anchorPane6.getStyleClass().add("root");

        Button btnSimple = new Button("Simple");
        btnSimple.setLayoutX(238);
        btnSimple.setLayoutY(170);
        btnSimple.setPrefHeight(45);
        btnSimple.setPrefWidth(125);
        btnSimple.setStyle("-fx-background-color: #4393a1; -fx-background-radius: 17; -fx-font-size: 14 ; -fx-font-weight: bold;-fx-font-family:'Comic Sans MS'");

        Button btnMortgage = new Button("Mortgage");
        btnMortgage.setLayoutX(238);
        btnMortgage.setLayoutY(230);
        btnMortgage.setPrefHeight(45);
        btnMortgage.setPrefWidth(125);
        btnMortgage.setStyle("-fx-background-color: #4393a1; -fx-background-radius: 17;-fx-font-size: 14; -fx-font-weight: bold;-fx-font-family:'Comic Sans MS'");

        Button btnLoan = new Button("Loan");
        btnLoan.setLayoutX(238);
        btnLoan.setLayoutY(290);
        btnLoan.setPrefHeight(45);
        btnLoan.setPrefWidth(125);
        btnLoan.setStyle("-fx-background-color: #4393a1; -fx-background-radius: 17; -fx-font-size: 14; -fx-font-weight: bold;-fx-font-family:'Comic Sans MS'");

        Button btnCompoundInt = new Button("Compound");
        btnCompoundInt.setLayoutX(238);
        btnCompoundInt.setLayoutY(350);
        btnCompoundInt.setPrefHeight(45);
        btnCompoundInt.setPrefWidth(125);
        btnCompoundInt.setStyle("-fx-background-color: #4393a1; -fx-background-radius: 17; -fx-font-size: 14; -fx-font-weight: bold;-fx-font-family:'Comic Sans MS'");

        Button btnHistory = new Button("History");
        btnHistory.setLayoutX(238);
        btnHistory.setLayoutY(410);
        btnHistory.setPrefWidth(125);
        btnHistory.setPrefHeight(45);
        btnHistory.setStyle("-fx-background-color: #4393a1; -fx-background-radius: 17; -fx-font-size: 14; -fx-font-weight: bold;-fx-font-family:'Comic Sans MS'");

        Button btnHelp = new Button("❓");
        btnHelp.setLayoutX(500);
        btnHelp.setLayoutY(460);
        btnHelp.setPrefHeight(35);
        btnHelp.setPrefWidth(35);
        btnHelp.setStyle("-fx-background-color: #4393a1; -fx-text-fill: #da1c22; -fx-background-radius: 17;-fx-font-size: 14; -fx-font-weight: bold;-fx-font-family:'Comic Sans MS'");

        btnSimple.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage primaryStage1 = new Stage();
                Simple_Savings Simple = new Simple_Savings();
                try {
                    Simple.start(primaryStage1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                primaryStage1.show();
                primaryStage.close();
            }
        });

        btnMortgage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage primaryStage2 = new Stage();
                Mortgage Mort = new Mortgage();
                try {
                    Mort.start(primaryStage2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                primaryStage2.show();
                primaryStage.close();
            }
        });

        btnLoan.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage primaryStage3 = new Stage();
                Loan loan = new Loan();
                try {
                    loan.start(primaryStage3);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                primaryStage3.show();
                primaryStage.close();
            }
        });

        btnCompoundInt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage primaryStage4 = new Stage();
                Compound_Interest ComInt = new Compound_Interest();
                try {
                    ComInt.start(primaryStage4);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                primaryStage4.show();
                primaryStage.close();
            }
        });

        btnHistory.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage primaryStage6 = new Stage();
                History history = new History();
                try {
                    history.start(primaryStage6);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                primaryStage6.show();
                primaryStage.close();
            }
        });

        btnHelp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage primaryStage5 = new Stage();
                Help help = new Help();
                try {
                    help.start(primaryStage5);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                primaryStage5.show();
                primaryStage.close();
            }
        });

        anchorPane6.getChildren().add(btnSimple);
        anchorPane6.getChildren().add(btnMortgage);
        anchorPane6.getChildren().add(btnLoan);
        anchorPane6.getChildren().add(btnCompoundInt);
        anchorPane6.getChildren().add(btnHistory);
        anchorPane6.getChildren().add(btnHelp);

        anchorPane6.getStylesheets().add(Home.class.getResource("homepage.css").toExternalForm());
        primaryStage.setScene(new Scene(anchorPane6, 600, 550));
        primaryStage.show();
    }
}
