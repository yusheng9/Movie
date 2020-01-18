package com.shixun.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * 	电影实体
 * @author Y
 *
 */
@Entity
@Table(name = "movie_film")
public class MovieFilm {
	//电影ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long filmId;
	//电影名称
	@Column(length = 255)
	private String filmName;
	//副标题
	@Column(length = 255)
	private String subtitle;
	//简介
	@Column(length = 255)
	private String filmIntro;
	//类型
	@ManyToMany
	@JoinColumn(name = "film_id")
	@JoinColumn(name = "st_id")
	private List<Secondtype> secondtype;
	//电影路径
	@Column(length = 255)
	private String filmPath;
	//电影连接
	@Column(length = 255)
	private String filmUrl;
	//电影图片
	@Column(length = 255)
	private String filmImg;
	//上映时间
	@Column(length = 255)
	private String releaseTime;
	//上传时间
	@Column(length = 255)
	private String uploadTime;
	//上传人
	@Column(length = 255)
	private String uploadUser;
	public long getFilmId() {
		return filmId;
	}
	public void setFilmId(long filmId) {
		this.filmId = filmId;
	}
	public String getFilmName() {
		return filmName;
	}
	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public String getFilmIntro() {
		return filmIntro;
	}
	public void setFilmIntro(String filmIntro) {
		this.filmIntro = filmIntro;
	}
	public List<Secondtype> getSecondtype() {
		return secondtype;
	}
	public void setSecondtype(List<Secondtype> secondtype) {
		this.secondtype = secondtype;
	}
	public String getFilmPath() {
		return filmPath;
	}
	public void setFilmPath(String filmPath) {
		this.filmPath = filmPath;
	}
	public String getFilmUrl() {
		return filmUrl;
	}
	public void setFilmUrl(String filmUrl) {
		this.filmUrl = filmUrl;
	}
	public String getFilmImg() {
		return filmImg;
	}
	public void setFilmImg(String filmImg) {
		this.filmImg = filmImg;
	}
	public String getReleaseTime() {
		return releaseTime;
	}
	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}
	public String getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}
	public String getUploadUser() {
		return uploadUser;
	}
	public void setUploadUser(String uploadUser) {
		this.uploadUser = uploadUser;
	}
	@Override
	public String toString() {
		return "MovieFilm [filmId=" + filmId + ", filmName=" + filmName + ", subtitle=" + subtitle + ", filmIntro="
				+ filmIntro + ", secondtype=" + secondtype + ", filmPath=" + filmPath + ", filmUrl=" + filmUrl
				+ ", filmImg=" + filmImg + ", releaseTime=" + releaseTime + ", uploadTime=" + uploadTime
				+ ", uploadUser=" + uploadUser + "]";
	}
	
	
	
	
	
}
