package com.latihan.myapp.core.persistence;

import java.util.List;

import com.latihan.myapp.core.domain.Product;
import com.latihan.myapp.core.persistence.exception.PersistenceException;

public interface ProductRepository {
	List<Product> findAll() throws PersistenceException;
}
