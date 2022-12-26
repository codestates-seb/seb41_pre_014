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

    @GetMapping("/{tag-id}")
    public ResponseEntity findTag() {
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity findAllTag() {
        return ResponseEntity.ok().build();
    }


}
