package com.radhika.salestaxproblem.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.radhika.salestaxproblem.model.InputFile;

@Component
public class InputFileReader {

    private static final Logger LOGGER = Logger.getLogger(InputFileReader.class.getName());
    
    public List<String> readFile(InputFile inputFile) throws FileNotFoundException {
        try {
            List<String> buffer = new ArrayList<>();
            File file = ResourceUtils.getFile(inputFile.getResourceLocation());

            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    buffer.add(line);
                }
                scanner.close();
            }
            return buffer;
        } catch (FileNotFoundException ex) {
            LOGGER.info("file not found got exception " + ex);
            throw new FileNotFoundException("file not found got exception " + ex);
        }
    }
}
