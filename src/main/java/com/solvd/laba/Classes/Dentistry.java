package com.solvd.laba.Classes;

import com.solvd.laba.Exceptions.InvalidCountryException;
import com.solvd.laba.Interfaces.CheckDentistry;
import com.solvd.laba.Interfaces.DentistryFilter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Consumer;

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

    public Queue<Patients> getDentistryQueue() {
        return dentistryQueue;
    }

    public void setDentistryQueue(Queue<Patients> dentistryQueue) {
        this.dentistryQueue = dentistryQueue;
    }

    public void addPatient (Patients patient) {
        dentistryQueue.offer(patient);
    }

    public Patients removeAndReturnPatient () {
        return dentistryQueue.poll();
    }

    public void filterPatients (Consumer<Patients> krakowFilter) {
        for (Patients p: dentistryQueue) {
            krakowFilter.accept(p);
        }

    }

    public void checkQueue (CheckDentistry<Dentistry> checkDent) {
        checkDent.check(this);


        //        CheckDentistry<Dentistry> checkDent = (Dentistry dentistry) -> {
//            int freePlaces = maxPatientsInQueue - dentistryQueue.size();
//            if (dentistryQueue.size() > maxPatientsInQueue) {
//                System.out.println("The queue at dentistry " + dentistry.name + " is overcrowded");
//            } else {
//                System.out.println("The queue at dentistry " + dentistry.name + " is ok, number of free places is " + freePlaces);
//            }
//        };
//        checkDent.apply(this);
    }

    public List<Patients> filterDentQueue (DentistryFilter filteredPatient) {
        List<Patients> filteredPatients = new ArrayList<>();
        for (Patients p: dentistryQueue) {
            if (filteredPatient.filter(p)) {
                filteredPatients.add(p);
            }
        }
        return filteredPatients;
    }

    @Override
    public String toString () {
        return "\nThe name of hospice is " + getName() +
                "\nthe hospice address is" + getAddress() +
                "\nthe doctor fee is " + doctorsFee + " EUR";
    }
}
