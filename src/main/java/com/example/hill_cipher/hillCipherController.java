package com.example.hill_cipher;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class hillCipherController implements Initializable {

    @FXML
    private TextArea plainTxt, cipherTxt;

    @FXML
    private Button decryptBtn, encryptBtn, generateBtn;

    @FXML
    private ComboBox inpuTxt_ComboBox;

    @FXML
    private TextField keyTxt;

    @FXML
    private ComboBox output_ComboBox;


    @FXML
    void Decrypt(ActionEvent event) {

    }

    @FXML
    void EncryptText(ActionEvent event) {

    }

    @FXML
    void randomizeKey(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // Set the items of the inputTxt_ComboBox ComboBox
        ObservableList<String> inputSizes = FXCollections.observableArrayList("2x2", "3x3", "4x4");
        inpuTxt_ComboBox.setItems(inputSizes);
        inpuTxt_ComboBox.setValue("2x2");

        // Set the items of the output_ComboBox ComboBox
        ObservableList<String> outputSizes = FXCollections.observableArrayList("2x2", "3x3", "4x4");
        output_ComboBox.setItems(outputSizes);
        output_ComboBox.setValue("2x2");
    }


}
