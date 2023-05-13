package com.example.hill_cipher;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

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
    int getMatrixSize() {
        String getSize = (String) inpuTxt_ComboBox.getValue();
        int stringSize = Integer.parseInt(getSize);
        return stringSize;

    }
    double[][] getKeyMatrix(String key, double[][] keyMatrix) {
        int size = getMatrixSize();
        int k = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                keyMatrix[i][j] = (key.charAt(k)) % 65;
                k++;
            }
        }
        return keyMatrix;
    }
    Boolean checkKey(String key) {
        if(key.length() == 0) {
            return false;
        }
        try {
            double[][] keyMatrix = new double[getMatrixSize()][getMatrixSize()];
            double iMD = findInverseMod26(determinant(getKeyMatrix(key, keyMatrix)));
            return true;
        }catch(IllegalArgumentException e) {
            key = "";
            return false;
        }
    }
    String randomKey() {
        final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String key = "";
        int size = getMatrixSize() * getMatrixSize();
        while(key.length() < size) {
            char extra = upper.charAt((int) ((Math.random() * 25) + 0));
            key += extra;
        }
        return key;
    }
    @FXML
    void generateKey() {
        String key = "";
        if(getMatrixSize() <= 7) {
            while (!checkKey(key)) {
                key = randomKey();
            }
        } else {
            key = randomKey();
        }
        keyTxt.setText(key);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Set the items of the inputTxt_ComboBox ComboBox
        ObservableList<String> inputSizes = FXCollections.observableArrayList("1", "2", "3", "4");
        inpuTxt_ComboBox.setItems(inputSizes);
        inpuTxt_ComboBox.setValue("1");
    }
}
