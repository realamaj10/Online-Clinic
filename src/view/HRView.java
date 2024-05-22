package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.baza.Employee;

public class HRView {
	private Employee HR;
	public HRView(Employee hr){
		HR=hr;
	}
	public void show(Stage st) {
		Button view =new Button("View");
		Button reg=new Button("Register");
		Button edit=new Button("Edit");
		Button del=new Button("Delete");
		Button out=new Button("LogOut");
		VBox vb=new VBox();
		vb.getChildren().addAll(view,reg,edit,del,out);
		vb.setSpacing(5);
		vb.setAlignment(Pos.CENTER);
		
		reg.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				(new RegisterUser(HR)).show(st);
				st.show();
			}
			
		});
		out.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent arg0) {
				(new Login()).show(st);
				st.show();
			}
		});
		view.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent arg0) {
				(new ViewUsers()).show(st);
				st.show();
			}
		});
		
		Scene sc=new Scene(vb,300,150);
		st.setScene(sc);
		st.setTitle("User"+" Accounts");	
		
	}
	
}
