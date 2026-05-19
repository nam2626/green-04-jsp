package mapper;

import java.util.HashMap;
import java.util.List;

import dto.BoardDTO;
import dto.BoardFileDTO;

public interface BoardMapper {

	List<BoardDTO> selectBoardList(int page);

	int insertBoard(BoardDTO board);

	int insertBoardFile(List<BoardFileDTO> list);

	int selectBoardCount();

	BoardDTO selectBoard(int bno);

	List<BoardFileDTO> selectFileList(int bno);

	int updateBoardCount(int bno);

	int insertBoardLike(HashMap<String, Integer> map);

	int deleteBoardLike(HashMap<String, Integer> map);

	int selectBoardLikeCount(int bno);

}




