package com.solvd.laba.Classes;

import com.solvd.laba.Exceptions.InvalidCountryException;
import com.solvd.laba.Interfaces.HospitalInformation;

import java.util.Deque;
import java.util.LinkedList;
import java.util.function.Consumer;

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
        return "\nBrandname of private clinic is " + brandName +
                " The name of hospital is " + getName() +
                "\nthe hospital address is" + getAddress();
    }

    public void destroy () {
        Consumer<String> hurricane = (name) -> System.out.println(name + " was destroyed with hurricane");
        hurricane.accept(getName());
    }

    public void addPatient(Patients patient) {
        privateClinicQueue.offer(patient);
    }

    public Patients nextPatient () {
        return privateClinicQueue.poll();
    }

}
