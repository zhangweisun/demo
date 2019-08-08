package zhangweisun.crm.service;

import java.util.List;

import zhangweisun.crm.pojo.BaseDict;

public interface BaseDictService {

	/**
	 * 根据code查询客户
	 * @param code
	 * @return
	 */
	public List<BaseDict> selectBaseDictByCode(String code);
}
