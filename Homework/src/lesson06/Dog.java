package lesson06;

public class Dog extends Animals {
    private static double DEFAULT_MAX_JUMP = 0.5;
    private static double DEFAULT_MAX_RUN = 500;
    private static double DEFAULT_MAX_SWIM = 10;
    protected String typeAnimals = "Cобака";
    private String type;

    public Dog(String name, int age, String type) {
        super(name, age);
        this.setTypeAnimals(typeAnimals);
        this.type = type;
        this.MAX_JUMP = DEFAULT_MAX_JUMP;
        this.MAX_RUN = DEFAULT_MAX_RUN;
        this.MAX_SWIM = DEFAULT_MAX_SWIM;
    }

    public Dog(String name, int age, String type, double MAX_JUMP, double MAX_RUN, double MAX_SWIM) {
       this(name, age, type);
        this.MAX_JUMP = MAX_JUMP;
        this.MAX_RUN = MAX_RUN;
        this.MAX_SWIM = MAX_SWIM;
    }

//    public Dog(String name, int age, String type) {
//        super(name, age);
//        this.setTypeAnimals(typeAnimals);
//        this.type = type;
//    }
@Override
    public void printInfo() {
        System.out.println("Собака: кличка - \"" + name + "\", возраст " + printAge(age) + ", порода - " + type + ".");
    }

    public void woof() {
        System.out.println("Собака по кличке \"" + name + "\" сказала \"Гав-Гав\"!");
    }

    //метод бега собаки
    public void run(int run) {
        runAnimals(this.getTypeAnimals(), run, MAX_RUN);
    }

    //метод прыжков собаки
    public void jump(int jump) {
        jumpAnimals(this.getTypeAnimals(), jump, MAX_JUMP);
    }

    //метод плавания собаки
    public void swim(int swim) {
        swimAnimals(this.getTypeAnimals(), swim, MAX_SWIM);
    }


}
