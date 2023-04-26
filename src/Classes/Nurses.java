package Classes;

import Interfaces.SalaryCalculator;

public class Nurses extends Staff implements SalaryCalculator {
    private int experience;
    private int standardSalary;

    public Nurses(String name, String surname, int experience, int standardSalary) {
        super(name, surname);
        this.experience = experience;
        this.standardSalary = standardSalary;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getStandardSalary() {
        return standardSalary;
    }

    public void setStandardSalary(int standardSalary) {
        this.standardSalary = standardSalary;
    }

    @Override
    public void calculatePayment() {
        int payment = experience * standardSalary * 2;
        System.out.println("salary is " + payment + "$");
    }

    @Override
    public String toString () {
        return "\nthe nurse name is " + getName() +
                " surname " + getSurname() +
                "\nshe has " + experience +
                " years of experience";
    }
}
