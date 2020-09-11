package lesson07;

public class Cat {
    private String name;
    private int appetite;
    private boolean wellFed;


    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }


    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public boolean isWellFed() {
        return wellFed;
    }

    public void setWellFed(boolean wellFed) {
        this.wellFed = wellFed;
    }


    public void CatInfo() {
        System.out.println("Кот по кличке \"" + getName() + "\" за один присест может съесть " + getAppetite() + " кусков еды. Сейчас кот " + (!isWellFed() ? "голоден." : "сыт."));
    }


}
