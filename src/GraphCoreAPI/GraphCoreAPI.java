package GraphCoreAPI;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import GraphCore.GraphCoreTest;
import GraphCore.GraphCoreTestHelper;

/**
 * Servlet implementation class GraphCoreAPI
 */
@WebServlet("/GraphCoreAPI")
public class GraphCoreAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public GraphCoreAPI() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String requestUrl = request.getRequestURI();
		System.out.println("This is the RequestURL >> "+ requestUrl);
		String country = requestUrl.substring("/GraphCoreAPI/".length());
		System.out.println("This is the Request to the Server >> "+ country);
		String capital=null;
		
		try {
			java.util.Properties props = new java.util.Properties();
			java.lang.String[] args = new java.lang.String[0];
			ORB orb = ORB.init(args,props);			
			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
			GraphCoreTest graphCoreTest = GraphCoreTestHelper.narrow(ncRef.resolve_str("GraphCore"));
			capital=graphCoreTest.getCapital(country);
		}		
		catch(Exception e) {
			System.out.println("Client error "+e.getMessage());
			e.printStackTrace(System.out);			
		}
		response.setContentType("text/html");
	      PrintWriter out = response.getWriter();
	      System.out.println("This is the responce from the Server >> "+capital); 
	      out.println("<h1>" + capital + "</h1>");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
