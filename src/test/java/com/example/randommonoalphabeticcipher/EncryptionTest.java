package com.example.randommonoalphabeticcipher;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EncryptionTest {
    Encryption encryption = new Encryption();

    @Test
    void testEncryption() {
        String plainText = "WEATHER";
        String cipher = "FEATHER";
        String cipherText = encryption.getMonoCipherMethod().encrypt(plainText, cipher);
        assertEquals("GHFKYHM", cipherText);
    }

    @Test
    void testDecrypt() {
        String cipherText = "GHFKYHM";
        String cipher = "FEATHER";
        String decryptedText = encryption.getMonoCipherMethod().decrypt(cipherText, cipher);
        assertEquals("WEATHER", decryptedText);
    }
}