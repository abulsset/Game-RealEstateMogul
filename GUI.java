
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * @author Tess Luba, 2022
 */
public class GUI extends Application {

    // Instance Variables for View Components and Model
    private RealEstate model;
    private Button click;
    private TextField toString;
    private Label total;
    private Button buyDuplex;
    private Button buyApartmentBuilding;
    private Button buyHighRise;
    private Label costPerDuplex;
    private Label costPerApartmentBuilding;
    private Label costPerHighRise;


    public GUI() {
    }



    /**
     *
     * @param event - adds to total properties at each click
     */
    private void create(ActionEvent event) {
        model.click();
        if (((model.getProperties() >= 1000 + (model.getHighRise() * 1000) && (model.getProperties() >= 500 + (model.getApartmentBuilding() * 500)) && (model.getProperties() >= model.getDuplex() * 100)))) {
            buyHighRise.setDisable(false);
            buyApartmentBuilding.setDisable(false);
            buyDuplex.setDisable(false);
        } else if (((model.getProperties() >= 1000 + (model.getHighRise() * 1000) && (model.getProperties() >= 500 + (model.getApartmentBuilding() * 500))))) {
            buyHighRise.setDisable(false);
            buyApartmentBuilding.setDisable(false);
        } else if (((model.getProperties() >= 500 + (model.getApartmentBuilding() * 500) && (model.getProperties() >= 100 + (model.getDuplex() * 100))))) {
            buyDuplex.setDisable(false);
            buyApartmentBuilding.setDisable(false);
        } else if ((model.getProperties() >= 1000 + (model.getHighRise() * 1000))) {
            buyHighRise.setDisable(false);
        } else if (model.getProperties() >= 500 + (model.getApartmentBuilding() * 500)) {
            buyApartmentBuilding.setDisable(false);
        } else if (model.getProperties() >= 100 + (model.getDuplex() * 100)) {
            buyDuplex.setDisable(false);
        }
        total.setText("Properties Per Click: " + model.getPropertiesPerClick());
        toString.setText(model.toString());
        costPerDuplex.setText("Cost Per Duplex: " + Integer.toString(model.getCostPerDuplex()));
    }

    /**
     *
     * @param event - purchases a duplex
     */
    private void addDuplex(ActionEvent event) {
        model.setProperties(model.getProperties() - (100 + model.getDuplex() * 100));
        model.setDuplex(model.getDuplex() + 1);

        if (model.getProperties() < (100 + model.getDuplex() * 100)) {
            buyDuplex.setDisable(true);
            buyApartmentBuilding.setDisable(true);
            buyHighRise.setDisable(true);
        } else if (model.getProperties() < (500 + model.getApartmentBuilding() * 500)) {
            buyApartmentBuilding.setDisable(true);
            buyHighRise.setDisable(true);
        } else if (model.getProperties() < (1000 + model.getHighRise() * 1000)) {
            buyHighRise.setDisable(true);
        }
        total.setText("Properties Per Click: " + model.getPropertiesPerClick());
        toString.setText(model.toString());
        costPerDuplex.setText("Cost Per Duplex: " + Integer.toString(model.getCostPerDuplex()));
        costPerApartmentBuilding.setText("Cost Per Apartment Building: " + Integer.toString(model.getCostPerApartmentBuilding()));
        costPerHighRise.setText("Cost Per High Rise: " + Integer.toString(model.getCostPerHighRise()));
    }


    /**
     *
     * @param event - purchases an apartment building
     */
    private void addApartmentBuilding(ActionEvent event) {
        model.setProperties(model.getProperties() - (500 + model.getApartmentBuilding() * 500));
        model.setApartmentBuilding(model.getApartmentBuilding() + 1);

        if (model.getProperties() < (100 + model.getDuplex() * 100)) {
            buyDuplex.setDisable(true);
            buyApartmentBuilding.setDisable(true);
            buyHighRise.setDisable(true);
        } else if (model.getProperties() < (500 + model.getApartmentBuilding() * 500)) {
            buyApartmentBuilding.setDisable(true);
            buyHighRise.setDisable(true);
        } else if (model.getProperties() < (1000 + model.getHighRise() * 1000)) {
            buyHighRise.setDisable(true);
        }
        total.setText("Properties Per Click: " + model.getPropertiesPerClick());
        toString.setText(model.toString());
        costPerDuplex.setText("Cost Per Duplex: " + Integer.toString(model.getCostPerDuplex()));
        costPerApartmentBuilding.setText("Cost Per Apartment Building: " + Integer.toString(model.getCostPerApartmentBuilding()));
        costPerHighRise.setText("Cost Per High Rise: " + Integer.toString(model.getCostPerHighRise()));
    }

    /**
     *
     * @param event - purchases a high rise
     */
    private void addHighRise(ActionEvent event) {
        model.setProperties(model.getProperties() - (1000 + model.getHighRise() * 1000));
        model.setHighRise(model.getHighRise() + 1);

        if (model.getProperties() < (100 + model.getDuplex() * 100)) {
            buyDuplex.setDisable(true);
            buyApartmentBuilding.setDisable(true);
            buyHighRise.setDisable(true);
        } else if (model.getProperties() < (500 + model.getApartmentBuilding() * 500)) {
            buyApartmentBuilding.setDisable(true);
            buyHighRise.setDisable(true);
        } else if (model.getProperties() < (1000 + model.getHighRise() * 1000)) {
            buyHighRise.setDisable(true);
        }
        total.setText("Properties Per Click: " + model.getPropertiesPerClick());
        toString.setText(model.toString());
        costPerDuplex.setText("Cost Per Duplex: " + Integer.toString(model.getCostPerDuplex()));
        costPerApartmentBuilding.setText("Cost Per Apartment Building: " + Integer.toString(model.getCostPerApartmentBuilding()));
        costPerHighRise.setText("Cost Per High Rise: " + Integer.toString(model.getCostPerHighRise()));
    }


    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        Scene scene = new Scene(root, 500, 359); // set the size here
        Image img = new Image("real-estate-background-for-sale-property-concept-vector-4004023.jpg");
        BackgroundImage bImg = new BackgroundImage(img,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background bGround = new Background(bImg);
        root.setBackground(bGround);
        stage.setTitle("Real Estate Mogul");
        stage.setScene(scene);

        // Create the model
        model = new RealEstate();

        // Create the components
        click = new Button("Click Me");
        toString = new TextField(model.toString());
        total = new Label("Properties Per Click: " + Integer.toString(model.getPropertiesPerClick()));
        buyDuplex = new Button("Buy a Duplex");
        buyApartmentBuilding = new Button("Buy an Apartment Building");
        buyHighRise = new Button("Buy a High Rise");
        costPerDuplex = new Label("Cost Per Duplex: " + Integer.toString(model.getCostPerDuplex()));
        costPerApartmentBuilding = new Label("Cost Per Apartment Building: " + Integer.toString(model.getCostPerApartmentBuilding()));
        costPerHighRise = new Label("Cost Per High Rise: " + Integer.toString(model.getCostPerHighRise()));

        //Add components to the root

        root.getChildren().addAll(click, toString, total, buyDuplex, buyApartmentBuilding, buyHighRise, costPerDuplex, costPerApartmentBuilding, costPerHighRise);

        // Configure the components

        click.relocate(200, 175);
        click.setPrefSize(100, 30);
        click.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

        total.setFont(new Font("Verdana", 15));
        total.relocate(175, 225);

        toString.relocate(10, 250);
        toString.setPrefSize(475, 10);
        toString.setFont(new Font("Verdana", 11));

        buyDuplex.relocate(50, 300);
        buyDuplex.setDisable(true);
        buyDuplex.setTextFill(Paint.valueOf("#041EB0"));

        costPerDuplex.relocate(45, 325);
        costPerDuplex.setFont(Font.font("Verdana", FontPosture.ITALIC, 9));

        buyApartmentBuilding.relocate(170, 300);
        buyApartmentBuilding.setDisable(true);
        buyApartmentBuilding.setTextFill(Paint.valueOf("#041EB0"));

        costPerApartmentBuilding.relocate(173, 325);
        costPerApartmentBuilding.setFont(Font.font("Verdana", FontPosture.ITALIC, 9));

        buyHighRise.relocate(350, 300);
        buyHighRise.setDisable(true);
        buyHighRise.setTextFill(Paint.valueOf("#041EB0"));

        costPerHighRise.relocate(350, 325);
        costPerHighRise.setFont(Font.font("Verdana", FontPosture.ITALIC, 9));

        //  Add Event Handlers
        click.setOnAction(this::create);
        buyDuplex.setOnAction(this::addDuplex);
        buyApartmentBuilding.setOnAction(this::addApartmentBuilding);
        buyHighRise.setOnAction(this::addHighRise);

        // Show the stage
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
