package hw4;

public class Application {
    public static void main(String[] args)
    {
        User[] users = new User[10];
        users[0] = new User("Иванов", "Пётр", "Алексеевич", 1988, "Ivanov@gmail.com");
        users[1] = new User("Смирнов", "Алексей", "Михайлович", 1974, "Smirnov@gmail.com");
        users[2] = new User("Кузнецов", "Иван", "Васильевич", 1990, "Kuznetsov@gmail.com");
        users[3] = new User("Попов", "Николай", "Павлович", 1985, "Popov@gmail.com");
        users[4] = new User("Васильев", "Михаил", "Федорович", 1970, "Vasilyev@gmail.com");
        users[5] = new User("Петров", "Борис", "Николаевич", 1993, "Petrov@gmail.com");
        users[6] = new User("Соколов", "Леонид", "Ильич", 1980, "Sokolov@gmail.com");
        users[7] = new User("Михайлов", "Александр", "Николаевич", 1979, "Mikhailov@gmail.com");
        users[8] = new User("Фёдоров", "Павел", "Петрович", 1995, "Fedorov@gmail.com");
        users[9] = new User("Волков", "Владимир", "Ильич", 1982, "Volkov@gmail.com");

        for (int i = 0; i < users.length; i++) {
            int age = users[i].getAge();
            if (age > 40 && age != -1) {
                users[i].printUserInfo();
            }
        }
    }
}
