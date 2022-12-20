/**
 * This class creates a person object that will be used later to create a general tree.The class creates some getter methods that could be utilized later
 * Aryan Suri
 * 11/24/2021
 */
public class Person 
{
    //instance variables
    public String name;    
    public Person next;
    public Person childHead;
    public Person childTail;
    public int count;
    
    //constructor
    public Person(String name) 
    {
        this.name = name;
    }
    //returns name
    public String getName()
    {
        return name;
    }
    //returns the total number of children
    public int childCount()
    {
        return count;
    }
    
    public String toString()
    {
        return "Name is: " + name + " " + "Total children: " + count + "\n";
    }
}

