package com.mballem.curso.security.datatables;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class Datatables {
	
	private HttpServletRequest request;
	private String[] colunas;	

	public Datatables() {
		super();
		System.out.println("Datatables 0001");
	}
	
	public Map<String, Object> getResponse(Page<?> page) {		
		Map<String, Object> json = new LinkedHashMap<>();
		json.put("draw", draw());
		json.put("recordsTotal", page.getTotalElements());
		json.put("recordsFiltered", page.getTotalElements());
		json.put("data", page.getContent());
		System.out.println("Datatables 0002");
		return json;
	}	

	public HttpServletRequest getRequest() {
		System.out.println("Datatables 0003");
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
		System.out.println("Datatables 0004");
	}

	public String[] getColunas() {
		System.out.println("Datatables 0005");
		return colunas;
	}

	public void setColunas(String[] colunas) {
		this.colunas = colunas;
		System.out.println("Datatables 0006");
	}

	private int draw() {
		System.out.println("Datatables 0007");
		return Integer.parseInt(this.request.getParameter("draw"));
	}
	
	private int start() {
		System.out.println("Datatables 0008");
		return Integer.parseInt(this.request.getParameter("start"));
	}
	
	public int getLength() {
		System.out.println("Datatables 0009");
		return Integer.parseInt(this.request.getParameter("length"));
	}

	public int getCurrentPage() {
		System.out.println("Datatables 0010");
		return start() / getLength();
	}

	public String getColumnName() {
		int iCol = Integer.parseInt(this.request.getParameter("order[0][column]"));
		System.out.println("Datatables 0011");
		return this.colunas[iCol];
	}	

	public Sort.Direction getDirection() {
		String order = this.request.getParameter("order[0][dir]");
		Sort.Direction sort = Sort.Direction.ASC;
		if (order.equalsIgnoreCase("desc")) {
			sort = Sort.Direction.DESC;
		}
		System.out.println("Datatables 0012");
		return sort;
	}

	public String getSearch() {		
		System.out.println("Datatables 0013");
		return this.request.getParameter("search[value]");
	}
	
	public Pageable getPageable() {
		System.out.println("Datatables 0014");
		return PageRequest.of(getCurrentPage(), getLength(), getDirection(), getColumnName());
	}
}
