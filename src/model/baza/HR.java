package model.baza;

public class HR extends Employee {

	public HR(String user, String pass, String name, String surname,
			Birthday bdt) {
		super(user, pass, name, surname, bdt);
		setTipi(Tipi.HR);
	}
	public String toString(){
		return "HR:"+super.getName()+" "+super.getSurname();
	}
}
