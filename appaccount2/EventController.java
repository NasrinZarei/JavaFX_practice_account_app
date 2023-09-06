package appaccount2;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class EventController implements EventControllerInterface {

    public static final String FILE_PATH = "C:/MyJava/Demo.txt";

    int count = 0;

    HashMap<Integer, Customer> hashmap = new HashMap<>();

    @Override
    public void handleCreate(
            Button createAccountButton,
            ComboBox<Integer> customerIDComboBox,
            TextField nameTextField,
            TextField addressTextField) {
        createAccountButton.setOnAction(e -> {
            ++count;
            customerIDComboBox.getItems().add(count);
            customerIDComboBox.setValue(count);
            nameTextField.setText("");
            addressTextField.setText("");

        });

    }

    @Override
    public void handleSave(
            Button saveAccountButton,
            ComboBox<Integer> customerIDComboBox,
            TextField nameTextField,
            TextField addressTextField) {
        saveAccountButton.setOnAction(e -> {
            Customer customer = new Customer(customerIDComboBox.getValue(),
                    nameTextField.getText(),
                    addressTextField.getText());

            hashmap.put(count, customer);
            try ( ObjectOutputStream writeObject = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
                for (Customer ct : hashmap.values()) {
                    writeObject.writeObject(ct);
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });
    }

    @Override
    public void handleSearch(
            Button searchAccountButton,
            ComboBox<Integer> customerIDComboBox,
            TextField nameTextField,
            TextField addressTextField) {
        searchAccountButton.setOnAction(e -> {
            try ( ObjectInputStream readObject = new ObjectInputStream(new FileInputStream(FILE_PATH))) {

                this.readCustomersFromFile(readObject, customerIDComboBox);

            } catch (EOFException ex) {
            } catch (Exception ex) {
                System.out.println(ex);
            }
        });

        customerIDComboBox.valueProperty().addListener(e -> {
            this.fetchCustomer(customerIDComboBox, nameTextField, addressTextField);
        });

    }

    private void readCustomersFromFile(ObjectInputStream readObject, ComboBox<Integer> customerIDComboBox) throws Exception {
        Customer customerclassObject;
        while ((customerclassObject = (Customer) readObject.readObject()) != null) {
            hashmap.put(customerclassObject.getId(), customerclassObject);
            if (customerclassObject.getId() > count) {
                count = customerclassObject.getId();
            }
            customerIDComboBox.getItems().add(customerclassObject.getId());
        }

    }

    private void fetchCustomer(ComboBox<Integer> customerIDComboBox, TextField nameTextField, TextField addressTextField) {
        int item = customerIDComboBox.getValue();
        Customer customerid = hashmap.get(item);
        nameTextField.setText((customerid != null) ? customerid.getName() : "");
        addressTextField.setText((customerid != null) ? customerid.getAddress() : "");

    }

}
