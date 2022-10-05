package game;

import java.util.ArrayList;

/*
 * The responsibility of word is to select and output a random word
 */
public class Word {

    public Word()
    {
    }

    /*
     * The responsibility of get_random_word is to create a list of words, 
     * select and output a random word
     */
    public String get_random_word()
    {   
        ArrayList<String> words = new ArrayList<>();
        words.add("phone");
        words.add("keyboard");
        words.add("mouse");
        words.add("sing");
        words.add("water");
        words.add("rock");
        words.add("gospel");
        words.add("love");
        words.add("clap");

        int index = (int)(Math.random() * words.size());
        String random_word = words.get(index);
        return random_word;
    }


}
