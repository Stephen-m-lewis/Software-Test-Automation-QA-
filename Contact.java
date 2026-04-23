package contact;

// Author: Stephen Lewis

public class Contact {
	// this should stay the same once the contact is made
	private final String contactId;

	// these can be updated later if needed
	private String firstName;
	private String lastName;
	private String phone;
	private String address;

	/*
	 * All of the rules for:
	 * - contactId
	 * - firstName
	 * - lastName
	 * - phone
	 * - address
	 */
	public Contact(String contactId, String firstName, String lastName, String phone, String address) {
		if (contactId == null) {
			throw new IllegalArgumentException("Contact ID can't be null");
		}
		if (contactId.length() > 10) {
			throw new IllegalArgumentException("Contact ID can't be greater than 10 characters");
		}

		this.contactId = contactId;

		// use setters so the same validation is used here too
		setFirstName(firstName);
		setLastName(lastName);
		setPhone(phone);
		setAddress(address);
	}

	public String getContactId() {
		return contactId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	public void setFirstName(String firstName) {
		if (firstName == null) {
			throw new IllegalArgumentException("First name can't be null");
		}
		if (firstName.length() > 10) {
			throw new IllegalArgumentException("First name can't be greater than 10 characters");
		}

		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		if (lastName == null) {
			throw new IllegalArgumentException("Last name can't be null");
		}
		if (lastName.length() > 10) {
			throw new IllegalArgumentException("Last name can't be greater than 10 characters");
		}

		this.lastName = lastName;
	}

	public void setPhone(String phone) {
		if (phone == null) {
			throw new IllegalArgumentException("Phone number can't be null");
		}
		if (phone.length() != 10) {
			throw new IllegalArgumentException("Phone number must be exactly 10 digits");
		}
		if (!phone.matches("\\d{10}")) {
			throw new IllegalArgumentException("Phone number must only contain digits");
		}

		this.phone = phone;
	}

	public void setAddress(String address) {
		if (address == null) {
			throw new IllegalArgumentException("Address can't be null");
		}
		if (address.length() > 30) {
			throw new IllegalArgumentException("Address can't be greater than 30 characters");
		}

		this.address = address;
	}
}
