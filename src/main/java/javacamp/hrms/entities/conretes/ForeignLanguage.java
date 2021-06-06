package javacamp.hrms.entities.conretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "foreign_languages")
public class ForeignLanguage {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int languageId;
	
	@Column(name = "language_name")
    private String languageName;
	
	@Min(1)
    @Max(5)
	@Column(name = "level")
    private int level;
	
	@ManyToOne()
	@JsonIgnore
    @JoinColumn(name="curriculum_vitae_id")
    private CurriculumVitae curriculumVitae;

	public ForeignLanguage() {
		
	}

	public ForeignLanguage(int languageId, String languageName, @Min(1) @Max(5) int level,
			CurriculumVitae curriculumVitae) {
		super();
		this.languageId = languageId;
		this.languageName = languageName;
		this.level = level;
		this.curriculumVitae = curriculumVitae;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public CurriculumVitae getCurriculumVitae() {
		return curriculumVitae;
	}

	public void setCurriculumVitae(CurriculumVitae curriculumVitae) {
		this.curriculumVitae = curriculumVitae;
	}

}
