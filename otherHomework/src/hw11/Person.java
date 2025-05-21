package hw11;

public class Person {
    private long id;
    private String name;
    private int age;
    private Position position;
    private boolean isManager;


    public Person(long id, String name, int age, Position position) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.position = position;

    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
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
    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
        this.isManager = (position == Position.MANAGER || position == Position.DIRECTOR
                || position == Position.BRANCH_DIRECTOR || position == Position.SENIOR_MANAGER);
    }
    public boolean isManager() {
        return isManager;
    }
}
