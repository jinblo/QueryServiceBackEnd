package s23.team1project.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String q; 
	
	@ManyToOne
	@JoinColumn(name = "query_id")
	@JsonIgnore
	private Query query;

	public Question() {}
	
	public Question(String q, Query query) {
		super();
		this.q = q;
		this.query = query;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}

	public Query getQuery() {
		return query;
	}

	public void setQuery(Query query) {
		this.query = query;
	}
	
}
