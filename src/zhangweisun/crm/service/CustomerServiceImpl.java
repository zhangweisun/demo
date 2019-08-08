package zhangweisun.crm.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import zhangweisun.crm.dao.CustomerDao;
import zhangweisun.crm.pojo.Customer;
import zhangweisun.crm.pojo.QueryVo;
import zhangweisun.utils.Page;

@Component(value="customerService")
public class CustomerServiceImpl implements CustomerService {

	@Resource(name="customerDao")
	private CustomerDao customerDao;
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	//通过4个条件查询分页
	public Page<Customer> selectPageByQuweyVo(QueryVo vo){
		Page<Customer> page = new Page<Customer>();
		//判断当前页和vo不为空
		page.setSize(5);//分页显示的是5个按钮
		vo.setSize(8);//设置显示的数据条数
		if(null!=vo ){
			if(null !=vo.getPage()){
				page.setPage(vo.getPage());
				vo.setStartRow((vo.getPage()-1)*vo.getSize());//设置开始页数据的开始id,vo.getPage()是获取当前页
			}
			if(null !=vo.getCustName() && !"".equals(vo.getCustName().trim())){
				vo.setCustName(vo.getCustName().trim());
			}
			if(null !=vo.getCustSource() && !"".equals(vo.getCustSource().trim())){
				vo.setCustSource(vo.getCustSource().trim());
			}
			if(null !=vo.getCustIndustry() && !"".equals(vo.getCustIndustry().trim())){
				vo.setCustIndustry(vo.getCustIndustry().trim());
			}
			if(null !=vo.getCustLevel() && !"".equals(vo.getCustLevel().trim())){
				vo.setCustLevel(vo.getCustLevel().trim());
			}
			//总条数
			page.setTotal(customerDao.customerCountQueryByVo(vo));
			//结果集
			page.setRows(customerDao.selectCustomerQueryByVo(vo));
		}
			
		return page;
	}
	
	/**
	 * 根据id查询customer
	 */
	@Override
	public Customer selectCustomerById(Integer id) {
		
		return customerDao.selectCustomerById(id);
	}
	/**
	 * 根据id修改customer
	 */
	@Override
	public void updateCustomerById(Customer customer) {
		
		customerDao.updateCustomerById(customer);
	}
	@Override
	public void deleteCustomerById(Integer id) {
		
		customerDao.deleteCustomerById(id);
	}
	
}
