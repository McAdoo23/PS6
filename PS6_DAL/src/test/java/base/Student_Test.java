package base;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;

public class Student_Test {

	private static PersonDomainModel persons;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		Date dDate = null;
		try {
			dDate = new SimpleDateFormat("yyyy-MM-dd").parse("1972-07-31");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		persons = new PersonDomainModel();
		persons.setFirstName("Kayla");
		persons.setLastName("McAdoo");
		persons.setBirthday(dDate);
		persons.setCity("New Castle");
		persons.setPostalCode(19720);
		persons.setStreet("123 Reads Way");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		PersonDomainModel per;	
		PersonDAL.deletePerson(persons.getPersonID());
		per = PersonDAL.getPerson(persons.getPersonID());
		assertNull(per);		
	}
	
	@Test
	public void AddPersonTest()
	{		
		PersonDomainModel per;		
		per = PersonDAL.getPerson(persons.getPersonID());		
		assertNull("Adding persons" ,per);		
		PersonDAL.addPerson(persons);	
		
		per = PersonDAL.getPerson(persons.getPersonID());
		
		assertNotNull("After adding",per);
	}
	
	@Test
	public void UpdatePersonTest()
	{		
		PersonDomainModel person;
		final String C_LASTNAME = "Mac";
		
		person = PersonDAL.getPerson(persons.getPersonID());		
		assertNull("before updating",person);		
		PersonDAL.addPerson(persons);	
		
		persons.setLastName(C_LASTNAME);
		PersonDAL.updatePerson(persons);
		
		person = PersonDAL.getPerson(persons.getPersonID());

		assertTrue("No update",persons.getLastName() == C_LASTNAME);
	}

	@Test
	public void DeletePersonTest()
	{		
		PersonDomainModel person;		
		person = PersonDAL.getPerson(persons.getPersonID());		
		assertNull("Empty",person);	
		
		PersonDAL.addPerson(persons);			
		persons = PersonDAL.getPerson(persons.getPersonID());
		System.out.println(persons.getPersonID() + " found");
		assertNotNull("Before delete",person);
		
		PersonDAL.deletePerson(persons.getPersonID());
		person = PersonDAL.getPerson(persons.getPersonID());		
		assertNull("after delete",person);	
		
	}
}
	
