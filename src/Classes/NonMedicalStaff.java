package Classes;

import Interfaces.IPayable;
import enums.StaffType;

public class NonMedicalStaff extends Staff implements IPayable {
    private StaffType staffType;
    private int staffCategory;
    private int standardSalary;

    public NonMedicalStaff(String name, String surname, StaffType staffType, int staffCategory, int standardSalary) {
        super(name, surname);
        this.staffType = staffType;
        this.staffCategory = staffCategory;
        this.standardSalary = standardSalary;
    }

    public StaffType getStaffType() {
        return staffType;
    }

    public void setStaffType(StaffType staffType) {
        this.staffType = staffType;
    }

    public int getStaffCategory() {
        return staffCategory;
    }

    public void setStaffCategory(int staffCategory) {
        this.staffCategory = staffCategory;
    }

    public int getStandardSalary() {
        return standardSalary;
    }

    public void setStandardSalary(int standardSalary) {
        this.standardSalary = standardSalary;
    }

    @Override
    public void calculatePayment() {
        int payment = standardSalary * staffCategory;
        System.out.println("Salary is " + payment + "$");
    }

    @Override
    public String toString () {
        return "\nName" + getName() +
                " surname " + getSurname() +
                " working area " + staffType;
    }
}
