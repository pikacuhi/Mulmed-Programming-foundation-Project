package pages;


import java.io.File;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;

public class ViewCharmWindow extends StackPane {
	BorderPane root;
    Pane imgContainer;

    Label name, desc;

    Button rotateClockwise;
    Button rotateAnti;
    Button scaleP;
    Button scaleM;

    HBox containerBtn;

    double rotationCount = 0;
    double scaleCount = 1;

    public ViewCharmWindow() {
        root = new BorderPane();

        name = new Label("Name");
        desc = new Label("Description");

        rotateClockwise = new Button("->");
        rotateAnti = new Button("<-");
        scaleP = new Button("+");
        scaleM = new Button("-");

        containerBtn = new HBox();
        containerBtn.getChildren().addAll(rotateAnti, rotateClockwise, scaleP, scaleM);
        containerBtn.setAlignment(Pos.CENTER);

        imgContainer = new Pane();
        ImageView img = load("asset/image/heart.png");
        imgContainer.getChildren().add(img);

        imgContainer.widthProperty().addListener((obs, oldVal, newVal) -> {
            img.setLayoutX((newVal.doubleValue() - img.getBoundsInLocal().getWidth()) / 2);
        });
        imgContainer.heightProperty().addListener((obs, oldVal, newVal) -> {
            img.setLayoutY((newVal.doubleValue() - img.getBoundsInLocal().getHeight()) / 2);
        });

        rotateClockwise.setOnMouseClicked(e -> {
            rotateImage(img, 15);
        });
        rotateAnti.setOnMouseClicked(e -> {
            rotateImage(img, -15);
        });

        scaleP.setOnMouseClicked(e -> {
            scaleImage(img, 1.1);
        });
        scaleM.setOnMouseClicked(e -> {
            scaleImage(img, 0.9);
        });
        VBox topContainer = new VBox();
        topContainer.getChildren().addAll(name, desc);
        topContainer.setAlignment(Pos.CENTER);
        topContainer.setSpacing(10);

        root.setTop(topContainer);
        root.setCenter(imgContainer);
        root.setBottom(containerBtn);
    }

    private ImageView load(String url) {
        File file = new File(url);
        return new ImageView(file.toURI().toString());
    }

    private void scaleImage(ImageView img, double factor) {
        double newScale = scaleCount * factor;

        if (newScale > 1.5) {
            newScale = 1.5;
        } else if (newScale < 0.75) {
            newScale = 0.75;
        }

        Scale scale = new Scale(newScale, newScale);
        scale.setPivotX(img.getBoundsInLocal().getWidth() / 2);
        scale.setPivotY(img.getBoundsInLocal().getHeight() / 2);

        img.getTransforms().add(scale);
        scaleCount = newScale;
    }

    private void rotateImage(ImageView img, double degree) {
        rotationCount += degree;

        Rotate rotation = new Rotate(degree);
        rotation.setPivotX(img.getBoundsInLocal().getWidth() / 2);
        rotation.setPivotY(img.getBoundsInLocal().getHeight() / 2);

        img.getTransforms().add(rotation);
    }
}
