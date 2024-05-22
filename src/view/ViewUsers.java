package view;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javafx.beans.InvalidationListener;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.RW.UserRW;
import model.baza.Employee;

public class ViewUsers {

	public void show(Stage st) {
		//ArrayList<Text> txt=new ArrayList<Text>();
		TableView table=new TableView();
		UserRW rw=new UserRW();
		VBox vb=new VBox();
		table.setEditable(true);
        TableColumn us = new TableColumn("Username");
        us.setMinWidth(100);
        us.setCellValueFactory(
                new PropertyValueFactory<>("username"));
        TableColumn nm = new TableColumn("Name");
        nm.setMinWidth(100);
        nm.setCellValueFactory(
                new PropertyValueFactory<>("name"));
        TableColumn snm = new TableColumn("Surname");
        snm.setMinWidth(100);
        snm.setCellValueFactory(
                new PropertyValueFactory<>("surname"));
        TableColumn bdy = new TableColumn("Birthday");
        bdy.setMinWidth(100);
        bdy.setCellValueFactory(
                new PropertyValueFactory<>("bdt"));
        table.setItems(FXCollections.observableArrayList(
        			rw.readEmp()
        		));
        table.getColumns().addAll(us,nm,snm,bdy);
        
        HBox hb =new HBox();
        Button add=new Button("Add User");
        Button del=new Button("Delete User");
        hb.getChildren().addAll(add,del);
        hb.setSpacing(10);
        vb.getChildren().addAll(table,hb);
        
		Scene sc=new Scene(vb);
		st.setScene(sc);
		st.setTitle("Users Table");
        st.setWidth(400);
        st.setHeight(500);
		st.show();
		
	}
}
