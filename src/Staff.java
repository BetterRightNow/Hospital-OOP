public class Staff {
    private String Name;
    private String Surname;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public Staff(String name, String surname) {
        Name = name;
        Surname = surname;
    }

    public void printStafInfo () {
        System.out.println("\nname " + getName() + " surname " + getSurname());
    }
}
