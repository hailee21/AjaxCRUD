package cafe.jjdev.ajaxcrud.member.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cafe.jjdev.ajaxcrud.member.vo.Member;

@Mapper
public interface MemberMapper {
	// 전체 행 갯수 세기
	public int countMemberList();
	// 전체회원조회, 페이징 
	public List<Member> selectMemberList(Map<String, Object> map);
	
	// 회원등록
	public int insertMember(Member member);
	
	// 회원삭제
	public int deleteMember(Member member);
	
	// 회원수정
	public int updateMember(Member member);
}
