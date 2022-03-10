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
package org.springblade.modules.haiyue.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import lombok.AllArgsConstructor;
import javax.validation.Valid;

import org.springblade.core.mp.support.Condition;
import org.springblade.core.mp.support.Query;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.utils.Func;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springblade.modules.haiyue.entity.Member;
import org.springblade.modules.haiyue.vo.MemberVO;
import org.springblade.modules.haiyue.wrapper.MemberWrapper;
import org.springblade.modules.haiyue.service.IMemberService;
import org.springblade.core.boot.ctrl.BladeController;

/**
 * 会员表 控制器
 *
 * @author BladeX
 * @since 2022-03-09
 */
@RestController
@AllArgsConstructor
@RequestMapping("haiyue/member")
@Api(value = "会员表", tags = "会员表接口")
public class MemberController extends BladeController {

	private final IMemberService memberService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入member")
	public R<MemberVO> detail(Member member) {
		Member detail = memberService.getOne(Condition.getQueryWrapper(member));
		return R.data(MemberWrapper.build().entityVO(detail));
	}

	/**
	 * 分页 会员表
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入member")
	public R<IPage<MemberVO>> list(Member member, Query query) {
		IPage<Member> pages = memberService.page(Condition.getPage(query), Condition.getQueryWrapper(member));
		return R.data(MemberWrapper.build().pageVO(pages));
	}


	/**
	 * 自定义分页 会员表
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入member")
	public R<IPage<MemberVO>> page(MemberVO member, Query query) {
		IPage<MemberVO> pages = memberService.selectMemberPage(Condition.getPage(query), member);
		return R.data(pages);
	}

	/**
	 * 新增 会员表
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入member")
	public R save(@Valid @RequestBody Member member) {
		return R.status(memberService.save(member));
	}

	/**
	 * 修改 会员表
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入member")
	public R update(@Valid @RequestBody Member member) {
		return R.status(memberService.updateById(member));
	}

	/**
	 * 新增或修改 会员表
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入member")
	public R submit(@Valid @RequestBody Member member) {
		return R.status(memberService.saveOrUpdate(member));
	}

	
	/**
	 * 删除 会员表
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 7)
	@ApiOperation(value = "逻辑删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(memberService.deleteLogic(Func.toLongList(ids)));
	}

	
}
