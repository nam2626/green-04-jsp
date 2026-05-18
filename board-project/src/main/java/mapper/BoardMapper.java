package mapper;

import java.util.List;

import dto.BoardDTO;

public interface BoardMapper {

	List<BoardDTO> selectBoardList(int page);

	int insertBoard(BoardDTO board);

}
