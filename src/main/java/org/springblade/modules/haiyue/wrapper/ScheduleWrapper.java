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
import org.springblade.modules.haiyue.entity.Schedule;
import org.springblade.modules.haiyue.vo.ScheduleVO;
import java.util.Objects;

/**
 * 课程表包装类,返回视图层所需的字段
 *
 * @author BladeX
 * @since 2022-03-11
 */
public class ScheduleWrapper extends BaseEntityWrapper<Schedule, ScheduleVO>  {

	public static ScheduleWrapper build() {
		return new ScheduleWrapper();
 	}

	@Override
	public ScheduleVO entityVO(Schedule schedule) {
		ScheduleVO scheduleVO = Objects.requireNonNull(BeanUtil.copy(schedule, ScheduleVO.class));

		//User createUser = UserCache.getUser(schedule.getCreateUser());
		//User updateUser = UserCache.getUser(schedule.getUpdateUser());
		//scheduleVO.setCreateUserName(createUser.getName());
		//scheduleVO.setUpdateUserName(updateUser.getName());

		return scheduleVO;
	}

}
