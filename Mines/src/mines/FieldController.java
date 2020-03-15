/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mines;

import java.util.Scanner;

/**
 *
 * @author Matěj
 */
public class FieldController {

    public static void replaceOnHidenField(int x, int y) {
        FieldCreator.hidenField[x][y] = FieldCreator.field[x][y];
    }

    public static void replaceOnHidenFieldAllNeighbors(int x, int y) {
        if ((x - 1) >= 0 && (x - 1) < FieldCreator.Xaxis) {
            if ((y - 1) >= 0 && (y - 1) < FieldCreator.Yaxis) {
                FieldCreator.hidenField[x - 1][y - 1] = FieldCreator.field[x - 1][y - 1];
            }
        }

        if ((x - 1) >= 0 && (x - 1) < FieldCreator.Xaxis) {
            if ((y) >= 0 && (y) < FieldCreator.Yaxis) {
                FieldCreator.hidenField[x - 1][y] = FieldCreator.field[x - 1][y];
            }
        }

        if ((x - 1) >= 0 && (x - 1) < FieldCreator.Xaxis) {
            if ((y + 1) >= 0 && (y + 1) < FieldCreator.Yaxis) {
                FieldCreator.hidenField[x - 1][y + 1] = FieldCreator.field[x - 1][y + 1];
            }
        }

        if ((x) >= 0 && (x) < FieldCreator.Xaxis) {
            if ((y - 1) >= 0 && (y - 1) < FieldCreator.Yaxis) {
                FieldCreator.hidenField[x][y - 1] = FieldCreator.field[x][y - 1];
            }
        }

        if ((x) >= 0 && (x) < FieldCreator.Xaxis) {
            if ((y + 1) >= 0 && (y + 1) < FieldCreator.Yaxis) {
                FieldCreator.hidenField[x][y + 1] = FieldCreator.field[x][y + 1];
            }
        }

        if ((x + 1) >= 0 && (x + 1) < FieldCreator.Xaxis) {
            if ((y - 1) >= 0 && (y - 1) < FieldCreator.Yaxis) {
                FieldCreator.hidenField[x + 1][y - 1] = FieldCreator.field[x + 1][y - 1];
            }
        }

        if ((x + 1) >= 0 && (x + 1) < FieldCreator.Xaxis) {
            if ((y) >= 0 && (y) < FieldCreator.Yaxis) {
                FieldCreator.hidenField[x + 1][y] = FieldCreator.field[x + 1][y];
            }
        }

        if ((x + 1) >= 0 && (x + 1) < FieldCreator.Xaxis) {
            if ((y + 1) >= 0 && (y + 1) < FieldCreator.Yaxis) {
                FieldCreator.hidenField[x + 1][y + 1] = FieldCreator.field[x + 1][y + 1];
            }
        }

    }

    private static boolean isInField(int x, int y) {
        if ((x) >= 0 && (x) < FieldCreator.Xaxis) {
            return (y) >= 0 && (y) < FieldCreator.Yaxis;
        }
        return false;
    }

    private static boolean isCorectInput(String input) {
        return input.matches("^[0-9]*$");
    }

    private static boolean isIn2DArray(String[][] arr, String element) {
        boolean reason = false;
        for (String[] row : arr) {
            for (String string : row) {
                if (string.contains(element)) {
                    reason = true;
                    break;
                }
            }
        }
        return reason;
    }

    public static int elementsIn2DArray(String[][] arr, String element) {
        int numberOfCount = 0;
        for (String[] row : arr) {
            for (String string : row) {
                if (string.equals(element)) {
                    numberOfCount++;
                }
            }
        }
        return numberOfCount;
    }

    public static void playTheGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Výtejte ve hře Miny. Před zahánením hry si prosím nastavte herní pole... Velikost osy X:");
        int x = scanner.nextInt();
        System.out.print("Velikost osy Y:");
        int y = scanner.nextInt();
        System.out.print("Počet bomb:");
        int bombs = scanner.nextInt();
        FieldCreator.createField(x, y, bombs);

        System.out.println();
        FieldCreator.printHidenField();
        System.out.println();
        while (true) {
            System.out.print("Prosím zadejte sloupec Vámi vybraného políčka z leva od jedné: ");
            int X = scanner.nextInt() - 1;
            System.out.print("Prosím zadejte řádek Vámi vybraného políčka z leva od jedné: ");
            int Y = scanner.nextInt();
            if (isInField(X, Y)) {
                if (!FieldCreator.field[X][Y].equals("B")) {

                    FieldController.replaceOnHidenField(X, Y);
                    System.out.println();
                } else {
                    FieldController.replaceOnHidenField(X, Y);
                    System.out.println();
                    FieldCreator.printHidenField();
                    System.out.println("Prohráli jste! Konec hry.");
                    System.exit(0);
                }
                if (FieldCreator.field[X][Y].equals("0")) {
                    replaceOnHidenFieldAllNeighbors(X, Y);
                }

                do {
                    for (int i = 0; i < FieldCreator.Yaxis; i++) {
                        for (int j = 0; j < FieldCreator.Xaxis; j++) {
                            if (FieldCreator.hidenField[j][i].equals("0")) {
                                FieldCreator.hidenField[j][i] = "_";
                                FieldCreator.field[j][i] = "_";
                                replaceOnHidenFieldAllNeighbors(j, i);

                            }
                        }
                    }
                } while (isIn2DArray(FieldCreator.hidenField, "0"));
                if (elementsIn2DArray(FieldCreator.hidenField, "#") == FieldCreator.bombs) {
                    FieldCreator.printHidenField();
                    System.out.println("Výhráli jste! Gratuluji.");
                    System.exit(0);
                }
            } else {
                System.out.println("Prosím, zadejte souřadnice políčka nacházejícího se v poli.");
            }

            FieldCreator.printHidenField();
        }
    }
}
