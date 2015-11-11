package base;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.ArrayList;
import domain.PersonDomainModel;
import util.HibernateUtil;

public class Student_Test {
	private static PersonDomainModel Kayla;
	private static PersonDomainModel Mac;
	private ArrayList<PersonDomainModel> pers;
	private static UUID perID;
	//private static final int PersonDomainModel = 0;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		//PersonDomainModel perGet = null;		
		ArrayList<PersonDomainModel> pers = new ArrayList<PersonDomainModel>();
		PersonDomainModel perGet = new PersonDomainModel perGet ;
		perGet.setFirstName("Kayla");
		perGet.setLastName("McAdoo");
		perGet.setPostalCode(19720);
		perGet.setStreet("123 Reads way");
		perGet.setCity("New Castle");
		
		//PersonDAL.addPerson(Kayla);
	
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void deletePerson() {
		PersonDAL.deletePerson(perID);
		assertTrue(pers.size()== 0);
	}
	@Test
	public void addPerson(){
		PersonDAL.addPerson(Mac);
		PersonDAL.getPersons().add(Mac);
		assertEquals(Mac, PersonDAL.getPersons().get(1));
	}
	
}
