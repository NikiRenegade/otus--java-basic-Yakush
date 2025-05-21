package hw6;

public class Bowl {
    private int maximumAmountFood;
    private int currentAmountFood;

    public Bowl(int maximumAmountFood) {
        this.maximumAmountFood = maximumAmountFood;
        this.currentAmountFood = maximumAmountFood;
    }

    public void addFood(int amount) {
        this.currentAmountFood = this.currentAmountFood + amount > this.maximumAmountFood ?
                maximumAmountFood : this.currentAmountFood + amount;
        ;
    }

    public boolean subtractFood(int amount) {
        if (this.currentAmountFood >= amount) {
            this.currentAmountFood -= amount;
            return true;
        }
        return false;
    }

}
