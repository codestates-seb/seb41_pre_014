package com.seb41_pre_014.member.mapper;

import com.seb41_pre_014.member.dto.MemberDto.Patch;
import com.seb41_pre_014.member.dto.MemberDto.Post;
import com.seb41_pre_014.member.dto.MemberDto.Response;
import com.seb41_pre_014.member.dto.MemberDto.Response.ResponseBuilder;
import com.seb41_pre_014.member.entity.Member;
import com.seb41_pre_014.member.entity.Member.MemberBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-01T16:27:06+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.16 (Azul Systems, Inc.)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public Member memberPostDtoToMember(Post memberPostDto) {
        if ( memberPostDto == null ) {
            return null;
        }

        MemberBuilder member = Member.builder();

        member.email( memberPostDto.getEmail() );
        member.password( memberPostDto.getPassword() );
        member.displayName( memberPostDto.getDisplayName() );

        return member.build();
    }

    @Override
    public Member memberPatchDtoToMember(Patch memberPatchDto) {
        if ( memberPatchDto == null ) {
            return null;
        }

        MemberBuilder member = Member.builder();

        member.password( memberPatchDto.getPassword() );
        member.displayName( memberPatchDto.getDisplayName() );
        member.fullName( memberPatchDto.getFullName() );
        member.location( memberPatchDto.getLocation() );
        member.title( memberPatchDto.getTitle() );
        member.aboutMe( memberPatchDto.getAboutMe() );
        member.websiteLink( memberPatchDto.getWebsiteLink() );
        member.twitterLink( memberPatchDto.getTwitterLink() );
        member.githubLink( memberPatchDto.getGithubLink() );
        member.profileImageUrl( memberPatchDto.getProfileImageUrl() );

        return member.build();
    }

    @Override
    public Response memberToMemberResponseDto(Member member) {
        if ( member == null ) {
            return null;
        }

        ResponseBuilder response = Response.builder();

        response.member( member );

        return response.build();
    }

    @Override
    public List<Response> membersToMemberResponseDtos(List<Member> members) {
        if ( members == null ) {
            return null;
        }

        List<Response> list = new ArrayList<Response>( members.size() );
        for ( Member member : members ) {
            list.add( memberToMemberResponseDto( member ) );
        }

        return list;
    }
}
