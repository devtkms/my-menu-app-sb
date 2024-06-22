package com.devtkms.mymenuappsb.controller.photo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import com.devtkms.mymenuappsb.service.photo.PhotoService

@RestController
@RequestMapping("/api")
class PhotoController @Autowired constructor(private val photoService: PhotoService) {
	@PostMapping("/photos")
	fun insertPhoto(@RequestParam photoId: Int): Int {
		return photoService.uploadPhoto(photoId)
	}
}