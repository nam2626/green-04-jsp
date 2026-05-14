package mapper;

import java.util.List;

import dto.MemberDTO;

public interface MemberMapper {

	List<MemberDTO> selectAllMember();

	MemberDTO selectMemberById(String id);

	int insertMember(MemberDTO memberDTO);

}
