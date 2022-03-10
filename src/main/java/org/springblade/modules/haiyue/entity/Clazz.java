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
package org.springblade.modules.haiyue.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import org.springblade.core.mp.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 班级表实体类
 *
 * @author BladeX
 * @since 2022-03-10
 */
@Data
@TableName("haiyue_clazz")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Clazz对象", description = "班级表")
public class Clazz extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	* 班级编号
	*/
		@ApiModelProperty(value = "班级编号")
		private String code;
	/**
	* 班级姓名
	*/
		@ApiModelProperty(value = "班级姓名")
		private String name;
	/**
	* 管理员
	*/
		@ApiModelProperty(value = "管理员")
		private String manager;
	/**
	* 教师
	*/
		@ApiModelProperty(value = "教师")
		private String teacher;


}