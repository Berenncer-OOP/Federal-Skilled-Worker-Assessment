package app;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class AppDriver {    
    public static void main(String[] args) throws FileNotFoundException {
        
        Scanner kInput = new Scanner(System.in);
        //ArrayList<String> workerData = new ArrayList<String>();

        
        System.out.println("Please provide the name and full file path of the input file: ");
        String inputFilePath = kInput.next();
        //for fileOut:
        //System.out.println("Please provide the name and full file path of the output file: ");
        //String outputFilePath = kInput.next();
        
        File workerFile = new File(inputFilePath);
        Scanner fInput = new Scanner(workerFile);
        String headingsLine = new String(fInput.nextLine()); //separate out headings line to initialize correct line for while loop and store headings for fileOut
        String[] headingsArray = headingsLine.split("\t");
        
        while (fInput.hasNext()) {
            String applicantLine = new String(fInput.nextLine());
            Applicant currentApplicant = new Applicant(applicantLine);
            currentApplicant.scoreTotal();
            //System.out.println(currentApplicant.getScore());
            // if statement for if currentApplicant.score is >=threshold
            
            }
        
        fInput.close();
        kInput.close();
    }
}
    