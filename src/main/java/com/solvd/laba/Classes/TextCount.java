package com.solvd.laba.Classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextCount {
    public static Logger textCountLogger = LogManager.getLogger();
    public static void textCount (String filename) {
        try {
            FileReader reader = new FileReader(filename);
            BufferedReader br = new BufferedReader(reader);
            int counter = 0;
            String str;
            while ((str = br.readLine()) != null) {
                str = str.trim();
                if (!str.isEmpty()) {
                    String [] words = str.split("\\s+");
                    counter += words.length;
                }
            }
            FileWriter writer = new FileWriter(filename, true);
            writer.write("\n\nThis file contains " + counter + " words");
            writer.close();
            System.out.println("Number of words in " + filename + " saved to this file");
        } catch (IOException e) {
            textCountLogger.error("Can't read the file : {}", filename, e);
        }
    }
}