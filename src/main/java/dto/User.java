package dto;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User 
{
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", address=" + address
				+ ", password=" + password + ", addNotes=" + addNotes + "]";
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
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<AddNotes> getAddNotes() {
		return addNotes;
	}
	public void setAddNotes(List<AddNotes> addNotes) {
		this.addNotes = addNotes;
	}
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
 private int id;
 private String name;
 private long phone;
 private String email;
 private String address;
 private String password;
 @OneToMany
 private List<AddNotes> addNotes;
 
 
 
 
	

}
