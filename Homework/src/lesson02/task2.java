package lesson02;

import static lesson02.lesson02.outMessageToConsole;

/*
 * Task 2.
 * Задать пустой целочисленный массив размером 8.
 * С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
 * */
public class task2 {
    public static void task() {
        String textTask = "\nЗадание 2. \nЗадать пустой целочисленный массив размером 8.\n" +
                "С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21.\n\n";
        String sourceArray = "";
        String resultArray = "Итоговый массив: ";

        int[] task2Array = new int[8];
        int x = 0;
        for (int i : task2Array) {
            resultArray += task2Array[i] = x;
            x += 3;
            resultArray += " ";
        }
        resultArray += "\n";
        outMessageToConsole(textTask, sourceArray, resultArray);

    }
}
