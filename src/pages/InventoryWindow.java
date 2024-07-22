package pages;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class InventoryWindow extends StackPane {

    private GridPane pane;
    private List<InventoryItem> inventory;

    public InventoryWindow() {
        initComp();
        addComp();
    }

    public void initComp() {
        pane = new GridPane();
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        inventory = new ArrayList<>();
        inventory.add(new InventoryItem("Heart", 2, "file:asset/image/heart.png"));
        inventory.add(new InventoryItem("Coffee", 2, "file:asset/image/coffee.png"));
        inventory.add(new InventoryItem("Whetstone", 2, "file:asset/image/whetstone.png"));
        inventory.add(new InventoryItem("Twin Heart", 1, "file:asset/image/twinheart.png"));
        inventory.add(new InventoryItem("Smoke Bomb", 3, "file:asset/image/smokebomb.png"));
    }

    public void addComp() {
        updateInventory();
        getChildren().add(pane);
    }

    public void updateInventory() {
    	pane.setPadding(new Insets(10));
        pane.setStyle("-fx-background-color: #A0522D; -fx-border-color: black; -fx-border-width: 1;");
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().clear();
        int col = 0;
        for (InventoryItem item : inventory) {
            Label nameLabel = new Label(item.getName());
            Label quantityLabel = new Label("Quantity: " + item.getQuantity() + "X");
            Button useButton = new Button("Use Charm");
            nameLabel.setTextFill(Color.WHITE);
            quantityLabel.setTextFill(Color.WHITE);

            ImageView imageView = new ImageView(new Image(item.getImagePath()));
            imageView.setFitHeight(100);
            imageView.setFitWidth(100);

            useButton.setOnAction(e -> useCharm(item));

            imageView.setOnMouseClicked(e -> {
                Stage charmStage = new Stage();
                charmStage.setTitle(item.getName() + " Details");
                VBox charmDetails = new VBox(10, new Label("Details for " + item.getName()));
                charmDetails.setPadding(new Insets(10));
                Scene charmScene = new Scene(charmDetails, 300, 200);
                charmStage.setScene(charmScene);
                charmStage.show();
            });

            VBox charmBox = new VBox(5, nameLabel, imageView, quantityLabel, useButton);
            charmBox.setPadding(new Insets(10));
            charmBox.setStyle("-fx-border-color: black; -fx-border-width: 1px;");

            pane.add(charmBox, col++, 0);
            GridPane.setMargin(charmBox, new Insets(0, 10, 0, 10));
        }
    }

    private void useCharm(InventoryItem item) {
        int quantity = item.getQuantity();
        if (quantity > 1) {
            item.setQuantity(quantity - 1);
        } else {
            inventory.remove(item);
        }
        updateInventory();
    }

    private static class InventoryItem {
        private String name;
        private int quantity;
        private String imagePath;

        public InventoryItem(String name, int quantity, String imagePath) {
            this.name = name;
            this.quantity = quantity;
            this.imagePath = imagePath;
        }

        public String getName() {
            return name;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public String getImagePath() {
            return imagePath;
        }
    }
}

