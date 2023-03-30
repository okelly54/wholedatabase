package com.qa.ims.persistence.domain;

public class Customer {

	private Long customerid;
	private String firstName;
	private String surname;

	public Customer(String firstName, String surname) {
		this.setFirstName(firstName);
		this.setSurname(surname);
	}

	public Customer(Long customerid, String firstName, String surname) {
		this.setCustomerId(customerid);
		this.setFirstName(firstName);
		this.setSurname(surname);
	}

	public Long getCustomerId() {
		return customerid;
	}

	public void setCustomerId(Long customerid) {
		this.customerid = customerid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		return "id:" + customerid + " first name:" + firstName + " surname:" + surname;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((customerid == null) ? 0 : customerid.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (getFirstName() == null) {
			if (other.getFirstName() != null)
				return false;
		}
//		} else if (!getFirstName().equals(other.getFirstName()))
//			return false;
		if (getSurname() == null) {
			if (other.getSurname() != null)
				return false;
		}
		if (customerid == null) {
			if (other.customerid != null)
				return false;
		} else if (!customerid.equals(other.customerid))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		}
		if (surname == null) {
			if (other.surname != null)
				return false;
		}
//		} else if (!surname.equals(other.surname))
//			return false;
		return true;
	}

}
