package app;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class AppDriver {    
    public static void main(String[] args) throws FileNotFoundException {
        
        Scanner kInput = new Scanner(System.in);
        ArrayList<String> workerData = new ArrayList<String>();
        
        //String inputFilePath = "/data/input/";
        //String outputFilePath = "/data/output/";
        
        System.out.println("Please provide the name of the input file (to be located in): ");
        String filePath = kInput.next();
        File workerFile = new File(filePath);
        Scanner fInput = new Scanner(workerFile);
        
        while (fInput.hasNext()) {
            String applicantLine = new String(fInput.nextLine());
            //System.out.println(applicantLine);
            Applicant currentApplicant = new Applicant(applicantLine);
            currentApplicant.scoreLanguageSkills();
            }
        
        fInput.close();
        kInput.close();
    }
}
    