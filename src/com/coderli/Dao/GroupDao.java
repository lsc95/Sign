package com.coderli.Dao;

import java.util.List;

import com.coderli.entry.User;

public interface GroupDao {

	List<User> getGroupInfo(int unumber);

}
