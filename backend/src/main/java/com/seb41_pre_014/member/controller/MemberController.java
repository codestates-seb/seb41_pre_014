package com.seb41_pre_014.member.controller;


import com.seb41_pre_014.board.dto.BoardDto;
import com.seb41_pre_014.board.entity.Board;
import com.seb41_pre_014.board.mapper.BoardMapper;
import com.seb41_pre_014.member.dto.MemberDto;
import com.seb41_pre_014.member.entity.Member;
import com.seb41_pre_014.member.mapper.MemberMapper;
import com.seb41_pre_014.member.service.MemberService;
import com.seb41_pre_014.tag.dto.TagDto;
import com.seb41_pre_014.tag.entity.Tag;
import com.seb41_pre_014.tag.mapper.TagMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

import static com.seb41_pre_014.board.entity.Board.BoardType.ANSWER;
import static com.seb41_pre_014.board.entity.Board.BoardType.QUESTION;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final MemberMapper mapper;
    private final BoardMapper boardMapper;
    private final TagMapper tagMapper;

    @PostMapping
    public ResponseEntity postMember(@RequestBody @Valid MemberDto.Post postDto) {
        Member member = mapper.memberPostDtoToMember(postDto);
        Member saveMember = memberService.createMember(member);

        return new ResponseEntity<>(mapper.memberToResponseDto(saveMember), HttpStatus.CREATED);
    }

    @PatchMapping("/{member-id}")
    public ResponseEntity patchMember(@PathVariable("member-id") @Positive Long memberId,
                                      @RequestBody @Valid MemberDto.Patch patchDto) {
        Member member = mapper.memberPatchDtoToMember(patchDto);
        member.setMemberId(memberId);
        Member updateMember = memberService.updateMember(member);

        return new ResponseEntity<>(mapper.memberToResponseDto(updateMember), HttpStatus.OK);
    }

    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id") @Positive Long memberId) {
        Member findMember = memberService.findMember(memberId);

        return new ResponseEntity<>(mapper.memberToResponseDto(findMember), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getMembers(@RequestParam("page") @Positive int page,
                                     @RequestParam("size") @Positive int size) {
        List<Member> members = memberService.findAll(page, size).getContent();

        return new ResponseEntity<>(mapper.membersToResponseDtos(members), HttpStatus.OK);
    }

    @GetMapping("/{member-id}/questions")
    public ResponseEntity getQuestionsByMember(@PathVariable("member-id") @Positive Long memberId,
                                               @RequestParam("page") @Positive int page,
                                               @RequestParam("size") @Positive int size) {
        List<Board> boards = memberService.findQuestionsOrAnswersByMember(memberId, QUESTION, page, size).getContent();

        return new ResponseEntity<>(boardMapper.boardsToBoardResponseDtos(boards), HttpStatus.OK);
    }

    @GetMapping("/{member-id}/answers")
    public ResponseEntity getAnswersByMember(@PathVariable("member-id") @Positive Long memberId,
                                             @RequestParam("page") @Positive int page,
                                             @RequestParam("size") @Positive int size) {
        List<Board> boards = memberService.findQuestionsOrAnswersByMember(memberId, ANSWER, page, size).getContent();

        return new ResponseEntity<>(boardMapper.boardsToBoardResponseDtos(boards), HttpStatus.OK);
    }

    @GetMapping("/{member-id}/tags")
    public ResponseEntity getTagsByMember(@PathVariable("member-id") @Positive Long memberId,
                                          @RequestParam("page") @Positive int page,
                                          @RequestParam("size") @Positive int size) {
        List<Tag> tags = memberService.findTagsByMember(memberId, page, size).getContent();

        return new ResponseEntity<>(tagMapper.tagsToResponseDtos(tags), HttpStatus.OK);
    }

    @GetMapping("/{member-id}/bookmarks")
    public ResponseEntity getBoardsByBookmark(@PathVariable("member-id") @Positive Long memberId,
                                               @RequestParam("page") @Positive int page,
                                               @RequestParam("size") @Positive int size) {
        List<Board> boards = memberService.findBoardsByBookmark(memberId, page, size).getContent();

        return new ResponseEntity<>(boardMapper.boardsToBoardResponseDtos(boards), HttpStatus.OK);
    }

    @GetMapping("/{member-id}/votes")
    public ResponseEntity getBoardsByVote(@PathVariable("member-id") @Positive Long memberId,
                                          @RequestParam("page") @Positive int page,
                                          @RequestParam("size") @Positive int size) {
        List<Board> boards = memberService.findBoardsByVote(memberId, page, size).getContent();

        return new ResponseEntity<>(boardMapper.boardsToBoardResponseDtos(boards), HttpStatus.OK);
    }

    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable("member-id") @Positive Long memberid) {
        memberService.deleteMember(memberid);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
