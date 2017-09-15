package cn.crm.right.biz;

import java.util.Collection;
import java.util.List;

import cn.crm.entity.SysRight;

public interface RightBiz {
	public List<SysRight> getTopRights();

	public Collection<String> getAllRights();
}
