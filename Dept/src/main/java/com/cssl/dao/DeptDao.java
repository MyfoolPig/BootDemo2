package com.cssl.dao;

import java.util.*;
import com.cssl.entity.*;

public interface DeptDao {

	List<Dept> selectAll();

    int selectCount();

	List<Dept> selectPage(Map<String, Object> mp);
	
	Dept selectByPrimaryKey(Integer deptno) ;
	
	int insert(Dept d2);

	int deleteByList(List<String> list);

	int deleteByPrimaryKey(Integer deptno);
	
	int updateByPrimaryKey(Dept d2);
}
