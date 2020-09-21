package org.hjh.mother.service;

import java.util.List;

import org.hjh.mother.domain.DataVo;

public interface DataService {
	public boolean register(DataVo data);
	public DataVo get(int dno);
	public boolean modify(DataVo data);
	public boolean remove(int dno);
	public List<DataVo> getList();
//	public List<DataVo> getList(Criteria cri);
//	public int getTotal(Criteria cri); 
}
