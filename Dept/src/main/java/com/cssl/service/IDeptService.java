package com.cssl.service;

import java.util.*;

import com.cssl.entity.*;

public interface IDeptService {

    List<Dept> selectAll();

	int selectCount();

	List<Dept> selectPage(Map<String, Object> mp);

	Dept selectByPrimaryKey(Integer deptno) ;
	
	int insert(Dept d2);
	
	int deleteByPrimaryKey(Integer deptno);

	int deleteByList(List<String> list);

	int updateByPrimaryKey(Dept d2);
}
