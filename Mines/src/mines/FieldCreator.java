/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mines;

import java.util.Random;

/**
 *
 * @author Matěj
 */
public class FieldCreator {

    public static String[][] field, hidenField;
    public static int Xaxis, Yaxis, bombs;

    public static void createField(int X, int Y, int bombs) {
        FieldCreator.setField(X, Y);
        FieldCreator.plantBombs(bombs);
        FieldCreator.addNumbsInField();
        setHidenField();
    }

    public static void setField(int X, int Y) {
        Xaxis = X;
        Yaxis = Y;
        field = new String[Xaxis][Yaxis];
        for (int y = 0; y < Yaxis; y++) {
            for (int x = 0; x < Xaxis; x++) {
                field[x][y] = "0";
            }
        }
    }

    private static void setHidenField() {
        hidenField = new String[Xaxis][Yaxis];
        for (int y = 0; y < Yaxis; y++) {
            for (int x = 0; x < Xaxis; x++) {
                hidenField[x][y] = "#";
            }
        }
    }

    public static void printHidenField() {
        for (int y = 0; y < Yaxis; y++) {
            for (int x = 0; x < Xaxis; x++) {
                System.out.print(hidenField[x][y] + " ");
            }
            System.out.println("");
        }
    }

    public static void printField() {
        for (int y = 0; y < Yaxis; y++) {
            for (int x = 0; x < Xaxis; x++) {
                System.out.print(field[x][y] + " ");
            }
            System.out.println("");
        }
    }

    public static void addNumbsInField() {
        for (int y = 0; y < Yaxis; y++) {
            for (int x = 0; x < Xaxis; x++) {
                if (!field[x][y].equals("B")) {
                    field[x][y] = Integer.toString(numberOfNeighboringBombs(x, y));
                }
            }
        }
    }

    private static int numberOfNeighboringBombs(int x, int y) {
        int numberOfNeighboringBombs = 0;

        if ((x - 1) >= 0 && (x - 1) < Xaxis) {
            if ((y - 1) >= 0 && (y - 1) < Yaxis) {
                if (field[x - 1][y - 1].equals("B")) {
                    numberOfNeighboringBombs++;
                }
            }
        }

        if ((x - 1) >= 0 && (x - 1) < Xaxis) {
            if ((y) >= 0 && (y) < Yaxis) {
                if (field[x - 1][y].equals("B")) {
                    numberOfNeighboringBombs++;
                }
            }
        }

        if ((x - 1) >= 0 && (x - 1) < Xaxis) {
            if ((y + 1) >= 0 && (y + 1) < Yaxis) {
                if (field[x - 1][y + 1].equals("B")) {
                    numberOfNeighboringBombs++;
                }
            }
        }

        if ((x) >= 0 && (x) < Xaxis) {
            if ((y - 1) >= 0 && (y - 1) < Yaxis) {
                if (field[x][y - 1].equals("B")) {
                    numberOfNeighboringBombs++;
                }
            }
        }

        if ((x) >= 0 && (x) < Xaxis) {
            if ((y + 1) >= 0 && (y + 1) < Yaxis) {
                if (field[x][y + 1].equals("B")) {
                    numberOfNeighboringBombs++;
                }
            }
        }

        if ((x + 1) >= 0 && (x + 1) < Xaxis) {
            if ((y - 1) >= 0 && (y - 1) < Yaxis) {
                if (field[x + 1][y - 1].equals("B")) {
                    numberOfNeighboringBombs++;
                }
            }
        }

        if ((x + 1) >= 0 && (x + 1) < Xaxis) {
            if ((y) >= 0 && (y) < Yaxis) {
                if (field[x + 1][y].equals("B")) {
                    numberOfNeighboringBombs++;
                }
            }
        }

        if ((x + 1) >= 0 && (x + 1) < Xaxis) {
            if ((y + 1) >= 0 && (y + 1) < Yaxis) {
                if (field[x + 1][y + 1].equals("B")) {
                    numberOfNeighboringBombs++;
                }
            }
        }
        return numberOfNeighboringBombs;
    }

    public static void plantBombs(int numberOfBombs) {
        bombs = numberOfBombs;

        while (!isCorrectCountOfBombs()) {
            field[getRandomNumberInRange(0, (Xaxis - 1))][getRandomNumberInRange(0, (Yaxis - 1))] = "B";
        }
    }


    public static boolean isCorrectCountOfBombs() {
        int numberOfBombs = 0;
        for (int y = 0; y < Yaxis; y++) {
            for (int x = 0; x < Xaxis; x++) {
                if (field[x][y].equals("B")) {
                    numberOfBombs++;
                }
            }
        }
        return numberOfBombs == bombs;
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

}
