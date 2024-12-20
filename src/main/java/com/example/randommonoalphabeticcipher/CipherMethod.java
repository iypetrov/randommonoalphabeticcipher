package com.example.randommonoalphabeticcipher;

public class CipherMethod {
    private final IEncryptable callbackFtn;

    public CipherMethod(IEncryptable callbackFtn) {
        this.callbackFtn = callbackFtn;
    }

    public String encryptText(String plainText, String cipher) {
        return callbackFtn.encrypt(plainText, cipher);
    }

    public String decryptText(String cipherText, String cipher) {
        return callbackFtn.decrypt(cipherText, cipher);
    }
}
