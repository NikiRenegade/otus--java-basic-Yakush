package HW6;

public class Cat {
    private String name;
    private int appetite;
    private boolean isWellFed;
    private boolean genderFemale;

    public Cat(String name, int appetite, boolean genderFemale) {
        this.name = name;
        this.appetite = appetite;
        this.isWellFed = false;
        this.genderFemale = genderFemale;
    }

    public void eat(Bowl bowl) {
        String printResult;
        if (!this.isWellFed && bowl.subtractFood(appetite)) {
            this.isWellFed = true;
            printResult = genderFemale ? name + " поела и теперь сыта" : name + " поел и теперь сыт";
            System.out.println(printResult);
        } else {
            printResult = genderFemale ? name + " не смогла поесть." : name + " не смог поесть.";
            printResult += " В тарелке не достаточно еды";
            System.out.println(printResult);
        }
    }
}
