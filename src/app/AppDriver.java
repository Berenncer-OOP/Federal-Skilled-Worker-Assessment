package app;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class AppDriver {    
    public static void main(String[] args) throws FileNotFoundException {
        
        Scanner kInput = new Scanner(System.in);
        String filePath = new String();
        ArrayList<String> workerData = new ArrayList<String>();
        
        String inputFilePath = "/data/input/";
        String outputFilePath = "/date/output/";
        
        System.out.println("Please provide the name of the input file (to be located in" + inputFilePath + "): ");
        filePath = kInput.next();
        File workerFile = new File(filePath);
        Scanner fInput = new Scanner(workerFile);
        
        while (fInput.hasNext()) {
            String applicantLine = new String(fInput.nextLine());
            Applicant currentApplicant = new Applicant(applicantLine);
            
            }

}