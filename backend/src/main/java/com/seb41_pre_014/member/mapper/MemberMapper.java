package com.seb41_pre_014.member.mapper;

import com.seb41_pre_014.member.dto.MemberDto;
import com.seb41_pre_014.member.entity.Member;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    Member memberPostDtoToMember(MemberDto.Post memberPostDto);

    Member memberPatchDtoToMember(MemberDto.Patch memberPatchDto);

    MemberDto.Response memberToResponseDto(Member member);

    List<MemberDto.Response> membersToResponseDtos(List<Member> members);

}
