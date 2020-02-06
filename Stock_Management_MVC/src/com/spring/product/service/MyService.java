package com.spring.product.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.spring.product.model.ModelDTO;
import com.spring.product.model.OrderDTO;
import com.spring.product.model.RegistrationDTO;

public interface MyService {
	
	boolean MangerRegistration(RegistrationDTO rdto);

	boolean ManagerLogin(HttpServletRequest req);

	boolean addproduct(ModelDTO mdto);

	List<ModelDTO> allproduct();

	List<ModelDTO> searchproduct(String search,String filter);

	List<ModelDTO> updateproduct(ModelDTO mdto);

	List<ModelDTO> addtocart(ModelDTO mdto);

	List<ModelDTO> cartadded(ModelDTO mdto);

	List<OrderDTO> showCart();


}
