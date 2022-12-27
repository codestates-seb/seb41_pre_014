package com.seb41_pre_014.member.controller;


import com.seb41_pre_014.board.dto.BoardDto;
import com.seb41_pre_014.member.dto.MemberDto;
import com.seb41_pre_014.member.entity.Member;
import com.seb41_pre_014.tag.dto.TagDto;
import com.seb41_pre_014.tag.entity.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;


@RestController
@RequestMapping("/members")
public class MemberController {

    //회원등록, 변경, 조회, 삭제

    @PostMapping
    public ResponseEntity postMember(@RequestBody @Valid MemberDto.Post memberPostDto) {
        return new ResponseEntity<>(createMember1(), HttpStatus.CREATED);
    }

    @PatchMapping("/{member-id}")
    public ResponseEntity patchMember(@PathVariable("member-id") @Positive Long memberId,
                                      @RequestBody @Valid MemberDto.Patch memberPatchDto) {
        return new ResponseEntity<>(createMember1(), HttpStatus.OK);
    }

    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id") @Positive Long memberId) {
        return new ResponseEntity<>(createMember1(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getMembers(@RequestParam("page") @Positive int page,
                                     @RequestParam("size") @Positive int size) {
        return new ResponseEntity<>(List.of(createMember2(), createMember1()), HttpStatus.OK);
    }

    @GetMapping("/{member-id}/questions")
    public ResponseEntity getQuestionsByMember(@PathVariable("member-id") @Positive Long memberId,
                                               @RequestParam("page") @Positive int page,
                                               @RequestParam("size") @Positive int size) {
        return new ResponseEntity<>(List.of(createQuestion(), createQuestion()), HttpStatus.OK);
    }

    @GetMapping("/{member-id}/answers")
    public ResponseEntity getAnswersByMember(@PathVariable("member-id") @Positive Long memberId,
                                             @RequestParam("page") @Positive int page,
                                             @RequestParam("size") @Positive int size) {
        return new ResponseEntity<>(List.of(createAnswer(), createAnswer()), HttpStatus.OK);
    }

    @GetMapping("/{member-id}/tags")
    public ResponseEntity getTagsByMember(@PathVariable("member-id") @Positive Long memberId,
                                          @RequestParam("page") @Positive int page,
                                          @RequestParam("size") @Positive int size) {
        return new ResponseEntity<>(List.of(createTag1(), createTag2()), HttpStatus.OK);
    }

    @GetMapping("/{member-id}/bookmarks")
    public ResponseEntity getBoardsByBookmark(@PathVariable("member-id") @Positive Long memberId,
                                               @RequestParam("page") @Positive int page,
                                               @RequestParam("size") @Positive int size) {
        return new ResponseEntity<>(List.of(createQuestion(), createAnswer()), HttpStatus.OK);
    }

    @GetMapping("/{member-id}/votes")
    public ResponseEntity getBoardsByVote(@PathVariable("member-id") @Positive Long memberId,
                                          @RequestParam("page") @Positive int page,
                                          @RequestParam("size") @Positive int size) {
        return new ResponseEntity<>(List.of(createQuestion(), createAnswer()), HttpStatus.OK);
    }

    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable("member-id") @Positive Long memberid) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public TagDto.Response createTag1() {
        TagDto.Response.ResponseBuilder builder = TagDto.Response.builder();
        builder.tagId(1L);
        builder.name("java");
        builder.boardId(1L);
        return builder.build();
    }

    public TagDto.Response createTag2() {
        TagDto.Response.ResponseBuilder builder = TagDto.Response.builder();
        builder.tagId(1L);
        builder.name("react");
        builder.boardId(1L);
        return builder.build();
    }

    public MemberDto.Response createMember1() {
        MemberDto.Response.ResponseBuilder builder = MemberDto.Response.builder();
        builder.memberId(1L);
        builder.email("stub email@email.com");
        builder.password("password");
        builder.displayName("display_name");
        builder.fullName("홍길동");
        builder.location("home");
        builder.title("자기소개");
        builder.aboutMe("자기소개 내용");
        builder.websiteLink("link1");
        builder.twitterLink("link2");
        builder.githubLink("link3");
        builder.profileImageUrl("image url");
        builder.memberStatus("활동중");
        builder.reputation(10);
        builder.questions(3);
        builder.answers(3);
        MemberDto.Response response;
        response = builder.build();

        return response;
    }

    public MemberDto.Response createMember2() {
        MemberDto.Response.ResponseBuilder builder = MemberDto.Response.builder();
        builder.memberId(2L);
        builder.email("Hongildong@email.com");
        builder.password("password");
        builder.displayName("display_name");
        builder.fullName("홍길동2");
        builder.location("home");
        builder.title("자기소개");
        builder.aboutMe("자기소개 내용");
        builder.websiteLink("link1");
        builder.twitterLink("link2");
        builder.githubLink("link3");
        builder.profileImageUrl("image url");
        builder.memberStatus("활동중");
        builder.reputation(20);
        builder.questions(5);
        builder.answers(5);
        MemberDto.Response response;
        response = builder.build();

        return response;
    }

    public BoardDto.Response createQuestion() {
        BoardDto.Response.ResponseBuilder builder = BoardDto.Response.builder();
        builder.boardId(1L);
        builder.writerMemberId(1L);
        builder.writerReputation(10L);
        builder.writerProfileUrl("url");
        builder.writerDisplayName("홍길동1");
        builder.boardStatus("공개");
        builder.boardType("Question");
        builder.title("What is Lorem Ipsum?");
        builder.body("Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
        builder.tags(List.of("java", "react"));
        builder.score(10);
        builder.viewCount(1000);
        builder.answerCount(5);
        builder.bookmarkCount(20);
        builder.questionId(null);
        builder.answers(List.of(2L, 3L));
        BoardDto.Response response;
        response = builder.build();

        return response;
    }

    public BoardDto.Response createAnswer() {
        BoardDto.Response.ResponseBuilder builder = BoardDto.Response.builder();
        builder.boardId(2L);
        builder.writerMemberId(2L);
        builder.writerReputation(20L);
        builder.writerProfileUrl("url");
        builder.writerDisplayName("홍길동2");
        builder.boardStatus("임시저장");
        builder.boardType("Answer");
        builder.title("What is Lorem Ipsum?");
        builder.body("Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
        builder.tags(List.of("javascript"));
        builder.score(20);
        builder.viewCount(500);
        builder.answerCount(5);
        builder.bookmarkCount(30);
        builder.questionId(1L);
        BoardDto.Response response;
        response = builder.build();

        return response;
    }
}
