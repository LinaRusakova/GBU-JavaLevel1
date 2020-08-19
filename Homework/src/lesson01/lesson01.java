package lesson01;
/*Author Lina Rusakova
This is my homework for lesson1 of course Java. Level1
All tasks  printed out in to console.
Thanks!
* */
import java.util.Scanner;

public class lesson01 {
    public static void main(String[] args) {

        //Task 2 of Homework for lesson01
        // Создать переменные всех пройденных типов данных, и инициализировать их значения;
        javaDataTypes();

        //Task3 of Homework for lesson01
        // Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,где a, b, c, d – входные параметры этого метода;
        decision(11, 13, 17, 19);

        //Task4 of Homework for lesson01
        // Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах от 10 до 20(включительно), если да – вернуть true, в противном случае – false;
        sumYN(10, 5);

        //Task5 of Homework for lesson01
        //Написать метод, которому в качестве параметра передается целое число,
        // метод должен напечатать в консоль положительное ли число передали, или отрицательное;
        // Замечание: ноль считаем положительным числом.
        isPositiveNumber(8);

        //Task6 of Homework for lesson01
        //Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true, если число отрицательное;
        isNegativeNumber(-5);

        //Task7 of Homework for lesson01
        //Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
        printName("Незнакомец");

        //Task8 of Homework for lesson01
        // Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль. Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
        isVisokosYear();

    }

    private static void isVisokosYear() {
        System.out.println("Задание 8.");
        System.out.println("Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль.\n (Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.");
        System.out.println("Пожлауйста, введите ниже год для проверки:");
        //создаем экземпляр объекта
        Scanner console = new Scanner(System.in);
        //используем только значнение, которае является типом int
        int inputYear = console.nextInt();
        String message = "обычным (не высокосным)"; //наиболее частый ответ )))
        //делаем проверку по указанным параметрам остаток от деления по модулю 4 и 400 должен быть равен 0, и при этом год не должен быть равен 100.
        if ((inputYear % 4 == 0 || inputYear % 400 == 0) & inputYear%100 != 0) message = "высокосным";
        System.out.println("Год " + inputYear + " является " + message + ".");
    }

    private static void printName(String str) {

        System.out.println("Задание 7.");
        System.out.println("Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен вывести в консоль сообщение «Привет, указанное_имя!»;");
        System.out.println("Методу передано имя \"" + str + "\".");
        System.out.println("Привет, " + str + "!\n");
    }

    private static void isNegativeNumber(int i) {
        boolean bool = false;
        if (i < 0) bool = true;
        System.out.println("Задание 6.");
        System.out.println("Написать метод, выводящий в консоль true, если переданное методу число является отрицательным");
        System.out.println("Так как в метод передано число " + i + " метод возвращает " + bool + ".\n");

    }

    private static void isPositiveNumber(int i) {
        String message = "положительным";
        if (i < 0) message = "отрицательным";

        System.out.println("Задание 5.");
        System.out.println("Написать метод, выводящий в консоль сообщение, является ли переданное методу число положительным или отрицательным.");
        System.out.println("Переданное в метод число " + i + " является " + message + ".\n");
    }

    public static void javaDataTypes() {
        // creating and initial numeral datatype variables:
        int i = 10;
        byte b = 10;
        short sh = 10;
        double db = 10D;
        float fl = 10F;
        long l = 10L;
        // creating and initial char datatype variable:
        char ch = 'X';
        // creating and initial boolean datatype variable:
        boolean bool = true;
        // creating and initial links datatype variable:
        String str = "\"Hello\"";

        //выводим теперь всё в консоль (для наглядности)
        String numType;
        numType = "Переменные числовых типов данных:\n";
        numType += "Переменной b типа \"byte\" присвоено значение: " + b + ".\n";
        numType += "Переменной sh типа \"short\" присвоено значение: " + sh + ".\n";
        numType += "Переменной i типа \"int\" присвоено значение: " + i + ".\n";
        numType += "Переменной db типа \"double\" присвоено значение: " + db + ".\n";
        numType += "Переменной fl типа \"float\" присвоено значение: " + fl + ".\n";
        numType += "Переменной l типа \"long\" присвоено значение: " + l + ".\n";
        String charType;
        charType = "Перменной ch литерального типа \"char\" присвоено значение: ";
        charType += "\"" + ch + "\"" + ".\n";

        String booleanType;
        booleanType = "Булевой переменной bool присвоено значение: ";
        booleanType += "\"" + bool + "\"" + ".\n";
        String linksType;
        linksType = "Переменной str ссылочного типа (\"String\") присвоено значение: ";
        linksType += str + ".\n";
        System.out.println("Задание 2.");
        System.out.println("Создать переменные всех пройденных типов данных, и инициализировать их значения.");
        System.out.println(numType + charType + booleanType + linksType);
    }

    public static int decision(int a, int b, int c, int d) {
        int result = a * (b + (c / d));
        System.out.println("Задание 3.");
        System.out.println("Написать метод, вычислющий результат a * (b + (c / d)), где метод принимает следующие параметры: a=" + a + ", b=" + b + ", c=" + c + ", d=" + d + ".");
        System.out.println("Возвращаемый методом результат равен " + result + ".\n");
        return result;
    }

    public static boolean sumYN(int x, int y) {
        int sum = x + y;
        boolean answer;
        System.out.println("Задание 4.");
        System.out.println("Написать метод, вычисляющий, находится ли сумма чисел \"x\" и \"y\" в пределах между 10 и 20");
        System.out.print("Так как сумма передаваемых методу чисел x=" + x + " и y=" + y + " равна " + sum + ", поэтому метод возвращает ");
        if (sum >= 10 & sum <= 20) {
            System.out.print(true + ".\n\n");
            answer = true;
        } else {
            System.out.print(false + ".\n\n");
            answer = false;
        }
        return answer;
    }


}
