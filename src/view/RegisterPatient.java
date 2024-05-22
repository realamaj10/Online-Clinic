package view;

import javafx.stage.Stage;
import model.RW.PatientRW;
import model.baza.DR;

public class RegisterPatient {
	private DR emp;
	private PatientRW pat;
	public RegisterPatient(DR emp){
		this.emp=emp;
		pat=new PatientRW();
	}
	public void show(Stage st) {
		
	}

}
