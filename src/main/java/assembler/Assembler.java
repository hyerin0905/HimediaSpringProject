package assembler;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberRegisterService;

public class Assembler {

	// 실행에 필요한 객체를 필드로 정의
	private MemberDao memberDao;
	private MemberRegisterService reqSvc;
	private ChangePasswordService pwdSvc;
	
	// 이 프로그램에서 필요한 모든 정보를 만들어줌
	public Assembler() {
		memberDao = new MemberDao();
		reqSvc = new MemberRegisterService(memberDao);
		pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao);
	}
	
	
	public MemberDao getMemberDao() {
		return this.memberDao;
	}
	public MemberRegisterService getMemberRegisterService() {
		return this.reqSvc;
	}
	public ChangePasswordService getChangePasswordService() {
		return this.pwdSvc;
	}



	}

