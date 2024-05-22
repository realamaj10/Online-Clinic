import model.RW.UserRW;
import model.baza.User;

public class getInfo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserRW urw=new UserRW();
		for(User x: urw.readEmp()) {
			System.out.println(x.getUsername()+":"+x.getPassword());
		}
	}

}
