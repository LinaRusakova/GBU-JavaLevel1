package lesson02;

import static lesson02.lesson02.outMessageToConsole;

/*
 * Task 4.
 * Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
 * и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
 * */
public class task4 {

    protected static void task() {
        String textTask = "\nЗадание 4. \nСоздать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), \n" +
                "и с помощью цикла(-ов) заполнить его диагональные элементы единицами;\n";
        String strSourceArray = "";
        String strResultArray = "Итоговый массив: \n";
        byte length = 10;
        byte[][] sourceArray = new byte[length][length];
        for (byte x = 0; x < sourceArray.length; x++) {
            for (byte y = 0; y < sourceArray.length; y++) {
                if (x == y || y == (sourceArray.length - 1) - x) sourceArray[x][y] = 1;
                strResultArray += sourceArray[x][y] + " ";
            }
            strResultArray += "\n";
        }
        strResultArray += "\n";
        outMessageToConsole(textTask, strSourceArray, strResultArray);
    }
}
