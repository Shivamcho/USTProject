package com.spring.product.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.spring.product.model.ModelDTO;
import com.spring.product.model.OrderDTO;
import com.spring.product.model.RegistrationDTO;

@Component
public interface MyDAO {


	boolean MangerRegistration(RegistrationDTO rdto);

	boolean ManagerLogin(HttpServletRequest req);

	boolean addproduct(ModelDTO mdto);

	List<ModelDTO> allproduct();
	
	List<ModelDTO> searchproduct(String search, String filter);

	List<ModelDTO> updateproduct(ModelDTO mdto);

	List<ModelDTO> addtocart(ModelDTO mdto);

	List<ModelDTO> cartadded(ModelDTO mdto);
	List<OrderDTO> showCart();
}
