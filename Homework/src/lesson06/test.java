package lesson06;
/*
 * Author Lina Rusakova.
 * This is main package for homework for lesson6 of course Java Level1.
 *
 * Thanks!
 */
import java.util.Random;

public class test {
    public static void main(String[] args) {

        Animals[] animals = {
                new Cat("Мурзик", 3, "серый"),
                new Cat("Пушок", 1, "белый", 3, 300, 0),
                new Dog("Барбос", 5, "бульдог"),
                new Dog("Рекс", 2, "овчарка", 2, 1000, 100),
        };

        test(animals);

    }

    private static void test(Animals[] animals) {
        Random random = new Random();
        for (Animals animal : animals) {
            animal.printInfo();
            animal.run(random.nextInt(500));
            animal.jump(random.nextInt(2));
            animal.swim(random.nextInt(100));
            System.out.println();
        }
    }





//        Cat[] cats = {
//                new Cat("Мурзик", 3, "серый"),
//                new Cat("Пушок", 1, "белый", 3, 300, 0)
//        };
//
//        Dog[] dogs = {
//                new Dog("Барбос", 5, "бульдог"),
//                new Dog("Рекс", 2, "овчарка", 2, 1000, 100),
//        };
//
//        testCats(cats);
//        testDogs(dogs);
//
//    }
//
//    private static void testCats(Cat[] cats) {
//        Random random = new Random();
//        for (Cat animal : cats) {
//            animal.printInfo();
//            animal.run(random.nextInt(500));
//            animal.jump(random.nextInt(2));
//            animal.swim(random.nextInt(100));
//            System.out.println();
//        }
//    }
//
//    private static void testDogs(Dog[] dogs) {
//        Random random = new Random();
//        for (Dog animal : dogs) {
//            animal.printInfo();
//            animal.run(random.nextInt(500));
//            animal.jump(random.nextInt(2));
//            animal.swim(random.nextInt(100));
//            System.out.println();
//        }
//    }
}
