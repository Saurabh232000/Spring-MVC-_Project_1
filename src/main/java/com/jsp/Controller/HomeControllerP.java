package com.jsp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsp.DTO.Merchant;
import com.jsp.DTO.Product;
import com.jsp.Dao.MerchantDao;
import com.jsp.Dao.ProductDao;

@Controller
public class HomeControllerP {
	@Autowired
	private ProductDao dao;
	@Autowired
	private MerchantDao dao1;

	// -----------InsertData-------
	@RequestMapping("/insertData")
	public String Form() {
		return "form";
	}

	@RequestMapping(path = "/Submit", method = RequestMethod.POST)
	public String FinalData(@ModelAttribute Product product, Model model) {
		System.out.println(product);
		int insert = this.dao.Insert(product);
		System.out.println(insert);
		model.addAttribute("Data", product);
		return "Inserted Data";
	}

	// ----------UPdatedata------------
	@RequestMapping("/updateData")
	public String form1() {
		return "form1";
	}

	@RequestMapping(path = "/update", method = RequestMethod.POST)
	public String UpdateForm(@ModelAttribute Product product, Model model) {
		this.dao.Update(product);
		model.addAttribute("Data", product);
		return "Update Data";
	}

	// ----------DeleteDataById-----------
	@RequestMapping("/deleteData")
	public String form2() {
		return "form2";
	}

	@RequestMapping(path = "/delete", method = RequestMethod.POST)
	public String DeleteForm(@RequestParam("id") int id, Model model) {
		Product fetch = this.dao.fetch(id);
		this.dao.Delete(id);
		model.addAttribute("msg" + " " + id + " " + "Given Id Is Deleted");
		return "Delete Data";
	}

	// --------------FetchById--------------
	@RequestMapping("/FetchDataById")
	public String form3() {
		return "form3";
	}

	@RequestMapping(path = "/fetch", method = RequestMethod.POST)
	public String FetchForm(@RequestParam("id") int id, Model model) {
		Product fetch = this.dao.fetch(id);
		System.out.println(fetch);
		model.addAttribute("FetchById", fetch);
		return "Fetch Data";
	}

	// -------------FetchALL--------------
	@RequestMapping("/FetchAllData")
	public String form4(Model model) {
		List<Product> fetchAll = this.dao.FetchAll();
		model.addAttribute("allData", fetchAll);
		return "Fetch All";
	}
	// FetchDataByMerchantId

	// ---------InsertMerchant----------------
	@RequestMapping("/InsertMerchantData")
	public String mform() {
		return "mform";
	}

	@RequestMapping(path = "/Insert", method = RequestMethod.POST)
	public String Data(@ModelAttribute Merchant merchant, Model model) {
		int saveMerchant = this.dao1.saveMerchant(merchant);
		model.addAttribute("save", merchant);
		return "saveM";
	}

	// -----------updateMerchant--------
	@RequestMapping("/UpdateMerchant")
	public String mform1() {
		return "mform1";
	}

	@RequestMapping(path = "/updatem", method = RequestMethod.POST)
	public String UpdateMData(@ModelAttribute Merchant merchant, Model model) {
		this.dao1.updateMerchant(merchant);
		model.addAttribute("update", merchant);
		return "updateM";
	}

	// ----------deleteMerchant-----------
	@RequestMapping("/deleteMerchant")
	public String mform3() {
		return "mform3";
	}

	@RequestMapping(path = "/deletem", method = RequestMethod.POST)
	public String DeleteMerchant(@RequestParam("id") int id, Model model) {
		Merchant fetchMerchant = this.dao1.fetchMerchant(id);
		this.dao1.deleteMerchant(id);
		model.addAttribute("msg", "Deleted");
		return "deleteM";
	}

	// -------------------fetchMerchantById----------------
	@RequestMapping("/FetchDataByIdM")
	public String mform4() {
		return "mform4";
	}

	@RequestMapping(path = "/fetchm", method = RequestMethod.POST)
	public String FetchMForm(@RequestParam("id") int id, Model model) {
		Merchant fetchMerchant = this.dao1.fetchMerchant(id);
		model.addAttribute("fetchM", fetchMerchant);
		return "fetchM";
	}

	// -----------------------------FetchAllMerChant-----------
	@RequestMapping("/FetchAllDataM")
	public String findall(Model model) {
		List<Merchant> aLLMerchant = this.dao1.aLLMerchant();
		model.addAttribute("fetchA", aLLMerchant);
		return "fetchA";

	}

	// ------------------fetchByIdAndPassword------------
	@RequestMapping("/VerifyByIdandPassword")
	public String mform5() {
		return "mform5";
	}

	@RequestMapping(path = "/verifym", method = RequestMethod.POST)
	public String Verifym(@RequestParam("id") int id, @RequestParam("password") String password, Model model) {
		List<Merchant> fetchByIdPas = this.dao1.FetchByIdPas(id, password);
		model.addAttribute("fetchsP", fetchByIdPas);
		return "fetchById";
	}

	// ------------------FetchProductbyMerchssntId------------
//	@RequestMapping("/dfghjkl")
//	public String pform6() {
//		return "pform6";
//	}
}
