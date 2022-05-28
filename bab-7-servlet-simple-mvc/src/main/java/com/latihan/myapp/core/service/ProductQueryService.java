package com.latihan.myapp.core.service;

import java.sql.Connection;
import java.util.List;

import com.latihan.myapp.core.domain.Product;
import com.latihan.myapp.core.persistence.DatabaseHelper;
import com.latihan.myapp.core.persistence.ProductRepository;
import com.latihan.myapp.core.persistence.RepositoryFactory;
import com.latihan.myapp.core.persistence.exception.DatabaseException;
import com.latihan.myapp.core.persistence.exception.PersistenceException;
import com.latihan.myapp.core.service.exception.BusinessServiceException;

public class ProductQueryService {
	List<Product> findAllProdct() throws BusinessServiceException{
		Connection conn = null;
		List<Product> products = null;
		try {
			conn = DatabaseHelper.getConnection();
			ProductRepository productRepo = RepositoryFactory
										.withThisConnection(conn)
										.getProductRepository();
			
			products = productRepo.findAll();
		
		} catch (DatabaseException e) {
			throw new BusinessServiceException(e.getMessage());
		} catch (PersistenceException e) {
			throw new BusinessServiceException(e.getMessage());
		}
		
		return products;
	}
}
