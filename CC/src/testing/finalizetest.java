package testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import net.sourceforge.jwebunit.junit.WebTester;

public class finalizetest extends TestCase{
		
		private WebTester tester;

		/**
		 * Create a new WebTester object that performs the test.
		 */
		@Before
		public void prepare() {
			tester = new WebTester();
			tester.setBaseUrl("http://localhost:8080/CC/");
		}

		@Test
		public void TestCheckAccess() {

			//show calendar page element test 
			tester.beginAt("finalize");
			tester.assertTablePresent("FinalizedAppointment");
			String[][] tableHeadings = { { "name", "startTime","endTime","description","street","town","participants","deadline of participation"} };
			tester.assertTableEquals("FinalizedAppointment", tableHeadings);
		
		}
	}

