package hw6;

public class Application {
    public static void main(String[] args) {
        Bowl bowl = new Bowl(20);

        Cat[] cats = {
                new Cat("Лисик", 5, true),
                new Cat("Смоук", 8, false),
                new Cat("Рыжуля", 6, true),
                new Cat("Мурка", 4, true),
                new Cat("Ловет", 7, true)
        };
        for (Cat cat : cats) {
            cat.eat(bowl);
        }
    }
}
