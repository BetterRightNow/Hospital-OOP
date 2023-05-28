package com.solvd.laba.classes;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Set;

public class UniqueWordsCount {
    public static Logger logger = LogManager.getLogger();
    public static void countUniqueWords (String filename) throws IOException {
        try {
            File file = new File(filename);
            String str = FileUtils.readFileToString(file, Charset.forName("UTF-8"));
            String [] words = StringUtils.split(str, " \t\n\r\f.,:;?!\"'()[]{}+-*/=<>|");
            Set <String> uniqueWords = new HashSet<>();
            for (String word: words) {
                uniqueWords.add(word);
            }
            String result = String.join(", ", uniqueWords);
            FileUtils.writeStringToFile(file, "\n\nthis file contains such unique words: " + result +
                    "\nthe number of unique words is " + uniqueWords.size(), true);
            System.out.println("Unique words from " + filename + " were calculated and saved to this file");
        } catch (IOException e) {
            logger.error("Can't read the file: {}", filename, e);
            throw e;
        }
    }
}
