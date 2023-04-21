abstract public class Patients {
    protected String patName;
    protected String patSurname;
    protected Disease disease;

    public Patients(String patName, String patSurname, Disease disease) {
        this.patName = patName;
        this.patSurname = patSurname;
        this.disease = disease;
    }

    public String getPatName() {
        return patName;
    }

    public void setPatName(String patName) {
        this.patName = patName;
    }

    public String getPatSurname() {
        return patSurname;
    }

    public void setPatSurname(String patSurname) {
        this.patSurname = patSurname;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    abstract protected void prescribeDrug(Disease disease, Drugs drugs);
}
