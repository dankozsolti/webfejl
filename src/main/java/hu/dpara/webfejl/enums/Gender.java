package hu.dpara.webfejl.enums;


public enum Gender {
	/** Male. */
	M("M"),
	/** Female. */
	F("F");

	private final String name;

	private Gender(String name) {
		this.name = name;
	}

	/**
	 * @return The string representation of this element in the enumeration.
	 */
	public String getName() {
		return this.name;
	}

	public String setName() {
		return this.name;
	}
}