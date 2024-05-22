package view;

import java.util.Date;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.RW.Logger;
import model.baza.DR;
import model.baza.Employee;

public class DRView {
	private DR emp;
	
	public DRView(Employee emp) {
		this.emp = (DR) emp;
	}

	public void show(Stage st) {
		Button search=new Button("Search");
		Button patients=new Button("My Patients");
		Button	register=new Button("Register");
		Button out=new Button("Log Out");
		VBox vb=new VBox();
		vb.getChildren().addAll(search,patients,register,out);
		vb.setSpacing(10);
		vb.setAlignment(Pos.CENTER);
		Scene sc=new Scene(vb,200,400);
		st.setScene(sc);
		st.setTitle("Doctor View");
		st.show();
		
		register.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent arg0) {
				(new RegisterPatient(emp)).show(st);
			}
		});
		out.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				new Logger(emp+" Logged Out: "+(new Date()).toString());
      		  (new Login()).show(st);
			}
			
		});
	}

}
