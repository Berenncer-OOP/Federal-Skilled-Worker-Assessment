package app;

public class Applicant {
	/**Applicant class stores and processes all data fields associated with an applicant to the Federal Skilled Workers program in order to assess their eligibility.*/
//fields: all applicant data
//first_name    last_name    age    marital_status    speak_1    listen_1    read_1    write_1    all_2    education    work_experience    arranged_employment    adaptability_spouse_language    adaptability_spouse_education    adaptability_spouse_work    adaptability_you_education    adaptability_you_work    adaptability_you_employment    adaptability_relatives

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

    public Applicant(String applicantLine) {
    	/**Constructor method for objects of Applicant class; 
    	 * @param applicantLine accepts line from Federal Skilled Workers applicant list .txt file and populates fields of object
    	 * */
        //separate String applicantLine into list
        String[] applicantArray = applicantLine.split("\t");
        this.firstName = applicantArray[0];
        this.lastName = applicantArray[1];
        this.age = Integer.parseInt(applicantArray[2]);
        
        this.maritalStatus = convert(applicantArray[3]);
        
        this.speak = Integer.parseInt(applicantArray[4]);
        this.listen = Integer.parseInt(applicantArray[5]);
        this.read = Integer.parseInt(applicantArray[6]);
        this.write = Integer.parseInt(applicantArray[7]);
        this.minimumCLB = convert(applicantArray[8]);
        
        this.education = applicantArray[9];
        this.workExperience = Integer.parseInt(applicantArray[10]); 
        this.arrangedEmployment = convert(applicantArray[11]);
        
        this.spouseAdaptabilityLanguage = convert(applicantArray[12]);
        this.spouseAdaptabilityEducation = convert(applicantArray[13]);
        this.spouseAdaptabilityWork = convert(applicantArray[14]);
        
        this.adaptabilityEducation = convert(applicantArray[15]);
        this.adaptabilityWork = convert(applicantArray[16]);
        this.adaptabilityEmployment = convert(applicantArray[17]);
        this.adaptabilityRelatives = convert(applicantArray[18]);
        }
    
/**getter Methods Are Available For firstName, lastName, age, score fields.*/
    public String getFirstName() {
    	/**@return Applicant first name*/
        return this.firstName;
    }
    public String getLastName() { 
    	/**@return Applicant last name*/
        return this.lastName;
    }
    public int getAge() {
    	/**@return Applicant age*/
        return this.age;
    }
    public int getScore() {
    	/**@return Applicant score*/
        return this.score;
    }

    public void scoreTotal() {
        /**scoreTotal() method calls all other scoring methods and adds their return values to assign the resulting integer to this.score*/
        int total = scoreLanguageSkills()+scoreEducation()+scoreWorkExperience()+scoreAge()+scoreEmployment()+scoreAdaptability();
        this.score = total;
    }
    
    public int scoreLanguageSkills() {
        /**scores applicant language skills. 
         * @return applicant language score. max 28 points.*/
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
        /**scores highest level of education applicant has achieved. 
         * @return applicant education score. max 25 points*/
        int educationScore = 0;
        if(this.education.contains("high school diploma")) {
        	educationScore += 5;
        }
        else if(this.education.contains("One-year degree")) {
        	educationScore += 15;
        }
        else if(this.education.contains("Two-year degree")) {
        	educationScore += 19;
        }
        else if(this.education.contains("Bachelor's degree")) {
        	educationScore += 21;
        }
        else if(this.education.contains("Two or more")) {
        	educationScore += 22;
        }
        else if(this.education.contains("Professional degree needed")) {
        	educationScore += 23;
        }
        else if(this.education.contains("Master's level")) {
        	educationScore += 23;
        }
        else if(this.education.contains("PhD")) {
        	educationScore += 25;
        }
        return educationScore;
    }
   
    public int scoreWorkExperience() {
        /**scores applicant's years of work experience. 
         * @return applicant work experience score. max 15 points*/
        int workExperienceScore = 0;
        if(this.workExperience < 1) {
        	return workExperienceScore;
        }
        else if(this.workExperience == 1) {
        	workExperienceScore =9;
        }
        else if(this.workExperience == 2 |this.workExperience == 3) {
        	workExperienceScore =11;
        }
        else if(this.workExperience == 4 |this.workExperience == 5) {
        	workExperienceScore =13;
        }
        else if(this.workExperience >= 6) {
        	workExperienceScore =15;
        }
        return workExperienceScore;
    }
    
    public int scoreAge() {
    	/**calculates applicants age score
    	 * @return applicant age score. max 12 points.*/
    	int ageScore = 0;
    	if (this.age < 18) {
    	ageScore +=0;
    	} else if (this.age >= 18 && age <= 35) {
    	ageScore +=12;
    	} else if (this.age == 36)  {
    	ageScore +=11;
    	} else if (this.age == 37) {
    	ageScore +=10;
    	} else if (this.age == 38) {
    	ageScore +=9;
    	} else if (this.age == 39) {
    	ageScore +=8;
    	} else if (this.age == 40) {
    	ageScore +=7;
    	} else if (this.age == 41) {
    	ageScore +=6;
    	} else if (this.age == 42) {
    	ageScore +=5;
    	} else if (this.age == 43) {
    	ageScore +=4;
    	}else if (this.age == 44) {
    	ageScore +=3;
    	}else if (this.age == 45) {
    	ageScore +=2;
    	}else if (this.age == 46) {
    	ageScore +=1;
    	} else {
    	ageScore+=0;
    	}
    	return ageScore;
    }
    
    
    public int scoreEmployment() {
        /**scores whether or not applicant has employment arranged in Canada. 
         * @return applicant employment score. max 10 points*/
        int employmentScore = 0;
        if(this.arrangedEmployment) {
        	employmentScore = 10;
        }
        return employmentScore;
    }
    	    
    public int scoreAdaptability() {
        /**score presumed adaptability of applicant and applicant's family to life in Canada. 
         * @return applicant adaptability score. max 10 points*/
        int adaptabilityScore = 0;
            if (this.adaptabilityEducation == true) {
                adaptabilityScore += 5;
            }
            if (this.adaptabilityWork == true) {
                adaptabilityScore += 10;
            }
            if (this.adaptabilityEmployment == true) {
                adaptabilityScore += 5;
            }
            if (this.adaptabilityRelatives == true) {
                adaptabilityScore += 5;
            }
            if (this.maritalStatus == true) {
                if (this.spouseAdaptabilityLanguage == true) {
                    adaptabilityScore += 5;
                }
                if (this.spouseAdaptabilityEducation == true) {
                    adaptabilityScore += 5;
                }
                if (this.spouseAdaptabilityWork == true) {
                    adaptabilityScore += 5;
                }
            }
            if (adaptabilityScore > 10) {
                //necessary because max adaptability score is 10
                adaptabilityScore = 10;
            }
        return adaptabilityScore;
    }

    public boolean convert(String testStr) {
    	/**converts required strings to boolean values
    	 * @return true if "yes" or "married"; false if "no" or "single"*/
        if(testStr.contains("yes") | testStr.contains("Yes")) {
            return true;
        }
        else if(testStr.contains("married")| testStr.contains("Married") ){
            
            return true;
        }
        else {
            return false;
        }
    }
}

