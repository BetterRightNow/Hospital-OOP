package com.solvd.laba.classes;

import com.solvd.laba.exceptions.InvalidCountryException;
import com.solvd.laba.interfaces.CheckOldness;
import com.solvd.laba.interfaces.HospitalInformation;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class PrivateClinic extends Hospital implements HospitalInformation {
    private String brandName;
    private Deque<Patients> privateClinicQueue;

    public PrivateClinic(String name, Address address, String brandName) throws InvalidCountryException {
        super(name, address);
        this.brandName = brandName;
        privateClinicQueue = new LinkedList<>();
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Deque<Patients> getPrivateClinicQueue() {
        return privateClinicQueue;
    }

    public void setPrivateClinicQueue(Deque<Patients> privateClinicQueue) {
        this.privateClinicQueue = privateClinicQueue;
    }

    @Override
    public Address hospAddress() {
        return address;
    }

    @Override
    public String hospName() {
        return name;
    }

    @Override
    public String toString () {
        return "\nBrand name of private clinic is " + brandName +
                " The name of hospital is " + getName() +
                "\nthe hospital address is" + getAddress();
    }

    public void destroy () {
        Consumer<String> hurricane = (name) -> System.out.println(name + " was destroyed with hurricane");
        hurricane.accept(getName());
    }

    public <C> void checkOldPatients(CheckOldness<PrivateClinic, Patients, C> checkIfOld, C collection) {
        checkIfOld.checkOld(this, privateClinicQueue, collection);
    }

    public void addPatient(Patients patient) {
        privateClinicQueue.offer(patient);
    }

    public Patients nextPatient () {
        return privateClinicQueue.poll();
    }

    public void choosePatients (Function<Deque<Patients>, List<Patients>> choosePatientLambda) {
        List<Patients> chosenPatients = choosePatientLambda.apply(privateClinicQueue);
        System.out.println(chosenPatients);
        }
}
