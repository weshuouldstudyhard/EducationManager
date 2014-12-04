package cn.edu.fjnu.cdio4.xplan.other;

import java.sql.Date;

import javax.servlet.http.HttpSession;

import org.junit.Test;

/**
 *类的作用：
 *
 *
 *@author 一叶扁舟
 *@version 1.0
 *@创建时间： 2014-11-30   下午2:17:55
 */
public class TestMethod {
	//获取系统当前时间
	@Test
	public void testGetTime(){
		Long strLong = System.currentTimeMillis();
		strLong.toString();
		System.out.println(System.currentTimeMillis());
		
	}

}
