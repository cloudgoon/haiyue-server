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
import org.springblade.modules.haiyue.entity.Clazz;
import org.springblade.modules.haiyue.vo.ClazzVO;
import org.springblade.modules.haiyue.wrapper.ClazzWrapper;
import org.springblade.modules.haiyue.service.IClazzService;
import org.springblade.core.boot.ctrl.BladeController;

/**
 * 班级表 控制器
 *
 * @author BladeX
 * @since 2022-03-10
 */
@RestController
@AllArgsConstructor
@RequestMapping("haiyue/clazz")
@Api(value = "班级表", tags = "班级表接口")
public class ClazzController extends BladeController {

	private final IClazzService clazzService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入clazz")
	public R<ClazzVO> detail(Clazz clazz) {
		Clazz detail = clazzService.getOne(Condition.getQueryWrapper(clazz));
		return R.data(ClazzWrapper.build().entityVO(detail));
	}

	/**
	 * 分页 班级表
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入clazz")
	public R<IPage<ClazzVO>> list(Clazz clazz, Query query) {
		IPage<Clazz> pages = clazzService.page(Condition.getPage(query), Condition.getQueryWrapper(clazz));
		return R.data(ClazzWrapper.build().pageVO(pages));
	}


	/**
	 * 自定义分页 班级表
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入clazz")
	public R<IPage<ClazzVO>> page(ClazzVO clazz, Query query) {
		IPage<ClazzVO> pages = clazzService.selectClazzPage(Condition.getPage(query), clazz);
		return R.data(pages);
	}

	/**
	 * 新增 班级表
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入clazz")
	public R save(@Valid @RequestBody Clazz clazz) {
		return R.status(clazzService.save(clazz));
	}

	/**
	 * 修改 班级表
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入clazz")
	public R update(@Valid @RequestBody Clazz clazz) {
		return R.status(clazzService.updateById(clazz));
	}

	/**
	 * 新增或修改 班级表
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入clazz")
	public R submit(@Valid @RequestBody Clazz clazz) {
		return R.status(clazzService.saveOrUpdate(clazz));
	}

	
	/**
	 * 删除 班级表
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 7)
	@ApiOperation(value = "逻辑删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(clazzService.deleteLogic(Func.toLongList(ids)));
	}

	
}
