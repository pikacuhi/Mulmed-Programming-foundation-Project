package pages;

import java.io.File;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdminWindow extends StackPane {

    private Label title;
    private Label pricelbl, stocklbl, desclbl;

    private TextField price;
    private Spinner<Integer> stock;
    private TextArea description;

    private Image heartimg, coffeeimg, whetstoneimg, twinheartimg, smokebombimg;
    private ImageView heartimgv, coffeeimgv, whetstoneimgv, twinheartimgv, smokebombimgv;

    private MenuBar bar;
    private Menu menu;
    private MenuItem menuitem, menuLogout;

    private ScrollPane Sp;
    private VBox CharmContainer, Vb2;
    private BorderPane bp;

    private Stage primaryStage;

    public void initComp() {
        title = new Label("Admin Page");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        pricelbl = new Label("Price:");
        stocklbl = new Label("Stock:");
        desclbl = new Label("Description:");

        price = new TextField();
        price.setPrefWidth(50);
        stock = new Spinner<>(0, 100, 1);
        stock.setPrefWidth(80);
        description = new TextArea();
        description.setWrapText(true);
        description.setPrefHeight(50);

        heartimg = new Image(new File("asset/image/heart.png").toURI().toString());
        heartimgv = new ImageView(heartimg);
        
        coffeeimg = new Image(new File("asset/image/coffee.png").toURI().toString());
        coffeeimgv = new ImageView(coffeeimg);
        
        whetstoneimg = new Image(new File("asset/image/whetstone.png").toURI().toString());
        whetstoneimgv = new ImageView(whetstoneimg);
        
        twinheartimg = new Image(new File("asset/image/twinheart.png").toURI().toString());
        twinheartimgv = new ImageView(twinheartimg);
        
        smokebombimg = new Image(new File("asset/image/smokebomb.png").toURI().toString());
        smokebombimgv = new ImageView(smokebombimg);
        

        bar = new MenuBar();
        menu = new Menu("Menu");
        menuitem = new MenuItem("Inventory");
        menuLogout = new MenuItem("Logout");
        menu.getItems().addAll(menuitem, menuLogout);
        bar.getMenus().add(menu);

        // Event handler for logout
        menuLogout.setOnAction(e -> {
            Scene loginScene = new Scene(new LoginWindow(), 1500, 900);
            primaryStage.setScene(loginScene);
        });

        CharmContainer = new VBox(20);
        CharmContainer.setPadding(new Insets(10));
        CharmContainer.setAlignment(Pos.TOP_CENTER);
        Vb2 = new VBox();
        Sp = new ScrollPane(CharmContainer);
        Sp.setFitToWidth(true);

        bp = new BorderPane();
        bp.setPadding(new Insets(10));
        bp.setTop(bar);
        bp.setCenter(Sp);
    }

    public void addComp() {
    	Vb2.getChildren().addAll(title,CharmContainer);
        VBox itemBox1 = createItemBox("Heart", heartimgv, 5, 10, "Adds an additional hit point but lightly weakens your attack power");
        VBox itemBox2 = createItemBox("Coffee", coffeeimgv, 8, 7, "Super meter continuously fills in addition to what you earn");
        VBox itemBox3 = createItemBox("Whetstone", whetstoneimgv, 6, 6, "Short description of Whetstone's effect");
        VBox itemBox4 = createItemBox("Twin Heart", twinheartimgv, 10, 5, "Adds two additional hit points but significantly weakens your attack power");
        VBox itemBox5 = createItemBox("Smoke Bomb", smokebombimgv, 12, 4, "Makes you invincible while dashing but requires precise timing");

        CharmContainer.getChildren().addAll(itemBox1, itemBox2, itemBox3, itemBox4, itemBox5);
    }

    private VBox createItemBox(String name, ImageView imageView, int priceVal, int stockVal, String desc) {
        VBox itemBox = new VBox(10);
        itemBox.setPadding(new Insets(10));
        itemBox.setStyle("-fx-background-color: #A0522D; -fx-border-color: black; -fx-border-width: 1;");
        itemBox.setAlignment(Pos.TOP_CENTER);

        Label nameLabel = new Label(name);
        nameLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        HBox nameBox = new HBox(imageView, nameLabel);
        nameBox.setSpacing(10);
        nameBox.setAlignment(Pos.CENTER_LEFT);

        HBox priceBox = new HBox(10);
        priceBox.setAlignment(Pos.CENTER_LEFT);
        Label priceLabel = new Label("Price:");
        TextField priceField = new TextField(String.valueOf(priceVal));
        priceField.setPrefWidth(50);
        priceBox.getChildren().addAll(priceLabel, priceField);

        HBox stockBox = new HBox(10);
        stockBox.setAlignment(Pos.CENTER_LEFT);
        Label stockLabel = new Label("Stock:");
        Spinner<Integer> stockSpinner = new Spinner<>(0, 100, stockVal);
        stockSpinner.setPrefWidth(80);
        stockBox.getChildren().addAll(stockLabel, stockSpinner);

        TextArea descriptionArea = new TextArea(desc);
        descriptionArea.setWrapText(true);
        descriptionArea.setPrefHeight(50);

        Button updateButton = new Button("Update");
        updateButton.setOnAction(e -> {
            // Handle update action
        	updateLogicButton();
            System.out.println(name + " updated: Price=" + priceField.getText() + ", Stock=" + stockSpinner.getValue());
        });

        VBox.setMargin(nameBox, new Insets(0, 0, 10, 0));
        VBox.setMargin(priceBox, new Insets(0, 0, 5, 0));
        VBox.setMargin(stockBox, new Insets(0, 0, 5, 0));
        VBox.setMargin(descriptionArea, new Insets(0, 0, 5, 0));

        itemBox.getChildren().addAll(nameBox, priceBox, stockBox, desclbl, descriptionArea, updateButton);
        return itemBox;
    }
    
    private void updateLogicButton() {
    	String prices = price.getText();
    	Integer TotStock = stock.getValue();
    	String Desc = description.getText();

//        try {
//            int price = Integer.parseInt(prices);
//            if (price <= 0) {
//                ShowAlert("Error", "Price must be more than 0!");
//                return;
//            }
//        } catch (NumberFormatException ex) {
//            ShowAlert("Error", "Price must be numeric!");
//            return;
//        }
        
        if(TotStock <= 0) {
        	ShowAlert("Error", "Stock must be filled in and more than 0!");
        }else if(Desc.isEmpty()) {
        	ShowAlert("Error", "Description Must be filled in!");
        }else {
        	InfoAlert("Success", "Success Update Item");
        }
    }
    
    public void InfoAlert(String header, String message) {
		Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Nice!");
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
	}
    
    public void ShowAlert(String header, String message) {
		Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
	}
    
    public AdminWindow() {
        initComp();
        addComp();
        getChildren().add(bp);
    }
}
