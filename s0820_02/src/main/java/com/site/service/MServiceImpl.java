package com.site.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.dao.MemberMapper;
import com.site.dto.Member;

@Service
public class MServiceImpl implements MService {
	
	@Autowired MemberMapper memberMapper;

	@Override
	public List<Member> selectAll() {
		List<Member> list = memberMapper.selectAll();
		return list;
	}
	
}
