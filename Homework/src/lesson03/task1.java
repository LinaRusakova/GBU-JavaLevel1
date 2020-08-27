package lesson03;
/*
 * Task 1.
 * Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки угадать это число.
 * При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное, или меньше.
 * После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет;
 * */


import java.util.Random;
import java.util.Scanner;

public class task1 {
    static Scanner scanner = new Scanner(System.in);
    static int answersCount = 2; // задаем значение (N-1) количества попыток угадать число
    static boolean restartGame; //задаем значение переменной, "разрешающей" продолжить игру (по-умолчанию, разрешено)

    public static void task() {

        String taskNumber = "Задание 1";
        String textTask = "Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки угадать это число. \n" +
                "При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное, или меньше.\n" +
                "После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).";
        System.out.printf("%s%n%s%n%n", taskNumber, textTask);


        restartGame = true;
        while (restartGame) {
            playLevel(9);
            reStartGame();
        }
        System.out.println("Игра завершена!");
    }

    private static void playLevel(int range) {
        Random random = new Random();
        int number = random.nextInt(9);

        //int number=(int)(Math.random()*range); // загадываем искомое число
        System.out.println("Угадайте число от 0 до " + range + ". У вас на это " + (answersCount + 1) + " попытки");
        while (true) {
            if (answersCount < 0) { //Если попытки кончились выходим из цикла
                System.out.println("Вы проиграли\n Играем уровень заново?");
                break;
            }
            int input_number = scanner.nextInt();
            if (input_number == number) {
                System.out.println("Вы угадали");
                answersCount = 3; //сбрасываем количество сделанных игроком попыток
                break;
            } else if (input_number > number) {
                System.out.println("Загаданное число меньше");
                System.out.println("Для ответа осталось попыток: " + answersCount + ".");
                answersCount--;
            } else {
                System.out.println("Загаданное число больше");
                System.out.println("Для ответа осталось попыток: " + answersCount + ".");
                answersCount--;
            }
        }

    }

    private static void reStartGame() {
        String scannerText;
        if (restartGame) {
            System.out.println("Введите \"1\", если хотите продолжить игру. \"0\" - чтобы завершить игру.");
            boolean answer=true;
            while (answer) {
                scannerText = scanner.next();
                if (scannerText.equals("1")) {
                    System.out.println("продолжаем...");
                    answersCount = 2;
                    answer=false;
                } else if (scannerText.equals("0")) {
                    restartGame = false; //scanner.close();
                    answer=false;
                } else {continue;}
            }
        }
    }
}
//    Вариант с вопросом "да"?
//        private static void reStartGame() {
//            String scannerText;
//            if (restartGame) {
//                System.out.println("Введите \"да\", если хотите продолжить игру.");
//                scannerText= scanner.next();
//                if (scannerText.equals("да")) {
//                    System.out.println("продолжаем..."); answersCount=2;
//                } else {
//                    restartGame=false; //scanner.close();
//                }
//            }
//        }
//    }

