package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ConProcess;
import model.Contract;
import service.ContractService;
import util.AppException;

/**
 * Servlet implementation class ContractListForUser
 */
@WebServlet("/ContractListForUser")
public class ContractListForUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContractListForUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
request.setCharacterEncoding("UTF-8");
		
		/**	
			// Declare session
			HttpSession session = null;
			// Get session by using request
			session = request.getSession();
			//Integer userId = (Integer)session.getAttribute("userId");
			
			
			// If user is not login, jump to login page
			if (userId == null) {
				response.sendRedirect("Login");
			}else {
				
				**/
				
				try {
					Integer userId=2;
					// Initialize contractService
					ContractService contractService = new ContractService();
					// Initialize contractList
					List<Contract> contractList = new ArrayList<Contract>();
					// Call business logic layer to get list of contract to be countersigned 
					contractList = contractService.getContractListForUser(userId);
					
					// Save contractList to request
					request.setAttribute("contractList", contractList);
					
					// Forward to page of contract to be countersigned
					request.getRequestDispatcher("/contractListForUser.jsp").forward(request, response);
				} catch (AppException e) {
					e.printStackTrace();
					// Redirect to the exception page
					response.sendRedirect("toError");
				}
		//	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
