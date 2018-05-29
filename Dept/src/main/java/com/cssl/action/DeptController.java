package com.cssl.action;

import com.cssl.entity.*;
import com.alibaba.fastjson.JSON;
import java.util.*;
import java.io.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.cssl.service.*;
import javax.servlet.http.HttpServletResponse;

@Controller
public class DeptController {
	@Autowired
	private IDeptService ds;

	@RequestMapping(value="/deptList",produces={"application/json; charset=UTF-8"})
	@ResponseBody
	public Object deptList(String page,String rows,String sort,String order) throws Exception{
		System.out.println(" --- deptList ");
		System.out.println(" --- page :"+page);
		System.out.println(" --- rows :"+rows);
		System.out.println(" --- sort :"+sort);
		System.out.println(" --- order :"+order);
		//取数据
		//List<Dept> list = ds.selectAll();
		int size = ds.selectCount();

		Map<String,Object> mp = new HashMap<String,Object>();
		mp.put("starts",(Integer.valueOf(page)-1)*Integer.valueOf(rows));
		mp.put("sizes",Integer.valueOf(rows));

		List<Dept> list = ds.selectPage(mp);
        //封装数据
		GridData gd = new GridData();
		         gd.setRows(list);
                 gd.setTotal(size);
        //转json
		String js = JSON.toJSONString(gd);
		System.out.println("json :"+js);

		return js;
	}

	@RequestMapping(value="/deptOne",produces={"application/json; charset=UTF-8"})
	@ResponseBody
	public Object deptOne(String dno,String type) throws Exception{
		System.out.println(" --- deptOne ");
		System.out.println(" --- dno :"+dno);
		System.out.println(" --- type :"+type);

		//取数据
		Dept d2 = ds.selectByPrimaryKey(Integer.valueOf(dno));

		//转json
		String js = JSON.toJSONString(d2);
		System.out.println("json :"+js);

		return js;
	}

	@RequestMapping("/deptDelete")
	public void deptDelete(Integer dno, HttpServletResponse response) throws Exception{
		System.out.println(" --- deptDelete dno :"+dno);
		PrintWriter out = response.getWriter();

		int num = ds.deleteByPrimaryKey(dno);
		out.print(""+num);

		out.flush();
		out.close();
	}

	@RequestMapping("/deptDeleteCheck")
	public void deptDeleteCheck(String dnos, HttpServletResponse response) throws Exception{
		System.out.println(" --- deptDeleteCheck dnos :"+dnos);
		PrintWriter out = response.getWriter();
		if(dnos.endsWith(",")){
			dnos= dnos.substring(0,dnos.length()-1);
		}
		System.out.println(" --- deptDeleteCheck dnos :"+dnos);
		List<String> list = Arrays.asList(dnos);
		System.out.println(" --- deptDeleteCheck list :"+list);

		int num = ds.deleteByList(list);
		out.print(""+num);

		out.flush();
		out.close();
	}

	@RequestMapping("/deptUpdate")
	public void deptUpdate(Dept d2, HttpServletResponse response) throws Exception{
		System.out.println(" --- deptUpdate d2 :"+d2);
		PrintWriter out = response.getWriter();

		int num = ds.updateByPrimaryKey(d2);
		out.print(""+num);

		out.flush();
		out.close();
	}
	
	@RequestMapping("/deptAdd")
	public void deptAdd(Dept d2, HttpServletResponse response) throws Exception{
		System.out.println(" --- deptAdd d2 :"+d2);
		System.out.println(" --- deptAdd d2 jointime:"+d2.getJoinTime());
        PrintWriter out = response.getWriter();
		//int num = 1;
		int num = ds.insert(d2);

		out.print(""+num);

		out.flush();
		out.close();
	}
}
