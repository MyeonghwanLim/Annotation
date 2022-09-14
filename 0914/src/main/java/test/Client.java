package test;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.lim.biz.board.BoardService;
import com.lim.biz.board.BoardVO;
import com.lim.biz.member.MemberService;
import com.lim.biz.member.MemberVO;

public class Client {
	public static void main(String[] args) {
		// Spring 컨테이너를 동작시킬수있도록 코드작성
//		TestBean tb = (TestBean)factory.getBean("tb");
//		Map<String,String> datas=tb.getDatas();
//		System.out.println(datas);
//		factory.close();
		
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		BoardService bs=(BoardService)factory.getBean("boardService");
		
		BoardVO vo =new BoardVO();
		Scanner sc = new Scanner(System.in);
		System.out.println("글 내용 작성");
		String msg = sc.nextLine();
		vo.setContent(msg);
		vo.setTitle("글 제목");
		vo.setWriter("작은 티모");
		bs.insertBoard(vo);
		
		List<BoardVO> datas=bs.selectAllBoard(vo);
		for(BoardVO v:datas) {
			System.out.println(v);
		}
		
		MemberService mbs=(MemberService)factory.getBean("memberService");
		
		MemberVO mvo = new MemberVO();
		System.out.println("아이디입력하세요");
		String id = sc.nextLine();
		System.out.println("비밀번호 입력하세요");
		String pw = sc.nextLine();
		System.out.println("이름을 입력하세요");
		String name = sc.nextLine();
		System.out.println("등급을 입력하세요.");
		String role = sc.nextLine();
		mvo.setMid(id);
		mvo.setMpw(pw);
		mvo.setName(name);
		mvo.setRole(role);
		mbs.insert(mvo);
		
		System.out.println("전체 회원출력");
		List<MemberVO> mdatas=mbs.selectAll(mvo);
		for(MemberVO v:mdatas) {
			System.out.println(v);
		}
		
		while(true) {
			MemberVO lvo = new MemberVO();
		
		System.out.println("아이디입력해주세요");
		String lid = sc.nextLine();
		System.out.println("비밀번호 입력해주세요");
		String lpw = sc.nextLine();
		
		lvo.setMid(lid);
		lvo.setMpw(lpw);
		lvo=mbs.selectOne(lvo);
		
		if(lvo!=null) {
			System.out.println("로그인성공");
			break;
		}
		else {
			System.out.println("로그인실패");
			continue;
		}
		
		}
		
		
		// Spring 컨테이너야, 나 폰 객체를 가지고싶어!
		// == Lookup == 객체요청: 컨테이너야? 가지고있는 객체중에 이름이 "phone"인 객체를 줘!
//		Phone phone=(Phone)factory.getBean("gp");
//		phone.powerOn();
//		phone.volumeUp();
//		phone.volumeDown();
//		phone.powerOff();
//		factory.close();
		
		/*
		BeanFactory bf=new BeanFactory();
		Phone phone=(Phone)bf.getBean(args[0]);
		phone.powerOn();
		phone.volumeUp();
		phone.volumeDown();
		phone.powerOff();
		*/
	}
}
