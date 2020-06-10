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
		//시설명을 클릭하면 표출되는 상세페이지를 담당하는 컨트롤러
	delivery delivery; //delivery entity, 해당 시설명의 상세정보를 담고 있음.
	
	deliveryService service = new deliveryService();
	String uniqueid = request.getParameter("uniqueid");
	//get방식으로 넘어온 uniqueid의 파라미터 값을 받아 저장한다.
	
	delivery = service.getdeliverydetail(uniqueid);
	//상세정보를 가져올 시설의 시설명을 매개변수로 주고, 시설의 상세정보를 받아온다.
		
		request.setAttribute("delivery", delivery);
		request.getRequestDispatcher("/deliverydetail.jsp").forward(request, response);
		
	}
	

}
