package hw5;

public class Application {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Cat lisik = new Cat("Lisik", 2, 1 );
        lisik.run(5);
        Dog smoke = new Dog("Smoke", 2, 6, 15);
        smoke.swim(180);
        smoke.getInfo();
    }
}
