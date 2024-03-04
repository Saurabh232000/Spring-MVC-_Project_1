package com.jsp.Dao;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.jsp.DTO.Product;

@Repository
public class ProductDao {
	/**
	 * @return the templete
	 */
	public HibernateTemplate getTemplete() {
		return templete;
	}

	/**
	 * @param templete the templete to set
	 */
	public void setTemplete(HibernateTemplate templete) {
		this.templete = templete;
	}

	@Autowired
	private HibernateTemplate templete;

	@Transactional
	public int Insert(Product product) {
		int save = (int) this.templete.save(product);
		return save;
	}

	@Transactional
	public void Update(Product product) {
		this.templete.saveOrUpdate(product);
	}

	@Transactional
	public void Delete(int id) {
		Product product = this.templete.get(Product.class, id);
		this.templete.delete(product);
	}

	public Product fetch(int id) {
		Product product = this.templete.get(Product.class, id);
		return product;
	}

	public List<Product> FetchAll() {
		List<Product> loadAll = this.templete.loadAll(Product.class);
		return loadAll;
	}
}