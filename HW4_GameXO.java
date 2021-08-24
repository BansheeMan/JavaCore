package lesson4;

import java.util.Random;
import java.util.Scanner;

public class HW4_GameXO {

    public static final int FIELD_SIZE = 5;
    public static final char HUMAN_DOT = 'X';
    public static final char PC_DOT = 'O';
    public static final int WIN_DOT = 4; //длина комбинации необходимая  для победы


    public static void main(String[] args) {
        start(FIELD_SIZE);
    }

    static void start(int field_size) {
        char[][] field = createField(field_size);
        drawField(field);

        do {
            doPlayerMove(field);
            drawField(field);
            if (isWin(field, HUMAN_DOT)) {
                System.out.println("Congrats!!! You are winner :)");
                break;
            }
            if (isDraw(field)) {
                System.out.println("This is draw.");
                break;
            }

            doAIMove(field);
            drawField(field);
            if (isWin(field, PC_DOT)) {
                System.out.println("Sorry!!! You are looser :(");
                break;
            }
            if (isDraw(field)) {
                System.out.println("This is draw.");
                break;
            }
        } while (true);
    }

    static boolean isDraw(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (isFreeCell(field, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isWin(char[][] field, char symbol) {
        int hor, ver;
        int diagLeft, diagRight;
        for (int i = 0; i < FIELD_SIZE; i++) {
            hor = 0;
            ver = 0;
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (field[i][j] == symbol) {
                    hor++;
                } else if (field[i][j] != symbol && hor < WIN_DOT) {
                    hor = 0;
                }
                if (field[j][i] == symbol) {
                    ver++;
                }   else if (field[j][i] != symbol && ver < WIN_DOT) {
                    ver = 0;
                }
            }
            if (hor >= WIN_DOT || ver >= WIN_DOT)
                return true;
        }

        for (int j = 0; j < FIELD_SIZE; j++) {
            diagLeft = 0;
            for (int i = 0; i < FIELD_SIZE; i++) {
                int k = j + i;
                if (k < FIELD_SIZE) {
                    if (field[i][k] == symbol) {
                        diagLeft++;
                    } else if (field[i][k] != symbol && diagLeft < WIN_DOT) {
                        diagLeft = 0;
                    }
                }
                if (diagLeft >= WIN_DOT)
                    return true;
            }
        }
        for (int j = 1; j < FIELD_SIZE; j++) {
            diagLeft = 0;
            for (int i = 0; i < FIELD_SIZE; i++) {
                int k = j + i;
                if (k < FIELD_SIZE) {
                    if (field[k][i] == symbol) {
                        diagLeft++;
                    } else if (field[k][i] != symbol && diagLeft < WIN_DOT) {
                        diagLeft = 0;
                    }
                }
                if (diagLeft >= WIN_DOT)
                    return true;
            }
        }
        for (int j = 0; j < FIELD_SIZE; j++) {
            diagRight = 0;
            for (int i = 0; i < FIELD_SIZE; i++) {
                int k = (FIELD_SIZE - 1) - i;
                int l = j + i;
                if (k >= 0 && l < FIELD_SIZE) {
                    if (field[l][k] == symbol) {
                        diagRight++;
                    } else if (field[l][k] != symbol && diagRight < WIN_DOT) {
                        diagRight = 0;
                    }
                }
                if (diagRight >= WIN_DOT)
                    return true;
            }
        }
        for (int j = 1; j < FIELD_SIZE; j++) {
            diagRight = 0;
            for (int i = 0; i < FIELD_SIZE; i++) {
                int k = (FIELD_SIZE - 1) - j - i;
                if (k >= 0) {
                    if (field[i][k] == symbol) {
                        diagRight++;
                    } else if (field[i][k] != symbol && diagRight < WIN_DOT) {
                        diagRight = 0;
                    }
                }
                if (diagRight >= WIN_DOT)
                    return true;
            }
        }
        return false;
    }


    static char[][] createField(int field_size) {
        char[][] field = new char[field_size][field_size];
        for (int y = 0; y < field_size; y++){
            for (int x = 0; x < field_size; x++){
                field[y][x] = '-';
            }
        }
        return field;
    }

    static void doPlayerMove(char[][] field) {
        int h, v;
        do {
            h = getCoordinate(field.length - 1, 'h');
            v = getCoordinate(field.length - 1, 'v');
        } while (isNotFreeCell(field, h, v));

        field[h][v] = HUMAN_DOT;
    }

    //БЛОКИРОВКА ПОСЛЕДНЕГО ХОДА ИГРОКА
    static boolean blockPlayerLastMove(char[][] field) {
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (isFreeCell(field, i, j)) {
                    field[i][j] = HUMAN_DOT;            // поставим X в каждую клетку по очереди
                    if (isWin(field, HUMAN_DOT)) {      // если игрок побеждает
                        field[i][j] = PC_DOT;           // ставим на то место O
                        return true;
                    }
                    field[i][j] = '-';            // в противном случае вернуть на место пустоту
                }
            }
        }
        return false;
    }

    static void doAIMove(char[][] field) {
        if (blockPlayerLastMove(field)) { //ИИ ПРОВЕРЯЕТ И БЛОКИРУЕТ ПРИ НЕОБХОДИМОСТИ ПОСЛЕДНИЙ ХОД ИГРОКА
            return;
        }
        int h, v;
        Random random = new Random();

        do {
            h = random.nextInt(field.length);
            v = random.nextInt(field.length);
        } while (isNotFreeCell(field, h, v));

        field[h][v] = PC_DOT;
    }

    static boolean isFreeCell(char[][] field, int h, int v) {
        return field[h][v] == '-';
    }
    static boolean isNotFreeCell(char[][] field, int h, int v) {
        return !isFreeCell(field, h, v);
    }


    static int getCoordinate(int lastIndex, char coordName) {
        Scanner scanner = new Scanner(System.in);
        int coord;
        do {
            System.out.printf("Please enter %s-coordinate ... [1-%s]%n", coordName, FIELD_SIZE);
            coord = scanner.nextInt() - 1;
        } while (coord < 0 || coord > lastIndex);
        return coord;
    }

    static void drawField(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                System.out.print(field[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

        System.out.println();
    }

}
