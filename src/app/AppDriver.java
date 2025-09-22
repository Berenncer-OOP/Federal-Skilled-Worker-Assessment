
//Fenna, Bernard, Spencer group 14

package app;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

public class AppDriver {    
    public static void main(String[] args) throws IOException {
    	//fields and scanners
    	int count = 0;
    	String bold = "\033[0;1m";
        String reset = "\033[0;0m";
        String header = String.format("%-20s|%-20s|%-5s|%-5s",
                "First Name", "Last Name", "Age", "Score");
        String divider = "--------------------+--------------------+-----+-----";
        Scanner kInput = new Scanner(System.in);
        
        //prompt for inputFile
        System.out.print("Please provide of the name in the input file (to be located in data/input/):  "+ bold);
        String inputFile = kInput.next();
        System.out.print(reset);
       
        //prompt for outputFile
        System.out.print("Please provide of the name in the output file (to be located in data/output/):  "+ bold);
        String outputFile = kInput.next();
        System.out.print(reset);
       
        //setup input file
        File workerFile = new File("data/input/" + inputFile);
        Scanner fInput = new Scanner( workerFile);
        fInput.nextLine(); //separate out headings line to initialize correct line for while loop
        
        //setup output file and begins formatting
        File outFile = new File ("data/output/"+ outputFile);
        PrintWriter qualifiedApplicantOut = new PrintWriter(outFile);
        qualifiedApplicantOut.println(header);
        qualifiedApplicantOut.println(divider);
        
        //loop to grab everything from input file and check qualified applicants then write out to qualifiedapplicants
        while (fInput.hasNext()) {
            String applicantLine = new String(fInput.nextLine());
            Applicant currentApplicant = new Applicant(applicantLine);
            currentApplicant.scoreTotal();
           
            if(currentApplicant.getScore() >= 67) {
            count ++;
            	 
            	String outputStr = String.format("%-20s|%-20s|%-5d|%-5d",currentApplicant.getFirstName() , currentApplicant.getLastName(), currentApplicant.getAge(), currentApplicant.getScore());
            	qualifiedApplicantOut.println(outputStr);
            }
        }
        
        //string formatting and closing scanners/printwriter
        	System.out.println();
        	System.out.println("There were "+bold+ count+reset+ " qualified applicants");
        	qualifiedApplicantOut.close();
        	fInput.close();
  	        kInput.close();
    }
}