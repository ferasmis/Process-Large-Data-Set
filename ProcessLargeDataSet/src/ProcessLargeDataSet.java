/*****************************************************
* Name: Feras
* Description: A program that reads data from link and display total salaries
* and the average of salaries
 ***************************************************/

//import statement 
import java.util.ArrayList;
import java.util.Scanner;
public class ProcessLargeDataSet {
    public static void main(String[] args) throws Exception {
        // Create three ArrayLists class to store data
        ArrayList<Double> assistant = new ArrayList<>();
	ArrayList<Double> associate = new ArrayList<>();
	ArrayList<Double> full = new ArrayList<>();

	// Read data from url
        //try catch statements
	try {
            //create URL Object
            java.net.URL url = new java.net.URL(
                "https://liveexample.pearsoncmg.com/data/Salary.txt");
                
            //Create Scanner Object using openStream method
            Scanner input = new Scanner(url.openStream());
            
            //while loop to read data 
            while (input.hasNext()) {
                String[] line = (input.nextLine()).split(" ");
                processData(assistant, associate, full, line[2],
                    new Double(line[3]));
            }//end while loop
        }//end try statment
        
        //catch errors and terminate the program
        catch (java.net.MalformedURLException ex) {
            System.out.println("Invalid URL");
        }//end catch statement
        
        catch (java.io.IOException ex) {
            System.out.println("I/O Errors: no such file");
        }//end catch statemnt
        
       //Compute the total from the data using methods
       double totalAssistant = getTotal(assistant);
       double totalAssociate = getTotal(associate);
       double totalFullProfs = getTotal(full);
       double totalSalary =(totalAssistant + totalAssociate + totalFullProfs);
       
        //Display the results to the user and use printf to format the no.
        System.out.printf("Total salary for assistant professor is %.2f\n",
                totalAssistant);
        System.out.printf("Total salary for associate professor is %.2f\n",
                totalAssociate);
        System.out.printf("Total salary for full professor is %.2f\n",
                totalFullProfs);
        System.out.printf("Total salary for all professors is %.2f\n",
                totalSalary);
        System.out.printf("Average salary for assistant professor is %.2f\n", 
                (totalAssistant / assistant.size()));
        System.out.printf("Average salary for associate professor is %.2f\n",
                (totalAssociate / associate.size()));
        System.out.printf("Average salary for full professor is %.2f\n",
                (totalFullProfs / full.size()));
        System.out.printf("Average salary for all professors is %.2f\n",
                (totalSalary/(assistant.size() + associate.size() 
                        + full.size())));
    }//end main
    
    //method to return the sum of elements in the ArrayList
    public static double getTotal(ArrayList<Double> list ){
        double total = 0;
        for (int i = 0; i < list.size(); i++) {
            total += list.get(i);
        }//end loop
        
        return total;
    }//end method
    
    //method process data from the link
    public static void processData(ArrayList<Double> assistant,
        ArrayList<Double> associate, ArrayList<Double> full,
        String rank, double salary) {
        
        switch (rank) {
            case "assistant":
                assistant.add(salary);
                break;
            case "associate":
                associate.add(salary);
                break;
            case "full":
                full.add(salary);
                break;
            default:
                break;
        }
        
    }//end method
}//end class
