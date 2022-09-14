package com.lim.biz.member.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lim.biz.member.MemberService;
import com.lim.biz.member.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public void insert(MemberVO vo) {
		// TODO Auto-generated method stub
		memberDAO.insert(vo);
	}

	@Override
	public void update(MemberVO vo) {
		// TODO Auto-generated method stub
		memberDAO.update(vo);
	}

	@Override
	public void delete(MemberVO vo) {
		// TODO Auto-generated method stub
		memberDAO.delete(vo);
	}

	@Override
	public MemberVO selectOne(MemberVO vo) {
		// TODO Auto-generated method stub
		return memberDAO.selectOne(vo);
	}

	@Override
	public List<MemberVO> selectAll(MemberVO vo) {
		// TODO Auto-generated method stub
		return memberDAO.selectAll(vo);
	}
	
}
