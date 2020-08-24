package lesson02;

import static lesson02.lesson02.outMessageToConsole;

/*
 * Task 1.
 * Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
 * С помощью цикла и условия заменить 0 на 1, 1 на 0;
 * */
public class task1 {
    public static void task() {
        String textTask = "\nЗадание 1. \nЗадать целочисленный массив, состоящий из элементов 0 и 1. С помощью цикла и условия заменить 0 на 1, 1 на 0.\n\n";
        String sourceArray = "Исходный массив: ";
        String resultArray = "Итоговый массив: ";
        byte[] massiveOneZero = {0, 1, 0, 0, 0, 1, 1, 0};
        for (byte i : massiveOneZero) {
            sourceArray += massiveOneZero[i] + " ";
            if (massiveOneZero[i] != 0) {
                massiveOneZero[i] = 0;
            } else {
                massiveOneZero[i] = 1;
            }
            resultArray += massiveOneZero[i] + " ";
        }
        sourceArray+="\n";
        resultArray+="\n";
        outMessageToConsole(textTask, sourceArray, resultArray);
    }

}
