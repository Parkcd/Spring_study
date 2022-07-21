package com.spring.ex02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class UserController extends MultiActionController {
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userID = "";
		String passwd = "";
		String viewName = getViewName(request); //getViewName 메소드 하는역할은 주소앞에 http://localhost8090/pro21/test 까지 짤라주고 뒤에는 do 짤라줌.
		
		ModelAndView mav = new ModelAndView();
		request.setCharacterEncoding("utf-8");
		userID = request.getParameter("userID");
		passwd = request.getParameter("passwd");
	
		mav.addObject("userID", userID);
		mav.addObject("passwd", passwd);
		//mav.setViewName("result");
		mav.setViewName(viewName);
		//System.out.println("viewName:" + viewName);
		return mav;
	}
	
	
	public ModelAndView memberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
	    ModelAndView mav=new ModelAndView();
	    String id=request.getParameter("id");
	    String pwd=request.getParameter("pwd");
	    String name=request.getParameter("name");
	    String email=request.getParameter("email");

	    mav.addObject("id",id);
	    mav.addObject("pwd",pwd);
	    mav.addObject("name",name);
	    mav.addObject("email",email);
	    mav.setViewName("memberInfo");
	    return mav;
	}
	
	
	public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		return new ModelAndView(viewName);
	}
	
	
	public ModelAndView memberForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		return new ModelAndView(viewName);
	}
	 
	private  String getViewName(HttpServletRequest request) throws Exception { //getViewName 메소드 하는역할은 주소앞에 http://localhost8090/pro21/test 까지 짤라주고 뒤에는 jsp 짤라줌. 그래서 jsp 파일명만 남김
	      String contextPath = request.getContextPath();
	    //  System.out.println("contextPath:" + contextPath);
	     
	      String uri = (String)request.getAttribute("javax.servlet.include.request_uri");
	    //  System.out.println("uri:" + uri);
	      
	      if(uri == null || uri.trim().equals("")) {
	         uri = request.getRequestURI();
	      }

	      int begin = 0;
	      if(!((contextPath==null)||("".equals(contextPath)))){
	         begin = contextPath.length();
	   //      System.out.println("begin:" + begin);
	      }
	      
	   //   System.out.println("uri:" + uri);
	      int end;
	      if(uri.indexOf(";")!=-1){ //indexOf의 역할은 위치를 찾는것
	         end=uri.indexOf(";");
	      }else if(uri.indexOf("?")!=-1){
	         end=uri.indexOf("?");
	      }else{
	         end=uri.length();
	      }
	    //  System.out.println("end:" + end);

	      String fileName=uri.substring(begin,end);
	      if(fileName.indexOf(".")!=-1){
	         fileName=fileName.substring(0,fileName.lastIndexOf("."));
	      }
	      if(fileName.lastIndexOf("/")!=-1){
	         fileName=fileName.substring(fileName.lastIndexOf("/"),fileName.length());
	      }
	      
	    //  System.out.println("fileName:" + fileName);
	      return fileName;
	   }

    
}
