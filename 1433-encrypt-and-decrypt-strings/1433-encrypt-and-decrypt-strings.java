import java.util.*;

class Encrypter {
    private Map<Character, String> encryptMap;
    private Map<String, Integer> decryptCount;

    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        encryptMap = new HashMap<>();
        decryptCount = new HashMap<>();

        for (int i = 0; i < keys.length; i++) {
            encryptMap.put(keys[i], values[i]);
        }

        for (String word : dictionary) {
            String encryptedWord = encrypt(word);
            decryptCount.put(encryptedWord, decryptCount.getOrDefault(encryptedWord, 0) + 1);
        }
    }

    public String encrypt(String word) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (!encryptMap.containsKey(c)) return "";
            encrypted.append(encryptMap.get(c));
        }
        return encrypted.toString();
    }

    public int decrypt(String encryptedWord) {
        return decryptCount.getOrDefault(encryptedWord, 0);
    }

    public static void main(String[] args) {
        char[] keys = {'a', 'b', 'c', 'd'};
        String[] values = {"aa", "bb", "cc", "dd"};
        String[] dictionary = {"abcd", "acbd", "bacd"};

        Encrypter encrypter = new Encrypter(keys, values, dictionary);

        System.out.println(encrypter.encrypt("abcd")); // Output: "aabbccdd"
        System.out.println(encrypter.decrypt("aabbccdd")); // Output: 1
    }
}
