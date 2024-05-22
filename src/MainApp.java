

import java.util.Date;
import java.util.Optional;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.RW.Logger;
import view.Login;


public class MainApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage st) throws Exception {
		(new Login()).show(st);
		st.show();
		st.getIcons().add(new Image("images/agency.png"));
		st.setOnCloseRequest(new EventHandler<WindowEvent>() {
	          public void handle(WindowEvent we) {
	        	  Alert alert = new Alert(AlertType.CONFIRMATION);
	        	  alert.setTitle("Confirmation Dialog");
	        	  alert.setHeaderText("Look, a Confirmation Dialog");
	        	  alert.setContentText("Are you ok with this?");
	        	  ButtonType bt1 = new ButtonType("OK");
	        	  ButtonType bt2 = new ButtonType("LogOut");
	        	  ButtonType cancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
	        	  alert.getButtonTypes().clear();
	        	  alert.getButtonTypes().addAll(bt1,bt2,cancel);
	        	  Optional<ButtonType> result = alert.showAndWait();
	        	  if (result.get() == bt2){
	        		  new Logger("User Logged Out: "+(new Date()).toString());
	        		  (new Login()).show(st);
	        		  //st.show();
	        		  we.consume();
	        	  }else if (result.get() == bt1){
	        		  new Logger("Stage is closing: "+(new Date()).toString());
	        	  } else {
	        	      we.consume();//Window not Closing
	        	  }
	          }
	          
	      });
	}
}
