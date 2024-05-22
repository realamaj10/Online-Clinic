package model.baza;

public class Nurse extends Employee {

	public Nurse(String user, String pass, String name, String surname,
			Birthday bdt) {
		super(user, pass, name, surname, bdt);
		setTipi(Tipi.Nurse);
	}
	public String toString(){
		return "Nurse: "+super.getName()+" "+super.getSurname();
	}
}
