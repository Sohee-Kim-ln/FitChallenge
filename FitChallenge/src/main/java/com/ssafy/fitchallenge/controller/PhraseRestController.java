package com.ssafy.fitchallenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.fitchallenge.model.dto.Phrase;
import com.ssafy.fitchallenge.service.PhraseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/phrase")
@Api(tags = "문구 컨트롤러")
public class PhraseRestController {
	@Autowired
	PhraseService pService;

	@ApiOperation(value = "문구 id로 문구 가져오기")
	@GetMapping("/{phraseId}")
	public ResponseEntity<?> getPhrase(@PathVariable int phraseId){
		Phrase phrase = pService.selectPhrasebyId(phraseId);
		return new ResponseEntity<>(phrase,HttpStatus.OK);
	}

}
