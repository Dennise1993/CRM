package cn.crm.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("rawtypes")
/**
 * 分页是一页的信息
 * @author Betty
 *
 */
public class PageBean {
	// 指定的或是参数
	private int currentPage;// 当前页
	private int pageSize;// 每页显示几条

	// 查询数据库
	private int recordCount;// 总记录数
	private List recordList = new ArrayList();// 本页的数据列表
	private Map<String, Integer> price = new HashMap<String, Integer>();

	// 计算(按照上述四个数据计算)
	private int pageCount;// 总页数
	private int beginPageIndex;// 页码开始索引
	private int endPageIndex;// 页码结束索引

	public PageBean() {

	}

	/**
	 * 只接受前四个必要的属性，会自动计算出其他三个属性的值
	 * 
	 * @param currentPage
	 * @param pageSize
	 * @param pageCount
	 * @param recordList
	 */
	public PageBean(int currentPage, int pageSize, int recordCount,
			List recordList, Map<String, Integer> price) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.recordCount = recordCount;
		this.recordList = recordList;
		this.price = price;
		// 计算总页码
		pageCount = (recordCount + pageSize - 1) / pageSize;

		// 计算beginPageIndex和endPageIndex
		// 总页数不多于4页，则全部显示
		if (pageCount <= 4) {
			beginPageIndex = 1;
			endPageIndex = pageCount;
		}
		// 总页数多于4页，则显示当前页附近的共4个页码
		else {
			// 当前页附近的4个页码（前一个+当前页+后两个）
			beginPageIndex = currentPage - 1;
			endPageIndex = currentPage + 2;
			// 当前面的页码不足1个时，则显示前4个页码
			if (beginPageIndex < 1) {
				endPageIndex = 4;
				beginPageIndex = 1;
			}
			// 当后面的页码不足两个，则显示后4个页码
			if (endPageIndex > pageCount) {
				endPageIndex = pageCount;
				beginPageIndex = pageCount - 3;
			}
		}
	}

	public PageBean(int currentPage, int pageSize, int recordCount,
			List recordList) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.recordCount = recordCount;
		this.recordList = recordList;
		// 计算总页码
		pageCount = (recordCount + pageSize - 1) / pageSize;

		// 计算beginPageIndex和endPageIndex
		// 总页数不多于4页，则全部显示
		if (pageCount <= 4) {
			beginPageIndex = 1;
			endPageIndex = pageCount;
		}
		// 总页数多于4页，则显示当前页附近的共4个页码
		else {
			// 当前页附近的4个页码（前一个+当前页+后两个）
			beginPageIndex = currentPage - 1;
			endPageIndex = currentPage + 2;
			// 当前面的页码不足1个时，则显示前4个页码
			if (beginPageIndex < 1) {
				endPageIndex = 4;
				beginPageIndex = 1;
			}
			// 当后面的页码不足两个，则显示后4个页码
			if (endPageIndex > pageCount) {
				endPageIndex = pageCount;
				beginPageIndex = pageCount - 3;
			}
		}

	}

	public List getRecordList() {
		return recordList;
	}

	public void setRecordList(List recordList) {
		this.recordList = recordList;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public int getBeginPageIndex() {
		return beginPageIndex;
	}

	public void setBeginPageIndex(int beginPageIndex) {
		this.beginPageIndex = beginPageIndex;
	}

	public int getEndPageIndex() {
		return endPageIndex;
	}

	public void setEndPageIndex(int endPageIndex) {
		this.endPageIndex = endPageIndex;
	}

	public Map<String, Integer> getPrice() {
		return price;
	}

	public void setPrice(Map<String, Integer> price) {
		this.price = price;
	}

}
