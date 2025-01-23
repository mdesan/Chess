package com.example.chess;

import com.example.chess.pieces.*;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;

import javax.swing.text.Element;

public class Board extends GridPane {

    public static Square [][] squares = new Square[8][8];

    public String lightStyle ="-fx-base: white;";
    public String darkStyle ="-fx-base: #FA8072";
    public String currentStyle;



    //the color of the board
    public final Color lightColor =  Color.WHITE;
    public final Color darkColor = Color.web("#FA8072");

    public Square selectedSquare = null; //square that is going to move

    Player whitePlayer = new Player();
    Player blackPlayer = new Player();


public Board(){

    createBoard();


}

public void createBoard(){
    super.setPrefSize(800,800);


    for(int i =0;i<8;i++){
        for(int j =0;j<8;j++){
            Square square = new Square();

            square.setX(i);
            square.setY(j);

            if((i+j)%2==0){
                square.setStyle(lightStyle);
                square.setToLightSquare();
            }
            else{
                square.setStyle(darkStyle);
            }
            StackPane stackPane = new StackPane(square);


            //setting letter labels to the 8th rank
            if(j==7){
                Label label= new Label();
                String c = String.valueOf((char)('a'+i));
                label.setText(c);
                label.setStyle("-fx-font-size: 14;");

                if(square.getIsLightSquare()){
                    label.setTextFill(getDarkColor());
                }
                else{
                    label.setTextFill(getLightColor());
                }

                stackPane.getChildren().add(label);
                stackPane.setAlignment(label, Pos.BOTTOM_LEFT);

            }

            //setting # labels to the h column
            int [] ranks = {8,7,6,5,4,3,2,1};

            if(i==7){
                Label label= new Label();

                label.setText(String.valueOf(ranks[j]));
                label.setStyle("-fx-font-size: 14;");

                if(square.getIsLightSquare()){
                    label.setTextFill(getDarkColor());
                }
                else{
                    label.setTextFill(getLightColor());
                }

                stackPane.getChildren().add(label);
                stackPane.setAlignment(label, Pos.TOP_RIGHT);

            }

            square.setPrefSize(100,100);

            add(stackPane,i,j);
            squares[i][j] = square;

        }
    }

    initPieces();


//            squares[5][5].removePiece();
//    for(int i = 0;i<8;i++){
//        for(int j =0;j<8;j++){
//
//            System.out.println(this.squares[j][i].getOccupied());
//        }
//    }

}

    public Color getLightColor() {
        return this.lightColor;
    }
    public Color getDarkColor(){
    return this.darkColor;
    }

//sets all the pieces on the board
public void initPieces(){
    //init pawns
    for(int i = 0;i<8;i++){
        for(int j =0;j<8;j++){
            if(j==1){
                squares[i][j].setPiece(new Pawn("black"));
            }
            if(j==6){
                squares[i][j].setPiece(new Pawn("white"));
            }

            int finalI = i;
            int finalJ = j;


            squares[i][j].setOnMouseClicked(event -> movePiece(squares[finalI][finalJ]));

            squares[5][2].setText("5 2");
            squares[6][4].setText("6 4");
            squares[5][4].setText("" + squares[5][4].getX() + " " + squares[5][4].getY());
        }
    }

    //init white pieces-------------------------------------------
    //white rooks
    squares[0][7].setPiece(new Rook("white"));

    squares[7][7].setPiece(new Rook("white"));

    //white knights
    squares[1][7].setPiece(new Knight("white"));

    squares[6][7].setPiece(new Knight("white"));

    //white bishops
    squares[2][7].setPiece(new Bishop("white"));

    squares[5][7].setPiece(new Bishop("white"));

    //white queen
    squares[3][7].setPiece(new Queen("white"));

    //white king
    squares[4][7].setPiece(new King("white"));


    //---------------------------------------------------------
    //init black pieces-------------------
    //white rooks
    squares[0][0].setPiece(new Rook("black"));

    squares[7][0].setPiece(new Rook("black"));

    //white knights
    squares[1][0].setPiece(new Knight("black"));

    squares[6][0].setPiece(new Knight("black"));
    //white bishops
    squares[2][0].setPiece(new Bishop("black"));
    squares[5][0].setPiece(new Bishop("black"));
     //white queen
    squares[3][0].setPiece(new Queen("black"));
    //white king
    squares[4][0].setPiece(new King("black"));





}


//removes the pieces and then calls the initPieces method to reset the board
public void resetBoard(){
    for(int i =0;i<8;i++){
        for(int j =0;j<8;j++){
            if(squares[i][j].getOccupied()){
                squares[i][j].removePiece();
            }
        }
    }
    this.selectedSquare=null;
    removeSelected();
    this.whitePlayer.getCapturedPieces().clear();
    this.blackPlayer.getCapturedPieces().clear();
    UI.removeCapturedPieces();

    if(Game.getTurn()==-1){
        Game.setTurn();
    }


    initPieces();
}

    public void movePiece(Square square) { //square is the square being pressed

        if(this.selectedSquare==null ) {
            if ((square.getOccupied() && square.getPiece().getColor().equals("white") && Game.getTurn() == 1) || square.getOccupied()&& square.getPiece().getColor().equals("black") && Game.getTurn() == -1) {
                if (square.getOccupied()) {
                    this.selectedSquare = square;
                    square.select();
                    this.currentStyle = square.getStyle();
                    if (!currentStyle.endsWith(";") && !currentStyle.isEmpty()) {
                        currentStyle += ";"; // Ensure the existing style ends with a semicolon
                    }
                    square.setStyle(currentStyle + "-fx-border-color: yellow; -fx-border-width: 2;");
                    Game.setTurn();
                }
            }
        }
        else {

            if (square != selectedSquare) {

                if(square.getOccupied()){
                    capturePiece(square);

                }

                square.setPiece(selectedSquare.getPiece());
                removeSelected();
            }
            else{
                square.select();
                selectedSquare=null;
                removeYellowBorder();
                Game.setTurn();
            }
        }

        }

        public void removeSelected(){

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (squares[i][j].getSelected()) {
                        squares[i][j].removePiece();
                        squares[i][j].select();
                        this.selectedSquare = null;
                    }
                    if(squares[i][j].getStyle().equals(this.getCurrentStyle()+"-fx-border-color: yellow; -fx-border-width: 2;") ){
                        if(squares[i][j].getIsLightSquare()){
                            squares[i][j].setStyle(this.lightStyle);
                        }
                        else{
                            squares[i][j].setStyle(this.darkStyle);
                        }
                    }

                }
            }
        }
        public void removeYellowBorder() {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (squares[i][j].getStyle().equals(this.getCurrentStyle()+"-fx-border-color: yellow; -fx-border-width: 2;")) {



                        if(squares[i][j].getIsLightSquare()){
                            squares[i][j].setStyle(this.lightStyle);
                        }
                        else{
                            squares[i][j].setStyle(this.darkStyle);
                        }
                    }
                }
            }
        }

        //this method adds the captured piece to the correct arraylist. it also appends the captured piece to the correct side
        public void capturePiece(Square square){

            if(square.getPiece().getColor().equals("white")){
                this.blackPlayer.getCapturedPieces().add(square.getPiece());
                UI.updateBlackCaptures(square.getPiece());
            }
            else{
                this.whitePlayer.getCapturedPieces().add(square.getPiece());
                UI.updateWhiteCaptures(square.getPiece());
            }

        }

        public String getCurrentStyle(){
            return this.currentStyle;
        }

        public Player getWhitePlayer(){
            return this.whitePlayer;
        }
        public Player getBlackPlayer(){
            return this.blackPlayer;
        }






        public static void main (String[] args){


        }

    }
