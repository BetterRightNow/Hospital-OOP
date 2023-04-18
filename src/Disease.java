public class Disease {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Disease(String name) {
        this.name = name;
    }
    public void printDiseaseInfo () {
        System.out.println("\nthe name od Disease is " + name);
    }
}
