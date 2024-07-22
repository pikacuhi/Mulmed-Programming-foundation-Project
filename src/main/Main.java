package main;

import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import pages.InventoryWindow;
import pages.LoginWindow;

//Kelompok (Nama - NIM):
//Steven Yong - 2602136266
//Priska Dellan Lanosta - 2602141783
//Trishtan Manuel W - 2602137754
//Devin - 2602150043

public class Main extends Application{

	private Scene scene;
	private Image LogoApp;
	private ImageView LogoV;
	
	private Media bgm;
	private MediaPlayer bgmp;
	private MediaView bgmv;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		scene = new Scene(new LoginWindow(), 1500, 900);
		LogoApp = new Image(new File("asset/image/applogo.png").toURI().toString());
		LogoV = new ImageView(LogoApp);
		
		bgm = new Media(new File("asset/audio/bgm.mp3").toURI().toString());
		bgmp = new MediaPlayer(bgm);
		bgmv = new MediaView(bgmp);
		
		bgmp.setAutoPlay(true);
		
		primaryStage.setTitle("Jubilee Emporium");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
