package com.example.chess.pieces;

import com.example.chess.Piece;
import javafx.scene.image.Image;

public class Pawn extends Piece {

    private static final String wUrl = "/pieces/w-pawn.png";
    private static final String bUrl = "/pieces/b-pawn.png";

    public Pawn(String color){

            super("pawn",color,color.equals("white")? wUrl: bUrl);

    }


}
