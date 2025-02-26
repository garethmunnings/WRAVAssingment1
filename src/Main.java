import java.io.FileNotFoundException;

// Author: Anne van der Merwe

public class Main {

    // DO NOT CHANGE
    public static void main(String[] args) throws FileNotFoundException {

        MyHashTable my_hash_table = new MyHashTable();

        String[] words_to_add = {
                "listen", "silent", "enlist", "stop", "tops", "pots",
                "stone", "tones", "notes", "onset", "care", "race",
                "acre", "heart", "earth", "hater", "cinema", "iceman",
                "anemic", "angel", "glean", "angle", "rescue", "secure"
        };

        String[] words_to_remove = {
                "silent", "tops", "tones", "race", "earth", "iceman"
        };

        System.out.println("Adding words to my_hash_table ...");
        for (String word : words_to_add) {
            my_hash_table.put(word, String.valueOf(word.charAt(0)));
        }
        my_hash_table.display();

        System.out.println("\nRemoving words from the hash table...");
        for (String word : words_to_remove) {
            my_hash_table.remove(word);
        }
        my_hash_table.display();

        String word_to_check = "listen";

        System.out.println();
        System.out.println("Total unique anagram groups: " + my_hash_table.uniqueGroups());
        System.out.println("Count of words in the anagram group for '" + word_to_check + "' : " + my_hash_table.anagramFrequency(word_to_check));
        System.out.println("The value for '" + word_to_check + "' : " + my_hash_table.get(word_to_check));

    }

}