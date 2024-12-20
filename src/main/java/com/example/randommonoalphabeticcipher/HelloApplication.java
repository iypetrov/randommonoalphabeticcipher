package com.example.randommonoalphabeticcipher;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        Encryption encryption = new Encryption();
        CipherMethod cipherMethod = new CipherMethod(encryption.getMonoCipherMethod());

        TextArea txtKey = new TextArea();
        txtKey.setPromptText("Enter cipher key");
        TextArea txtPlainText = new TextArea();
        txtPlainText.setPromptText("Enter plain text");
        TextArea txtCipherText = new TextArea();
        txtCipherText.setPromptText("Cipher text will appear here");

        Button btnEncrypt = new Button("Encrypt");
        btnEncrypt.setOnAction(e -> {
            String plainText = txtPlainText.getText().toUpperCase();
            String cipher = txtKey.getText().toUpperCase();
            txtCipherText.setText(cipherMethod.encryptText(plainText, cipher));
        });

        Button btnDecrypt = new Button("Decrypt");
        btnDecrypt.setOnAction(e -> {
            String cipherText = txtCipherText.getText().toUpperCase();
            String cipher = txtKey.getText().toUpperCase();
            txtPlainText.setText(cipherMethod.decryptText(cipherText, cipher));
        });

        VBox root = new VBox(10, txtKey, txtPlainText, txtCipherText, btnEncrypt, btnDecrypt);

        Scene scene = new Scene(root, 400, 300);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}