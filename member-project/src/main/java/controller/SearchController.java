package controller;

import java.io.IOException;
import java.util.HashMap;

import org.json.JSONObject;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import view.ModelAndView;

public class SearchController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String kind = request.getParameter("kind");
		String search = request.getParameter("search");
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("msg", "테스트 메세지 "+kind + " / " + search);
		
		JSONObject json = new JSONObject(map);
		response.getWriter().println(json.toString());
		
		return null;
	}

}






