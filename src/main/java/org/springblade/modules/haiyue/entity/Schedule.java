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
 * 课程表实体类
 *
 * @author BladeX
 * @since 2022-03-11
 */
@Data
@TableName("haiyue_schedule")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Schedule对象", description = "课程表")
public class Schedule extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	* 星期一
	*/
		@ApiModelProperty(value = "星期一")
		private String monday;
	/**
	* 星期二
	*/
		@ApiModelProperty(value = "星期二")
		private String tuesday;
	/**
	* 星期三
	*/
		@ApiModelProperty(value = "星期三")
		private String wednesday;
	/**
	* 星期四
	*/
		@ApiModelProperty(value = "星期四")
		private String thursday;
	/**
	* 星期五
	*/
		@ApiModelProperty(value = "星期五")
		private String friday;
	/**
	* 星期六
	*/
		@ApiModelProperty(value = "星期六")
		private String saturday;
	/**
	* 星期天
	*/
		@ApiModelProperty(value = "星期天")
		private String sunday;


}
