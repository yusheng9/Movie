package com.shixun.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 电影院表实体对象
 * @author Wxj
 */
@Entity
@Table(name = "movie_cinema")
public class MovieCinema {
	//影院ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cinemaId;
    //影院名称
	@Column(length = 255)
	private String cinemaName;
	//影院名称
	@Column(length = 255)
	private String cinemaAddress;
	//所有的放映厅集合
	@OneToMany
	@JoinColumn(name = "cinema_id")
	private List<MovieHall> movieHall;
	public long getCinemaId() {
		return cinemaId;
	}
	public void setCinemaId(long cinemaId) {
		this.cinemaId = cinemaId;
	}
	public String getCinemaName() {
		return cinemaName;
	}
	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}
	public String getCinemaAddress() {
		return cinemaAddress;
	}
	public void setCinemaAddress(String cinemaAddress) {
		this.cinemaAddress = cinemaAddress;
	}
	public List<MovieHall> getMovieHall() {
		return movieHall;
	}
	public void setMovieHall(List<MovieHall> movieHall) {
		this.movieHall = movieHall;
	}
	@Override
	public String toString() {
		return "MovieCinema [cinemaId=" + cinemaId + ", cinemaName=" + cinemaName + ", cinemaAddress=" + cinemaAddress
				+ ", movieHall=" + movieHall + "]";
	}
	
	
	
	
}
