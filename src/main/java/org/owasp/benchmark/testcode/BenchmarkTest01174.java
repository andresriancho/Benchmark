/**
* OWASP Benchmark Project v1.2beta
*
* This file is part of the Open Web Application Security Project (OWASP)
* Benchmark Project. For details, please see
* <a href="https://www.owasp.org/index.php/Benchmark">https://www.owasp.org/index.php/Benchmark</a>.
*
* The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
* of the GNU General Public License as published by the Free Software Foundation, version 2.
*
* The OWASP Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
* even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* @author Dave Wichers <a href="https://www.aspectsecurity.com">Aspect Security</a>
* @created 2015
*/

package org.owasp.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01174")
public class BenchmarkTest01174 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	
		String param = "";
		boolean flag = true;
		java.util.Enumeration<String> names = request.getHeaderNames();
		while (names.hasMoreElements() && flag) {
			String name = (String) names.nextElement();
			java.util.Enumeration<String> values = request.getHeaders(name);
			if (values != null) {
				while (values.hasMoreElements() && flag) {
					String value = (String) values.nextElement();
					if (value.equals("vector")) {
						param = name;
						flag = false;
					}
				}
			}
		}

		String bar = new Test().doSomething(param);
		
		// javax.servlet.http.HttpSession.putValue(java.lang.String^,java.lang.Object)
		request.getSession().putValue( bar, "10340");
		
		response.getWriter().println("Item: '" + org.owasp.benchmark.helpers.Utils.encodeForHTML(bar)
			+ "' with value: 10340 saved in session.");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map59153 = new java.util.HashMap<String,Object>();
		map59153.put("keyA-59153", "a_Value"); // put some stuff in the collection
		map59153.put("keyB-59153", param); // put it in a collection
		map59153.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map59153.get("keyB-59153"); // get it back out
		bar = (String)map59153.get("keyA-59153"); // get safe value back out

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
