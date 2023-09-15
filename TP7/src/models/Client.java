package model;

public class Client {
	private int id;
	private String name;
	private String cuit;
	private String email;
	private String numberPhone;
	
	public Client(int id, String name, String cuit, String email, String numberPhone) {
		this.id = id;
		this.name = name;
		this.cuit = cuit;
		this.email = email;
		this.numberPhone = numberPhone;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCuit() {
		return cuit;
	}
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumberPhone() {
		return numberPhone;
	}
	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}
}