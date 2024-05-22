package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.RW.UserRW;
import model.baza.Birthday;
import model.baza.DR;
import model.baza.Employee;
import model.baza.Nurse;
import model.baza.Tipi;

public class RegisterUser {
	private Employee HR;
	public RegisterUser(Employee hr){
		HR=hr;
	}
	public void show(Stage st) {
		Label username = new Label("Username: ");
		Label password = new Label("Password: ");
		TextField userField = new TextField();
		TextField passField = new TextField();
		HBox bx1=new HBox();
		bx1.getChildren().addAll(username,userField);
		bx1.setSpacing(5);
		bx1.setAlignment(Pos.CENTER);
		HBox bx2=new HBox();
		bx2.getChildren().addAll(password,passField);
		bx2.setSpacing(5);
		bx2.setAlignment(Pos.CENTER);
		ToggleGroup pos = new ToggleGroup();
		RadioButton hr = new RadioButton("HR");
		RadioButton dr = new RadioButton("DR");
		RadioButton ass = new RadioButton("Nurse");
		hr.setToggleGroup(pos);
		dr.setToggleGroup(pos);
		ass.setToggleGroup(pos);
		HBox bx3=new HBox();
		bx3.getChildren().addAll(hr,dr,ass);
		bx3.setSpacing(5);
		bx3.setAlignment(Pos.CENTER);
		Label emer = new Label("Name: ");
		Label mbiemer = new Label("Surname: ");
		TextField name = new TextField();
		TextField surname = new TextField();
		HBox bx4=new HBox();
		bx4.getChildren().addAll(emer,name);
		bx4.setSpacing(5);
		bx4.setAlignment(Pos.CENTER);
		HBox bx5=new HBox();
		bx5.getChildren().addAll(mbiemer,surname);
		bx5.setSpacing(5);
		bx5.setAlignment(Pos.CENTER);
		DatePicker dp=new DatePicker();
		Label date=new Label("Birthday:");
		HBox bx6=new HBox();
		bx6.getChildren().addAll(date,dp);
		bx6.setSpacing(5);
		bx6.setAlignment(Pos.CENTER);
		
		Button create =new Button("create");
		Button back=new Button("Back");
		HBox bx7=new HBox();
		bx7.getChildren().addAll(create,back);
		bx7.setSpacing(5);
		bx7.setAlignment(Pos.CENTER);
		VBox vb=new VBox();
		vb.getChildren().addAll(bx1,bx2,bx3,bx4,bx5,bx6,bx7);
		vb.setSpacing(5);
		vb.setAlignment(Pos.CENTER);
		Scene sc=new Scene(vb,300,400);
		st.setScene(sc);
		st.setTitle("Register New Account");
		/***ENDVIEW**/
		back.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent arg0) {
				(new HRView(HR)).show(st);
				st.show();
			}
		});
		create.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent arg0) {
				if(userField.getText()!=null && passField.getText()!=null
						&& name.getText()!=null&&surname.getText()!=null&& 
						dp.getValue().toString()!=null && 
						(hr.isSelected()||dr.isSelected()||ass.isSelected())){
					UserRW usrw=new UserRW();
					if(hr.isSelected())
						usrw.addEmp(new model.baza.HR(userField.getText(),passField.getText(),
								name.getText(),surname.getText(),
								new Birthday(dp.getValue().toString().replace("-","/"))));
					else if (dr.isSelected())
						usrw.addEmp(new DR(userField.getText(),passField.getText(),
								name.getText(),surname.getText(),
								new Birthday(dp.getValue().toString().replace("-","/"))));
					else
						usrw.addEmp(new Nurse(userField.getText(),passField.getText(),
								name.getText(),surname.getText(),
								new Birthday(dp.getValue().toString().replace("-","/"))));
					(new HRView(HR)).show(st);
					st.show();
				}
			}
		});
	}

}
