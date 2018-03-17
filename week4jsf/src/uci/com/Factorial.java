package uci.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Factorial
 */
@WebServlet("/Factorial")
public class Factorial extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Factorial() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		long facRes ;
		java.util.Date today = new java.util.Date();
		StringBuffer factorialTableTop = new StringBuffer();
		factorialTableTop.append("<html>")
		.append("<body>").append("<table border=2>")
		.append("<tr><td>Number</td><td>Factorial</td></tr>")
		.append("<tr><td>0</td><td>1</td></tr>");
		
		
		for(int i=1;i<=15;i++) {
			facRes = computeFactorial(i);
			//out.println(i+ " : " + facRes);
			factorialTableTop.append("<tr><td>") 
			.append(i).append("</td><td>").append(facRes).append("</td></tr>");
		}
		factorialTableTop.append("</table>").append("</body>")
		.append("</html>");
		out.println(factorialTableTop.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private long computeFactorial(int n) {
		   //TODO - Enter your logic here
		long res = n;
		for(int i=1;i<n;i++) {
			res = res * (n-i);
		}
		return res;
		  }

}
