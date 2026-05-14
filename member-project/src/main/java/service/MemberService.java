package service;

import java.util.HashMap;
import java.util.List;

import config.DBManager;
import dto.MemberDTO;
import mapper.MemberMapper;

/**
 * 회원 관련 비즈니스 로직을 처리하는 서비스 클래스입니다.
 * 싱글톤 패턴으로 구현되어 프로그램 전체에서 하나의 객체만 생성됩니다.
 */
public class MemberService {
	// 1. 자기 자신의 인스턴스를 static으로 생성하여 관리합니다.
	private static MemberService instance = new MemberService();
	
	// DB 작업을 도와줄 MyBatis 매퍼
	private MemberMapper mapper;
	
	// 2. 생성자를 private으로 막아 외부에서 객체 생성을 못하게 합니다.
	private MemberService() {	
		// DBManager를 통해 세션을 열고, MemberMapper 인터페이스를 가져옵니다.
		mapper = DBManager.getInstance().getSession().getMapper(MemberMapper.class);
	}
	
	// 3. 외부에서 유일한 인스턴스를 가져갈 수 있는 메서드입니다.
	public static MemberService getInstance() {
		if(instance == null)
			instance = new MemberService();
		return instance;
	}

	/** 모든 회원 정보를 가져옵니다. */
	public List<MemberDTO> selectAllMember() {
		return mapper.selectAllMember();
	}

	/** 아이디로 특정 회원을 검색합니다. */
	public MemberDTO selectMemberById(String id) {
		return mapper.selectMemberById(id);
	}

	/** 새로운 회원을 등록(가입)합니다. */
	public int insertMember(MemberDTO memberDTO) {
		int result = 0;
		
		try {
			// 매퍼를 통해 실제 DB에 INSERT 쿼리를 실행합니다.
			result = mapper.insertMember(memberDTO);
		}catch (Exception e) {
			// 오류 발생 시 콘솔에 출력합니다.
			e.printStackTrace();
		}
		
		return result;
	}

	/** 로그인을 시도합니다. 아이디와 비밀번호가 맞으면 회원 정보를 반환합니다. */
	public MemberDTO login(String id, String passwd) {
		// MyBatis에 여러 데이터를 보낼 때 Map에 담아서 전달합니다.
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("passwd", passwd);
		
		MemberDTO dto = mapper.login(map);
		
		return dto;
	}

	/** 회원 번호로 회원을 삭제합니다. */
	public int deleteMember(String no) {
		return mapper.deleteMember(no);
	}
}
