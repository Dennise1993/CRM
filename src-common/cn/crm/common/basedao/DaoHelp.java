package cn.crm.common.basedao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.crm.common.util.PageBean;
import cn.crm.common.util.QueryHelper;

@SuppressWarnings("rawtypes")
public class DaoHelp extends HibernateDaoSupport {

	public Serializable save(Object obj) {
		return super.getHibernateTemplate().save(obj);
	}

	public void del(Object obj) {
		super.getHibernateTemplate().delete(obj);
	}

	public List search(String hql) {
		return super.getHibernateTemplate().find(hql);
	}
	public void saveOrUpdate(Object obj) {
		super.getHibernateTemplate().saveOrUpdate(obj);
	}
	
	public void update(Object obj) {
		super.getHibernateTemplate().update(obj);
	}

	/**
	 * 
	 * @param entityClass
	 *            类名，如SysUser.Class
	 * @param id
	 *            ID值
	 * @return
	 */
	public <T> T query(Class<T> entityClass, int id) {
		return super.getHibernateTemplate().get(entityClass, id);
	}

	// 参数查询
	public List searchByParams(String hql, Object[] params) {
		return super.getHibernateTemplate().find(hql, params);
	}

	// HQL动态分页查询(组合查询)
	public List getByPage(String hql, Object bean, Integer pageIndex,
			Integer pageSize) {
		List list = null;
		SessionFactory factory = super.getHibernateTemplate()
				.getSessionFactory();
		Session session = factory.openSession();
		try {
			Query query = session.createQuery(hql);
			if (bean != null) {
				query.setProperties(bean);
			}
			// 设置分页的起始记录
			query.setFirstResult((pageIndex - 1) * pageSize);
			// 设置分页的记录数
			query.setMaxResults(pageSize);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
		return list;
	}

	// 原生SQL查询，带参数
	public List queryBySQLPage(String sql, Integer pageIndex, Integer pageSize,Object bean) {
		List list = null;
		SessionFactory factory = super.getHibernateTemplate()
				.getSessionFactory();
		Session session = factory.openSession();
		try {
			SQLQuery query = session.createSQLQuery(sql);
			if (bean != null) {
				query.setProperties(bean);
			}
			// 设置分页的起始记录
			query.setFirstResult((pageIndex - 1) * pageSize);
			// 设置分页的记录数
			query.setMaxResults(pageSize);
			list = query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
		return list;
	}
	
	// 原生SQL查询
		public List queryBySQLPage(String sql, Integer pageIndex, Integer pageSize) {
			List list = null;
			SessionFactory factory = super.getHibernateTemplate()
					.getSessionFactory();
			Session session = factory.openSession();
			try {
				SQLQuery query = session.createSQLQuery(sql);
				// 设置分页的起始记录
				query.setFirstResult((pageIndex - 1) * pageSize);
				// 设置分页的记录数
				query.setMaxResults(pageSize);
				list = query.list();
			} catch (HibernateException e) {
				e.printStackTrace();
			} finally {
				session.close();
				factory.close();
			}
			return list;
		}

	// 返回一个唯一结果,带参数
		public Object uniqueResultBySQL(String sql,Object bean) {
			Object obj = null;
			SessionFactory factory = super.getHibernateTemplate()
					.getSessionFactory();
			Session session = factory.openSession();
			try {
				SQLQuery query = session.createSQLQuery(sql);		
				if (bean != null) {
					query.setProperties(bean);
				}
				obj = query.uniqueResult();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
				factory.close();
			}
			return obj;
		}
		
		// 返回一个唯一结果
				public Object uniqueResultBySQL(String sql) {
					Object obj = null;
					SessionFactory factory = super.getHibernateTemplate()
							.getSessionFactory();
					Session session = factory.openSession();
					try {
						SQLQuery query = session.createSQLQuery(sql);		
						obj = query.uniqueResult();
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						session.close();
						factory.close();
					}
					return obj;
				}
		
		
		
	// 返回一个唯一结果
	public Object uniqueResult(String hql, Object bean) {
		Object obj = null;
		SessionFactory factory = super.getHibernateTemplate()
				.getSessionFactory();
		Session session = factory.openSession();
		try {
			Query query = session.createQuery(hql);//报异常
			if (bean != null) {
				query.setProperties(bean);
			}
			obj = query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
		return obj;
	}

	// 公共的查询分页信息的方法
	public PageBean getPageBean(int pageNum, int pageSize, QueryHelper queryH) {
		System.out
				.println("-------> DaoSupportImpl.getPageBean( int pageNum, int pageSize, QueryHelper queryHelper )");

		// 参数列表
		List<Object> parameters = queryH.getParameters();

		// 查询本页的数据列表
		Query listQuery = getSession().createQuery(queryH.getListQueryHql()); // 创建查询对象
		if (parameters != null) { // 设置参数
			for (int i = 0; i < parameters.size(); i++) {
				listQuery.setParameter(i, parameters.get(i));
			}
		}
		listQuery.setFirstResult((pageNum - 1) * pageSize);
		listQuery.setMaxResults(pageSize);
		List list = listQuery.list(); // 执行查询

		// 查询总记录数量
		Query countQuery = getSession().createQuery(queryH.getCountQueryHql());
		if (parameters != null) { // 设置参数
			for (int i = 0; i < parameters.size(); i++) {
				countQuery.setParameter(i, parameters.get(i));
			}
		}
		Long count = (Long) countQuery.uniqueResult(); // 执行查询

		return new PageBean(pageNum, pageSize, count.intValue(), list);
	}
	
	/**
	 * 动态查询
	 */
	public List query(String hql, Object bean, Integer pageindex,
			Integer pagesize) {
		Session session = getHibernateTemplate().getSessionFactory()
				.openSession();
		List list = null;
		try {
			Query query = session.createQuery(hql);
			if (bean != null) {
				query.setProperties(bean);
			}
			query.setFirstResult((pageindex - 1) * pagesize);
			query.setMaxResults(pagesize);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	/**
	 * 获得Session会话进行分页显示显示的结果递增
	 * 
	 * @return
	 */
	public List criOperateAsc(Class cla, Criterion cri,String str, Integer pagesize,
			Integer pageindex) {
		List list = null;
		SessionFactory sf = super.getHibernateTemplate().getSessionFactory();
		Session session = sf.openSession();
		try {
			Criteria criteria = session.createCriteria(cla);
			if(str!=null&&!"".equals(str)){
				criteria.addOrder(Order.desc(str));
			}
			if (cri != null && !"".equals(cri)) {
				criteria.add(cri);
			}
			if (pagesize != null && !"".equals(pagesize) && pageindex != null
					&& !"".equals(pageindex)) {
				criteria.setFirstResult((pageindex - 1) * pagesize);
				criteria.setMaxResults(pagesize);
			}
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sf.close();
		}

		return list;
	}
	
	/**
	 * 实体的更新和删除（通过hql语句）
	 */
	public Integer deletequery(String hql, Object[] params) {
		Integer n = null;
		SessionFactory sf = super.getHibernateTemplate().getSessionFactory();
		Session session = sf.openSession();
		try {
			Query query = session.createQuery(hql);
			if (params != null && params.length > 0) {
				for (int i = 0; i < params.length; i++) {
					query.setParameter(i, params[i]);
				}
			}
			n = query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sf.close();
		}
		return n;
	}
	
	/**
	 * 获得Session会话进行分页显示
	 * 
	 * @return
	 */
	public List criOperate(Class cla, Criterion cri, Integer pagesize,
			Integer pageindex) {
		List list = null;
		SessionFactory sf = super.getHibernateTemplate().getSessionFactory();
		Session session = sf.openSession();
		try {
			Criteria criteria = session.createCriteria(cla);
			
			if (cri != null && !"".equals(cri)) {
				criteria.add(cri);
			}
			if (pagesize != null && !"".equals(pagesize) && pageindex != null
					&& !"".equals(pageindex)) {
				criteria.setFirstResult((pageindex - 1) * pagesize);
				criteria.setMaxResults(pagesize);
			}
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sf.close();
		}

		return list;
	}
	
	public List searchList(String hql, Object[] params,Integer pagesize,Integer pageindex) {
		List n = null;
		SessionFactory sf = super.getHibernateTemplate().getSessionFactory();
		Session session = sf.openSession();
		try {
			Query query = session.createQuery(hql);
			if (params != null && params.length > 0) {
				for (int i = 0; i < params.length; i++) {
					query.setParameter(i, params[i]);
				}
			}
			if(pagesize!=null &&!"".equals(pagesize)&&pageindex!=null &&!"".equals(pageindex)){
				query.setFirstResult((pageindex-1)*pagesize);
				query.setMaxResults(pagesize);
			}
			n = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sf.close();
		}
		return n;
	}
	
	/**
	 * 根据主键进行更新
	 */
	public void updateObject(Object obj) {
		super.getHibernateTemplate().update(obj);
	}

}
