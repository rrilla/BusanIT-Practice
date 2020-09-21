package org.hjh.mother.service;

import java.util.List;

import org.hjh.mother.domain.DataVo;
import org.hjh.mother.mapper.DataMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

@Log
@Service
@AllArgsConstructor
public class DataSerivceImpl implements DataService {

	private DataMapper dataMapper;
	
	@Override
	public boolean register(DataVo data) {
		if(dataMapper.insert(data) == 1) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public DataVo get(int dno) {
		return dataMapper.read(dno);
	}

	@Override
	public boolean modify(DataVo data) {
		if(dataMapper.update(data) == 1) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean remove(int dno) {
		if(dataMapper.delete(dno) == 1) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<DataVo> getList() {
		return dataMapper.getList();
	}

}
