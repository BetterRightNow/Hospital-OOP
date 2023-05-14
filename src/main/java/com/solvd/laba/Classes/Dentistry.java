package com.solvd.laba.Classes;

import com.solvd.laba.Exceptions.InvalidCountryException;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

interface CheckDentistry<T> {
    void apply(T t);
}



public class Dentistry extends Hospital {
    private int doctorsFee;
    private int maxPatientsInQueue;

    private Queue<Patients> dentistryQueue;


    public Dentistry(String name, Address address, int doctorsFee, int maxPatientsInQueue) throws InvalidCountryException {
        super(name, address);
        this.doctorsFee = doctorsFee;
        dentistryQueue = new LinkedList<>();
        this.maxPatientsInQueue = maxPatientsInQueue;
    }

    public int getMaxPatientsInQueue() {
        return maxPatientsInQueue;
    }

    public void setMaxPatientsInQueue(int maxPatientsInQueue) {
        this.maxPatientsInQueue = maxPatientsInQueue;
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

    public void filterPatients () {
        Consumer<Queue<Patients>> krakowFilter = (dentistryQueue) -> {
            for (Patients p: dentistryQueue) {
                if (p.getAddress().getCity().equals("Krakow")) {
                    System.out.println(p);
                }
            }
        };
        krakowFilter.accept(dentistryQueue);
    }

    public void checkQueue () {
        CheckDentistry<Dentistry> checkDent = (Dentistry dentistry) -> {
            int freePlaces = maxPatientsInQueue - dentistryQueue.size();
            if (dentistryQueue.size() > maxPatientsInQueue) {
                System.out.println("The queue at dentistry " + dentistry.name + " is overcrowded");
            } else {
                System.out.println("The queue at dentistry " + dentistry.name + " is ok, number of free places is " + freePlaces);
            }
        };
        checkDent.apply(this);
    }

    @Override
    public String toString () {
        return "\nThe name of hospice is " + getName() +
                "\nthe hospice address is" + getAddress() +
                "\nthe doctor fee is " + doctorsFee + " EUR";
    }
}
