package pages;
//
import java.io.File;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import java.util.ArrayList;
import java.util.List;

public class ShopWindow extends StackPane {

    private Label totalLbl;
    private Label coinLbl;
    private VBox cartBox;
    private VBox charmBox;
    private Button checkoutbtn;
    private Button clearCartbtn;
    private MenuBar menuBar;
    private int totalCoins = 100;
    private int totalPrice = 0;
    private List<String> cart = new ArrayList<>();

    public void initComp() {
//        totalLbl = new Label("Total: 0");
//        coinLbl = new Label("Coin: 100");
//        cartBox = new VBox(10);
//        charmBox = new VBox(10);
//        checkoutbtn = new Button("Checkout");
//        clearCartbtn = new Button("Clear Cart");
//        menuBar = new MenuBar();
//
//        Menu menu = new Menu("Menu");
//        MenuItem menuItem1 = new MenuItem("Inventory");
//        MenuItem menuLogout = new MenuItem("Logout");
//        menu.getItems().addAll(menuItem1, menuLogout);
//        menuBar.getMenus().add(menu);
    }

    public void addComp() {
//        VBox cartContainer = new VBox(10, new Label("YOUR CART"), cartBox, totalLbl, checkoutbtn, clearCartbtn);
//        VBox.setMargin(cartContainer, new Insets(10));
//        cartContainer.setStyle("-fx-background-color: #8b4513; -fx-padding: 10;");
//
//        VBox charmContainer = new VBox(10, new Label("CHARM SHOP"), charmBox, coinLbl);
//        VBox.setMargin(charmContainer, new Insets(10));
//        charmContainer.setStyle("-fx-background-color: #8b4513; -fx-padding: 10;");
//
//        HBox mainContainer = new HBox(10, cartContainer, charmContainer);
//        mainContainer.setPadding(new Insets(10));
//
//        setAlignment(Pos.TOP_CENTER);
//        getChildren().addAll(menuBar, mainContainer);
//        setPadding(new Insets(10));
//        setStyle("-fx-background-color: #d2691e;");
    }

//    private void addItems() {
//        addItem("Heart", 5, 10, new Image(new File("asset/image/heart.png").toURI().toString()));
//        addItem("Coffee", 8, 7, new Image(new File("asset/image/coffee.png").toURI().toString()));
//        addItem("Whetstone", 6, 6, new Image(new File("asset/image/whetstone.png").toURI().toString()));
//        addItem("Twin Heart", 5, 3, new Image(new File("asset/image/twinheart.png").toURI().toString()));
//        addItem("Smoke Bomb", 7, 4, new Image(new File("asset/image/smokebomb.png").toURI().toString()));
//    }
//
//    private void addItem(String name, int price, int stock, Image image) {
//        VBox itemBox = new VBox(5);
//        itemBox.setPadding(new Insets(10));
//        itemBox.setStyle("-fx-background-color: #a0522d; -fx-border-color: black; -fx-border-width: 1;");
//        Label nameLabel = new Label(name);
//        Label priceLbl = new Label("Price: " + price);
//        Label stockLbl = new Label("Stock: " + stock);
//        ImageView imageView = new ImageView(image);
//        imageView.setFitWidth(100);
//        imageView.setFitHeight(100);
//
//        itemBox.setOnDragDetected(event -> {
//            Dragboard db = itemBox.startDragAndDrop(TransferMode.ANY);
//            ClipboardContent content = new ClipboardContent();
//            content.putString(name);
//            db.setContent(content);
//            event.consume();
//        });
//
//        itemBox.getChildren().addAll(imageView, nameLabel, priceLbl, stockLbl);
//        charmBox.getChildren().add(itemBox);
//    }
//
//    private void updateCart() {
//        cartBox.getChildren().clear();
//        for (String itemName : cart) {
//            Label cartItem = new Label(itemName + " Quantity: " + countOccurrences(cart, itemName));
//            cartBox.getChildren().add(cartItem);
//        }
//    }
//
//    private int countOccurrences(List<String> list, String item) {
//        int count = 0;
//        for (String listItem : list) {
//            if (listItem.equals(item)) {
//                count++;
//            }
//        }
//        return count;
//    }
//
//    private void addEventHandlers() {
//    	checkoutbtn.setOnAction(e -> {
//            if (totalPrice > totalCoins) {
//                showAlert("Not enough coins.");
//            } else {
//                totalCoins -= totalPrice;
//                coinLbl.setText("Coin: " + totalCoins);
//                cart.clear();
//                totalPrice = 0;
//                totalLbl.setText("Total: 0");
//                updateCart();
//            }
//        });
//
//    	clearCartbtn.setOnAction(e -> {
//            cart.clear();
//            totalPrice = 0;
//            totalLbl.setText("Total: 0");
//            updateCart();
//        });
//
//        cartBox.setOnDragOver(event -> {
//            if (event.getGestureSource() != cartBox && event.getDragboard().hasString()) {
//                event.acceptTransferModes(TransferMode.ANY);
//            }
//            event.consume();
//        });
//
//        cartBox.setOnDragDropped(event -> {
//            Dragboard db = event.getDragboard();
//            boolean success = false;
//            if (db.hasString()) {
//                String name = db.getString();
//                int price = getPrice(name);
//                cart.add(name);
//                totalPrice += price;
//                totalLbl.setText("Total: " + totalPrice);
//                updateCart();
//                success = true;
//            }
//            event.setDropCompleted(success);
//            event.consume();
//        });
//    }
//
//    private int getPrice(String itemName) {
//        switch (itemName) {
//            case "Heart": return 5;
//            case "Coffee": return 8;
//            case "Whetstone": return 6;
//            case "Twin Heart": return 5;
//            case "Smoke Bomb": return 7;
//            default: return 0;
//        }
//    }
//
//    private void showAlert(String message) {
//        Alert alert = new Alert(Alert.AlertType.ERROR);
//        alert.setTitle("Error");
//        alert.setHeaderText(null);
//        alert.setContentText(message);
//        alert.showAndWait();
//    }
//
    public ShopWindow() {
        initComp();
        addComp();
//        addItems();
//        addEventHandlers();
    }
}
