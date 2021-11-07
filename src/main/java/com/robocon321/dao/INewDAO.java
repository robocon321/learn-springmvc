package com.robocon321.dao;

import java.util.List;

import com.robocon321.model.NewModel;
import com.robocon321.paging.Pageble;


public interface INewDAO extends GenericDAO<NewModel> {
	List<NewModel> findAll();
}
