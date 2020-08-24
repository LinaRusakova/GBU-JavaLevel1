package lesson02;

import static lesson02.lesson02.outMessageToConsole;

/*
 * Task 5.
 * Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
 */

public class task5 {

    public static void task() {
        String textTask = "\nЗадание 5. \nЗадать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета); \n";
        String strSourceArray = "Одномерный массив: ";
        String strResult = "Минимальное значение: ";
        int minValue = 0, maxValue = 0;
        int[] sourceArray = {1, 5, 3, 2, 11, -4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < sourceArray.length; i++) {
            if (minValue > sourceArray[i]) minValue += sourceArray[i];
            if (maxValue < sourceArray[i]) maxValue = sourceArray[i];
            strSourceArray += sourceArray[i] + " ";
        }
        strSourceArray += "\n";
        strResult += minValue + ", максимальное значение: " + maxValue + "\n";
        outMessageToConsole(textTask, strSourceArray, strResult);
    }

}
