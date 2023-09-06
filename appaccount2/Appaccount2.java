package appaccount2;
/**
 *
 * @author Nasrin Zarei.
 * This code uses Java 18.
 * This code was written on 2023-09-06.
 */

import javafx.application.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import appaccount2.EventController;
import appaccount2.FormGenerator;

public class Appaccount2 extends Application {

    // This variable is used to keep track of the number of times the `start()` method has been called.
     

    @Override
    public void start(Stage Stage) throws Exception {
       
        // This object is used to create labels, text fields, buttons, and HBoxes.
        FormGenerator formGenerator = new FormGenerator();
        //Creates a label with the text "Customer ID".
        Label customerIDLabel = formGenerator.createLabel("Customer ID");
        //Creates a label with the text "Name : "
        Label nameLabel = formGenerator.createLabel("Name : ");
        //Creates a label with the text "Adress : ".
        Label addressLabel = formGenerator.createLabel("Address : ");
        // This object is a ComboBox 
        ComboBox<Integer> customerIDComboBox = formGenerator.createComboBox();
        // This code creates two text fields, one for the name and one for the address.
        // The name text field has a preferred number of columns of 15.
        TextField nameTextField = formGenerator.createTextField();
        nameTextField.setPrefColumnCount(15);
        // The address text field has a preferred number of columns of 20.
        TextField addressTextField = formGenerator.createTextField();
        addressTextField.setPrefColumnCount(20);

  
        Button createAccountButton = formGenerator.createButton("Create");
        Button saveAccountButton = formGenerator.createButton("Save");
        Button searchAccountButton = formGenerator.createButton("Search");

        EventController createAccountButtonAction = new EventController();

        createAccountButtonAction.handleCreate(createAccountButton, customerIDComboBox, nameTextField, addressTextField);
        createAccountButtonAction.handleSave(saveAccountButton, customerIDComboBox, nameTextField, addressTextField);
        createAccountButtonAction.handleSearch(searchAccountButton,customerIDComboBox,nameTextField, addressTextField);
       

        HBox hboxId = formGenerator.createHBox(customerIDLabel, customerIDComboBox);
        hboxId.setAlignment(Pos.CENTER);
        HBox hboxName = formGenerator.createHBox(nameLabel, nameTextField);
        hboxName.setAlignment(Pos.CENTER);
        HBox hboxaddress = formGenerator.createHBox(addressLabel, addressTextField);
        hboxaddress.setAlignment(Pos.CENTER);
        HBox hboxCreadSave = formGenerator.createHBox(createAccountButton, saveAccountButton,searchAccountButton);
        hboxCreadSave.setAlignment(Pos.CENTER);

        VBox verticalbox = new VBox();
        verticalbox.getChildren().addAll(hboxId, hboxName, hboxaddress, hboxCreadSave);
        verticalbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(verticalbox, 500, 500);
        Stage.setScene(scene);
        Stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
