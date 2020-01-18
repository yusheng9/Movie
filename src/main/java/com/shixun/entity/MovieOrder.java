package com.shixun.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 订单表实体对象
 * @author Y
 *
 */
@Entity
@Table(name = "movie_order")
public class MovieOrder {
	//订单Id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderId;
	//电影票座位信息
	@Column(length = 255)
	private String orderPosition; 
	//订单状态 0：退票中 -1：无法退票  1：已支付 2：退票成功
	private int orderState;
	//订单价格
	private int orderPrice;
	//订单支付时间
	@Column(length = 255)
	private String orderTime;
	//所属用户对象 
	@ManyToOne
	@JoinColumn(name = "user_id")
	private MovieUser movieUser;
//	//所属电影场次 所属场次编号,通过schedule_id-》场次信息-》放映厅信息+电影信息
//	@ManyToOne
//	@JoinColumn(name = "schedule_id")
//	private MovieSchedule movieSchedule;
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public String getOrderPosition() {
		return orderPosition;
	}
	public void setOrderPosition(String orderPosition) {
		this.orderPosition = orderPosition;
	}
	public int getOrderState() {
		return orderState;
	}
	public void setOrderState(int orderState) {
		this.orderState = orderState;
	}
	public int getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public MovieUser getMovieUser() {
		return movieUser;
	}
	public void setMovieUser(MovieUser movieUser) {
		this.movieUser = movieUser;
	}
	@Override
	public String toString() {
		return "MovieOrder [orderId=" + orderId + ", orderPosition=" + orderPosition + ", orderState=" + orderState
				+ ", orderPrice=" + orderPrice + ", orderTime=" + orderTime + ", movieUser=" + movieUser + "]";
	}
	
	
	
}
