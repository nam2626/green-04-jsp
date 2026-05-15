package mapper;

import java.util.HashMap;
import java.util.List;

import dto.MemberDTO;

/**
 * MyBatis 매퍼 인터페이스입니다.
 * member-mapper.xml에 정의된 SQL 쿼리들과 연결됩니다.
 */
public interface MemberMapper {

	/** 전체 회원 목록 조회 */
	List<MemberDTO> selectAllMember();

	/** 아이디로 특정 회원 정보 조회 */
	MemberDTO selectMemberById(String id);

	/** 새 회원 등록 */
	int insertMember(MemberDTO memberDTO);

	/** 로그인 처리 (아이디와 비밀번호 확인) */
	MemberDTO login(HashMap<String, String> map);

	/** 회원 번호로 회원 삭제 */
	int deleteMember(String no);

	List<MemberDTO> searchMembers(HashMap<String, String> map);

}
