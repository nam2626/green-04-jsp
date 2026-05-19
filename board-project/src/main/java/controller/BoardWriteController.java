package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dto.BoardDTO;
import dto.BoardFileDTO;
import dto.MemberDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import service.BoardService;
import view.ModelAndView;

/**
 * 게시글 작성 및 파일 업로드를 처리하는 컨트롤러입니다.
 * 사용자가 글쓰기 폼에서 '저장'을 누르면 실행됩니다.
 */
public class BoardWriteController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 1. 현재 로그인한 사용자의 계정 정보(회원번호)를 세션에서 읽어옵니다.
		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO) session.getAttribute("user");
		int mno = member.getNo(); // 작성자의 회원번호
		
		// 2. 글쓰기 폼에서 입력한 제목과 내용을 받아옵니다.
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		// 3. 받아온 데이터를 BoardDTO 객체에 담습니다.
		BoardDTO board = new BoardDTO();
		board.setMno(mno);
		board.setTitle(title);
		board.setContent(content);
		
		// 4. DB의 board 테이블에 게시글 데이터를 등록합니다.
		// (이 때, insert 문에서 생성된 게시글 번호(bno)가 board 객체에 자동으로 채워집니다.)
		BoardService.getInstance().insertBoard(board);
		
		System.out.println(board); // 확인용 콘솔 출력
		
		// 5. 파일 업로드(쓰기) 처리
		try {
			// 업로드할 파일이 저장될 실제 컴퓨터 폴더 경로를 지정합니다.
			File root = new File("c:\\fileupload");
			
			// 해당 경로의 폴더가 없으면 새로 만듭니다.
			if(!root.exists()) {
				root.mkdirs();
			}
			
			// 업로드된 파일들의 정보(게시글 번호, 저장 경로)를 보관할 리스트를 만듭니다.
			List<BoardFileDTO> list = new ArrayList<>();
			
			// 사용자가 폼에서 전송한 파일 조각(Parts)들을 하나씩 확인합니다.
			request.getParts().forEach(part -> {
				// 파일 이름이 없거나 파일 크기가 0이면 무시하고 넘어갑니다.
				if(part.getSubmittedFileName() == null || part.getSize() == 0) return;
				
				// 저장할 폴더 경로와 파일 이름을 합쳐서 최종 저장 경로(path)를 만듭니다.
				String path = root.getAbsolutePath() + 
						File.separator + part.getSubmittedFileName();
				try {
					// 지정한 경로에 실제 파일을 저장합니다.
					part.write(path);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				// 저장된 파일 정보를 리스트에 추가합니다. (방금 작성한 글의 번호 bno 사용)
				list.add(new BoardFileDTO(board.getBno(), path));
			});
			
			System.out.println(list); // 확인용 콘솔 출력
			
			// 첨부파일이 하나라도 있다면 DB의 board_file 테이블에 파일 내용들을 등록합니다.
			if(!list.isEmpty()) {
				BoardService.getInstance().insertBoardFile(list);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
		
		// 6. 글쓰기와 파일 업로드가 끝나면 메인 게시판 목록으로 리다이렉트(이동)합니다.
		return new ModelAndView("./main.do", true);
	}

}







