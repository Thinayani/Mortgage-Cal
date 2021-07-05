package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Help extends Application {

    @Override
    public void start(Stage primaryStage5) throws Exception {

        primaryStage5.setTitle("Help");

        AnchorPane anchorPane5 = new AnchorPane();
        anchorPane5.prefHeight(500);
        anchorPane5.prefWidth(650);
        Label label = new Label("This report is about four Financial Calculators\n which are namely Simple Savings, Loan, Mortgage\n and Compound Interest. Each of these calculators\n calculates a number of components. Here it\n is shown the codes along with the User\n Interfaces that I used to create these\n calculators. ");
        label.setLayoutX(60);
        label.setLayoutY(60);

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
                primaryStage5.close();
            }
        });

        anchorPane5.getChildren().add(btnBack);
        anchorPane5.getChildren().add(label);
        anchorPane5.getStyleClass().add("root");

        anchorPane5.getStylesheets().add(Home.class.getResource("help.css").toExternalForm());


        primaryStage5.setScene(new Scene(anchorPane5, 650, 500));
        primaryStage5.show();


    }
}
