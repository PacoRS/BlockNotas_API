package restfull.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="notes")
public class Note {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="title",length= 128)
	private String title;
	
	@Column(name="description",length= 256)
	private String description;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
	private Usuario user;
	
	public Note(Long id, String title, String description) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
	}
	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Note [id=" + id + ", title=" + title + ", description=" + description + "]";
	}
	
	

}
