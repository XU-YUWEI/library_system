package com.xu.kinggame.service;

import java.util.List;
import java.util.Map;


import com.xu.kinggame.entity.Kind;
import com.xu.kinggame.entity.User;
import com.xu.kinggame.util.PageQueryUtil;
import com.xu.kinggame.util.PageResult;

public interface KindService {

	PageResult UserList(PageQueryUtil params);


	boolean insertKind(String kindName);


	boolean updateKind(String kindName, Long kindId);


	Kind selectById(Long id);


	boolean deleteKind(Integer[] ids);


	List<Kind> getAllKinds();

}
