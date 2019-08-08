package zhangweisun.crm.pojo;

public class QueryVo {

	private String custName;//客户名称
	private String custSource;//客户来源
	private String custIndustry;//所属行业
	private String custLevel;//客户级别
	private Integer page;//当前页
	private Integer size=10;//每页显示的数据条数，默认显示10条数据
	private Integer startRow=0;//开始行，默认从0开始
	
	public Integer getStartRow() {
		return startRow;
	}
	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}
	public String getCustName() {
		return custName;
	}
	public String getCustSource() {
		return custSource;
	}
	public String getCustIndustry() {
		return custIndustry;
	}
	public String getCustLevel() {
		return custLevel;
	}
	public Integer getPage() {
		return page;
	}
	public Integer getSize() {
		return size;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}
	public void setCustIndustry(String custIndustry) {
		this.custIndustry = custIndustry;
	}
	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	
	
	
}
