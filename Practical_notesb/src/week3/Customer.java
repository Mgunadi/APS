package week3;

public class Customer {
    private String surname;
    private String firstname;
    private int age;

    public String getSurname(){return surname;}
    public String getFirstname() {return firstname;}
    public int getAge(){return age;}

    public Customer(String firstname, String surname, int age)
    {   this.firstname = firstname;
        this.surname = surname;
        this.age = age;
    }
}
