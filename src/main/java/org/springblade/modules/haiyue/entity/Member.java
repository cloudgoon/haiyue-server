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
import java.time.LocalDate;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 会员表实体类
 *
 * @author BladeX
 * @since 2022-03-15
 */
@Data
@TableName("haiyue_member")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Member对象", description = "会员表")
public class Member extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	* 会员编号
	*/
		@ApiModelProperty(value = "会员编号")
		private String code;
	/**
	* 会员姓名
	*/
		@ApiModelProperty(value = "会员姓名")
		private String name;
	/**
	* 会员电话
	*/
		@ApiModelProperty(value = "会员电话")
		private String phone;
	/**
	* 出生日期
	*/
		@ApiModelProperty(value = "出生日期")
		private LocalDate birth;
	/**
	* 家长姓名
	*/
		@ApiModelProperty(value = "家长姓名")
		private String parentName;
	/**
	* 宝宝小名
	*/
		@ApiModelProperty(value = "宝宝小名")
		private String nickname;
	/**
	* 课程数
	*/
		@ApiModelProperty(value = "课程数")
		private Integer classNum;
	/**
	* 赠课数
	*/
		@ApiModelProperty(value = "赠课数")
		private Integer giveNum;


}
