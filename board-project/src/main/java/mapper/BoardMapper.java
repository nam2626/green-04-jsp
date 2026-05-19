package mapper;

import java.util.List;

import dto.BoardDTO;
import dto.BoardFileDTO;

public interface BoardMapper {

	List<BoardDTO> selectBoardList(int page);

	int insertBoard(BoardDTO board);

	int insertBoardFile(List<BoardFileDTO> list);

	int selectBoardCount();

}
