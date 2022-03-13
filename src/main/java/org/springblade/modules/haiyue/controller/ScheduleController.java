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
import org.springblade.modules.haiyue.entity.Schedule;
import org.springblade.modules.haiyue.vo.ScheduleVO;
import org.springblade.modules.haiyue.wrapper.ScheduleWrapper;
import org.springblade.modules.haiyue.service.IScheduleService;
import org.springblade.core.boot.ctrl.BladeController;

/**
 * 课程表 控制器
 *
 * @author BladeX
 * @since 2022-03-11
 */
@RestController
@AllArgsConstructor
@RequestMapping("haiyue/schedule")
@Api(value = "课程表", tags = "课程表接口")
public class ScheduleController extends BladeController {

	private final IScheduleService scheduleService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入schedule")
	public R<ScheduleVO> detail(Schedule schedule) {
		Schedule detail = scheduleService.getOne(Condition.getQueryWrapper(schedule));
		return R.data(ScheduleWrapper.build().entityVO(detail));
	}

	/**
	 * 分页 课程表
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入schedule")
	public R<IPage<ScheduleVO>> list(Schedule schedule, Query query) {
		IPage<Schedule> pages = scheduleService.page(Condition.getPage(query), Condition.getQueryWrapper(schedule));
		return R.data(ScheduleWrapper.build().pageVO(pages));
	}


	/**
	 * 自定义分页 课程表
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入schedule")
	public R<IPage<ScheduleVO>> page(ScheduleVO schedule, Query query) {
		IPage<ScheduleVO> pages = scheduleService.selectSchedulePage(Condition.getPage(query), schedule);
		return R.data(pages);
	}

	/**
	 * 新增 课程表
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入schedule")
	public R save(@Valid @RequestBody Schedule schedule) {
		return R.status(scheduleService.save(schedule));
	}

	/**
	 * 修改 课程表
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入schedule")
	public R update(@Valid @RequestBody Schedule schedule) {
		return R.status(scheduleService.updateById(schedule));
	}

	/**
	 * 新增或修改 课程表
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入schedule")
	public R submit(@Valid @RequestBody Schedule schedule) {
		return R.status(scheduleService.saveOrUpdate(schedule));
	}

	
	/**
	 * 删除 课程表
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 7)
	@ApiOperation(value = "逻辑删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(scheduleService.deleteLogic(Func.toLongList(ids)));
	}

	
}
