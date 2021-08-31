
public class Staff {

	private int staff;
	private String name;
	private String address;
	public Staff() {
		
	}
	public Staff(int staff, String name, String address) {
		super();
		this.staff = staff;
		this.name = name;
		this.address = address;
	}
	public int getStaff() {
		return staff;
	}
	public void setStaff(int staff) {
		this.staff = staff;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Staff [staff=" + staff + ", name=" + name + ", address=" + address + "]";
	}
}
