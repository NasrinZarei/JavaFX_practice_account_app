
package appaccount2;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
// This interface defines the methods for creating form components.

public interface FormGeneratorInterface {
    // Creates a label with the given text
    public Label createLabel(String text);
    // Creates a text field.
    public TextField createTextField();
    // Creates a button with the given text.
    public Button createButton(String text);
    // Creates an HBox with the given children.
    public HBox createHBox(Node... children);
    // Creates a combo box.
    public ComboBox<Integer> createComboBox();
}
