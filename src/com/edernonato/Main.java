package com.edernonato;


public class Main {
    public static void main(String[] args) {

        PongGame pongGame = new PongGame();
        while (pongGame.play) {
            try {
                Thread.sleep(8);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            pongGame.moveBall();
        }

    }
}
