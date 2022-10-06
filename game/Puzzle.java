package game;

import java.util.ArrayList;

public class Puzzle {

    private TerminalService terminalService = new TerminalService();
    public String letter_guessed = "";
    public String random_word = "";
    public String wordPlace ="";
    public Boolean guessed;
    private int wrongCount;
    private int winCounter;
    public Boolean gameOver = false;
    // Draws the board
    String desition1 = " ___";
    String desition2 = "/___\\ ";
    String desition3 = "\\   /";
    String desition4 = " \\ /";
    String desition5 = "  0";

    ArrayList<String> leterList = new ArrayList<>(); 
    ArrayList<String> mysterious_word_List = new ArrayList<>();
    
    //*constructs a new instance of Puzzle. */
    public Puzzle()
    {
    }

    /*
    Prints the hint of how many letters the word has
     */    
    private String place()
    {
        // ArrayList chars = new ArrayList<>();
        // chars.AddRange(random_word);
        // int wordLength = random_word.Length;

        for(int i=0;i<random_word.length();i++)
        {
            wordPlace += ("_  ");
        }
        return wordPlace;
    }

    /*
     * The responsibility of draw board is to display the first version of the board.
     */
    public void drawBoard()
    {
        terminalService.WriteText(" ");
        System.out.println(place());
        terminalService.WriteText(" ");
        terminalService.WriteText(" ___");
        terminalService.WriteText("/___\\ ");
        terminalService.WriteText("\\   /");
        terminalService.WriteText(" \\ /");
        terminalService.WriteText("  0");
        terminalService.WriteText(" /|\\ ");
        terminalService.WriteText(" / \\");
        terminalService.WriteText(" ");
        terminalService.WriteText("^^^^^^^");
        terminalService.WriteText(" ");
    }

    /*
     * The responsibility of getInput is to wright the promt and hold the user's answer. 
     */
    public void GetInputs()
    {
        letter_guessed = terminalService.ReadText("Guess a letter [a-z]: ");
    }

    /*
     * The responsibility of mysterious_word_board() is to create a string list
     * from the random_word so I can compare it later against the guessed word.
     */
    public void mysterious_word_board()
    {
        // List<char> chars = new List<char>();
        // chars.AddRange(random_word);
        
        //so mysterious_word_List can have as many elements as the radom word has characters.
        for(int i=0;i<random_word.length();i++)
        {
            leterList.add(random_word.substring(i, i+1));
            mysterious_word_List.add("_ ");
        }
    } 

    /*
     * The responsibility of mysterious_word_update()is to compare the guessed letter
     * with the letters of the random_word, if the guess is correct the underscore is replaced
     * by the letter.
     */
    private void mysterious_word_update()
    {
        // create a list that shows the guessed letters
        // foreach (string item in leterList)
        for(String letter : leterList)  
        {
            if (letter.equals(letter_guessed))
            {   
                winCounter += 1;
                int index = leterList.indexOf(letter);
                mysterious_word_List.set(index, letter);
                int listSize = leterList.size();
                if (winCounter == listSize)
                {
                    gameOver = true;
                }
            }
        } 
        // print the the list that shows the guessed letters. 
        for(String item : mysterious_word_List)
        {
            System.out.print(item);
        } 
    }
    /*
     * The responsibility of updateBoard()is to cut the parechute if necesary and
     * display the letters that are correct. 
     */
    public void updateBoard()
    {   
        
        if (guessed == false)
        {
            wrongCount += 1;
            if (wrongCount == 1)
            {
                desition1 = "";
            }else if (wrongCount == 2)
            {
                desition1 = "";
                desition2 = "";
            }else if (wrongCount == 3)
            {
                desition1 = "";
                desition2 = "";
                desition3 = "";
            }else if (wrongCount == 4)
            {
                desition1 = "";
                desition2 = "";
                desition3 = "";
                desition4 = "";
            }else if (wrongCount == 5)
            {
                desition1 = "";
                desition2 = "";
                desition3 = "";
                desition4 = "";
                desition5 = "  x";
                gameOver = true;
            }
        }
        terminalService.WriteText(" ");
        terminalService.WriteText(" ");
        mysterious_word_update();
        terminalService.WriteText(" ");
        terminalService.WriteText(desition1);
        terminalService.WriteText(desition2);
        terminalService.WriteText(desition3);
        terminalService.WriteText(desition4);
        terminalService.WriteText(desition5);
        terminalService.WriteText(" /|\\ ");
        terminalService.WriteText(" / \\ ");
        terminalService.WriteText(" ");
        terminalService.WriteText("^^^^^^^");
        terminalService.WriteText(" ");
    }
}
