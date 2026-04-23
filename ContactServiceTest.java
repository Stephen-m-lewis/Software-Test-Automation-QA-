package contact;

//Author: Stephen Lewis

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ContactServiceTest {

	@Test
	public void testAddContact() {
		ContactService service = new ContactService();
		Contact contact = new Contact("C123", "Megan", "Parker", "6035551234", "14 Elm Street, Concord");

		service.addContact(contact);

		assertEquals("Megan", service.findContact("C123").getFirstName());
	}

	@Test
	public void testCannotAddDuplicateContactId() {
		ContactService service = new ContactService();
		Contact contact1 = new Contact("C123", "Megan", "Parker", "6035551234", "14 Elm Street, Concord");
		Contact contact2 = new Contact("C123", "Emma", "Stone", "6035558888", "22 Pine Road, Nashua");

		service.addContact(contact1);

		assertThrows(IllegalArgumentException.class, () -> {
			service.addContact(contact2);
		});
	}

	@Test
	public void testDeleteContact() {
		ContactService service = new ContactService();
		Contact contact = new Contact("C123", "Megan", "Parker", "6035551234", "14 Elm Street, Concord");

		service.addContact(contact);
		service.deleteContact("C123");

		assertThrows(IllegalArgumentException.class, () -> {
			service.findContact("C123");
		});
	}

	@Test
	public void testDeleteContactThatDoesNotExist() {
		ContactService service = new ContactService();

		assertThrows(IllegalArgumentException.class, () -> {
			service.deleteContact("BADID");
		});
	}

	@Test
	public void testUpdateFirstName() {
		ContactService service = new ContactService();
		Contact contact = new Contact("C123", "Megan", "Parker", "6035551234", "14 Elm Street, Concord");

		service.addContact(contact);
		service.updateFirstName("C123", "Emma");

		assertEquals("Emma", service.findContact("C123").getFirstName());
	}

	@Test
	public void testUpdateLastName() {
		ContactService service = new ContactService();
		Contact contact = new Contact("C123", "Megan", "Parker", "6035551234", "14 Elm Street, Concord");

		service.addContact(contact);
		service.updateLastName("C123", "Stone");

		assertEquals("Stone", service.findContact("C123").getLastName());
	}

	@Test
	public void testUpdatePhone() {
		ContactService service = new ContactService();
		Contact contact = new Contact("C123", "Megan", "Parker", "6035551234", "14 Elm Street, Concord");

		service.addContact(contact);
		service.updatePhone("C123", "6035557777");

		assertEquals("6035557777", service.findContact("C123").getPhone());
	}

	@Test
	public void testUpdateAddress() {
		ContactService service = new ContactService();
		Contact contact = new Contact("C123", "Megan", "Parker", "6035551234", "14 Elm Street, Concord");

		service.addContact(contact);
		service.updateAddress("C123", "22 Pine Road, Nashua");

		assertEquals("22 Pine Road, Nashua", service.findContact("C123").getAddress());
	}

	@Test
	public void testUpdateContactThatDoesNotExist() {
		ContactService service = new ContactService();

		assertThrows(IllegalArgumentException.class, () -> {
			service.updateFirstName("BADID", "Emma");
		});
	}

	@Test
	public void testCannotAddNullContact() {
		ContactService service = new ContactService();

		assertThrows(IllegalArgumentException.class, () -> {
			service.addContact(null);
		});
	}
}