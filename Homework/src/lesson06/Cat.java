package lesson06;

public class Cat extends Animals {

    private static double DEFAULT_MAX_JUMP = 2;
    private static double DEFAULT_MAX_RUN = 200;
    private static double DEFAULT_MAX_SWIM = 0;
    private String color;
    private static final String typeAnimals = "Кошка";

    public Cat(String name, int age, String color) {
        super(name, age);
        this.setTypeAnimals(typeAnimals);
        this.color = color;
        this.MAX_JUMP = DEFAULT_MAX_JUMP;
        this.MAX_RUN = DEFAULT_MAX_RUN;
        this.MAX_SWIM = DEFAULT_MAX_SWIM;
    }

    public Cat(String name, int age, String type, double MAX_JUMP, double MAX_RUN, double MAX_SWIM) {
        this(name, age, type);
        this.MAX_JUMP = MAX_JUMP;
        this.MAX_RUN = MAX_RUN;
        this.MAX_SWIM = MAX_SWIM;
    }


@Override
    public void printInfo() {

        System.out.println("Кошка: кличка - \"" + name + "\", возраст " + printAge(age) + ", окрас - " + color + ".");
    }


    //метод мяукания кошки
    public void meow() {
        System.out.println("Кошка по кличке \"" + name + "\" сказала \"Мяуу\"!");
    }

//    //метод бега кошки
//
//    public void run(double run) {
//        runAnimals(this.getTypeAnimals(), run, MAX_RUN);
//    }
//
//    //метод прыжков кошки
//
//    public void jump(double jump) {
//        jumpAnimals(this.getTypeAnimals(), jump, MAX_JUMP);
//    }
//
//    //метод плавания кошки
//@Override
//    public void swim(double swim) {
//        System.out.println("Кошки не умеют плавать.");
//    }
}
