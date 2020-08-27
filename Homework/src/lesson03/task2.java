package lesson03;

import java.util.Random;
import java.util.Scanner;

public class task2 {
    public static void task() {
        String taskNumber = "Задание 2";
        String textTask = "Создать массив из слов String[] words = {\"apple\", \"orange\", \"lemon\", \"banana\", \"apricot\", \"avocado\", \"broccoli\", \"carrot\", \"cherry\", \"garlic\", \"grape\", \"melon\", \"leak\", \"kiwi\", \"mango\", \"mushroom\", \"nut\", \"olive\", \"pea\", \"peanut\", \"pear\", \"pepper\", \"pineapple\", \"pumpkin\", \"potato\"};\n" +
                "При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,\n" +
                "сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.. \n";

        System.out.printf("%n%s%n%s%n%n", taskNumber, textTask);

        //
        smartWord();

    }

    public static void smartWord() {
        String textTask = "Компьютер загадал одно из следующих слов:\n" +
                "\"apple\", \"orange\", \"lemon\", \"banana\", \"apricot\", \"avocado\", \"broccoli\", \"carrot\", \"cherry\", \"garlic\", \"grape\", \"melon\", \"leak\", \"kiwi\", \"mango\", \"mushroom\", \"nut\", \"olive\", \"pea\", \"peanut\", \"pear\", \"pepper\", \"pineapple\", \"pumpkin\", \"potato\"";

        String pleaseInput = "Пробуйте его отгадать.";
        String terms = "Игра идет до победного конца. Удачи!!!";
        System.out.printf("%s%n%s%n%s%n", textTask, pleaseInput, terms);
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        Random randomWord = new Random();
        String smartWord = words[randomWord.nextInt(words.length)];
//        System.out.println(smartWord);
        readConsole(smartWord);
    }

    public static void readConsole(String randomWord) {
        Scanner userAnswer = new Scanner(System.in);
        while (true) {
            System.out.println("Введите ваш вариант: ");

            if (!userAnswer.hasNextLine()) {
                System.out.println("Было введено число. Вам необходим ввести слов!");
                userAnswer.nextInt();
                continue;
            }

            String inputWord = userAnswer.nextLine();
            String messageForUser = "";
            int length;
            if (inputWord.equals(randomWord)) {
                System.out.println("Вы угадали загаданное слово  " + randomWord);
                break;
            } else {
                System.out.println("Вы ошиблись. Загадано другое слово.");
                if (randomWord.length()<=inputWord.length()) {
                   length=randomWord.length();
                } else  {
                     length=inputWord.length();
                }
                for (int i = 0; i < length; i++) {

                    if (randomWord.charAt(i) == inputWord.charAt(i)) {
                        messageForUser += randomWord.charAt(i);
                    } else {
                        messageForUser += "X";
                    }
                    if (i == (length - 1)) {
                        int j = randomWord.length() - 1;
                        for (; j < 15; j++) {
                            messageForUser += "X";
                        }
                    }
                }
                    System.out.println(messageForUser + "\nПопробуйте еще раз.");


            }
        }
    }

}

