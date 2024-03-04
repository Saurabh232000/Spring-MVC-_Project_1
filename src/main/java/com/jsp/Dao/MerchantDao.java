package com.jsp.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.jsp.DTO.Merchant;
import com.jsp.DTO.Product;

@Repository
public class MerchantDao {
	/**
	 * @return the template
	 */
	public HibernateTemplate getTemplate() {
		return template;
	}

	/**
	 * @param template the template to set
	 */
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	@Autowired
	private HibernateTemplate template;

	@Transactional
	public int saveMerchant(Merchant merchant) {
		int save1 = (int) this.template.save(merchant);
		System.out.println(save1);
		return save1;
	}

	@Transactional
	public void updateMerchant(Merchant merchant) {
		this.template.saveOrUpdate(merchant);

	}

	@Transactional
	public void deleteMerchant(int id) {
		Merchant merchant = this.template.get(Merchant.class, id);
		this.template.delete(merchant);
	}

	public Merchant fetchMerchant(int id) {
		Merchant merchant = this.template.get(Merchant.class, id);
		return merchant;
	}

	public List<Merchant> aLLMerchant() {
		List<Merchant> merchant = this.template.loadAll(Merchant.class);
		return merchant;
	}

	public List<Merchant> FetchByIdPas(int id, String password) {
		String qry = "select m from Merchant m where m.id=:id and m.password=:password";
		List<Merchant> merchant = (List<Merchant>) this.template.findByNamedParam(qry,
				new String[] { "id", "password" }, new Object[] { id, password });
		return merchant;

	}

	public List<Product> fetchByMerchantId(int id) {
		String qry = "select p from Product p where m.id=:id ";
		List<Product> findByNamedParam = (List<Product>) this.template.findByNamedParam(qry, new String[] { "id" },
				new Object[] { id });
		return findByNamedParam;
	}
}