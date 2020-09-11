package lesson07;

import java.util.Random;
import java.util.Scanner;


public class MainClass {
    static int i = 8; // задаем параметр максимального аппетита кота
    static int catCount = 5; // задаем количество создаваемых котов на 1 тарелку

    static Plate plate;
    static boolean nextPlay = true;
    static int stopEat = 0;//подсчитываем число сытых котов :)

    public static void main(String[] args) {
        // иницииализируем  массив котов
        Cat[] cats = new Cat[catCount];

        //"нарожаем" массив котов :-)
        bornCats(cats, i);


        //поставим перед ними 1 тарелку
        plate = new Plate();
        plate.info();

        //кормим котов
        while (nextPlay && stopEat < catCount) {
            feedingCats(cats);
        }
    }

    private static void bornCats(Cat[] cats, int i) {
        Random random = new Random();
        int j = 0;

        for (int k = 0; k < cats.length; k++) {

            cats[k] = new Cat(("Cat" + k), random.nextInt(i) + 1); // создаем объекты всех котов
            cats[k].CatInfo();
        }
        System.out.println("-------");
    }

    private static void feedingCats(Cat[] cats) {

        for (int k = 0; k < catCount; k++) {
            catEat(cats[k], plate);
            //cats[k].CatInfo();
            System.out.println("-------");
            if (cats[k].isWellFed()) {
                stopEat++;
            }
        }

    }

    private static void catEat(Cat cat, Plate plate) {

        //поесть можно, только, если в тарелке есть еда и кот не сыт
        if (plate.isFoodExist() && !cat.isWellFed()) {
            System.out.println("В тарелке есть еда (" + plate.getFood() + " кусков) и голодный кот по кличке " + cat.getName() + " подошел к тарелке.");
            if (plate.getFood() >= cat.getAppetite()) {
                System.out.println("В тарелке достаточно еды (" + plate.getFood() + " кусков), чтобы кот " + cat.getName() + " поел.");
                plate.decreaseFood(cat.getAppetite());
                cat.setWellFed(true);
                System.out.println("Кот " + cat.getName() + " съел " + cat.getAppetite() + " кусков еды.");
            } else {
                System.out.println("В тарелке есть еда (" + plate.getFood() + " кусков), но этого недостаточно, чтобы покормить голодного кота по кличке " + cat.getName() + ".");
                isAddFood(plate);
            }
        } else if (!plate.isFoodExist()) {
            System.out.println("Увы, в тарелке нет еды.");
            isAddFood(plate);
        } else if (plate.isFoodExist() && cat.isWellFed()) {
            System.out.println("В тарелке осталась еда (" + plate.getFood() + " кусков), но кот " + cat.getName() + " не голоден и есть отказался.");
        }
    }


    private static void isAddFood(Plate plate) {
        System.out.println("Хотите положить еды в тарелку и накормить голодных котов? (да / нет)");

        if (nextPlay) {
            Scanner scanner = new Scanner(System.in);
            String userStrAct = scanner.nextLine();
            if (userStrAct.toLowerCase().equals("да")) {
                nextPlay = true;
                plate.setFullFood();
                //plate.getFood();
            } else {
                nextPlay = false;
            }
        }
    }
}

