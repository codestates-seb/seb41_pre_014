package com.seb41_pre_014.tag.controller;

import com.seb41_pre_014.tag.dto.TagDto;
import com.seb41_pre_014.tag.entity.Tag;
import com.seb41_pre_014.tag.mapper.TagMapper;
import com.seb41_pre_014.tag.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;
    private final TagMapper mapper;

    @PostMapping
    public ResponseEntity postTag(@RequestBody @Valid TagDto.Post postDto) {
        Tag tag = mapper.tagPostDtoToTag(postDto);
        Tag postTag = tagService.createTag(tag);

        return new ResponseEntity(mapper.tagToResponseDto(postTag), HttpStatus.CREATED);
    }

    // 태그는 통상 수정이 없고 항상 새로운 태그가 생성되므로 patchTag는 없음
    @GetMapping("/{tag-id}")
    public ResponseEntity findTag(@PathVariable("tag-id") @Positive Long tagId) {
        Tag findTag = tagService.findTag(tagId);

        return new ResponseEntity(mapper.tagToResponseDto(findTag), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity findAllTag(@RequestParam(value = "page", defaultValue = "1") @Positive int page,
                                     @RequestParam(value = "size", defaultValue = "20") @Positive int size) {
        List<Tag> tags = tagService.findAll(page, size).getContent();

        return new ResponseEntity(mapper.tagsToResponseDtos(tags), HttpStatus.OK);
    }

    @DeleteMapping("/{tag-id}")
    public ResponseEntity deleteTag(@PathVariable("tag-id") @Positive Long tagId) {
        tagService.deleteTag(tagId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}