
public class IBDPStudent extends Student{
	private String IBDPClasses;
	private int IBScores;
	private String EETopic;
	public IBDPStudent(double GPA, int gradeLevel, String schoolName) {
		super(GPA, gradeLevel, schoolName);
		
	}
	public void setEETopic(String EETopic) {
		this.EETopic=EETopic;
	}

}
