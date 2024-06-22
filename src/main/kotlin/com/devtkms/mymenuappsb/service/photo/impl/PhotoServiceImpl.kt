package com.devtkms.mymenuappsb.service.photo.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import com.devtkms.mymenuappsb.mapper.PhotoMapper
import com.devtkms.mymenuappsb.service.photo.PhotoService

@Service
class PhotoServiceImpl @Autowired constructor(
	private val photoMapper: PhotoMapper
) : PhotoService {
	override fun uploadPhoto(photoId: Int): Int {
		return photoMapper.insertPhoto(photoId)
	}
}
