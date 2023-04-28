package Classes;

import Exceptions.InvalidSalaryInput;
import Interfaces.SalaryCalculator;

public class Doctors extends Staff implements SalaryCalculator {
    private String discipline;
    private int doctorsCategory;
    private int standardSalary;

    public Doctors(String name, String surname, String discipline, int doctorsCategory, int standardSalary) throws InvalidSalaryInput {
        super(name, surname);
        if (doctorsCategory > 6 || doctorsCategory < 1) {
            throw new InvalidSalaryInput("Doctors category could be from 1 to 6");
        }
        this.discipline = discipline;
        this.doctorsCategory = doctorsCategory;
        this.standardSalary = standardSalary;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public int getDoctorsCategory() {
        return doctorsCategory;
    }

    public void setDoctorsCategory(int doctorsCategory) {
        this.doctorsCategory = doctorsCategory;
    }

    public int getStandardSalary() {
        return standardSalary;
    }

    public void setStandardSalary(int standardSalary) {
        this.standardSalary = standardSalary;
    }

    @Override
    public void calculatePayment() {
        int payment = doctorsCategory * standardSalary * 3;
        System.out.println("salary is " + payment + "$");
    }

    @Override
    public String toString() {
        return "\nthe doctor name is " + getName() +
                " surname " + getSurname() +
                "\ndiscipline is " + discipline;
    }
}
