package service;

import java.util.HashMap;
import java.util.List;

import config.DBManager;
import dto.BoardDTO;
import dto.BoardFileDTO;
import mapper.BoardMapper;

public class BoardService {
	private static BoardService instance = new BoardService();
	private BoardMapper mapper;
	
	public BoardService() {
		mapper = DBManager.getInstance().getSession().getMapper(BoardMapper.class);
	}
	
	public static BoardService getInstance() {
		if(instance == null)
			instance = new BoardService();
		return instance;
	}

	public List<BoardDTO> selectBoardList(int page) {
		return mapper.selectBoardList(page);
	}

	public int insertBoard(BoardDTO board) {
		return mapper.insertBoard(board);
	}

	public int insertBoardFile(List<BoardFileDTO> list) {
		return mapper.insertBoardFile(list);
	}

	public int selectBoardCount() {
		return mapper.selectBoardCount();
	}

	public BoardDTO selectBoard(int bno) {
		return mapper.selectBoard(bno);
	}

	public List<BoardFileDTO> selectFileList(int bno) {
		return mapper.selectFileList(bno);
	}

	public int updateBoardCount(int bno) {
		return mapper.updateBoardCount(bno);
	}

	public int insertBoardLike(int no, int bno) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("bno", bno);
		map.put("mno", no);
		return mapper.insertBoardLike(map);
	}

	public int deleteBoardLike(int no, int bno) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("bno", bno);
		map.put("mno", no);
		return mapper.deleteBoardLike(map);
	}

	public int boardLikeCount(int bno) {
		return mapper.boardLikeCount(bno);
	}
}






