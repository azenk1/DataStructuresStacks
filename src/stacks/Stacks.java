/**
 * Class: Stacks
 * Purpose: Contains methods to help the user interact with the ArrayStack class.
 * Author: Al Zenk
 * Date: 09/23/2018
 */
package stacks;
import java.util.Scanner;
/**
 *
 * @author azenk
 */
public class Stacks {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 
        //Call to get user input and store in userEntry.
        String userEntry = getInput();
        
        //Create ArrayStack object with a size set to that of the length of user
        //input.
        ArrayStack testStack = new ArrayStack(userEntry.length());
     
        testStack = populateStack(testStack, userEntry);
        
        //pass stack to method to generate output
        giveOutput(testStack);

    }
    
    /**
     * Generates output based on the stack passed. Shown in regular order
     * with spaces to show each char popped off of stack and in reverse order as
     * a complete sentence.
     * @param stackIn - Stack containing user input.
     */
    public static void giveOutput(ArrayStack stackIn)
    {
        System.out.println(stackIn.toString());
        System.out.println(stackIn.reverseElements(stackIn));
    }
    
    /**
     * Prompts the user for input and stores input in a String variable.
     * @return - String returned to main. Contains user input.
     */
    public static String getInput()
    {
        //Scanner for taking in user input
        Scanner in = new Scanner(System.in);      
          
        //Prompt for input
        System.out.println("Enter a sentence");
        String userEntry = in.nextLine();
        
        //Return user input in String.
        return userEntry;
    }
    
    /**
     * 
     * @param stackin - stack passed in to be populated
     * @param textIn - String passed in to populate stack
     * @return - Stack populated with String of chars
     * Pushes a char onto the stack.
     */
    public static ArrayStack populateStack(ArrayStack stackin, String textIn)
    {
        ArrayStack charStack = stackin;
        
        for(int i = 0; i < textIn.length(); i++)
        {
            charStack.push(textIn.charAt(i));
        }
        
        return charStack;
    }
    
}
