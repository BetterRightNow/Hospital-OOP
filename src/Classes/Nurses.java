package Classes;

public class Nurses extends Staff{
    private int experience;

    public Nurses(String name, String surname, int experience) {
        super(name, surname);
        this.experience = experience;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString () {
        return "\nthe nurse name is " + getName() +
                " surname " + getSurname() +
                "\nshe has " + experience +
                " years of experience";
    }
}
