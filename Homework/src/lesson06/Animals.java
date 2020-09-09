package lesson06;

public class Animals {

    protected double MAX_RUN;
    protected double MAX_SWIM;
    protected double MAX_JUMP;
    protected String name;
    protected int age;
    protected String typeAnimals="животное";




    public Animals() {
        String name;
        int age;
        this.setTypeAnimals(typeAnimals);
    }

    public Animals(String name, int age) {
        this.typeAnimals=typeAnimals;
        this.name = name;
        this.age = age;
    }

    public Animals(double MAX_JUMP, double MAX_RUN, double MAX_SWIM) {
        this.MAX_JUMP = MAX_JUMP;
        this.MAX_RUN = MAX_RUN;
        this.MAX_SWIM = MAX_SWIM;
    }

    public String getTypeAnimals() {
        return typeAnimals;
    }

    public void setTypeAnimals(String typeAnimals) {
        this.typeAnimals = typeAnimals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String printAge(int age) {
        String printAge="";
        if (age>4) printAge=age+" лет";
        else if (age>1) printAge = age + " года";
        else printAge=age+" год";
        return printAge;
    }

 // метод проверки возможности пробежать/допрыгнуть/проплыть
 static boolean isRunJumpSwim(double length, double maxLength) {
        return length<=maxLength;
    }

    //метод бежать
    public void runAnimals(String typeAnimals, double run, double MAX_RUN) {
        boolean isRunJumpSwim=isRunJumpSwim(run, MAX_RUN);
        String moveType = "";
        if (isRunJumpSwim) moveType = " может пробежать ";
        else moveType = " не может пробежать ";
        printRunJumpSwim(typeAnimals, moveType,run, MAX_RUN);
    }
 //метод прыгать

public void jumpAnimals(String typeAnimals, double jump, double MAX_JUMP) {
    boolean isRunJumpSwim=isRunJumpSwim(jump, MAX_JUMP);
    String moveType = "";
    if (isRunJumpSwim) moveType = " может прыгнуть на высоту ";
    else moveType = " не может прыгнуть на высоту ";
    printRunJumpSwim(typeAnimals, moveType,jump, MAX_JUMP);
}
//    //метод плыть
public void swimAnimals(String typeAnimals, double swim, double MAX_SWIM) {
    boolean isRunJumpSwim=isRunJumpSwim(swim, MAX_SWIM);
    String moveType = "";
    if (isRunJumpSwim) moveType = " может проплыть дистанцию ";
    else moveType = " не может проплыть дистанцию ";
    printRunJumpSwim(typeAnimals, moveType, swim, MAX_SWIM);
}
    //вывод в консоль для бега/прыжков/плавания
    public void printRunJumpSwim(String typeAnimals, String moveType, double length, double max) {
        if (max!=0) {
            System.out.println(this.getTypeAnimals() + " по кличке \"" + this.getName() + "\"" + moveType + length + " метров.");
            System.out.println("Определено ограничение: " + max + " метров.\n");
        } else {
            System.out.println(this.getTypeAnimals() + " по кличке \"" + this.getName() + "\"" + "не умеет плавать.");
        }
    }

    public void printInfo() {
        System.out.println("Animal: name " + name + ", age "+ age+".");
    }

    public void run(int run) {
        runAnimals(this.getTypeAnimals(), run, MAX_RUN);
    }


    public void jump(int jump) {
        jumpAnimals(this.getTypeAnimals(), jump, MAX_JUMP);
    }


    public void swim(int swim) {
        swimAnimals(this.getTypeAnimals(), swim, MAX_SWIM);
    }

}
