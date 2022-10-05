package game;
/**The responsibility of Guess is to decide if the guess was right or not */
public class Guess {

    public String letter_guessed = "";
    public String random_word = "";

    public Guess()
    {
        
    }

    /**The responsibility of byLetter is to return true if the guess was right. */ 

    public Boolean byLetter()
        {
            Boolean exists = random_word.contains(letter_guessed);
            return exists;
        }
}
