package app;

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
	
	private boolean spouseAdaptabilityLanguage;
	private boolean spouseAdaptabilityEducation;
	private boolean spouseAdaptabilityWork;
	
	private boolean adaptabilityEducation;
	private boolean adaptabilityWork;
	private boolean adaptabilityEmployment;
	private boolean adaptabilityRelatives;
	
	private int score = 0;

	//testing a different method of reading data to the fields
	public Applicant(String applicantLine) {
		//separate String applicantLine into list
		String[] applicantArray = applicantLine.split("\t");
		//System.out.println(applicantArray[17]);
		this.firstName = applicantArray[0];
		this.lastName = applicantArray[1];
		System.out.println(this.firstName + " " + this.lastName);
		this.age = Integer.parseInt(applicantArray[2]);
		this.maritalStatus = ConvertToBoolean.convert(applicantArray[3]);
		
		this.speak = Integer.parseInt(applicantArray[4]);
		this.listen = Integer.parseInt(applicantArray[5]);
		this.read = Integer.parseInt(applicantArray[6]);
		this.write = Integer.parseInt(applicantArray[7]);
		this.minimumCLB = ConvertToBoolean.convert(applicantArray[8]);
		
		this.education = applicantArray[9];
		this.workExperience = Integer.parseInt(applicantArray[10]); 
		this.arrangedEmployment = ConvertToBoolean.convert(applicantArray[11]);
		
		this.spouseAdaptabilityLanguage = ConvertToBoolean.convert(applicantArray[12]);
		this.spouseAdaptabilityEducation = ConvertToBoolean.convert(applicantArray[13]);
		this.spouseAdaptabilityWork = ConvertToBoolean.convert(applicantArray[14]);
		
		this.adaptabilityEducation = ConvertToBoolean.convert(applicantArray[15]);
		this.adaptabilityWork = ConvertToBoolean.convert(applicantArray[16]);
		this.adaptabilityEmployment = ConvertToBoolean.convert(applicantArray[17]);
		this.adaptabilityRelatives = ConvertToBoolean.convert(applicantArray[18]);
		}
	
//methods: ???
	//getFirstName
	//getLastName
	//getAge
	//getScore
	//setScore
	public int getScore() {
		return score;
	}


	public void scoreTotal() {
		/**scoreTotal() method calls all other scoring methods and adds their return values to assign the resulting int to this.score*/
		int total = scoreLanguageSkills()+scoreEducation()+scoreWorkExperience()+scoreAge()+scoreEmployment()+scoreAdaptability();
		this.score = total;
	}
	
	public int scoreLanguageSkills() {
		/**scores applicant language skills. max 28 points.*/
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
		return languageScore;		
	}
	public int scoreEducation() {
		/**scores highest level of education applicant has achieved. max 25 points*/
		int educationScore = 0;
		//if-elif should be based on value of this.education str
		
		return educationScore;
	}
	public int scoreWorkExperience() {
		/**scores applicant's years of work experience. max 15 points*/
		int workExperienceScore = 0;
		//if-elif should be based on value of this.workExperience int
		
		return workExperienceScore;
	}
	public int scoreAge() {
		/**scores applicant's age. max 12 points*/
		int ageScore = 0;
		//if-elif should be based on value of this.Age int
		
		return ageScore;
	}
	public int scoreEmployment() {
		/**scores whether or not applicant has employment arranged in Canada. max 10 points*/
		int employmentScore = 0;
		//if-elif should be based on value of this.arrangedEmployment bool
		
		return employmentScore;
	}
	public int scoreAdaptability() {
		/**score presumed adaptability of applicant and applicant's family to life in Canada. max 10 points*/
		int adaptabilityScore = 0;
		//should be based on value of all adaptability-related items. should loop while adaptabilityScore<10 and stop when all adaptability-related items have been checked.
		
		return adaptabilityScore;
	}

}
