package lesson07;

public class Plate {

    private int food = 15; // начальное количество кусков еды в тарелке
    private final int MAX_FOOD = 20; //предельное количество кусков в тарелке (больше положить нельзя)

    public Plate() {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
// кусков еды в тарелку можно добавить только при условии, что не будет превышено максимальное число кусков еды в терелке
        this.food = food;

    }

    public void info() {
        System.out.println("В тарелке лежит " + getFood() + " кусков еды.");
    }

    public boolean isFoodExist() {
        return this.getFood() > 0;
    }

    public void decreaseFood(int appetite) {
        this.food -= appetite;
    }

    public void setFullFood() {
        int addFood=MAX_FOOD-this.getFood();
        setFood(addFood);
        System.out.printf("В тарелку положили %s кусков еды. \n", addFood);
    }
}
