package pages;

import java.io.File;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class RegisterWindow extends StackPane {
	
		private Label namelbl, emaillbl, passwordlbl, confirmpasslbl, loginherelbl;
		private TextField tfname, tfemail;
		private PasswordField tfpass, tfconfirmpass;
		private Image imglogo, imgbg;
		private ImageView imglogov,imgbgv;
		private Button registerbtn;
		private VBox vb,vb2;
		private BackgroundFill bf;
		private Background b;
		private Integer coin = 0;
		
		Integer height = 900;
		Integer width = 1500;
	
	public void initComp() {
		namelbl = new Label("Name");
		emaillbl = new Label("Email");
		passwordlbl = new Label("Password");
		confirmpasslbl = new Label("Confirm Password");
		loginherelbl = new Label("Login Here");
		
		tfname = new TextField();
		tfemail = new TextField();
		tfpass = new PasswordField();
		tfconfirmpass = new PasswordField();
		
		imglogo = new Image(new File("asset/image/logo.png").toURI().toString());
		imglogov = new ImageView(imglogo);
		
		imgbg = new Image(new File("asset/image/registerbg.jpg").toURI().toString());
		imgbgv = new ImageView(imgbg);
		
		registerbtn = new Button("Register Account");
		registerbtn.setMaxWidth(450);
		
		vb = new VBox();
		vb2 = new VBox();
		
		bf = new BackgroundFill(Color.DARKORANGE, CornerRadii.EMPTY, Insets.EMPTY);
	}
	
	public void addComp() {
		vb2.setAlignment(Pos.CENTER);
		
		vb.getChildren().addAll(namelbl, tfname, emaillbl, tfemail, passwordlbl, tfpass, confirmpasslbl, tfconfirmpass, loginherelbl, registerbtn);
		vb.setAlignment(Pos.CENTER_LEFT);
		vb.setMaxWidth(400);
		vb.setSpacing(3);
		
		namelbl.setTextFill(Color.WHITE);
		emaillbl.setTextFill(Color.WHITE);
		passwordlbl.setTextFill(Color.WHITE);
		confirmpasslbl.setTextFill(Color.WHITE);
		loginherelbl.setTextFill(Color.WHITE);
		registerbtn.setTextFill(Color.WHITE);
		
		b = new Background(bf);
		registerbtn.setBackground(b);
		
		registerbtn.setOnMouseClicked(e -> {
			LoginButtonLogic();
		});
		
		loginherelbl.setOnMouseClicked(e -> {
			loginherelbl.getScene().setRoot(new LoginWindow());
		});
		
		vb2.getChildren().addAll(imglogov, vb);
		getChildren().addAll(imgbgv,vb2);
	}
	
	public void LoginButtonLogic() {
        
		String name = tfname.getText();
		String email = tfemail.getText();
		String pass = tfpass.getText();
		String Confirm = tfconfirmpass.getText();
		
		if(name.length() < 3 && name.length() > 12) {
			ShowAlert("Name Wrong", "Name must more than 3 and not more than 12");
		}else if(!email.endsWith("@gmail.com")){
			ShowAlert("Email Error", "The email must end with @gmail.com");
		}else if(pass.length() < 8) {
			ShowAlert("Password Wrong", "The Password must be more than 8!");
		}else if(!Confirm.equals(pass)){
			ShowAlert("Password Wrong", "Please Confirm Correctly!");
		}else {
			coin = coin + 100;
			InfoAlert("Success", "Registration Successful");
			registerbtn.getScene().setRoot(new LoginWindow());
		}
	}

	public void ShowAlert(String header, String message) {
		Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
	}
	
	public void InfoAlert(String header, String message) {
		Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Nice!");
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
	}
	
	public RegisterWindow() {
		// TODO Auto-generated constructor stub
		initComp();
		addComp();
	}

}
