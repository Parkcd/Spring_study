package com.spring.ex03;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class MemberTest1 {

	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("member.xml")); //Bean을 넣을 컨테이너 생성
		MemberService service = (MemberService) factory.getBean("memberService"); // id가 memberService인 빈을 가져 오는것
		service.listMembers();
		

	}

}
