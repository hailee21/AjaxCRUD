package cafe.jjdev.ajaxcrud.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cafe.jjdev.ajaxcrud.member.mapper.MemberMapper;
import cafe.jjdev.ajaxcrud.member.service.MemberService;
import cafe.jjdev.ajaxcrud.member.vo.Member;

@RestController
public class MemberController {
	
	@Autowired private MemberMapper memberMapper;
	@Autowired private MemberService memberService;
	
	// 회원목록 출력, 페이징
	@GetMapping("/getMembers")
	public List<Member> getMembers(@RequestParam(value="currentPage", required=true) int currentPage){
		List<Member> list = memberService.getMemberList(currentPage); 
		System.out.println("[MemberController GET getMembers 요청]");
		System.out.println("[getMembers] memberMapper.selectMemberList().size : "+list.size());
		return list;		
	}
	
	// 회원추가
	@PostMapping("/addMembers")
	public void addMembers(Member member){
		System.out.println("[MemberController GET addMembers 요청]");
		System.out.println("[MemberController GET addMembers] add member: " +member);
		
		memberService.addMember(member);
	}
	
	// 회원삭제
	@PostMapping("/removeMembers")
	public void removeMembers(@RequestParam (value="ck[]") String[] ck){				// spring은  List<String> ck 알아서 배열로 바꿔줄 것
		System.out.println("[MemberController GET removeMembers 요청]");
		System.out.println("[MemberController GET removeMembers] remove ck : " +ck);	// ck가 있는 경우 ck.length 출력하자
		System.out.println("[MemberController GET removeMembers] ck.length : " +ck.length);
		
		String[] check = memberService.removeMember(ck);	
	}
	
	// 회원수정
	@PostMapping("/modifyMembers")
	public void modifyMembers(Member member){
		System.out.println("[MemberController GET modifyMembers 요청]");
		System.out.println("[MemberController GET modifyMembers] modify member: " +member);
		memberService.modifyMember(member);
	}
}
