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
import org.springblade.modules.haiyue.entity.Member;
import org.springblade.modules.haiyue.vo.MemberVO;
import java.util.Objects;

/**
 * 会员表包装类,返回视图层所需的字段
 *
 * @author BladeX
 * @since 2022-03-15
 */
public class MemberWrapper extends BaseEntityWrapper<Member, MemberVO>  {

	public static MemberWrapper build() {
		return new MemberWrapper();
 	}

	@Override
	public MemberVO entityVO(Member member) {
		MemberVO memberVO = Objects.requireNonNull(BeanUtil.copy(member, MemberVO.class));

		//User createUser = UserCache.getUser(member.getCreateUser());
		//User updateUser = UserCache.getUser(member.getUpdateUser());
		//memberVO.setCreateUserName(createUser.getName());
		//memberVO.setUpdateUserName(updateUser.getName());

		return memberVO;
	}

}
