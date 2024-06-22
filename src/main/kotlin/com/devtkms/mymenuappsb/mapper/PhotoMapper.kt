package com.devtkms.mymenuappsb.mapper

import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param

@Mapper
interface PhotoMapper {
	fun insertPhoto(@Param("photoId") photoId: Int): Int
}
