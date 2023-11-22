package s23.team1project.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class AnswerOption {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String answerOptionText;

	@ManyToOne
	@JoinColumn(name = "question_id")
	@JsonIgnore
	private Question question;
	
	public AnswerOption() {}
	
	public AnswerOption(String answerOptionText, Question question) {
		super();
		this.answerOptionText = answerOptionText;
		this.question = question;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAnswerOptionText() {
		return answerOptionText;
	}

	public void setAnswerOptionText(String answerOptionText) {
		this.answerOptionText = answerOptionText;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
	

}
