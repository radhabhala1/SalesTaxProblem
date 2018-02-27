package com.radhika.salestaxproblem.service;

import com.radhika.salestaxproblem.model.InputFile;
import com.radhika.salestaxproblem.model.PurchaseItem;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author rabhala
 */
@RunWith(MockitoJUnitRunner.class)
public class ParserTest {
    
    @Spy
    Parser parser;
    
    InputFileReader reader = new InputFileReader();
    
    @Test
    public void testParserImported(){
        List<String> lines = new ArrayList<>();
        lines.add("1 imported perfume 1.0");
        PurchaseItem item = (parser.parse(lines)).get(0);
        Assert.assertEquals(true, item.isImported());
    }
    
    @Test
    public void testParserExempted(){
        List<String> lines = new ArrayList<>();
        lines.add("1 the book 1.0");
        PurchaseItem item = (parser.parse(lines)).get(0);
        Assert.assertEquals(true, item.isExempted());
    }
    
    @Test
    public void testParserValidInformation() throws FileNotFoundException{
        InputFile inputFile = new InputFile("src/test/resources/input1");
        List<String> lines = reader.readFile(inputFile);
        List<PurchaseItem> items = parser.parse(lines);
        for(PurchaseItem item: items){
            Assert.assertNotNull(item.getDescription());
			Assert.assertTrue("Qty should be not be zero", item.getQuantity() !=0);
			Assert.assertTrue("Amount should be not be zero", item.getPrice() !=0);
        }
    }
    
}
