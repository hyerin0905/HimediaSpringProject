package spring;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

//모든 멤버 정보를 조회해서,	=> MemberDao 
//멤버 하나 하나의 정보를 출력	=> MemberPrinter

public class MemberListPrinter {

	private MemberDao memberDao;
	private MemberPrinter printer;
	
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	@Autowired
	// @Qualifier("printer")  
	public void setPrinter(MemberSummaryPrinter printer) {
		this.printer = printer;
	}
	
	public MemberListPrinter() {
		
	}
	// 의존 객체를 생성자를 통해서 주입
	public MemberListPrinter(MemberDao memberDao, MemberPrinter printer) {
		this.memberDao = memberDao;
		this.printer = printer;
	}
	
	// 모든 멤버 정보를 출력하는 메서드를 정의
	public void printAll() {
		Collection<Member> members = memberDao.selectAll();
		
		// members.forEach(member -> printer.print(member));
		//                 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		//                 람다식
		
		for (Member member : members) {
			printer.print(member);
		}		
	}

}
