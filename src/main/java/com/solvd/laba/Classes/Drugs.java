package com.solvd.laba.Classes;

import com.solvd.laba.enums.DrugType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;

public final class Drugs {
    public Logger drugListLogger = LogManager.getLogger();
    private String name;
    private String instruction;
    private DrugType drugType;
    private static int drugCount = 0;

    public Drugs(String name, String instruction, DrugType drugType) {
        this.name = name;
        this.instruction = instruction;
        this.drugType = drugType;
        drugCount++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public DrugType getDrugType() {
        return drugType;
    }

    public void setDrugType(DrugType drugType) {
        this.drugType = drugType;
    }
    public static void drugCount() {
        System.out.println("\nDrugs number is " + drugCount);
    }

    public void saveToFile(String fileName) {
        try {
            FileWriter writer = new FileWriter("src/main/resources/druglist.txt", true); // Create a new FileWriter object with the given fileName and append mode set to true
            writer.write(this.toString()); // Write the string representation of the Drugs object to the file
            writer.close(); // Close the FileWriter object
            System.out.println("Drug saved to file: " + fileName);
        } catch (IOException e) { // Catch IOException
            drugListLogger.error("Failed to save drug to file: {}", fileName, e);
            e.printStackTrace(); // Print the stack trace of the caught exception to the console
        }
    }

    @Override
    public String toString () {
        String result = "\ndrug name is " + name + "\nhow to use: " + instruction;
        switch (drugType) {
            case VITAMIN -> result += "\ntype of drug is vitamin";
            case ANTIBIOTIC -> result += "\ntype of drug is antibiotic";
            case PRESCRIPTION -> result += "\nyou need a prescription";
            case NON_PRESCRIPTION -> result += "\nit's an ordinary drug, you don't need a prescription";
            default -> result += "\ntype of drug is unknown";
        }
        return result;
    }
}
