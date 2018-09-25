package stacks;

import jsjf.exceptions.*;
import java.util.Arrays;
import jsjf.StackADT;

/**
 * An array implementation of a stack in which the bottom of the
 * stack is fixed at index 0.
 * 
 * @author Lewis and Chase
 * @version 4.0
 */
public class ArrayStack<T> implements StackADT<T>
{
    private final static int DEFAULT_CAPACITY = 100;

    private int top;  
    private T[] stack;
    private int size = 0;
    private final String REVERSE_HEADING = "\n***Your sentence in reverse order***\n   ***************************\n     ";
    private final String ORIGINAL_HEADING = "\n***Your sentence in original form***\n   ***************************\n     ";
  
    /**
     * Creates an empty stack using the default capacity.
     */
    public ArrayStack()
    {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Creates an empty stack using the specified capacity.
     * @param initialCapacity the initial size of the array 
     */
    public ArrayStack(int initialCapacity)
    {
        top = 0;
        stack = (T[])(new Object[initialCapacity]);
    }

    /**
     * Adds the specified element to the top of this stack, expanding
     * the capacity of the array if necessary.
     * @param element generic element to be pushed onto stack
     */
    @Override
    public void push(T element)
    {
        if (size() == stack.length) 
            expandCapacity();

        stack[top] = element;
        top++;
    }

    /**
     * Creates a new array to store the contents of this stack with
     * twice the capacity of the old one.
     */
    private void expandCapacity()
    {
        stack = Arrays.copyOf(stack, stack.length * 2);   
    }

    /**
     * Removes the element at the top of this stack and returns a
     * reference to it. 
     * @return element removed from top of stack
     * @throws EmptyCollectionException if stack is empty 
     */
    @Override
    public T pop() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("stack");

        top--;
        T result = stack[top];
        stack[top] = null; 

        return result;
    }
   
    /**
     * Returns a reference to the element at the top of this stack.
     * The element is not removed from the stack.  
     * @return element on top of stack
     * @throws EmptyCollectionException if stack is empty
     */
    @Override
    public T peek() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("stack");

        return stack[top-1];
    }

    /**
     * Returns true if this stack is empty and false otherwise. 
     * @return true if this stack is empty
     */
    @Override
    public boolean isEmpty()
    {
        // To be completed as a Programming Project
        boolean empty = false;
        
        if(top == 0)
        {
            empty = true;
        }
        
        return empty;
        
    }
 
    /**
     * Returns the number of elements in this stack.
     * @return the number of elements in the stack
     */
    @Override
    public int size()
    {
        
        size = top;
        
        return size;
    }

    /**
     * Returns a string representation of this stack. 
     * @return a string representation of the stack
     */
    @Override
    public String toString()
    {
        // To be completed as a Programming Project
        String stackPrintOut = ORIGINAL_HEADING;
        
        //Loop through stack and add each element to String stackPrintOut.
        for(int i = 0; i <= size; i++)
        {
            stackPrintOut += " " + stack[i] + " ";
        }
        return stackPrintOut;
    }
    
    /**
     * Prints contents of stack in reverse order. Space added to increase readability
     * @param stackIn - ArrayStack passed in to be reversed
     * @return - Returns formatted string representation of stack contents
     */
    public String reverseElements(ArrayStack stackIn)
    {
        String output = REVERSE_HEADING;
        for(int i = 0; i <= size; i++)
        {
            output +=  " " +  stackIn.pop();
        }
                
       
        return output;
    }
}

