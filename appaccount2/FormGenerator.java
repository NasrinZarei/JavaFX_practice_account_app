package appaccount2;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;


class FormGenerator implements FormGeneratorInterface {
  
     // Creates a label with the given text.
    @Override
    public Label createLabel(String text) {
        Label label = new Label(text);
        return label;
    }

   // Creates a text field.
    @Override
    public TextField createTextField() {
        TextField textField = new TextField();
        return textField;
    }
   // Creates a button with the given text.
    @Override
    public Button createButton(String text) {
        Button button = new Button(text);
        return button;
    }

    // Creates an HBox with the given children.
    @Override
    public HBox createHBox(Node... children) {

        HBox hbox = new HBox();
        hbox.getChildren().addAll(children);
        return hbox;
    }

   // Creates a combo box.
    @Override
    public ComboBox<Integer> createComboBox() {
        
        ComboBox<Integer> customerIDComboBox = new ComboBox<>();
        return customerIDComboBox;
    }

}
