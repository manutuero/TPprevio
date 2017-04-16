package com.utn.dds.tpprevio.domain;
public class Country {

    public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	private final String id;
    private final String name;

    public Country(final String id, final String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
