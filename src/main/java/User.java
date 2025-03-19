import java.time.LocalDate;

public class User {
    private String lastName;
    private String firstName;
    private String middleName;
    private int birthYear;
    private String email;

    public String getLastName() {
        return lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public int getBirthYear() {
        return birthYear;
    }
    public String getEmail() {
        return email;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public User(String lastName, String firstName, String middleName, int birthYear, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthYear = birthYear;
        this.email = email;
    }

    public void printUserInfo() {
        System.out.println("ФИО: " + lastName + " " + firstName + " " + middleName
                + "\nГод рождения: " + birthYear
                + "\ne-mail: "  + birthYear
                +"\n");

    }

    public int getAge() {
        return LocalDate.now().getYear() - birthYear;
    }
}
