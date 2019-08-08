package zhangweisun.crm.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import zhangweisun.crm.pojo.BaseDict;


@Component(value="baseDictDao")
public class BaseDictDaoImpl implements BaseDictDao {
	/**
	 * 注入数据sqlSessionFactory
	 */
	@Resource(name="sqlSessionFactory")
	private SqlSessionFactory sqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	/**
	 * 根据code查询数据库
	 */
	@Override
	public List<BaseDict> selectBaseDictByCode(String code) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<BaseDict> dictList = sqlSession.selectList(BaseDict.class.getName()+".selectBaseDictByCode", code);

		return dictList;
	}

	
		
		

}
