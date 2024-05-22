package model.baza;

public class DR extends Employee{

	public DR(String user, String pass, String name, String surname,
			Birthday bdt) {
		super(user, pass, name, surname, bdt);
		setTipi(Tipi.DR);
	}
	public String toString(){
		return "Doctor: "+super.getName()+" "+super.getSurname();
	}
}
