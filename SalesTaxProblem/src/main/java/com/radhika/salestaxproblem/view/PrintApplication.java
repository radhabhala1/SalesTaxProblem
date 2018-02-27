package com.radhika.salestaxproblem.view;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.radhika.salestaxproblem.model.InputFile;
import com.radhika.salestaxproblem.service.SalesTaxHelper;

public class PrintApplication {
 
    private static final Logger LOGGER = Logger.getLogger(PrintApplication.class.getName());
    
    public static void main(String[] args) {
        
        ConfigurableApplicationContext applicationContext = getApplicationContext();
        SalesTaxHelper helper = applicationContext.getBean(SalesTaxHelper.class);
        List<InputFile> inputFiles = new ArrayList<>();
        inputFiles.add(new InputFile("classpath:data/input1"));
        inputFiles.add(new InputFile("classpath:data/input2"));
        inputFiles.add(new InputFile("classpath:data/input3"));
        
        try {
            helper.printInput(inputFiles);
        } catch (FileNotFoundException e) {
            LOGGER.info("Input Files not found: " + e);
        }

        try {
            helper.printOutput(inputFiles);
        } catch (FileNotFoundException e) {
            LOGGER.info("Files not found: " + e);
        }
    }
    
    protected static ConfigurableApplicationContext getApplicationContext() {
        return new ClassPathXmlApplicationContext("spring-config.xml");
    }
}
