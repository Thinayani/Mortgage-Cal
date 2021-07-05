package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.text.DecimalFormat;

public class History extends Application{

    @Override
    public void start(Stage primaryStage6) throws Exception {

        primaryStage6.setTitle("History");
        DecimalFormat df = new DecimalFormat("#0.00");

        //Create AnchorPane
        AnchorPane anchorPane7 = new AnchorPane();
        //anchorPane7.setStyle("-fx-background-image: url('savi.jpg')");

        //Create TabPane
        TabPane tabPane = new TabPane();
        tabPane.setLayoutX(70);
        tabPane.setLayoutY(60);
        tabPane.setStyle("-fx-background-radius: 8");

        Tab simpleSavingsT = new Tab("Simple Savings");
        Tab compoundIntT = new Tab("Compound Savings");
        Tab loanT = new Tab("Loan");
        Tab mortgageT = new Tab("Mortgage");

        //Create ScrollPane
        ScrollPane simpleSavingSP = new ScrollPane();
        ScrollPane compoundIntSP = new ScrollPane();
        ScrollPane loanSP = new ScrollPane();
        ScrollPane mortgageSP = new ScrollPane();

        //create back button
        Button btnBack = new Button("Back");
        btnBack.setPrefWidth(60);
        btnBack.setPrefHeight(33);
        btnBack.setLayoutX(10);
        btnBack.setLayoutY(10);
        btnBack.setStyle("-fx-background-color: #9a9797; -fx-background-radius: 12; -fx-font-weight: bold;-fx-font-family:'Comic Sans MS'");

        simpleSavingsT.setContent(simpleSavingSP);
        compoundIntT.setContent(compoundIntSP);
        loanT.setContent(loanSP);
        mortgageT.setContent(mortgageSP);


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
                primaryStage6.close();
            }
        });

        anchorPane7.getChildren().add(btnBack);
        tabPane.getTabs().addAll(simpleSavingsT, compoundIntT, loanT, mortgageT);
        anchorPane7.getChildren().add(tabPane);

        TextArea loantext = new TextArea();
        TextArea savingtext = new TextArea();
        TextArea compoundtext = new TextArea();
        TextArea mortgagetext = new TextArea();

        //read file method
        Reading.readfile("savings",savingtext);
        Reading.readfile("compounddata",compoundtext);
        Reading.readfile("loandata",loantext);
        Reading.readfile("mortgagedata",mortgagetext);

        loanSP.setContent(loantext);
        simpleSavingSP.setContent(savingtext);
        compoundIntSP.setContent(compoundtext);
        mortgageSP.setContent(mortgagetext);

        anchorPane7.getStyleClass().add("root");

        anchorPane7.getStylesheets().add(Home.class.getResource("history.css").toExternalForm());

        primaryStage6.setScene(new Scene(anchorPane7, 650, 500));
        primaryStage6.show();

    }
}