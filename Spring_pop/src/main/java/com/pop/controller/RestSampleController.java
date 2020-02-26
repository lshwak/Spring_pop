package com.pop.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pop.model.SampleVO;

@RestController
@RequestMapping("/sample")
public class RestSampleController {
	private static final Logger logger = LoggerFactory.getLogger(RestSampleController.class);
	/* 단순 문자열 반환 */
	@RequestMapping(value="/hello", produces="text/plain;charset=UTF-8")
	public String sayHello() {
		
		logger.info("MIME TYPE : "+MediaType.TEXT_PLAIN_VALUE);
		return "Hello world";
		
	}
	/* 객체 반환*/
	@RequestMapping(value="/sendVO")
	public SampleVO sendVO() {
		SampleVO vo = new SampleVO();
		vo.setFirstname("린이");
		vo.setLastname("그");
		vo.setMno(123);
		return vo;
	}
	
	/* 컬랙션(ArrayList) 타입 객체 반환 */
	@RequestMapping(value="/sendList")
	public List<SampleVO> sendList() {
		List<SampleVO> list = new ArrayList<>();
		for(int i=0;i<10;i++) {
			SampleVO vo = new SampleVO();
			vo.setFirstname("길동");
			vo.setLastname("홍");
			vo.setMno(i);
			list.add(vo);
		}
		return list;
	}
	/* 컬랙션(HashMap) 타입 객체 반환 */
	@RequestMapping(value="/sendMap")
	public Map<Integer, SampleVO> sendMap() {
		Map<Integer, SampleVO>map = new HashMap<>();
		for(int i=0;i<10;i++) {
			SampleVO vo = new SampleVO();
			vo.setFirstname("길동");
			vo.setLastname("홍");
			vo.setMno(i);
			map.put(i,  vo);
			
		}
		return map;
	}
	/* @PathVariable : URL 경로의 일부를 파라미터로 사용 할 때 이용 */
	@RequestMapping(value="/member/{last}/{first}")
	public String[] getMember(@PathVariable("last")String last, @PathVariable("first")String first) {
		String[] member = new String[] {"lastname : "+last,"firstname"+first};
		return member;
	}
	
	/* @RequsetBody : JSON 데이터를 원하는 타입의 객체로 변환해야 하는 경우에 주로 사용 */
	@RequestMapping(value="/memberRequestBody", method = RequestMethod.POST)
	// @RequestMapping(value="/memberRequestBody")
	public SampleVO getmemberRequestBody(@RequestBody SampleVO sv) {
		logger.info("member RequestBody....."+sv);
		return sv;
	}
}








