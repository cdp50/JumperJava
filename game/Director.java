package game;
/**
 * A person who directs the game.
 * The responsibility of a Director is to control the sequence of play.
 */
public class Director {

    private Guess guess = new Guess();
    private Puzzle puzzle = new Puzzle();
    private Word word = new Word();
    private Boolean isPlaying = true;

        
    /** Constructs a new instance of Director.*/
    public Director()
    {
    }

    public void StartGame()
    {   
        puzzle.random_word = word.get_random_word();
        puzzle.mysterious_word_board();
        puzzle.drawBoard();   
        while (isPlaying)
        {
            GetInputs();
            DoUpdates();
            DoOutputs();
        }
    }

    private void GetInputs()
    {
        puzzle.GetInputs();
    }
    
    private void DoUpdates()
    {
        guess.random_word = puzzle.random_word;
        guess.letter_guessed = puzzle.letter_guessed;
        puzzle.guessed = guess.byLetter();
        puzzle.updateBoard();
    }

    private void DoOutputs()
    { 
        if (puzzle.gameOver)
        {
            isPlaying = false;
        }
    }
}
