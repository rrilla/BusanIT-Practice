package org.hjh.mother.mapper;

import java.util.List;

import org.hjh.mother.domain.DataVo;

public interface DataMapper {
	public List<DataVo> getList();
	//public List<DataVo> getListWithPaging(Criteria cri);
	public int insert(DataVo data);
	public DataVo read(int dno);
	public int update(DataVo data);
	public int delete(int dno);
	//public int totalCount(Criteria cri);
}
