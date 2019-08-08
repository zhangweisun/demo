package zhangweisun.crm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import zhangweisun.crm.dao.BaseDictDao;
import zhangweisun.crm.pojo.BaseDict;

@Component(value="baseDictService")
public class BaseDictServiceImpl implements BaseDictService{

	@Resource(name="baseDictDao")
	private BaseDictDao baseDictDao;
	public void setBaseDictDao(BaseDictDao baseDictDao) {
		this.baseDictDao = baseDictDao;
	}
	/**
	 * 根据code查询数据库
	 */
	@Override
	public List<BaseDict> selectBaseDictByCode(String code) {
		
		return baseDictDao.selectBaseDictByCode(code);
	}
	

	
}
