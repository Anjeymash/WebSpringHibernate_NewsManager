package by.yandex.anjeymash.news.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "news")
public class News {

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	@Column(name = "n_title")
	private String newsTitle;

	@NotNull(message = "is required")
	@Size(min = 1, max = 30, message = "is required")
	@Column(name = "n_brief")
	private String newsBrief;

	@NotNull(message = "is required")
	@Size(min = 10, max = 10000, message = "is required")
	@Column(name = "n_message")
	private String newsMes;
	
	@NotNull(message = "is required")
	@Column(name = "n_date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date newsDate;

	@Id
	@GenericGenerator(name="gen",strategy="increment")
    @GeneratedValue(generator="gen")
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "n_id")
	private Long newsId;
	
	public News() {}

	public String getNewsMes() {
		return newsMes;
	}

	public void setNewsMes(String newsMes) {
		this.newsMes = newsMes;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getNewsBrief() {
		return newsBrief;
	}

	public void setNewsBrief(String newsBrief) {
		this.newsBrief = newsBrief;
	}
	
	public Date getNewsDate() {
	return newsDate;
	}

	public void setNewsDate(Date newsDate) {
		this.newsDate = newsDate;
	}

	public Long getNewsId() {
		return newsId;
	}

	public void setNewsId(Long newsId) {
		this.newsId = newsId;
	}

}
