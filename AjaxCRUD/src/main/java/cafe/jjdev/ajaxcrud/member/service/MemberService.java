package cafe.jjdev.ajaxcrud.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafe.jjdev.ajaxcrud.member.mapper.MemberMapper;
import cafe.jjdev.ajaxcrud.member.vo.Member;

@Service
public class MemberService {
	@Autowired private MemberMapper memberMapper;
	
	// 목록출력
	public Map<String, Object> getMemberList(int currentPage){
		System.out.println("[MemberService getMemberList 요청]");
		System.out.println("[MemberService getMemberList] currentPage : "+currentPage);
		
		// 회원리스트 출력, 페이징 작업 위한 준비 
		int rowPerPage = 20;
		int beginRow = (currentPage-1)*rowPerPage;
		
		// memberMapper에서 사용할 변수들 map내부에 담기
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("beginRow", beginRow);
		map.put("rowPerPage", rowPerPage);
		
		List<Member> list = memberMapper.selectMemberList(map);
		int memberCount = memberMapper.countMemberList();
		int lastPage = memberCount/rowPerPage;
		if(memberCount%rowPerPage != 0) {
			lastPage++;
		}
		
		// 리턴해서 controller에서 사용할 변수들 returnMap에 담기
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("list", list);
		returnMap.put("lastPage", lastPage);
		returnMap.put("currentPage", currentPage);
		System.out.println("[MemberService getMemberList] lastPage : "+ lastPage);
		
		return returnMap;
	}
	
	// 회원추가
	public void addMember(Member member) {
		System.out.println("[MemberService addMember 요청]");
		memberMapper.insertMember(member);
	}
	
	// 회원삭제
	public void removeMember(String[] ck) {
		System.out.println("[MemberService removeMember 요청]");
		System.out.println("[MemberService removeMember] service ck : "+ck);
		System.out.println("[MemberService removeMember]");
		
		//String 배열에 담겨있는 id를 가져와서 회원삭제 delete Mapper를 요청하는 반복문
		for(String id : ck) { 							// ck의 갯수만큼 for문을 반복한다
			Member member = new Member();
			member.setId(id);
			memberMapper.deleteMember(member);
		}
	}
	
	// 회원수정
	public void modifyMember(Member member) {
		memberMapper.updateMember(member);
	}

}
