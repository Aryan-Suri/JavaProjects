import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class uses a scanner to get names from the users and uses that to build a general tree by using methods such as print, Tree, and main
 * Aryan Suri
 * 11/25/2021
 */
public class Main 
{
    //builds a family tree
    public static void Tree(FamilyTree tree, Person root)
    {
        Scanner scan = new Scanner(System.in);  //gets the names from the user
        //asks user for the grandparent
        if (root == null) 
        {
            System.out.println("Name of the Grand Parent");
            String name = scan.nextLine();
            Person person= new Person(name);
            tree.header = person;
            tree.size++;
            Tree(tree, person);
        }
        else 
        {
            //gives users the prompts as to how to input the names
            System.out.println("Name of any Children of: " + root.name + ", seperated with spaces.");
            System.out.println("Enter \"none\" for no children");
            System.out.println();
            String name = scan.nextLine();  
            //stops running if user inputs null
            if (name.equals("none") || name.equals("")) 
            {
                return;
            }
            else 
            {
                String[] names = name.split(" ");    //splits the data where the first space is and stores it into an array
                ArrayList<Person> children = new ArrayList<Person>();
                for (String i : names) 
                {
                    Person person= new Person(i);
                    children.add(person);
                }
                root.childHead = children.get(0);
                for (int i = 0; i < children.size(); i++) 
                {
                    if (i == children.size() - 1) 
                    {
                        root.childTail = children.get(i);
                        root.count = children.size();
                    }
                    else 
                    {
                        children.get(i).next = children.get(i+1);
                    }
                    Tree(tree, children.get(i));
                }
            }
        }
    }

    //prints the tree built using previous method 
    public static void Print(String formatString, Person root) 
    {
        formatString = formatString + "\t";
        Person child = root.childHead;
        for (int i = 0; i < root.count; i++) 
        {
            System.out.println(formatString + child.name);
            Print(formatString, child);
            child = child.next;
        }
    }
    
    //uses both the methods above the create and print a general tree
    public static void main(String[] args) 
    {
        // Create a Family Tree
        FamilyTree tree = new FamilyTree();
        Tree(tree, null);
        System.out.println();
        System.out.println("Tree Representation of Names entered:");
        System.out.println();
        System.out.println(tree.header.name);
        Print(" ", tree.header);
    }

}
