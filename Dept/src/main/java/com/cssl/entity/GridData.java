package com.cssl.entity;

import java.util.*;

public class GridData {

	private int total;
	
	private List<Dept> rows ;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<Dept> getRows() {
		return rows;
	}

	public void setRows(List<Dept> rows) {
		this.rows = rows;
	}

	public GridData() {
		
	}

	public GridData(int total, List<Dept> rows) {
		this.total = total;
		this.rows = rows;
	}
	
}
