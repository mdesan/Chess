package com.example.chess.pieces;

import com.example.chess.Piece;

public class Queen extends Piece {

    private static final String wUrl = "/pieces/w-queen.png";
    private static final String bUrl = "/pieces/b-queen.png";

    public Queen(String color){


        super("queen",color,color.equals("white")? wUrl: bUrl);




    }

}
