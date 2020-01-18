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
 * 场次表实体对象
 * @author Wxj
 */
@Entity
@Table(name = "movie_schedule")
public class MovieSchedule {
	//场次Id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long scheduleId;
	//电影放映时间
	@Column(length = 255)
	private String scheduleStartTime;
	//售价
	private int schedulePrice;
	//剩余座位数
	@Column(length = 255)
	private String scheduleRemain;
	//场次状态 1：上映中 0：下架
	private int scheduleState;
	/*//所属放映厅对象
	@ManyToOne
	@JoinColumn(name = "hall_id")
	private MovieHall movieHall;*/
	//放映的电影
	@ManyToOne
	@JoinColumn(name = "film_id")
	private MovieFilm movieFilm;
	//所有的订单集合
	@OneToMany
	@JoinColumn(name = "schedule_id")
	private List<MovieOrder> movieOrder;
	
	
	public long getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(long scheduleId) {
		this.scheduleId = scheduleId;
	}
	public String getScheduleStartTime() {
		return scheduleStartTime;
	}
	public void setScheduleStartTime(String scheduleStartTime) {
		this.scheduleStartTime = scheduleStartTime;
	}
	public int getSchedulePrice() {
		return schedulePrice;
	}
	public void setSchedulePrice(int schedulePrice) {
		this.schedulePrice = schedulePrice;
	}
	public String getScheduleRemain() {
		return scheduleRemain;
	}
	public void setScheduleRemain(String scheduleRemain) {
		this.scheduleRemain = scheduleRemain;
	}
	public int getScheduleState() {
		return scheduleState;
	}
	public void setScheduleState(int scheduleState) {
		this.scheduleState = scheduleState;
	}
	public MovieFilm getMovieFilm() {
		return movieFilm;
	}
	public void setMovieFilm(MovieFilm movieFilm) {
		this.movieFilm = movieFilm;
	}
	public List<MovieOrder> getMovieOrder() {
		return movieOrder;
	}
	public void setMovieOrder(List<MovieOrder> movieOrder) {
		this.movieOrder = movieOrder;
	}
	@Override
	public String toString() {
		return "MovieSchedule [scheduleId=" + scheduleId + ", scheduleStartTime=" + scheduleStartTime
				+ ", schedulePrice=" + schedulePrice + ", scheduleRemain=" + scheduleRemain + ", scheduleState="
				+ scheduleState + ", movieFilm=" + movieFilm + ", movieOrder=" + movieOrder + "]";
	}
	
	
	
}
