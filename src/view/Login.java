package view;

import java.util.Date;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.RW.Logger;
import model.RW.UserRW;
import model.baza.Employee;
import model.baza.Tipi;

public class Login {

	public void show(Stage st) {
		/**VIEW**/
		VBox vb = new VBox();
		Label us=new Label("Username");
		Label pa=new Label("Password");
		TextField user=new TextField();
		PasswordField pass=new PasswordField();
		Button login=new Button("Login");
		Button cancel=new Button("Cancel");
		HBox hb1=new HBox();
		hb1.getChildren().addAll(us,user);
		hb1.setSpacing(5);
		hb1.setAlignment(Pos.CENTER);
		HBox hb2=new HBox();
		hb2.getChildren().addAll(pa,pass);
		hb2.setSpacing(5);
		hb2.setAlignment(Pos.CENTER);
		HBox hb3=new HBox();
		hb3.getChildren().addAll(login,cancel);
		hb3.setSpacing(5);
		hb3.setAlignment(Pos.CENTER);
		vb.getChildren().addAll(hb1,hb2,hb3);
		vb.setSpacing(10);
		vb.setAlignment(Pos.CENTER);
		Scene sc=new Scene(vb,300,200);
		st.setTitle("Login");
		st.setScene(sc);
		/**ENDVIEW**/
		cancel.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent arg0) {
				System.exit(0);				
			}
		});
		login.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent arg0) {
				UserRW us=new UserRW();
				if(user.getText().isEmpty()||pass.getText().isEmpty()){
					new AlertInfo("Enter Data in Username and Password!!!");
				} else {
					Employee emp=us.checkUser(user.getText(), pass.getText());
					if(emp==null){
						new AlertInfo("User and Password do not match!!!");
					} else {
						new Logger(emp+" logged in the system at "+(new Date()).toString());
						if(emp.getTipi().equals(Tipi.HR)){
							(new HRView(emp)).show(st);
						} else if(emp.getTipi().equals(Tipi.DR)){
							(new DRView(emp)).show(st);
						} else if(emp.getTipi().equals(Tipi.DR)){
							(new NurseView(emp)).show(st);
						}
					}
				}
			}
		});
		
	}
	
}
