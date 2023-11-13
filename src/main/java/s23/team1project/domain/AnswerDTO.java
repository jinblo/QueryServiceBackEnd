package s23.team1project.domain;

public class AnswerDTO {
	private String text;
	private long questionId;
	
	public AnswerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnswerDTO(String text, long questionId) {
		super();
		this.text = text;
		this.questionId = questionId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

}
