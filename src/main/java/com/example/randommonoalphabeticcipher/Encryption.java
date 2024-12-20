package com.example.randommonoalphabeticcipher;

public class Encryption {
    private static class MonoEncryption implements IEncryptable {
        @Override
        public String encrypt(String plainText, String cipher) {
            int[] cipherPad = makeCipher(cipher);

            StringBuilder sb = new StringBuilder();
            for (char c : plainText.toCharArray()) {
                sb.append((char)cipherPad[c - 'A']);
            }

            return sb.toString();
        }

        @Override
        public String decrypt(String cipherText, String cipher) {
            int[] cipherPad = makeCipher(cipher);

            char[] reverseCipherPad = new char[26];
            for (int i = 0; i < cipherPad.length; i++) {
                reverseCipherPad[cipherPad[i] - 'A'] = (char) ('A' + i);
            }

            StringBuilder sb = new StringBuilder();
            for (char c : cipherText.toCharArray()) {
                sb.append(reverseCipherPad[c - 'A']);
            }

            return sb.toString();
        }

        private int[] getCounts(String cipher) {
            int[] counts = new int[26];

            for (int i = 0; i < 26; i++) {
                counts[i] = 0;
            }
            for (char c : cipher.toCharArray()) {
                counts[c - 'A']++;
            }

            return counts;
        }

        private int[] makeCipher(String cipher) {
            int[] cipherPad = new int[26];
            boolean[] visited = new boolean[26];
            int index = 0;

            for (char c : cipher.toCharArray()) {
                if (!visited[c - 'A']) {
                    cipherPad[index++] = c;
                    visited[c - 'A'] = true;
                }
            }

            for (int i = 25; i >= 0; i--) {
                if (!visited[i]) {
                    cipherPad[index++] = 'A' + i;
                }
            }

            return cipherPad;
        }
    }

    public IEncryptable getMonoCipherMethod() {
        return new MonoEncryption();
    }
}
