package game;

import java.util.Scanner;

public class TerminalService {
 /*
 * Constructs a new instance of TerminalService.
 */
    public TerminalService()
    {
    }

    /*
     * Gets text input from the terminal. Directs the user with the given prompt.
     */
    public String ReadText(String prompt)
    {
        System.out.print(prompt);
        Scanner myObj = new Scanner(System.in);
        String userName = myObj.nextLine(); // Read user input
        
        return userName;
    }
    /*
     * Displays the given text on the terminal. 
     */
    public void WriteText(String text)
    {
        System.out.println(text);
    }

}
