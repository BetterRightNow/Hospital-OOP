package Classes;

import enums.StaffType;

public class NonMedicalStaff extends Staff{
    private StaffType staffType;

    public NonMedicalStaff(String name, String surname, StaffType staffType) {
        super(name, surname);
        this.staffType = staffType;
    }

    public StaffType getStaffType() {
        return staffType;
    }

    public void setStaffType(StaffType staffType) {
        this.staffType = staffType;
    }

    @Override
    public String toString () {
        return "\nName" + getName() +
                " surname " + getSurname() +
                " working area " + staffType;
    }
}
