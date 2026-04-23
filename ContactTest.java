package contact;

// Author: Stephen Lewis

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ContactTest {

	@Test
	public void testValidContact() {
		Contact contact = new Contact("C123", "Megan", "Parker", "6035551234", "14 Elm Street, Concord");

		assertEquals("C123", contact.getContactId());
		assertEquals("Megan", contact.getFirstName());
		assertEquals("Parker", contact.getLastName());
		assertEquals("6035551234", contact.getPhone());
		assertEquals("14 Elm Street, Concord", contact.getAddress());
	}

	@Test
	public void testContactIdCannotBeNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Megan", "Parker", "6035551234", "14 Elm Street, Concord");
		});
	}

	@Test
	public void testContactIdCannotBeTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678901", "Megan", "Parker", "6035551234", "14 Elm Street, Concord");
		});
	}

	@Test
	public void testFirstNameCannotBeNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("C123", null, "Parker", "6035551234", "14 Elm Street, Concord");
		});
	}

	@Test
	public void testFirstNameCannotBeTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("C123", "Maxamillion", "Parker", "6035551234", "14 Elm Street, Concord");
		});
	}

	@Test
	public void testLastNameCannotBeNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("C123", "Megan", null, "6035551234", "14 Elm Street, Concord");
		});
	}

	@Test
	public void testLastNameCannotBeTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("C123", "Megan", "Andersonson", "6035551234", "14 Elm Street, Concord");
		});
	}

	@Test
	public void testPhoneCannotBeNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("C123", "Megan", "Parker", null, "14 Elm Street, Concord");
		});
	}

	@Test
	public void testPhoneMustBeExactlyTenDigits() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("C123", "Megan", "Parker", "603555123", "14 Elm Street, Concord");
		});
	}

	@Test
	public void testPhoneMustOnlyContainDigits() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("C123", "Megan", "Parker", "60355AB234", "14 Elm Street, Concord");
		});
	}

	@Test
	public void testAddressCannotBeNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("C123", "Megan", "Parker", "6035551234", null);
		});
	}

	@Test
	public void testAddressCannotBeTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("C123", "Megan", "Parker", "6035551234", "1234567890123456789012345678901");
		});
	}

	@Test
	public void testSetFirstName() {
		Contact contact = new Contact("C123", "Megan", "Parker", "6035551234", "14 Elm Street, Concord");
		contact.setFirstName("Emma");
		assertEquals("Emma", contact.getFirstName());
	}

	@Test
	public void testSetLastName() {
		Contact contact = new Contact("C123", "Megan", "Parker", "6035551234", "14 Elm Street, Concord");
		contact.setLastName("Stone");
		assertEquals("Stone", contact.getLastName());
	}

	@Test
	public void testSetPhone() {
		Contact contact = new Contact("C123", "Megan", "Parker", "6035551234", "14 Elm Street, Concord");
		contact.setPhone("6035557777");
		assertEquals("6035557777", contact.getPhone());
	}

	@Test
	public void testSetAddress() {
		Contact contact = new Contact("C123", "Megan", "Parker", "6035551234", "14 Elm Street, Concord");
		contact.setAddress("22 Pine Road, Nashua");
		assertEquals("22 Pine Road, Nashua", contact.getAddress());
	}

	@Test
	public void testSetFirstNameCannotBeNull() {
		Contact contact = new Contact("C123", "Megan", "Parker", "6035551234", "14 Elm Street, Concord");

		assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName(null);
		});
	}

	@Test
	public void testSetLastNameCannotBeTooLong() {
		Contact contact = new Contact("C123", "Megan", "Parker", "6035551234", "14 Elm Street, Concord");

		assertThrows(IllegalArgumentException.class, () -> {
			contact.setLastName("Andersonson");
		});
	}

	@Test
	public void testSetPhoneCannotBeInvalid() {
		Contact contact = new Contact("C123", "Megan", "Parker", "6035551234", "14 Elm Street, Concord");

		assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhone("123");
		});
	}

	@Test
	public void testSetAddressCannotBeTooLong() {
		Contact contact = new Contact("C123", "Megan", "Parker", "6035551234", "14 Elm Street, Concord");

		assertThrows(IllegalArgumentException.class, () -> {
			contact.setAddress("1234567890123456789012345678901");
		});
	}
}