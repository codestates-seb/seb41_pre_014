package com.seb41_pre_014.tag.controller;

//<<<<<<< HEAD
import com.seb41_pre_014.board.dto.BoardDto;
import com.seb41_pre_014.suggestedEdit.dto.SuggestedEditDto;
import com.seb41_pre_014.tag.dto.TagDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//=======
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;
//>>>>>>> origin/iss8

@RestController
@RequestMapping("/tags")
public class TagController {

    @PostMapping("/{tag-id}")
    public ResponseEntity postTag(@PathVariable("tag-id") @Positive Long tagId,
                                  @RequestParam("editId") @Positive Long editId,
                                  @RequestBody @Valid TagDto.Post postTag) {
        TagDto.Response tag1 = stubTag(1);


        return new ResponseEntity(tag1, HttpStatus.CREATED);
    }

    // 태그는 통상 수정이 없고 항상 새로운 태그가 생성되므로 patchTag는 없음

    @GetMapping("/{tag-id}")
    public ResponseEntity findTag(@PathVariable("tag-id") @Positive Long tagId) {
        TagDto.Response tag1 = stubTag(1);


        return new ResponseEntity(tag1, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity findAllTag(@RequestParam(value = "page", defaultValue = "1") @Positive int page,
                                     @RequestParam(value = "size", defaultValue = "20") @Positive int size) {

        TagDto.Response tag1 = stubTag(1);
        TagDto.Response tag2 = stubTag(2);
        TagDto.Response tag3 = stubTag(3);
        return new ResponseEntity(List.of(tag1, tag2, tag3), HttpStatus.OK);
    }

    public TagDto.Response stubTag(long n) {
        TagDto.Response.ResponseBuilder builder = TagDto.Response.builder();
        TagDto.Response response = builder
                .tagId(n)
                .name("tag"+n)
                .boardId(n)
                .build();

        return response;
    }


}
