
public class IBCPStudent extends Student{
	private String careerPath;
	public IBCPStudent(double GPA, int gradeLevel, String schoolName) {
		super(GPA, gradeLevel, schoolName);
		
	}
	public void setCareerPath(String careerPath) {
		this.careerPath=careerPath;
	}

}
