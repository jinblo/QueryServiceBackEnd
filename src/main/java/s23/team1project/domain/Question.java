package s23.team1project.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Type type;
	private String questionText; 
	
	@ManyToOne
	@JoinColumn(name = "query_id")
	@JsonIgnore
	private Query query;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
	private List <Answer> answers;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
	private List <AnswerOption> answerOptions;

	public Question() {}
	
	public Question(String questionText, Query query) {
		super();
		this.questionText = questionText;
		this.query = query;
	}
	
	public Question(Type type, String questionText, Query query) {
		super();
		this.type = type;
		this.questionText = questionText;
		this.query = query;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public List<AnswerOption> getAnswerOptions() {
		return answerOptions;
	}

	public void setAnswerOptions(List<AnswerOption> answerOptions) {
		this.answerOptions = answerOptions;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public Query getQuery() {
		return query;
	}

	public void setQuery(Query query) {
		this.query = query;
	}
	
}
