package com.crm;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "performance")
public class Performance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employeeId;

    private int productivityScore;
    private int attendanceScore;
    private int teamworkScore;
	public Performance() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Performance(long employeeId, int productivityScore, int attendanceScore, int teamworkScore) {
		super();
		this.employeeId = employeeId;
		this.productivityScore = productivityScore;
		this.attendanceScore = attendanceScore;
		this.teamworkScore = teamworkScore;
	}
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public int getProductivityScore() {
		return productivityScore;
	}
	public void setProductivityScore(int productivityScore) {
		this.productivityScore = productivityScore;
	}
	public int getAttendanceScore() {
		return attendanceScore;
	}
	public void setAttendanceScore(int attendanceScore) {
		this.attendanceScore = attendanceScore;
	}
	public int getTeamworkScore() {
		return teamworkScore;
	}
	public void setTeamworkScore(int teamworkScore) {
		this.teamworkScore = teamworkScore;
	}

    
}

