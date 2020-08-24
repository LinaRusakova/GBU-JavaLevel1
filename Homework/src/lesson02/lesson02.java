package lesson02;
/*
* Author Lina Rusakova.
* This is main package for homework for lesson2 of course Java Level1
* All tasks for lesson02  printed out in to console.
* Thanks!
 */
public class lesson02 {
    //Метод для вывода всех заданий в консоль
    public static void outMessageToConsole (String textTask, String sourceText, String resultText) {
        System.out.print(textTask);
        System.out.print(sourceText);
        System.out.print(resultText);
    }
    public static void main(String[] args) {

        //Task1
        task1.task();

        //Task2
        task2.task();

        //Task3
        task3.task();

        //Task4
        task4.task();

    //Task5
        task5.task();

        //Task6
        task6.task();
        //Task7
        task7.task();

    }
}
