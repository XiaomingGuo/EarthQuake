package test.com.company;

import com.company.database.*;
import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class DatabaseTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testGetInfo() {
		Database testHandle = new Database();
		assertEquals(testHandle.getInfo(), "Hello World!");
	}

}
