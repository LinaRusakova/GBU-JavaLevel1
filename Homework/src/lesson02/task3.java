package lesson02;
import static lesson02.lesson02.outMessageToConsole;

/*
 * Task 3.
 * Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
 * */
public class task3 {
    public static void task() {
        String textTask = "\nЗадание 3. \nЗадать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2.\n\n";
        String strSourceArray = "Исходный массив: ";
        String strResultArray = "Итоговый массив: ";
        byte[] sourceArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (byte i : sourceArray) {
            strSourceArray += sourceArray[i] + " ";
            if (sourceArray[i]<6) {
                sourceArray[i]*=2;
            }
            strResultArray += sourceArray[i] + " ";
        }
        strSourceArray+="\n";
        strResultArray+="\n";
        outMessageToConsole(textTask, strSourceArray, strResultArray);

    }
}
