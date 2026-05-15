package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * [파일 다운로드 처리 서블릿]
 * 서버에 저장된 파일을 읽어서 클라이언트(브라우저)로 전송합니다.
 */
@WebServlet("/fileDown.do")
public class FileDownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FileDownServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 어떤 파일을 다운로드할지 파라미터를 읽어옵니다. (현재는 테스트용)
		int bno = Integer.parseInt(request.getParameter("bno"));
		int fno = Integer.parseInt(request.getParameter("fno"));
		
		// 2. 실제 파일이 저장된 물리적인 경로를 지정합니다.
		String path = "c:\\fileupload\\car.csv";
		File file = new File(path);
		
		// 3. 응답 헤더(Response Header) 설정
		// 브라우저에게 "이 데이터는 화면에 보여주지 말고 파일로 저장(다운로드)해라"라고 알려줍니다.
		// Content-Disposition: attachment;fileName=... -> 다운로드 창을 띄우는 핵심 설정
		response.setHeader("Content-Disposition", "attachment;fileName=" + file.getName());
		// Content-Transfer-Encoding: binary -> 이진 데이터(파일) 형식임을 명시
		response.setHeader("Content-Transfer-Encoding", "binary");
		// 파일의 전체 크기를 설정하여 다운로드 진행 바가 정상 표시되게 합니다.
		response.setContentLengthLong(file.length());
		
		// 4. 파일을 읽어서 브라우저로 내보내는 작업 (스트림 사용)
		// FileInputStream: 파일로부터 데이터를 읽어옵니다.
		// BufferedOutputStream: 성능 향상을 위해 버퍼를 사용하여 응답 스트림에 데이터를 씁니다.
		try(FileInputStream fis = new FileInputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream())){
			
			// 1MB 크기의 바구니(버퍼)를 준비합니다.
			byte[] buffer = new byte[1024*1024];
			
			while(true) {
				// 파일에서 데이터를 읽어 버퍼에 채웁니다.
				int size = fis.read(buffer);
				// 더 이상 읽을 데이터가 없으면(-1) 반복문을 종료합니다.
				if(size == -1) break;
				
				// 버퍼에 담긴 데이터를 응답 출력 스트림에 씁니다.
				bos.write(buffer, 0, size);
				// 버퍼에 남은 데이터를 즉시 전송합니다.
				bos.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}





