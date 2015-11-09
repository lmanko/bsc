package com.bsc;

import com.bsc.entities.Payment;
import com.bsc.utils.FileLoader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Ladislav
 * Date: 11/9/15
 * Time: 2:43 PM
 */
public class FileLoaderTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void readFromFile() throws IOException {
            String url = "test.txt";
        ArrayList<Payment> paymentList = FileLoader.readFromFile(url);
        Assert.assertTrue(paymentList.size()!=0);
        Assert.assertTrue(paymentList.get(0).getCurrency()!=null);
        Assert.assertEquals(paymentList.size(),4);

    }
}
