package cn.crm.common.baseaction;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;



import cn.crm.base.biz.BaseBiz;
import cn.crm.base.biz.ProductBiz;
import cn.crm.base.biz.StorageBiz;
import cn.crm.dev.biz.DevBiz;
import cn.crm.rept.biz.ContributionAnalysisBiz;
import cn.crm.rept.biz.CustomerLevelBiz;
import cn.crm.rept.biz.LostAnalysisBiz;
import cn.crm.rept.biz.ServicesAnalysisBiz;
import cn.crm.right.biz.UserBiz;
import cn.crm.sale.biz.SalChaneBiz;
import cn.crm.service.biz.ServiceBiz;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public abstract class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

	//====================ModelDriven的支持===================
	
	protected T model;
	
	@SuppressWarnings({ "null", "unchecked" })
	public BaseAction(){
			try {
				// 通过反射获取model的真实类型
				ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
				Class<T> clazz = (Class<T>) pt.getActualTypeArguments()[0];
				// 通过反射创建model的实例
				model = clazz.newInstance();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
	}
	

	@Override
	public T getModel() {
		// TODO Auto-generated method stub
		return model;
	}
	//====================Biz实例的声明======================
	@Resource
	protected ContributionAnalysisBiz contributionAnalysisBiz;
	
	@Resource
	protected CustomerLevelBiz customerLevelBiz;
	
	@Resource
	protected ServicesAnalysisBiz servicesAnalysisBiz;
	
	@Resource
	protected LostAnalysisBiz lostAnalysisBiz;
	
	@Resource
	protected UserBiz userBiz;
	
	//数据字典管理
	@Resource
	protected BaseBiz baseBiz;
	//商品管理
	@Resource
	protected ProductBiz productBiz;
	//库存管理
	@Resource
	protected StorageBiz storageBiz;
	
	@Resource
	protected ServiceBiz serviceBiz; //服务类Biz
	
	@Resource
	protected SalChaneBiz salChaneBiz;
	
	@Resource
	protected DevBiz devBiz;

   //====================分页信息===========================
	protected int pageNum=1;//当前页
	protected int pageSize=4;//每页多少条记录

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
