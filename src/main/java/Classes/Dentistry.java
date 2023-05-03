package Classes;

import Exceptions.InvalidCountryException;

import java.util.LinkedList;
import java.util.Queue;

public class Dentistry extends Hospital {
    private int doctorsFee;

    private Queue<Patients> dentistryQueue;


    public Dentistry(String name, Address address, int doctorsFee) throws InvalidCountryException {
        super(name, address);
        this.doctorsFee = doctorsFee;
        dentistryQueue = new LinkedList<>();
    }

    public int getDoctorsFee() {
        return doctorsFee;
    }

    public void setDoctorsFee(int doctorsFee) {
        this.doctorsFee = doctorsFee;
    }

    public void addPatient (Patients patient) {
        dentistryQueue.offer(patient);
    }

    public Patients removeAndReturnPatient () {
        return dentistryQueue.poll();
    }

    @Override
    public String toString () {
        return "\nThe name of hospice is " + getName() +
                "\nthe hospice address is" + getAddress() +
                "\nthe doctor fee is " + doctorsFee + " EUR";
    }
}
