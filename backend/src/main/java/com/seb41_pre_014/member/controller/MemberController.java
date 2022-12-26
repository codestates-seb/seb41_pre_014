package com.seb41_pre_014.member.controller;


import com.seb41_pre_014.member.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/members")
public class MemberController {

    //회원등록, 변경, 조회, 삭제

    @PostMapping
    public ResponseEntity postMember() {
        MemberDto.Response createMember = createMember();
        return new ResponseEntity<>(createMember, HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity patchMember() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getMember() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteMember() {
        return new ResponseEntity<>(HttpStatus.OK);
    }


    public MemberDto.Response createMember() {
        MemberDto.Response.ResponseBuilder builder = MemberDto.Response.builder();
        builder.memberId(1L);
        builder.email("stub email@email.com");
        builder.password("password");
        builder.display_name("display_name");
        builder.full_name("홍길동");
        builder.location("home");
        builder.title("자기소개");
        builder.website_link("link1");
        builder.twitter_link("link2");
        builder.github_link("link3");
        builder.profile_image_url("image url");
        builder.memberstatus("활동중");
        builder.reputation(10);
        builder.questions(3);
        builder.answers(3);
        MemberDto.Response response;
        response = builder.build();

        return response;
    }

}
