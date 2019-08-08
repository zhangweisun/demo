package zhangweisun.crm.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import zhangweisun.crm.pojo.Customer;
import zhangweisun.crm.pojo.QueryVo;

@Component(value="customerDao")
public class CustomerDaoImpl implements CustomerDao {
	/**
	 * 注入数据sqlSessionFactory
	 */
	@Resource(name="sqlSessionFactory")
	private SqlSessionFactory sqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	//查询符合条件的总条数
	@Override
	public Integer customerCountQueryByVo(QueryVo vo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		return sqlSession.selectOne(Customer.class.getName()+".customerCountQueryByVo", vo);
	}

	//结果集
	@Override
	public List<Customer> selectCustomerQueryByVo(QueryVo vo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Customer> selectList = sqlSession.selectList(Customer.class.getName()+".selectCustomerQueryByVo", vo);
		return selectList;
	}
	
	//根据id查询customer
	@Override
	public Customer selectCustomerById(Integer id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		return sqlSession.selectOne(Customer.class.getName()+".selectCustomerById", id);
	}
	
	//根据id修改customer
	@Override
	public void updateCustomerById(Customer customer) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		sqlSession.update(Customer.class.getName()+".updateCustomerById", customer);
	}
	
	//根据id删除customer
	@Override
	public void deleteCustomerById(Integer id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete(Customer.class.getName()+".deleteCustomerById", id);
		
	}

}
