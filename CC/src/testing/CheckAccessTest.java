package testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import net.sourceforge.jwebunit.junit.WebTester;

public class CheckAccessTest extends TestCase{
		
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
			tester.beginAt("groupmembergui");
			tester.assertTitleEquals("Collaborative Calendar - Access Calendar");
			tester.assertFormPresent();
			//tester.assertTextPresent("Welcome to our little demonstration on the CC Webapp");
			tester.assertTextPresent("Required Information");
			tester.assertTextPresent("Enter your Name");
			tester.assertFormElementPresent("memberslist");
			tester.assertSubmitButtonPresent("Submit");
			tester.setTextField("memberslist","salwan");
			tester.submit("Submit");
			
			// Check the representation of the table for an empty result
			//puplic void 
			tester.assertTablePresent("Group");
			String[][] tableHeadings = { { "Group Name", "Member Name"} };
			tester.assertTableEquals("Group", tableHeadings);
		
		}
		

	}

