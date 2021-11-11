package com.robocon321.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.robocon321.dao.INewDAO;
import com.robocon321.mapper.NewMapper;
import com.robocon321.model.NewModel;
import com.robocon321.paging.Pageble;

@Repository
public class NewDAO extends AbstractDAO<NewModel> implements INewDAO {
	
	@Override
	public List<NewModel> findAll() {
		StringBuilder sql = new StringBuilder("SELECT * FROM news");
		return query(sql.toString(), new NewMapper());
	}
}
