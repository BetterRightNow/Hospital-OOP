public class Disease {
    private String name;

    public Disease(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString () {
        return "\nthe name od Disease is " + name;
    }
}
