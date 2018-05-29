package com.cssl.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.*;

public class Dept {
    private Integer deptno;

    private String dname;

    private String loc;

    private Date joinTime;

    public Date getJoinTime() {
        return joinTime;
    }

    @DateTimeFormat( pattern = "yyyy-MM-dd")
    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname == null ? null : dname.trim();
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc == null ? null : loc.trim();
    }

	public String toString() {
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc
				+ "]";
	}
  
}