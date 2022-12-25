package com.seb41_pre_014.suggestedEdit.controller;


import com.seb41_pre_014.suggestedEdit.dto.SuggestedEditDto;
import com.seb41_pre_014.suggestedEdit.entity.SuggestedEdit;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suggested-edits")
public class SuggestedEditController {

    @PostMapping
    public ResponseEntity postEdit() {
        SuggestedEditDto.Response edit = stubEdit(1);
        return new ResponseEntity(edit, HttpStatus.CREATED);
    }

    @PatchMapping("/{edits-id}")
    public ResponseEntity patchEdit() {
        SuggestedEditDto.Response edit = stubEdit(1);
        return new ResponseEntity(edit, HttpStatus.CREATED);
    }

    @GetMapping("/{edits-id}")
    public ResponseEntity findEdit() {
        SuggestedEditDto.Response edit1 = stubEdit(1);
        SuggestedEditDto.Response edit2 = stubEdit(2);
        SuggestedEditDto.Response edit3 = stubEdit(3);
        return new ResponseEntity(edit1, HttpStatus.OK);
    }

    @GetMapping
    public  ResponseEntity findAllEdit() {
        SuggestedEditDto.Response edit1 = stubEdit(1);
        SuggestedEditDto.Response edit2 = stubEdit(2);
        SuggestedEditDto.Response edit3 = stubEdit(3);
        return new ResponseEntity(List.of(edit1, edit2, edit3), HttpStatus.OK);}

    public SuggestedEditDto.Response stubEdit(long n) {
        SuggestedEditDto.Response.ResponseBuilder builder = SuggestedEditDto.Response.builder();
        SuggestedEditDto.Response response = builder
                .editId(n)
                .title("TempEdit" + n)
                .boardId(n)
                .editId(n)
                .body("Body of TempEdit" + n)
                .tag(List.of("tag"+n,"tag2"+n+1))
                .build();

        return response;
    }


}
