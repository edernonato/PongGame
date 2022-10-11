package com.edernonato;

import java.awt.*;
import java.awt.event.KeyEvent;


public class PongGame {
    private final double leftX = 0.02;
    private final double rightX= 0.98;
    private double leftY = 0.5;
    private double rightY = 0.5;
    private final double halfLength = 0.01;
    private double ballX = 0.5;
    private double ballY = 0.5;
    private boolean bounceLeft = true;
    private boolean bounceRight = false;
    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;
    public boolean play = true;

    public PongGame() {
        updateScreen();
    }

    private void printScorePlayers() {
        String player1 = "" + this.scorePlayer1;
        String player2 = "" + this.scorePlayer2;
        Font font = new Font("Courier", Font.BOLD, 40);
        StdDraw.setFont(font);
        StdDraw.text(0.2,0.8, player1);
        StdDraw.text(0.8,0.8, player2);
    }

    public void createBall(){
        StdDraw.filledSquare(this.ballX,this.ballY,0.01);
    }

    public void moveBall(){
        if(StdDraw.isKeyPressed(KeyEvent.VK_W)){
            moveLeftPaddleUp();
        } else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
            moveLeftPaddleDown();
        } else if (StdDraw.isKeyPressed(KeyEvent.VK_O)) {
            moveRightPaddleUp();
        } else if(StdDraw.isKeyPressed(KeyEvent.VK_L)){
            moveRightPaddleDown();
        } else if (StdDraw.isKeyPressed(KeyEvent.VK_B)) {
            bounceBallLeft();
        } else if (StdDraw.isKeyPressed(KeyEvent.VK_N)) {
            bounceBallRight();
        } else if (StdDraw.isKeyPressed(KeyEvent.VK_P)) {
            this.play = false;
        }

        if ((this.rightX - this.ballX > 0 && this.rightX - this.ballX <= 0.020) &&
                (this.rightY - this.ballY > 0 && this.rightY - this.ballY <= 0.090)){
            bounceBallLeft();
        } else if ((this.leftX  - this.ballX  > 0 && this.leftX  - this.ballX  <= 0.040)
                && (this.leftY - this.ballY  > 0 && this.leftY - this.ballY <= 0.090)) {
            bounceBallLeft();
        }

        if(this.ballX > 1){
            this.ballX = 0.5;
            this.ballY = 0.5;
            this.scorePlayer1 ++;
        } else if (this.ballX < 0) {
            this.ballX = 0.5;
            this.ballY = 0.5;
            this.scorePlayer2 ++;
        }

        if(this.ballY >=1){
            bounceBallRight();
        } else if (this.ballY < 0.020) {
            bounceBallRight();
        }

        if(!bounceLeft) {
            this.ballX -= 0.02;
        } else{
            this.ballX += 0.02;
        }

        if(!bounceRight) {
            this.ballY += 0.02;
        } else{
            this.ballY -= 0.02;
        }

        updateScreen();
    }
    public void bounceBallLeft(){
        this.bounceLeft = !this.bounceLeft;
    }

    public void bounceBallRight(){
        this.bounceRight = !this.bounceRight;
    }
    public void updateScreen(){
        StdDraw.clear(StdDraw.BLACK);
        StdDraw.setPenColor(Color.WHITE);
        createLeftPaddle();
        createRightPaddle();
        createBall();
        printScorePlayers();
        createMiddleLine();
    }

    public void createMiddleLine(){
        for(double i = 0; i < 1; i+=0.04){
            StdDraw.line(0.5,i,0.5, i-0.02);
        }
    }

    public void createLeftPaddle(){
        StdDraw.filledSquare(this.leftX, this.leftY, this.halfLength);
        StdDraw.filledSquare(this.leftX, this.leftY - 0.02, this.halfLength);
        StdDraw.filledSquare(this.leftX, this.leftY- 0.04, this.halfLength);
        StdDraw.filledSquare(this.leftX, this.leftY- 0.06, this.halfLength);

    }

    public void createRightPaddle(){
        StdDraw.filledSquare(this.rightX, this.rightY, this.halfLength);
        StdDraw.filledSquare(this.rightX, this.rightY - 0.02, this.halfLength);
        StdDraw.filledSquare(this.rightX, this.rightY - 0.04, this.halfLength);
        StdDraw.filledSquare(this.rightX, this.rightY - 0.06, this.halfLength);
    }

    public void moveLeftPaddleUp(){
        if(this.leftY < 0.98) {
            this.leftY += 0.04;
            updateScreen();
        }
    }

    public void moveLeftPaddleDown(){
        if(this.leftY > 0.095) {
            this.leftY -= 0.04;
            updateScreen();
        }
    }

    public void moveRightPaddleUp(){
        if(this.rightY < 0.98) {
            this.rightY += 0.04;
            updateScreen();
        }
    }

    public void moveRightPaddleDown(){
        if(this.rightY > 0.095) {
            this.rightY -= 0.04;
            updateScreen();
        }
    }
}
