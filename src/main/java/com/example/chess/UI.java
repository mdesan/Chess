package com.example.chess;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.awt.*;

import java.beans.EventHandler;


public class UI extends Application {




    @Override
    public void start(Stage primaryStage) throws Exception {

        Font clockFont = Font.loadFont(
                UI.class.getResourceAsStream("/fonts/digital-7.ttf"),50
        );

        primaryStage.setTitle("Chess");
        BorderPane pane = new BorderPane();//highest level pane
        Scene scene = new Scene(pane);


        VBox leftPanel = new VBox();
        leftPanel.setPrefWidth(200);
        leftPanel.setStyle("-fx-background-color: lightgray;");
        leftPanel.setAlignment(Pos.CENTER);





        //test username and pfp-------------------------------------------------------
        //top panel (black side)
        HBox topPanel = new HBox();
        Region leftSpacer = new Region();

        topPanel.setPrefHeight(50);
        topPanel.setStyle("-fx-background-color: silver;");
        Label blackUser = new Label("  veil");
        blackUser.setPrefWidth(70);
        Image blackPfp = new Image(getClass().getResource("/pieces/CCpfp.jpeg").toString());
        ImageView blackPfpFrame = new ImageView(blackPfp);
        blackPfpFrame.setFitHeight(50);
        blackPfpFrame.setFitWidth(50);
        leftSpacer.setPrefWidth(200);

        Label blacksCaptures = new Label();
        blacksCaptures.setPrefWidth(650);
        blacksCaptures.setPrefHeight(50);
        blacksCaptures.setStyle("-fx-background-color: blue;");



        topPanel.getChildren().addAll(leftSpacer,blackPfpFrame,blackUser,blacksCaptures);
        //---------------------------------------------
        //bottom panel (white side)
        HBox bottomPanel = new HBox();
        Region rightSpacer = new Region();
        rightSpacer.setPrefWidth(200);
        bottomPanel.setPrefHeight(50);
        bottomPanel.setStyle("-fx-background-color: silver;");
        Label whiteUser = new Label("  parted");
        whiteUser.setPrefWidth(70);
        Image whitePfp = new Image(getClass().getResource("/pieces/cgPfp.jpeg").toString());
        ImageView whitePfpFrame = new ImageView(whitePfp);
        whitePfpFrame.setFitHeight(50);
        whitePfpFrame.setFitWidth(50);

        Label whitesCaptures = new Label();
        whitesCaptures.setPrefHeight(50);
        whitesCaptures.setPrefWidth(650);
        whitesCaptures.setStyle("-fx-background-color: blue;");



        bottomPanel.getChildren().addAll(rightSpacer, whitePfpFrame,whiteUser,whitesCaptures);
        //-----------------------------------------------------------------------------------------------



        Board board = new Board();


        pane.setPrefSize(1000,900);


        //left panel-------------------------------------------------------------------------------------
        Button reset = new Button("RESET BOARD");
        reset.setPrefSize(150,50);
        reset.setStyle("-fx-base: gray;");

        reset.setOnMouseClicked(event ->{
            board.resetBoard();
        });

        Button resign = new Button("RESIGN");
        resign.setPrefSize(150,50);
        resign.setStyle("-fx-base: gray;");





        Label whiteClock = new Label("10:00");
        Label blackClock = new Label("10:00");

        whiteClock.setPrefSize(170,80);
        whiteClock.setStyle("-fx-background-color: white;");
        whiteClock.setFont(clockFont);
        whiteClock.setAlignment(Pos.CENTER);

        blackClock.setPrefSize(170,80);
        blackClock.setStyle("-fx-background-color: gray; -fx-text-fill: white;");
        blackClock.setFont(clockFont);
        blackClock.setAlignment(Pos.CENTER);

        Region spacer = new Region();
        Region topSpacer = new Region();

//        topSpacer.setPrefHeight(100);
        spacer.setPrefHeight(500);
//        leftPanel.setVgrow(spacer, Priority.ALWAYS);
        leftPanel.getChildren().addAll(topSpacer,reset,resign,spacer,blackClock,whiteClock);


//---------------------------------------------------------------------------------------------------------
        //adding the panels to the main pane

        pane.setRight(board);
        pane.setLeft(leftPanel);
        pane.setTop(topPanel);
        pane.setBottom(bottomPanel);


        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();


    }

    public static void main(String[] args){
        launch();


    }


}
