package com.example.chess;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class Player {

    String color;
    String username;
    Image pfp;

    private ArrayList<Piece> capturedPieces = new ArrayList<>();

    public ArrayList<Piece> getCapturedPieces(){
        return this.capturedPieces;
    }


}
