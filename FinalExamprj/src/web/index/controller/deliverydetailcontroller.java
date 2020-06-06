package web.index.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.index.Service.deliveryService;
import web.index.entity.delivery;

@WebServlet("/deliverydetail")
public class deliverydetailcontroller extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	delivery delivery;
	deliveryService service = new deliveryService();
	String uniqueid = request.getParameter("uniqueid");
	delivery = service.getdeliverydetail(uniqueid);
		
		request.setAttribute("delivery", delivery);
		request.getRequestDispatcher("/deliverydetail.jsp").forward(request, response);
		
	}
	

}
