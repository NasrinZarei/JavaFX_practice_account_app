/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package appaccount2;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 *
 * @author morteza
 */
public interface EventControllerInterface {

    public void handleCreate(Button createAccountButton,
            ComboBox<Integer> customerIDComboBox,
            TextField nameTextField,
            TextField addressTextField);

    public void handleSave(Button saveAccountButton,
            ComboBox<Integer> customerIDComboBox,
            TextField nameTextField,
            TextField addressTextField);

    public void handleSearch(Button searchAccountButton,
            ComboBox<Integer> customerIDComboBox,
            TextField nameTextField,
            TextField addressTextField);
}
