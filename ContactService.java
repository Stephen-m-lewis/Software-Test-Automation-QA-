package contact;

//Author: Stephen Lewis

import java.util.HashMap;
import java.util.Map;

// Author: Stephen Lewis

public class ContactService {

	// using a map so each contact ID can only point to one contact
	private Map<String, Contact> contacts = new HashMap<String, Contact>();

	// adds a new contact if the ID isn't already being used
	public void addContact(Contact contact) {
		if (contact == null) {
			throw new IllegalArgumentException("Contact can't be null");
		}

		if (contacts.containsKey(contact.getContactId())) {
			throw new IllegalArgumentException("Contact ID already exists");
		}

		contacts.put(contact.getContactId(), contact);
	}

	// deletes by contact ID
	public void deleteContact(String contactId) {
		if (!contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("Contact ID was not found");
		}

		contacts.remove(contactId);
	}

	// updates first name for a contact
	public void updateFirstName(String contactId, String firstName) {
		Contact contact = findContact(contactId);
		contact.setFirstName(firstName);
	}

	// updates last name for a contact
	public void updateLastName(String contactId, String lastName) {
		Contact contact = findContact(contactId);
		contact.setLastName(lastName);
	}

	// updates phone number for a contact
	public void updatePhone(String contactId, String phone) {
		Contact contact = findContact(contactId);
		contact.setPhone(phone);
	}

	// updates address for a contact
	public void updateAddress(String contactId, String address) {
		Contact contact = findContact(contactId);
		contact.setAddress(address);
	}

	// helper method to find the contact first
	public Contact findContact(String contactId) {
		if (!contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("Contact ID was not found");
		}

		return contacts.get(contactId);
	}
}