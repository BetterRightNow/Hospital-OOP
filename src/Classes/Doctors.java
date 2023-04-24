package Classes;

public class Doctors extends Staff{
    private String discipline;

    public Doctors(String name, String surname, String discipline) {
        super(name, surname);
        this.discipline = discipline;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    @Override
    public String toString() {
        return "\nthe doctor name is " + getName() +
                " surname " + getSurname() +
                "\ndiscipline is " + discipline;
    }
}
