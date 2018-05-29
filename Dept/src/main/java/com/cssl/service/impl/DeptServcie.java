package com.cssl.service.impl;

import java.util.*;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cssl.entity.*;
import com.cssl.service.IDeptService;
import com.cssl.dao.*;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@MapperScan(basePackages = "com.cssl.dao")
@Service("deptServcie")  //
public class DeptServcie implements IDeptService{

	@Autowired
	private DeptDao dao;

	public Dept selectByPrimaryKey(Integer deptno) {
		
		return dao.selectByPrimaryKey(deptno);
	}

	public int selectCount() {
		return dao.selectCount();
	}

	public List<Dept> selectPage(Map<String, Object> mp) {
		return dao.selectPage(mp);
	}

	public List<Dept> selectAll() {
		
		return dao.selectAll();
	}

	public int insert(Dept d2) {
		
		return dao.insert(d2);
	}

	public int deleteByPrimaryKey(Integer deptno) {
		
		return dao.deleteByPrimaryKey(deptno);
	}

	public int updateByPrimaryKey(Dept d2) {
		
		return dao.updateByPrimaryKey(d2);
	}

	public int deleteByList(List<String> list) {
		return dao.deleteByList(list);
	}
}
