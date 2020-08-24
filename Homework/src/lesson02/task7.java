package lesson02;

import static lesson02.lesson02.outMessageToConsole;

/*
 * Task 7.
 * Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
 * при этом метод должен сместить все элементы массива на n позиций.
 * Для усложнения задачи нельзя пользоваться вспомогательными массивами.
 */

public class task7 {
    public static void task() {
        String textTask = "\nЗадание 7. \nНаписать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным), \n" +
                "при этом метод должен сместить все элементы массива на n позиций. \n" +
                "Для усложнения задачи нельзя пользоваться вспомогательными массивами. \n\n";
        String strSourceArray = "Исходный массив: \n";
        String strResult = "Итоговый массив: \n";

        int n = 3;
        int[] sourceArray = {1, 2, 3, 4, 5, 6, 7, 8};
        for (int i = 0; i < sourceArray.length; i++) {
            strSourceArray += sourceArray[i] + " ";
        }
        strSourceArray += "\n";

        //передаем в метод массив и число n для смешения элементов
        moveArrayElements(sourceArray, n);

        for (int i = 0; i < sourceArray.length; i++) {
            strResult += sourceArray[i] + " ";
        }
        strResult += "\n";
        outMessageToConsole(textTask, strSourceArray, strResult);
    }

    public static void moveArrayElements(int[] array, int n) {
        //Задание не успела сделать. (((
//        if (n != 0 && n < array.length - 1) {
//            if (n > 0) { // если n>0, значит сдвиг будет вправо
//                for (int i = 0; (i + n) < array.length; i++) {
//                    array[array.length - 1 - i] = array[array.length - 1 - i - n];
//                }
//                for (int i = 0; i < n; i++) {array[i] = 0;}
//            }
//            if (n < 0) { // если n<0, значит сдвиг будет влево
//                for (int i = 0; i<array.length+n ; i++) {
//                    array[i] = array[i - n];
//                }
//                for (int i = array.length-1; i > array.length-1+n; i--) {array[i] = 0;}
//            }
//        }
        if (n != 0) {
            int tempValueStart, tempValueEnd, removeValue;
            if (n > 0) {

                for (int i = 0; i < array.length; i++) {
                       removeValue=array[n];
                    if (i+n<array.length && n-i>0) {array[i+n]=array[i];}
                    if (n-i>0) {array[i]=array[array.length-1-(n-1-i)];}
                }
            }
        }

//

    }
}

