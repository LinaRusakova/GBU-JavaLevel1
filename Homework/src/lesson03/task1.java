package lesson03;
/*
 * Task 1.
 * Задать пустой целочисленный массив размером 8.
 * С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
 * */


import java.util.Random;
import java.util.Scanner;

public class task1 {

    public static void task() {
        String taskNumber = "Задание 1";
        String textTask = "Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки угадать это число. \n" +
                "При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное, или меньше.\n" +
                "После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).";
        System.out.printf("%s%n%s%n%n", taskNumber, textTask);

        randomNumber();

    }

    private static void randomNumber() {
        String textTask = "Угадайте случайное число от 0 до 9.\nВам дается 3 попытки угадать это число. \n";
        String pleaseInput = "Пожалуйста, введите ваш вариант:";
        System.out.printf("%s%n%s%n", textTask, pleaseInput);
        Random random = new Random();
        int randomNumber = random.nextInt(9);
        readConsole(randomNumber);

    }

    public static void readConsole(int randomNumber) {
        Scanner userAnswer = new Scanner(System.in);
        int counter = 3;
        while (true) {
            System.out.println("Введите число от 0 до 9: ");

            if (!userAnswer.hasNextInt()) {
                System.out.println("Было введено нечисловое значение!");
                userAnswer.nextLine();
                continue;
            }

            int number = userAnswer.nextInt();

            if ((number >= 0 && number <= 9) && number == randomNumber) {
                System.out.println("Вы угадали загаданное число  " + number);
                break;
            } else {
                System.out.println("Было загадано другое число.");
                if (number > randomNumber) {
                    System.out.println("Введенное вами число больше загаданного числа");
                } else {
                    System.out.println("Введенное вами число меньше загаданного числа.");
                }
                counter--;
                if (counter > 0) {
                    System.out.println("Попробуйте еще раз.");
                }
                System.out.println("У вас осталось " + counter + " попыток.");
                if (counter == 0) {
                    System.out.println("Вы проиграли! \nИгра окончена.");
                    break;
                }
            }
        }

    }
}
