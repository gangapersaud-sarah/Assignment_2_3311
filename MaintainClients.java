import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class MaintainUser {
	public ArrayList<Clients> clients = new ArrayList<User>();
	public String path;
	
	public void load(String path) throws Exception{
		CsvReader reader = new CsvReader(path); 
		reader.readHeaders();
		
		while(reader.readRecord()){ 
			Clients client = new Clients();
			//name,id,email,password
			client.setUserName(reader.get("username"));
			client.setFirstName(reader.get("first name"));
			client.setLastName(reader.get("last name"));
			client.setEmail(reader.get("email"));
            client.setPassword(reader.get("password"));
            client.setType(reader.get("type"));
			clients.add(client);
		}
	}
	
	public void update(String path) throws Exception{
		try {		
				CsvWriter csvOutput = new CsvWriter(new FileWriter(path, false), ',');
				//name,id,email,password
				csvOutput.write("username");
				csvOutput.write("first name");
		    	csvOutput.write("last name");
				csvOutput.write("email");
                csvOutput.write("password");
                csvOutput.write("type");
				csvOutput.endRecord();

				// else assume that the file already has the correct header line
				// write out a few records
				for(Clients u: clients){
					csvOutput.write(u.getName());
					csvOutput.write(u.getFirstName());
                    csvOutput.write(u.getLastName());
                    csvOutput.write(u.getEmail());
                    csvOutput.write(u.getPassword());
                    csvOutput.write(u.getType());
					csvOutput.endRecord();
				}
				csvOutput.close();
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
	public static void main(String [] args) throws Exception{
		String path = "Clients.csv";
		MaintainUser maintain = new MaintainUser();
	
		maintain.load(path);
		for(Clients u: maintain.clients){
			System.out.println(u.toString());
		}
		
		User newUser = new User("t4", 4, "t4@yorku.ca", "t4t4");
		maintain.clients.add(newUser);
		
		maintain.update(path);
	}
}
