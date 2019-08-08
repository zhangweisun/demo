package zhangweisun.utils;

import java.util.List;

public class Page<T> {
    
	private int total;//符合条件的总数
	private int page;//一共有多少页
	private int size;//页面显示的分页结果页数
    private List<T> rows;//分页结果集
    
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
    
	
    
}
