package Classes;

public  abstract class Staff {
    protected String name;
    protected String surname;
    private final String alert = "Attention to all patients. An alert is issued. Immediate evacuation initiated!";

    public Staff(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public final void setAlert() {
        System.out.println(alert);
    };

    public void setSurname(String surname) {
        this.surname = surname;
    }

}
