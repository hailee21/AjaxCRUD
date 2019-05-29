package cafe.jjdev.ajaxcrud.member.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cafe.jjdev.ajaxcrud.member.service.MemberService;
import cafe.jjdev.ajaxcrud.member.vo.Member;

@RestController
public class MemberController {
	
	@Autowired private MemberService memberService;
	
	// 회원목록 출력, 페이징
	@GetMapping("/getMembers")
	public Map<String, Object> getMembers(@RequestParam(value="currentPage", required=true) int currentPage){
		System.out.println("[MemberController GET getMembers 요청]");
		System.out.println("[getMembers] currentPage : "+currentPage);
		
		// memberService의 getMemberList 호출
		Map<String, Object> map = memberService.getMemberList(currentPage); 
		return map;		
	}
	
	// 회원추가
	@PostMapping("/addMembers")
	public void addMembers(Member member){
		System.out.println("[MemberController GET addMembers 요청]");
		System.out.println("[MemberController GET addMembers] add member: " +member);
		
		memberService.addMember(member);
	}
	
	// 아이디 중복검사 / 수정 검사
	@PostMapping("/idOverCheck")
	public boolean idOverCheck(@RequestParam (value="id", required=true) String memberId) {
		System.out.println("[MemberController POST idOverCheck 요청]");
		System.out.println("[MemberController POST idOverCheck] memberId : "+memberId);
				
		return memberService.idOverCheck(memberId);
	}	
	
	// 회원삭제
	@PostMapping("/removeMembers")
	public void removeMembers(@RequestParam (value="ck[]") String[] ck){				// spring은  List<String> ck 알아서 배열로 바꿔줄 것
		System.out.println("[MemberController GET removeMembers 요청]");
		System.out.println("[MemberController GET removeMembers] remove ck : " +ck);	// ck가 있는 경우 ck.length 출력하자
		System.out.println("[MemberController GET removeMembers] ck.length : " +ck.length);
		
		memberService.removeMember(ck);	
	}
	
	// 회원수정
	@PostMapping("/modifyMembers")
	public void modifyMembers(Member member){
		System.out.println("[MemberController GET modifyMembers 요청]");
		System.out.println("[MemberController GET modifyMembers] modify member: " +member);
		memberService.modifyMember(member);
	}
}
