package CurrencyConverter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.print.DocFlavor.STRING;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Converter
 */
@WebServlet(description = "CurrencyConverter", urlPatterns = { "/converter/servlet/Converter" })
public class Converter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private double output;
	String x = "Converted Money Value is";
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Converter() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"	<head>\r\n" + 
				"		<meta charset=\"ISO-8859-1\">\r\n" + 
				"		<title>Insert title here</title>\r\n" + 
				"	</head>\r\n" + 
				"	<body>\r\n" + 
				"		<h1>Welcome to Currency Converter</h1>\r\n" + 
				"	\r\n" + 
				"		<form action=\"Converter\" method=\"post\">\r\n" + 
				"		Input: &nbsp; &nbsp; &nbsp; \r\n" + 
				"		<select name=\"type1\">\r\n" + 
				"			<option value=\"usd\">US Dollar</option>\r\n" + 
				"			<option value=\"euro\">European Pound</option>\r\n" + 
				"			<option value=\"JPY\">Japanese Yen </option>\r\n" + 
				"		</select>\r\n" + 
				"		<br/>\r\n" + 
				"		Amount: &nbsp; <input type=\"text\" name=\"input\">\r\n" + 
				"		<br/>\r\n" + 
				"		Output: &nbsp; &nbsp; \r\n" + 
				"		<select name=\"type2\">\r\n" + 
				"			<option value=\"usd\">US Dollar</option>\r\n" + 
				"			<option value=\"euro\">European Pound</option>\r\n" + 
				"			<option value=\"JPY\">Japanese Yen </option>\r\n" + 
				"		</select>\r\n" + 
				"		<input type=\"submit\" value=\"Calculate\">\r\n" + 
				"		</form>\r\n" + 
				"		<h3>"+x+"</h3>\r\n" + 
				"		<h3>"+output+"</h3>\r\n" + 
				"	</body>\r\n" + 
				"</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		double input=Integer.valueOf(request.getParameter("input"));
		String type=request.getParameter("type1");
		if(type.equals("euro"))
			input=input/.9;
		else if(type.equals("JPY"))
			input=input/105.85;
		type=request.getParameter("type2");
		if(type.equals("euro"))
			input=input*.9;
		else if(type.equals("JPY"))
			input=input*105.85;
		
		output=input;
		
		
		doGet(request, response);
	}
}