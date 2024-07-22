package pages;

import java.io.File;

import javafx.event.EventHandler;
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;

public class LoginWindow extends StackPane{
	
	private Button loginbtn;
	private Label regislbl,passlbl,emaillbl;
	private TextField tfemail;
	private PasswordField tfpass;
	private ImageView iv;
	private Image img;
	private Media media, bgm;
	private MediaPlayer mp, bgmp;
	private MediaView mv, bgmv;
	private VBox vb,vb2;
	private BackgroundFill bf;
	private Background b;
	
	Integer height = 900;
	Integer width = 1500;
	
	private void initComp() {
		loginbtn = new Button("Login");
		loginbtn.setMaxWidth(450);
		
		regislbl = new Label("Click here to register");
		passlbl = new Label("Password");
		emaillbl = new Label("Username");
		
		tfemail = new TextField();
		tfpass = new PasswordField();
		
		media = new Media(new File("asset/video/video.mp4").toURI().toString());
		mp = new MediaPlayer(media);
		mv = new MediaView(mp);
		
//		bgm = new Media(new File("asset/audio/bgm.mp3").toURI().toString());
//		bgmp = new MediaPlayer(bgm);
//		bgmv = new MediaView(bgmp);
		
		mv.setFitHeight(this.height - 50);
		mv.setFitWidth(this.width);
		
		img = new Image(new File("asset/image/logo.png").toURI().toString());
		iv = new ImageView(img);
		
		vb = new VBox();
		vb2 = new VBox();
		
		bf = new BackgroundFill(Color.DARKORANGE, CornerRadii.EMPTY, Insets.EMPTY);
	}
	
	private void addComp() {
		
		vb.getChildren().addAll(emaillbl, tfemail, passlbl, tfpass, regislbl, loginbtn);
		vb.setAlignment(Pos.CENTER_LEFT);
		vb.setMaxWidth(400);
		vb.setSpacing(3);
		
		emaillbl.setTextFill(Color.WHITE);
		passlbl.setTextFill(Color.WHITE);
		regislbl.setTextFill(Color.WHITE);
		loginbtn.setTextFill(Color.WHITE);
		
		b = new Background(bf);
		loginbtn.setBackground(b);
		
		vb2.getChildren().addAll(iv,vb);
		vb2.setAlignment(Pos.CENTER);
		
//		bgmp.setAutoPlay(true);
//		mp.setCycleCount(MediaPlayer.INDEFINITE);
		mp.setAutoPlay(true);
		mp.setCycleCount(MediaPlayer.INDEFINITE);
		
		regislbl.setOnMouseClicked(e -> {
			regislbl.getScene().setRoot(new RegisterWindow());
		});
		
		loginbtn.setOnMouseClicked(new EventHandler() {

			@Override
			public void handle(javafx.event.Event event) {
				// TODO Auto-generated method stub
				LoginButtonLogic();
			}
		});
	}
	
	public void LoginButtonLogic() {
		String email = tfemail.getText();
		String pass = tfpass.getText();
		
		if(email.equals("admin@gmail.com") && pass.equals("admin")) {
			System.out.println(email);
			System.out.println(pass);
			loginbtn.getScene().setRoot(new AdminWindow());
		}else if(!email.endsWith("@gmail.com")){
			ShowAlert("Email Error", "The email must end with @gmail.com");
		}else if(pass.length() < 1) {
			ShowAlert("Password Wrong", "The Password must be filled!");
		}else {
			System.out.println(email);
			System.out.println(pass);
			loginbtn.getScene().setRoot(new ShopWindow());
		}
	}
	
	public void ShowAlert(String header, String message) {
		Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
	}
	
	public LoginWindow() {
		// TODO Auto-generated constructor stub
		initComp();
		addComp();
		getChildren().addAll(mv,vb2);
	}

}
