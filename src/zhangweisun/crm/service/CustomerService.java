package zhangweisun.crm.service;

import zhangweisun.crm.pojo.Customer;
import zhangweisun.crm.pojo.QueryVo;
import zhangweisun.utils.Page;

public interface CustomerService {
	
	//通过4个条件查询分页
	public Page<Customer> selectPageByQuweyVo(QueryVo vo);
	//根据id查询customer
	public Customer selectCustomerById(Integer id);
	//根据id修改customer
	public void updateCustomerById(Customer customer);
	//根据id删除customer
	public void deleteCustomerById(Integer id);
}
