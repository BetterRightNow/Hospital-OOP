package Classes;

import Exceptions.InvalidSalaryInput;
import Interfaces.SalaryCalculator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class Doctors extends Staff implements SalaryCalculator {
    public Logger salaryLogger = LogManager.getLogger();
    private String discipline;
    private int doctorsCategory;
    private int standardSalary;

    public Doctors(String name, String surname, String discipline, int doctorsCategory, int standardSalary) throws InvalidSalaryInput {
        super(name, surname);
        Configurator.initialize(null, "log4j2.xml");
        salaryLogger.info("Application started");
        if (doctorsCategory > 6 || doctorsCategory < 1) {
            salaryLogger.error("Invalid input of doctors category. Acceptable only from 1 to 6");
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
