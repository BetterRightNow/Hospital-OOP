package com.solvd.laba.Classes;

import com.solvd.laba.Interfaces.SalaryCalculator;

import java.util.function.UnaryOperator;

interface NurseRetirement<T, R> {
    R apply(T t);
}

public class Nurses extends Staff implements SalaryCalculator {
    private int experience;
    private int standardSalary;
    private UnaryOperator<Integer> yearSalaryLambda;

    public Nurses(String name, String surname, int experience, int standardSalary) {
        super(name, surname);
        this.experience = experience;
        this.standardSalary = standardSalary;
        yearSalaryLambda = (exp) -> 12 * standardSalary * exp * 2;
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

    public int calculateYearlySalary() {
        return yearSalaryLambda.apply(experience);
    }
    public int nurseRetirement () {
        NurseRetirement<Nurses, Integer> nurseRet = (Nurses nurse) -> {
            int result = 40 - experience;
            return result;
        };
        return nurseRet.apply(this);
    }

    @Override
    public String toString () {
        return "\nthe nurse name is " + getName() +
                " surname " + getSurname() +
                "\nshe has " + experience +
                " years of experience";
    }
}
