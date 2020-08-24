package lesson02;


import static lesson02.lesson02.outMessageToConsole;

/*
 * Task 6.
 * Написать метод, в который передается не пустой одномерный целочисленный массив,
 * метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
 * Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
 * граница показана символами ||, эти символы в массив не входят.
 */

public class task6 {
    public static void task() {

        String textTask = "\nЗадание 6. \nНаписать метод, в который передается не пустой одномерный целочисленный массив, \n" +
                "метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны. \n" +
                "Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true, \n" +
                "граница показана символами ||, эти символы в массив не входят. \n\n";
        String strSourceArray = "Проверяемый одномерный массив: ";
        String strResult = "Обработав исходный массив, метод вернул: ";
        boolean chekTrue;
//        int[] sourceArray = {1, 5, 3, 2, 11, -4, 5, 2, 4, 8, 9, 1};
//        int[] sourceArray = {1, 1, 1, 2, 1};
        int[] sourceArray = {2, 2, 2, 1, 2, 2, 10, 1};
        for (int i = 0; i < sourceArray.length; i++) {
            strSourceArray += sourceArray[i] + " ";
        }
        chekTrue = isBalance(sourceArray);
        strSourceArray += "\n";
        strResult += chekTrue + "\n";
        outMessageToConsole(textTask, strSourceArray, strResult);
    }

    public static boolean isBalance(int[] array) {
        // задаю  дефолтное значение переменной, которое вернет метод, если не обнаружит баланса
        boolean checkTrue = false;
        //сначала вычислю сумму всех элементов переданного в метод массива
        int sumArray = 0;
        for (int i = 0; i < array.length; i++) {
            sumArray += array[i];
        }
        // теперь с помощью цикла сравню сумму элементов массива слева, с оставшейся частью элементов справа (итерация по i)
        // а также одновременно сравню сумму элементов массива справа, с оставшейся частью элементов слева (итерация по j)
        // для этого также ввела две переменные valueLeft и valueRight, которые хранят в себе сумму элементов левее/правее проверяемого элемента

        int valueLeft = 0, valueRight = 0;
        for (int i = 0, j = array.length - 1; i < array.length; i++, j--) {
            if (array[i] + valueLeft == sumArray - array[i] - valueLeft) {
                checkTrue = true;
                break;
            } else valueLeft += array[i];
            if (array[j] + valueRight == sumArray - array[j] - valueRight) {
                checkTrue = true;
                break;
            } else valueRight += array[j];
        }
        return checkTrue;
    }
}
