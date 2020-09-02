package lesson04;

/*
 * Author Lina Rusakova.
 * This is main package for homework for lesson4 of course Java Level1.
 * All tasks for lesson04 printed out in to console.
 * Thanks!
 */


import java.util.Random;
import java.util.Scanner;


public class lesson04 {
    //В отличие от дефолтного варианта, я решила всю игровую карту сразу последовательно заполнить числовыми значениям, начиная с 1.
    //В таком варианте человеку будет легче играть: игроку необходимо только указать число в соответствующей ячейке, которое заменится на Х.
    // Таким образом я избавляюсь от необходимости строить числовые координатные оси и упрощаю логику для формироания поля и отслеживания игрового процесса.

    static String tempValue = ""; // строковый вариант переменной fillValues
    static int mapSize = 5; // задаем размер карты
    static int lengthWinner = 4; // задаем количество фишек в ряд, необходимых для победы
    static final String x = "X"; // задаем символ для хода человека
    static final String o = "O"; // задаем символ для хода компьютера
    public static String[][] gameMap = new String[mapSize][mapSize];
    static boolean isNext = true; // переменная, позволяющая/запрещающая (true/false) дальнейший ход игры
    static boolean isRepeat; // переменная, если игрок ввел некорректное значение
    static String userAct; // строковая переменная, введеного игроком числа
    public static boolean winnerGamer; // переменная, для определения победиителя в игре

    static int winnXCoordinate;
    static int winnYCoordinate;

    public static void main(String[] args) {
        //Сначала вызовем метод для создания игровой карты.
        prepareGameXO();
        //Вызовем основной метод игры.
        playGame();
    }

    // подготовка игрового поля
    private static void prepareGameXO() {
        System.out.printf("Игра \"крестики-нолики\" \nИгровое поле имеет размер %s на %s. \nВы ходите - \"%s\", компьютер ходит \"%s\".\nДля того, чтобы походить введите число, на место которого вы хотите поставить %s.\n\n", mapSize, mapSize, x, o, x);
        // String[][] gameMap = new String[mapSize][mapSize];
//        for (int i = 0; i < printValues.length; i++) {
//            printValues[i] = i + 1;
//        }
        int i, j;
        int movesNext = 0;
        for (i = 0; i < mapSize; i++) {
            for (j = 0; j < mapSize; j++) {
                gameMap[i][j] = Integer.toString(movesNext);
                tempValue += gameMap[i][j] + "\t";
                movesNext++;
            }
            tempValue += "\n";
        }

        System.out.println(tempValue);
        System.out.println("В игре возможных ходов: " + movesNext + ".\n");
        tempValue = "";// сбросим значение переменной
    }

    // оснвоной метод игры
    private static void playGame() {
        while (isNext) {
            playGameX();
            playGameO();
        }
    }

    // описываем метод хода игрока (человека)
    private static void playGameX() {
        if (isNext && isContinue()) {
            System.out.println("Ваш ход!");
            Scanner scanner = new Scanner(System.in);
            userAct = scanner.nextLine();

            //на игровом поле в ячейку, соответствующей введенному игроком числу, записываем "X"
            // а также проверяем, корректное ли число введено игроком (проверяем, есть ли такое на игровом поле)?
            int i, j;
            isRepeat = true;
            for (i = 0; i < mapSize; i++) {
                for (j = 0; j < mapSize; j++) {
                    if (userAct.equals(gameMap[i][j])) {
                        gameMap[i][j] = x;
                        isRepeat = false;
                    }
                    tempValue += gameMap[i][j] + "\t";
                }
                tempValue += "\n";
            }

            if (isRepeat) { //если число некорректное
                System.out.println("Вы ввели некорректное число. Повторите ввод заново!"); // сообщаем об этом игроку
                tempValue = "";// сбрасываем значение переменной, выводящей игровое поле в консоль
                playGameX(); //рекурсивно запустим метод  playGameX();
            } else { // если всё в порядке, то
                System.out.println(tempValue); // выводим игровое поле с ходом игрока
                tempValue = "";// сбрасываем значение переменной, выводящей игровое поле в консоль
                if (checkWinner(x, false)) {
                    System.out.println("Победил человек! Игра окончена.");
                    isNext = false;
                }
            }
        }
    }

    // описываем логику ходов компьютера
    private static void playGameO() {
        if (isNext && isContinue()) {
            String AiAct = "";
            isRepeat = true;
            while (isRepeat) {
            if (checkWinner(o, true)) { //проверяем, может ли на этом ходе победить компьютер
                if (!x.equals(gameMap[winnXCoordinate][winnYCoordinate]) && !o.equals(gameMap[winnXCoordinate][winnYCoordinate])) { //проверяем не стоит ли уже что-то в этом месте.
                    AiAct=gameMap[winnXCoordinate][winnYCoordinate];
                    gameMap[winnXCoordinate][winnYCoordinate] = o;
                }
            }
                if (checkWinner(x, true)) { //если нет, то проверяем, может ли на этом ходе победить человек, если да, то блокируем его
                    if (!x.equals(gameMap[winnXCoordinate][winnYCoordinate]) && !o.equals(gameMap[winnXCoordinate][winnYCoordinate])) {
                        AiAct = gameMap[winnXCoordinate][winnYCoordinate];
                        gameMap[winnXCoordinate][winnYCoordinate] = o;
                    }
                } else { //если не то и не другое, то запускаем рандомный шаг компьютера

                    Random random = new Random();
                    int numberAi = random.nextInt(mapSize * mapSize);
                    AiAct = String.valueOf(numberAi);
                    for (int i = 0; i < mapSize; i++) {
                        for (int j = 0; j < mapSize; j++) {
                            if (AiAct.equals(gameMap[i][j]) && !AiAct.equals(x) && !AiAct.equals(o)) {
                                gameMap[i][j] = o;
                                isRepeat = false;
                                break;
                            }
                        }
                    }

                }
            }

            //формируем итоговое игровое поле после хода компьютера
            for (int i = 0; i < mapSize; i++) {
                for (int j = 0; j < mapSize; j++) {
                    tempValue += gameMap[i][j] + "\t";
                }
                tempValue += "\n";
            }
            System.out.println("Копьютер ходит: " + AiAct + ".\n");
            System.out.println(tempValue); // выводим игровое поле с ходом игрока
            tempValue = "";// сбрасываем значение переменной, выводящей игровое поле в консоль
            if (checkWinner(o, false)) {
                System.out.println("Победил компьютер! Игра окончена.");
                isNext = false;
            }

        }
    }


    //Проверим, возможны ли ходы дальше, и не окончена ли уже игра.
    private static boolean isContinue() {
        if (isNext) {
            //проверим, остались ли незанятые ходами игрока и компьютера ячейки, если да суммируем их
            int i, j;
            int movesNext = 0;
            for (i = 0; i < mapSize; i++) {
                for (j = 0; j < mapSize; j++) {
                    if (gameMap[i][j].equals(x) || gameMap[i][j].equals(o)) {
                        movesNext++;
                    }
                }
            }
            if ((mapSize * mapSize - movesNext) > 0) {
                isNext = true;
                System.out.println("В игре осталось " + (mapSize * mapSize - movesNext) + " ходов.\n");
            } else { //если ходов не осталось
                isNext = false;
                System.out.println("Ходов не осталось. Игра завершилась ничьёй."); //если есть хотя бы одна ячейка со значением -1, то переменная isNext получает true, в противном случае false
            }
        }
        return isNext;
    }

    //проверка ходов на победу
    private static boolean checkWinner(String nameWinner, boolean simulation) {

        //проверяем победу на всех строках и столбцах, соответствующих условию количества выигрышных фишек и размеру игрового
        winnerGamer = false;
        int row = 0, col = 0;
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if (gameMap[i][j].equals(nameWinner)) {
                    row++;
                    if (row == lengthWinner) {
                        winnerGamer = true;
                        break;
                    }
                    if (row == lengthWinner - 1 && simulation && j + 1 < mapSize) {
                        if (o != gameMap[i][j + 1]) {
                            winnXCoordinate = i;
                            winnYCoordinate = j + 1;
                            winnerGamer = true;
                            break;
                        }
                    }
                }else {
                        row = 0;
                    }
            }
        }
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if (gameMap[j][i].equals(nameWinner)) {
                    col++;
                    if (col == lengthWinner) {
                        winnerGamer = true;
                        break;
                    }
                    if (col == lengthWinner - 1 && simulation && j + 1 < mapSize) {
                        if (o != gameMap[j+1][i]) {
                            winnXCoordinate = j+1;
                            winnYCoordinate = i;
                            winnerGamer = true;
                            break;
                        }
                    }
                } else {
                    col = 0;
                }
            }
        }

            //проверяем победу на всех диагоналях, соответствующих условию количества выигрышных фишек и размеру игрового поля
            int d = 0;
            while (d <= mapSize - lengthWinner) {
                //проверяем победу на всех главных диагоналях, соответствующих условию количества выигрышных фишек и размеру игрового поля
                for (int j = 0, diagonalH = 0, diagonalD = 0; j < mapSize - d; j++) {   //diagonalH- все диагонали выше главной, diagonalD все диагонали выше главной
                    if (gameMap[j + d][j].equals(nameWinner)) {
                        diagonalH++;
                        if (diagonalH == lengthWinner) {
                            winnerGamer = true;
                            break;
                        }
                        if (diagonalH == lengthWinner - 1 && simulation && j + d + 1 < mapSize && j + 1 < mapSize) {
                            if (o != gameMap[j + d + 1][j + 1]) {
                                winnXCoordinate = j + d + 1;
                                winnYCoordinate = j + 1;
                                winnerGamer = true;
                                break;
                            }
                        }
                    } else {
                        diagonalH = 0;
                    }
                    if (gameMap[j][j + d].equals(nameWinner)) {
                        diagonalD++;
                        if (diagonalD == lengthWinner) {
                            winnerGamer = true;
                            break;
                        }
                        if (diagonalD == lengthWinner - 1 && simulation && j + d + 1 < mapSize && j + 1 < mapSize) {
                            if (!gameMap[j + 1][j + d + 1].equals(o)) {
                                winnYCoordinate = j + d + 1;
                                winnXCoordinate = j + 1;
                                winnerGamer = true;
                                break;
                            }
                        }
                    } else {
                        diagonalD = 0;
                    }
                }
                //проверяем победу на всех второстепенных диагоналях, соответствующих условию количества выигрышных фишек и размеру игрового поля
                for (int j = 0, diagonalH = 0, diagonalD = 0; j < mapSize - d; j++) {   //diagonalH- все диагонали выше главной, diagonalD все диагонали выше главной
                    if (gameMap[j + d][mapSize - 1 - j].equals(nameWinner)) {
                        diagonalH++;
                        if (diagonalH == lengthWinner) {
                            winnerGamer = true;
                            break;
                        }
                        if (diagonalH == lengthWinner - 1 && simulation) {
                            if (j + d + 1 < mapSize - d && mapSize - 1 - (j + 1) < mapSize - d && !gameMap[j + d + 1][mapSize - 1 - (j + 1)].equals(o)) {
                                winnXCoordinate = j + d + 1;
                                winnYCoordinate = mapSize - 1 - (j + 1);
                                winnerGamer = true;
                                break;
                            }
                        }
                    } else {
                        diagonalH = 0;
                    }
                    if (gameMap[j][mapSize - 1 - (j + d)].equals(nameWinner)) {
                        diagonalD++;
                        if (diagonalD == lengthWinner) {
                            winnerGamer = true;
                            break;
                        }
                        if (diagonalD == lengthWinner - 1 && simulation) {
                            if (j + 1 < mapSize - d && mapSize - 1 - j + 1 < mapSize - d && !gameMap[j + 1][mapSize - 1 - (j + 1 + d)].equals(o)) {
                                winnXCoordinate = j + 1;
                                winnYCoordinate = mapSize - 1 - (j + 1 + d);
                                winnerGamer = true;
                                break;
                            }
                        }
                    } else {
                        diagonalD = 0;
                    }
                }
                d++;
            }
        return winnerGamer;
        }

    }
