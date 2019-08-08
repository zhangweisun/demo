package zhangweisun.crm.dao;

import java.util.List;

import zhangweisun.crm.pojo.Customer;
import zhangweisun.crm.pojo.QueryVo;

public interface CustomerDao {

	//查询符合条件的总条数
	public Integer customerCountQueryByVo(QueryVo vo);
	//结果集
	public List<Customer> selectCustomerQueryByVo(QueryVo vo);
	//根据id查询customer
	public Customer selectCustomerById(Integer id);
	//根据id修改customer
	public void updateCustomerById(Customer customer);
	//根据id删除customer
	public void deleteCustomerById(Integer id);
	
}
