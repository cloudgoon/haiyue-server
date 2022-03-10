/*
 *      Copyright (c) 2018-2028, Chill Zhuang All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 *  Redistributions of source code must retain the above copyright notice,
 *  this list of conditions and the following disclaimer.
 *  Redistributions in binary form must reproduce the above copyright
 *  notice, this list of conditions and the following disclaimer in the
 *  documentation and/or other materials provided with the distribution.
 *  Neither the name of the dreamlu.net developer nor the names of its
 *  contributors may be used to endorse or promote products derived from
 *  this software without specific prior written permission.
 *  Author: Chill 庄骞 (smallchill@163.com)
 */
package org.springblade.modules.haiyue.wrapper;

import org.springblade.core.mp.support.BaseEntityWrapper;
import org.springblade.core.tool.utils.BeanUtil;
import org.springblade.modules.haiyue.entity.Clazz;
import org.springblade.modules.haiyue.vo.ClazzVO;
import java.util.Objects;

/**
 * 班级表包装类,返回视图层所需的字段
 *
 * @author BladeX
 * @since 2022-03-10
 */
public class ClazzWrapper extends BaseEntityWrapper<Clazz, ClazzVO>  {

	public static ClazzWrapper build() {
		return new ClazzWrapper();
 	}

	@Override
	public ClazzVO entityVO(Clazz clazz) {
		ClazzVO clazzVO = Objects.requireNonNull(BeanUtil.copy(clazz, ClazzVO.class));

		//User createUser = UserCache.getUser(clazz.getCreateUser());
		//User updateUser = UserCache.getUser(clazz.getUpdateUser());
		//clazzVO.setCreateUserName(createUser.getName());
		//clazzVO.setUpdateUserName(updateUser.getName());

		return clazzVO;
	}

}
