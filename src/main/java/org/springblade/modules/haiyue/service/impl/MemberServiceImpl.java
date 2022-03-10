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
package org.springblade.modules.haiyue.service.impl;

import org.springblade.modules.haiyue.entity.Member;
import org.springblade.modules.haiyue.vo.MemberVO;
import org.springblade.modules.haiyue.mapper.MemberMapper;
import org.springblade.modules.haiyue.service.IMemberService;
import org.springblade.core.mp.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 会员表 服务实现类
 *
 * @author BladeX
 * @since 2022-03-10
 */
@Service
public class MemberServiceImpl extends BaseServiceImpl<MemberMapper, Member> implements IMemberService {

	@Override
	public IPage<MemberVO> selectMemberPage(IPage<MemberVO> page, MemberVO member) {
		return page.setRecords(baseMapper.selectMemberPage(page, member));
	}

}
