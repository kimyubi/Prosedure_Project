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


@WebServlet("/delivery")
public class DeliveryController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		deliveryService service = new deliveryService();
		List<delivery> list = new ArrayList<delivery>();
		String field = "city";
		String field_ = request.getParameter("selection");
		if(field_!=null&& !field_.equals(""))
		{
			field  = field_;
		}
		String query = "";
		String query_ = request.getParameter("search");
		if(query_!=null&& !query_.equals(""))
		{
			query  = query_;
		}
		
		list = service.getDeliveryList(field, query);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/delivery.jsp").forward(request, response);
		
		
	}
	

}
