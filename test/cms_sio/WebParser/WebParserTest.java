/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cms_sio.WebParser;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author goyet.stephane
 */
public class WebParserTest {
    
    public WebParserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of WebParser method, of class WebParser.
     */
    @Test
    public void testWebParser() throws IOException {
        System.out.println("WebParser");
        WebParser instance = new WebParser();
        instance.WebParser();
        
         URL url=new URL("http://www.creaduweb.fr/");
        String host=url.getHost();
        String fileName="home";
       
        assertTrue(Files.exists(new File(host+"/"+fileName).toPath()));
       
         
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of CreateDirectoryFromURL method, of class WebParser.
     */
    @Test
    public void testCreateDirectoryFromURL() throws MalformedURLException {
        System.out.println("CreateDirectoryFromURL");
        URL url1 = new URL("https://github.com/alvinje/CMS_SIO/");
        WebParser instance = new WebParser();
        String expResult = "./github.com/alvinje/CMS_SIO";
        String result = instance.CreateDirectoryFromURL(url1);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of FillDataBaseWithHTMLPage method, of class WebParser.
     */
    @Test
    public void testFillDataBaseWithHTMLPage() {
        System.out.println("FillDataBaseWithHTMLPage");
        String HTMLPage = "";
        WebParser instance = new WebParser();
        instance.FillDataBaseWithHTMLPage(HTMLPage);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
