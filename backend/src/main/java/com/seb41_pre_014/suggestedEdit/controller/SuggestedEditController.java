package com.seb41_pre_014.suggestedEdit.controller;


import com.seb41_pre_014.board.dto.BoardDto;
import com.seb41_pre_014.suggestedEdit.dto.SuggestedEditDto;
import com.seb41_pre_014.suggestedEdit.entity.SuggestedEdit;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/suggested-edits")
public class SuggestedEditController {

    @PostMapping
    public ResponseEntity postEdit(@RequestParam("memberId") @Positive Long memberId,
                                   @RequestParam("boardId") @Positive Long boardId,
                                   @RequestBody @Valid SuggestedEditDto.Post postEdit) {
        SuggestedEditDto.Response edit = stubEdit(1);
        return new ResponseEntity(edit, HttpStatus.CREATED);
    }

    @PatchMapping("/{edit-id}")
    public ResponseEntity patchEdit(@PathVariable("edit-id") @Positive Long editId,
                                    @RequestBody @Valid SuggestedEditDto.Patch patchEdit) {
        SuggestedEditDto.Response edit = stubEdit(1);
        return new ResponseEntity(edit, HttpStatus.OK);
    }

    @GetMapping("/{edit-id}")
    public ResponseEntity findEdit(@PathVariable("edit-id") @Positive Long editId) {
        SuggestedEditDto.Response edit1 = stubEdit(1);
        SuggestedEditDto.Response edit2 = stubEdit(2);
        SuggestedEditDto.Response edit3 = stubEdit(3);
        return new ResponseEntity(edit1, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity findAllEdit(@RequestParam(value = "page", defaultValue = "1") @Positive int page,
                                      @RequestParam(value = "size", defaultValue = "20") @Positive int size) {
        SuggestedEditDto.Response edit1 = stubEdit(1);
        SuggestedEditDto.Response edit2 = stubEdit(2);
        SuggestedEditDto.Response edit3 = stubEdit(3);
        return new ResponseEntity(List.of(edit1, edit2, edit3), HttpStatus.OK);
    }

    @DeleteMapping("/{edit-id}")
    public ResponseEntity deleteEdit(@PathVariable("edit-id") @Positive Long editId) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public SuggestedEditDto.Response stubEdit(long n) {
        SuggestedEditDto.Response.ResponseBuilder builder = SuggestedEditDto.Response.builder();
        return builder
                .editId(n)
                .title("TempEdit" + n)
                .editorId(n)
                .boardId(n)
                .editId(n)
                .body("Body of TempEdit" + n)
                .tags(List.of("tag" + n, "tag2" + n + 1))
                .editStatus("처리중")
                .build();
    }


}
