package app;

import java.util.Scanner;

public class Applicant {
//fields: all applicant data
//first_name	last_name	age	marital_status	speak_1	listen_1	read_1	write_1	all_2	education	work_experience	arranged_employment	adaptability_spouse_language	adaptability_spouse_education	adaptability_spouse_work	adaptability_you_education	adaptability_you_work	adaptability_you_employment	adaptability_relatives

	//AND score
	private String firstName;
	private String lastName;
	private int age;
	private boolean maritalStatus;
	
	private int speak;
	private int listen;
	private int read;
	private int write;
	private boolean minimumCLB; //min CLB 5 across prev. 4 language skills
	
	private String education;
	private int workExperience; //years
	private boolean arrangedEmployment;
	
	private boolean spouseLanguage;
	private boolean spouseEducation;
	private boolean spouseWork;
	
	private boolean adaptabilityEducation;
	private boolean adaptabilityWork;
	private boolean adaptabilityEmployment;
	private boolean relatives;
	
	private int applicantScore;

	public Applicant(String applicantLine) {
	    
	}
	public void fillData(int temp, String currToken) {
	    switch(temp) {
	    case 0:
	        this.firstName = currToken;
	        System.out.println(this.firstName);
	        break;
	    case 1:
	    	this.lastName = currToken;
	        break;
	    case 2:
	        this.age = Integer.parseInt(currToken);
	    case 3:
	    	this.maritalStatus = Integer.parseInt(currToken)
	    }
	}
	public void addAppData(String tmpString) {
	    Scanner strReader = new Scanner(tmpString);
	    String currToken;
	    for(int i = 0; i <= 18; i++) {
	        fillData(i, strReader.next());
	    }
	}
	
//methods: ???
	//getFirstName
	//getLastName
	//getAge
	//getScore
	//setScore
	
	public int scoreLanguageSkills() {
		int languageScore = 0;
		if (this.speak == 7) {
			languageScore += 4;
		}
		else if (this.speak == 8) {
			languageScore += 5;
		}
		else if (this.speak >= 9) {
			languageScore += 6;
		}
		else {
			languageScore += 0;
		}
		
		if (this.listen == 7) {
			languageScore += 4;
		}
		else if (this.listen == 8) {
			languageScore += 5;
		}
		else if (this.listen >= 9) {
			languageScore += 6;
		}
		else {
			languageScore += 0;
		}
		
		if (this.read == 7) {
			languageScore += 4;
		}
		else if (this.read == 8) {
			languageScore += 5;
		}
		else if (this.read >= 9) {
			languageScore += 6;
		}
		else {
			languageScore += 0;
		}
		
		if (this.write == 7) {
			languageScore += 4;
		}
		else if (this.write == 8) {
			languageScore += 5;
		}
		else if (this.write >= 9) {
			languageScore += 6;
		}
		else {
			languageScore += 0;
		}
		
		//secondary language
		
		if (this.minimumCLB == true) {
			languageScore += 4;
		}
		else {
			languageScore += 0;
		}
		
		
		System.out.println(languageScore);
		return languageScore;		
	}
	
<<<<<<< HEAD
	
	
=======
>>>>>>> branch 'main' of git@github.com:Berenncer-OOP/Federal-Skilled-Worker-Assessment.git
	
	public int scoreLanguageSkills() {
		int languageScore = 0;
		if (this.speak == 7) {
			languageScore += 4;
		}
		else if (this.speak == 8) {
			languageScore += 5;
		}
		else if (this.speak >= 9) {
			languageScore += 6;
		}
		else {
			languageScore += 0;
		}
		
		if (this.listen == 7) {
			languageScore += 4;
		}
		else if (this.listen == 8) {
			languageScore += 5;
		}
		else if (this.listen >= 9) {
			languageScore += 6;
		}
		else {
			languageScore += 0;
		}
		
		if (this.read == 7) {
			languageScore += 4;
		}
		else if (this.read == 8) {
			languageScore += 5;
		}
		else if (this.read >= 9) {
			languageScore += 6;
		}
		else {
			languageScore += 0;
		}
		
		if (this.write == 7) {
			languageScore += 4;
		}
		else if (this.write == 8) {
			languageScore += 5;
		}
		else if (this.write >= 9) {
			languageScore += 6;
		}
		else {
			languageScore += 0;
		}
		
		//secondary language
		
		if (this.minimumCLB == true) {
			languageScore += 4;
		}
		else {
			languageScore += 0;
		}
		
		
		System.out.println(languageScore);
		return languageScore;		
	}
	
	
	public int scoreLanguageSkills() {
		int languageScore = 0;
		if (this.speak == 7) {
			languageScore += 4;
		}
		else if (this.speak == 8) {
			languageScore += 5;
		}
		else if (this.speak >= 9) {
			languageScore += 6;
		}
		else {
			languageScore += 0;
		}
		
		if (this.listen == 7) {
			languageScore += 4;
		}
		else if (this.listen == 8) {
			languageScore += 5;
		}
		else if (this.listen >= 9) {
			languageScore += 6;
		}
		else {
			languageScore += 0;
		}
		
		if (this.read == 7) {
			languageScore += 4;
		}
		else if (this.read == 8) {
			languageScore += 5;
		}
		else if (this.read >= 9) {
			languageScore += 6;
		}
		else {
			languageScore += 0;
		}
		
		if (this.write == 7) {
			languageScore += 4;
		}
		else if (this.write == 8) {
			languageScore += 5;
		}
		else if (this.write >= 9) {
			languageScore += 6;
		}
		else {
			languageScore += 0;
		}
		
		//secondary language
		
		if (this.minimumCLB == true) {
			languageScore += 4;
		}
		else {
			languageScore += 0;
		}
		
		
		System.out.println(languageScore);
		return languageScore;		
	}
	
}
