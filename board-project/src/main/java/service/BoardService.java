package service;

import java.util.List;

import config.DBManager;
import dto.BoardDTO;
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
}






