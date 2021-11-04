package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        char water = '_';
        int gameBordLenght = 4;
        char ship = 'S';
        char hit = 'X';
        char miss = 'O';
        int shipNamber = 3;

        char [][] gameBoard = createGameBoard(gameBordLenght,water,ship,shipNamber);
        printGameBoard(gameBoard,water,ship);
    }

    private static void printGameBoard(char[][] gameBoard, char water, char ship) {
        int gameBoardLength = gameBoard.length;
        for (int row = 0;row < gameBoardLength; row++){
            for (int calms = 0; calms < gameBoardLength; calms++) {
                char possition = gameBoard [row][calms];
                if (possition == ship){
                    System.out.println(water + " " );
                } else {
                    System.out.println(possition + " ");
                }

            }
        }
    }

    private static char[][] createGameBoard(int gameBordLenght, char water, char ship, int shipNamber) {
        char[][] gameBoard = new char[gameBordLenght][gameBordLenght];
        for (char[] row : gameBoard) {
            Arrays.fill(row, water);
        }
        return placeShips(gameBoard, shipNamber, water, ship);
    }

    private static char[][] placeShips(char[][] gameBoard,int shipNamber,char water,char ship) {
        int placeShips = 0;
        int gameBoardLength = gameBoard.length;
        while (placeShips < shipNamber) {
            int[] location = genetrateShipCordinates(gameBoardLength);

            char possiblePlacement = gameBoard[location[0]][location[1]];
            if (possiblePlacement == water){
                gameBoard [location[0]][location[1]] = ship;
                placeShips ++;
            }
        }
        return gameBoard;
    }

    private static int[] genetrateShipCordinates(int gameBoardLength) {
        int[] cordinates = new int[2];
        for (int i = 0; i < cordinates.length; i++) {
            cordinates[i] = new Random().nextInt(gameBoardLength);

        }
        return cordinates;

    }
}