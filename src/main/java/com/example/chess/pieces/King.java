package com.example.chess.pieces;

import com.example.chess.Piece;

public class King extends Piece {

    private static final String wUrl = "/pieces/w-king.png";
    private static final String bUrl = "/pieces/b-king.png";

    public King(String color){


        super("king",color,color.equals("white")? wUrl: bUrl);




    };

}
