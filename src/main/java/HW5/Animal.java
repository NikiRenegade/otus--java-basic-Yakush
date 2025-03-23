package HW5;

public abstract class Animal {
    protected String name;
    protected int runSpeed;
    protected int swimSpeed;
    protected double stamina;
    private Integer swimmingStaminaCosts;

    public Animal(String name, int runSpeed, int swimSpeed, int stamina, Integer swimmingStaminaCosts) {
        this.name = name;
        this.runSpeed = runSpeed;
        this.swimSpeed = swimSpeed;
        this.stamina = stamina;
        this.swimmingStaminaCosts = swimmingStaminaCosts;
    }

    private double move(double distance, int staminaCost, int speed) {
        double fullStaminaCost = staminaCost * (distance/(double)speed);
        if (this.stamina >= fullStaminaCost) {
            this.stamina -= fullStaminaCost;
            double time = distance / speed;
            System.out.println(name + " продвинулся " + distance + " м за " + time + " с");
            return time;
        } else {
            double distanceTraveled = (speed * this.stamina / staminaCost);
            this.stamina = 0;
            double time = distanceTraveled / speed;
            System.out.println(name + " устал и продвинулся " + distanceTraveled + " м за " + time + " с");
            return -1;
        }
    }

    public double run(int distance) {
        return move(distance, 1, runSpeed);
    }

    public double swim(int distance) {
        if (swimmingStaminaCosts != null) {
            return move(distance, swimmingStaminaCosts, swimSpeed);
        }
        else {
            System.out.println(name + " не умеет плавать");
            return -1;
        }
    }
    public void getInfo() {
        System.out.println("Имя: " + name
                + "\nСкорость бега: " + runSpeed
                + "\nСкорость плаванья: " + swimSpeed
                + "\nВыносливость: " + stamina);
    }
}
