package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17925")
public class BenchmarkTest17925 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> names = request.getParameterNames();
		if (names.hasMoreElements()) {
			param = names.nextElement(); // just grab first element
		}

		String bar = doSomething(param);
		
		java.io.File file = new java.io.File(bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map10732 = new java.util.HashMap<String,Object>();
		map10732.put("keyA-10732", "a_Value"); // put some stuff in the collection
		map10732.put("keyB-10732", param.toString()); // put it in a collection
		map10732.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map10732.get("keyB-10732"); // get it back out
		bar = (String)map10732.get("keyA-10732"); // get safe value back out
	
		return bar;	
	}
}