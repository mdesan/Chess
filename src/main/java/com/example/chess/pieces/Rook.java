package com.example.chess.pieces;

import com.example.chess.Piece;

public class Rook extends Piece {

    private static final String wUrl = "/pieces/w-rook.png";
    private static final String bUrl = "/pieces/b-rook.png";

    public Rook(String color){


        super("rook",color,color.equals("white")? wUrl: bUrl);




    }

}
