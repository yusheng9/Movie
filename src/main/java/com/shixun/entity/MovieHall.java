package com.shixun.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 放映厅表实体对象
 * @author Wxj
 */
@Entity
@Table(name = "movie_hall")
public class MovieHall {
	//放映厅ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long hallId;
	//放映厅名称
	@Column(length = 255)
	private String hallName;
	//放映厅容量
	@Column(length = 255)
	private String hallCapacity;
	//所有的电影场次集合
	@OneToMany
	@JoinColumn(name = "hall_id")
	private List<MovieSchedule> movieSchedule;
	
	
	public long getHallId() {
		return hallId;
	}
	public void setHallId(long hallId) {
		this.hallId = hallId;
	}
	public String getHallName() {
		return hallName;
	}
	public void setHallName(String hallName) {
		this.hallName = hallName;
	}
	public String getHallCapacity() {
		return hallCapacity;
	}
	public void setHallCapacity(String hallCapacity) {
		this.hallCapacity = hallCapacity;
	}
	public List<MovieSchedule> getMovieSchedule() {
		return movieSchedule;
	}
	public void setMovieSchedule(List<MovieSchedule> movieSchedule) {
		this.movieSchedule = movieSchedule;
	}
	@Override
	public String toString() {
		return "MovieHall [hallId=" + hallId + ", hallName=" + hallName + ", hallCapacity=" + hallCapacity
				+ ", movieSchedule=" + movieSchedule + "]";
	}
	
	
	
	
	
}
