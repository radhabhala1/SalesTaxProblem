package com.radhika.salestaxproblem.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.radhika.salestaxproblem.model.InputFile;

/**
 *
 * @author rabhala
 */
@RunWith(MockitoJUnitRunner.class)
public class InputFileReaderTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    InputFileReader reader = new InputFileReader();
    
    private String filePath = "src/test/resources/";
    private String file1 = "input1", file2 = "invalidFile";
    
    @Test
    public void testReadFile() throws FileNotFoundException {
        InputFile inputFile = new InputFile(filePath + file1);
        List<String> lines = reader.readFile(inputFile);
        assertThat(lines, is(notNullValue()));
        assertThat(lines.size(), is(3));
    }

    @Test
    public void testReadFileInvalidResource() throws FileNotFoundException {
        InputFile inputFile = new InputFile(filePath + file2);
        thrown.expect(FileNotFoundException.class);
        reader.readFile(inputFile);
    }

}
