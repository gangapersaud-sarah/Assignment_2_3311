
public class Clients {
	public String UserName;
	public String FN;
	public String LN;
	public String Email;
    public String Password;
    public String Type;

	
	public Clients(String Name, String First, String Last, String email, String PW, String type) {
		super();
		this.UserName = Name;
		this.FN = First;
		this.LN = Last;
        this.Email = email;
		this.Password = PW;
        this.Type = type;
	}
	
	public Clients(){
		super();
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String name) {
		this.UserName = name;
	}

	public String getFirstName() {
		return FN;
	}

	public void setFirstName(String first) {
		this.FN = first;
	}

	public String getLastName() {
		return LN;
	}

	public void setLastName(String last) {
		this.LN = last;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}
	
	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		this.Password = password;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		this.Type = type;
	}
	
}
