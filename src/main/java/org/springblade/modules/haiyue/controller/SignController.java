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
import org.springblade.modules.haiyue.entity.Member;
import org.springblade.modules.haiyue.service.IMemberService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springblade.modules.haiyue.entity.Sign;
import org.springblade.modules.haiyue.vo.SignVO;
import org.springblade.modules.haiyue.wrapper.SignWrapper;
import org.springblade.modules.haiyue.service.ISignService;
import org.springblade.core.boot.ctrl.BladeController;

import java.util.Date;

/**
 * 会员签到表 控制器
 *
 * @author BladeX
 * @since 2022-03-15
 */
@RestController
@AllArgsConstructor
@RequestMapping("haiyue/sign")
@Api(value = "会员签到表", tags = "会员签到表接口")
public class SignController extends BladeController {

	private final ISignService signService;

	private final IMemberService memberService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入sign")
	public R<SignVO> detail(Sign sign) {
		Sign detail = signService.getOne(Condition.getQueryWrapper(sign));
		return R.data(SignWrapper.build().entityVO(detail));
	}

	/**
	 * 分页 会员签到表
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入sign")
	public R<IPage<SignVO>> list(Sign sign, Query query) {
		IPage<Sign> pages = signService.page(Condition.getPage(query), Condition.getQueryWrapper(sign));
		return R.data(SignWrapper.build().pageVO(pages));
	}


	/**
	 * 自定义分页 会员签到表
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入sign")
	public R<IPage<SignVO>> page(SignVO sign, Query query) {
		IPage<SignVO> pages = signService.selectSignPage(Condition.getPage(query), sign);
		return R.data(pages);
	}

	/**
	 * 新增 会员签到表
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入sign")
	public R save(@Valid @RequestBody Sign sign) {
		return R.status(signService.save(sign));
	}

	/**
	 * 修改 会员签到表
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入sign")
	public R update(@Valid @RequestBody Sign sign) {
		return R.status(signService.updateById(sign));
	}

	/**
	 * 新增或修改 会员签到表
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入sign")
	public R submit(@Valid @RequestBody Sign sign) {
		return R.status(signService.saveOrUpdate(sign));
	}


	/**
	 * 删除 会员签到表
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 7)
	@ApiOperation(value = "逻辑删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(signService.deleteLogic(Func.toLongList(ids)));
	}

	/**
	 * 签到 会员签到表
	 */
	@PostMapping("/sign")
	@ApiOperationSupport(order = 7)
	@ApiOperation(value = "签到", notes = "传入ids")
	public void sign(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {

		Member member = memberService.getById(ids);
		Sign sign = new Sign();
		sign.setSignDate(new Date());
		sign.setCode(member.getCode());
		sign.setBirth(member.getBirth());
		sign.setName(member.getName());
		sign.setPhone(member.getPhone());
		sign.setParentName(member.getParentName());
		sign.setMemberId(member.getId());
		signService.save(sign);
	}

}
