package app;

public class Applicant {
//fields: all applicant data
//first_name	last_name	age	marital_status	speak_1	listen_1	read_1	write_1	all_2	education	work_experience	arranged_employment	adaptability_spouse_language	adaptability_spouse_education	adaptability_spouse_work	adaptability_you_education	adaptability_you_work	adaptability_you_employment	adaptability_relatives

	//AND score
	private String first_name;
	private String last_name;
	private String age;
	private boolean marital_status;
	private int speak_1;
	private int listen_1;
	private int read_1;
	private int write_1;
	private boolean all_2; //min CLB 5 across prev. 4 language skills
	private String education;
	private int work_experience; //years
	private boolean arranged_employment;
	private boolean spouse_language;
	private boolean spouse_education;
	private boolean spouse_work;
	private boolean adaptability_education;
	private boolean adaptability_work;
	private boolean adaptability_employment;
	private boolean relatives;
	private int score;
	
	public Applicant(String applicantLine) {
	    
	}
	
//methods: ???
	//getFirstName
	//getLastName
	//getAge
	//getScore
	//setScore
}
