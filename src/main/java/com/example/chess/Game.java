package com.example.chess;

public class Game {

    public static int turn =1; //white: 1 black: -1

    public static int getTurn(){
        return turn;
    }
    public static void setTurn(){
        turn = getTurn()*-1;
    }//call this whenever move is made



}
