/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cms_sio.model;

import cms_sio.model.generic.HasId;
import cms_sio.model.generic.database.DBUtils;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sgoyet
 */
public class VariableElementTest {

    public VariableElementTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        DBUtils.init();
    }

    @AfterClass
    public static void tearDownClass() throws SQLException {
        DBUtils.close();
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() throws SQLException {

    }

    @Test
    public void testDrop() {

        VariableElement variableElement = new VariableElement();
        Logger.getLogger(DataPiece.class.getName()).log(Level.INFO, "Do drop");
        DBUtils.dropTable(variableElement);
        assertFalse(DBUtils.checkTableExists(variableElement));
    }

    @Test
    public void testCreation() {

        VariableElement variableElement = new VariableElement();
        Logger.getLogger(DataPiece.class.getName()).log(Level.INFO, "Do create");
        assertTrue(DBUtils.createTable(variableElement));
        Logger.getLogger(DataPiece.class.getName()).log(Level.INFO, "Do check table");
        assertTrue(DBUtils.checkTableExists(variableElement));
    }

    @Test
    public void testUpdate() {

        VariableElement variableElement = new VariableElement();
        
        //Drop first
        DBUtils.dropTable(variableElement);
        Logger.getLogger(DataPiece.class.getName()).log(Level.INFO, "Do create");
        
         //Create table
        DBUtils.createTable(variableElement);
        Logger.getLogger(DataPiece.class.getName()).log(Level.INFO, "Do check");
        
        //Check table exist
        assertTrue(DBUtils.checkTableExists(variableElement));

        variableElement.setMultiplicity(Multiplicity._0_1.toString());
        variableElement.setConfigurationType(ConfigurationType.DataUrl.toString());
        Logger.getLogger(DataPiece.class.getName()).log(Level.INFO, "Do update");
        assertTrue(DBUtils.updateDB(variableElement));
    }

    @Test
    public void testLoad() throws Exception {

        VariableElement variableElement = new VariableElement();
        DBUtils.dropTable(variableElement);
        Logger.getLogger(DataPiece.class.getName()).log(Level.INFO, "Do create");
        DBUtils.createTable(variableElement);
        Logger.getLogger(DataPiece.class.getName()).log(Level.INFO, "Do check");
        assertTrue(DBUtils.checkTableExists(variableElement));

        variableElement.setMultiplicity(Multiplicity._0_1.toString());
        variableElement.setConfigurationType(ConfigurationType.DataUrl.toString());
        Logger.getLogger(DataPiece.class.getName()).log(Level.INFO, "Do update DB");
        
        assertTrue(DBUtils.updateDB(variableElement));

        Logger.getLogger(DataPiece.class.getName()).log(Level.INFO, "Build new Variable with id = "+variableElement.getId());
        VariableElement variableElement_uploaded = new VariableElement(variableElement.getId());
        
      
        
        Logger.getLogger(DataPiece.class.getName()).log(Level.INFO, "Check id");
        assertEquals(variableElement_uploaded.id, variableElement.id);
        Logger.getLogger(DataPiece.class.getName()).log(Level.INFO, "Check conf type");
        assertEquals(variableElement_uploaded.getConfigurationType(), variableElement.getConfigurationType());
        Logger.getLogger(DataPiece.class.getName()).log(Level.INFO, "Check multiplicity "+variableElement_uploaded.getMultiplicity()+ " / "+variableElement.getMultiplicity());
        
        
        assertEquals(variableElement_uploaded.getMultiplicity(), variableElement.getMultiplicity());

    }
    /*
     @Test
     public void testSomeMethod() {
     // TODO review the generated test code and remove the default call to fail.
       
     HasId.connect();
     VariableElement variableElement=new VariableElement(1);
     variableElement.createTable(variableElement);
     assertTrue(variableElement.checkTableExists(variableElement));
        
     variableElement.multiplicity=Multiplicity._0_1.toString();
     variableElement.configurationType=ConfigurationType.DataUrl.toString();
     variableElement.updateRow(variableElement);
        
     assertTrue(variableElement.checkTableExists(variableElement));
     assertTrue(variableElement.checkRowExists(variableElement));
        
        
     VariableElement variableElement_uploaded=new VariableElement(1);
        
     assertTrue(variableElement_uploaded.loadFromDB(variableElement_uploaded));
     assertEquals(variableElement_uploaded.id,variableElement.id);
     assertEquals(variableElement_uploaded.configurationType,variableElement.configurationType);
     assertEquals(variableElement_uploaded.multiplicity,variableElement.multiplicity);
        
     }
     */

}
