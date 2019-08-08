package zhangweisun.crm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import zhangweisun.crm.pojo.BaseDict;
import zhangweisun.crm.pojo.Customer;
import zhangweisun.crm.pojo.QueryVo;
import zhangweisun.crm.service.BaseDictService;

import zhangweisun.crm.service.CustomerService;
import zhangweisun.utils.Page;
/**
 * 客户管理
 * @author zhangweisun
 *
 */

@Controller
@RequestMapping(value="/crm/customer")
public class customerController {
	
	@Resource(name="baseDictService")
	private BaseDictService baseDictService;
	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}
	@Resource(name="customerService")
	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	//在成员变量上注入需要查询的类型
	@Value("${fromType.code}")
	private String fromTypeCode;
	@Value("${industryType.code}")
	private String industryTypeCode;
	@Value("${levelType.code}")
	private String levelTypeCode;
	
	//显示customer列表
	@RequestMapping(value="/list")
	public String list(QueryVo vo, Model model) throws Exception{
		
		List<BaseDict> fromType = baseDictService.selectBaseDictByCode(fromTypeCode);
		List<BaseDict> industryType = baseDictService.selectBaseDictByCode(industryTypeCode);
		List<BaseDict> levelType = baseDictService.selectBaseDictByCode(levelTypeCode);
		//把类型放入域对象中
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		
		//通过4个条件，查询分页对象
		Page<Customer> page = customerService.selectPageByQuweyVo(vo);
		model.addAttribute("page", page);
		//回显数据
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
		
		//返回逻辑标签
		return "customer";
	}
	
	//跳转到修改页面
	@RequestMapping(value="/edit")
	public @ResponseBody
	Customer edit(Integer id){
		return customerService.selectCustomerById(id);
	}
	
	//保存修改
	@RequestMapping(value="/update")
	public @ResponseBody
	String update(Customer customer){
		customerService.updateCustomerById(customer);
		return "OK";
	}
	//保存修改
	@RequestMapping(value="/delete")
	public @ResponseBody
	String delete(Integer id){
		customerService.deleteCustomerById(id);
		return "OK";
	}

}
