package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * [파일 업로드 처리 서블릿]
 * 사용자가 보낸 파일 데이터를 서버 저장소에 기록하는 역할을 수행합니다.
 */
@WebServlet("/fileUpload.do")
/*
 * [@MultipartConfig]: 파일 업로드를 지원하기 위한 설정 어노테이션
 * - maxRequestSize: 전체 요청 데이터의 최대 크기 (50MB)
 * - maxFileSize: 개별 파일 하나의 최대 크기 (5MB)
 */
@MultipartConfig(maxRequestSize = 1024*1024*50 ,maxFileSize = 1024*1024*5)
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FileUploadServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 파일이 저장될 물리적인 경로를 설정합니다.
		// c 드라이브 하위의 fileupload 폴더를 사용합니다.
		File root = new File("c:\\fileupload"); 
		
		// 2. 해당 폴더가 실제로 존재하는지 확인하고, 없으면 생성합니다.
		if(!root.exists()) {
			System.out.println("업로드 폴더가 없어 생성합니다: " + root.getAbsolutePath());
			root.mkdirs(); // 하위 폴더까지 모두 생성
		}
		
		// 3. request.getParts(): 클라이언트가 보낸 모든 파트(텍스트, 파일들)를 가져옵니다.
		// Iterator를 사용해 하나씩 꺼내어 처리합니다.
		Iterator<Part> it = request.getParts().iterator();
		
		while(it.hasNext()) {
			Part p = it.next(); // 데이터 조각 하나를 꺼냄
			
			// 4. 꺼낸 데이터가 '파일'인지 확인합니다. (파일명이 있으면 파일임)
			if(p.getSubmittedFileName() != null && !p.getSubmittedFileName().isEmpty()) {
				System.out.println("파라미터명: " + p.getName());
				System.out.println("파일 크기: " + p.getSize() + " bytes");
				System.out.println("원본 파일명: " + p.getSubmittedFileName());
				
				// 5. 서버 컴퓨터의 물리적 경로에 파일을 실제로 기록합니다.
				// p.write("경로/파일명") 형식을 사용합니다.
				p.write(root.getAbsolutePath() + "\\" + p.getSubmittedFileName());
				System.out.println("파일 저장 완료!");
			} else {
				// 6. 파일이 아닌 일반 텍스트 데이터(input type="text")일 경우 처리
				// request.getParameter()로 기존 방식처럼 읽을 수 있습니다.
				System.out.println("일반 데이터: " + p.getName() + " = " + request.getParameter(p.getName()) );
			}
		}
		
		// 처리가 끝나면 간단한 응답을 보냅니다.
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println("파일 업로드 처리가 완료되었습니다.");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
