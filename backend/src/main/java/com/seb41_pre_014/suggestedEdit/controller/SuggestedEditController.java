package com.seb41_pre_014.suggestedEdit.controller;


import com.seb41_pre_014.board.dto.BoardDto;
import com.seb41_pre_014.suggestedEdit.dto.SuggestedEditDto;
import com.seb41_pre_014.suggestedEdit.entity.SuggestedEdit;
import com.seb41_pre_014.suggestedEdit.mapper.SuggestedEditMapper;
import com.seb41_pre_014.suggestedEdit.service.SuggestedEditService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/suggested-edits")
@RequiredArgsConstructor
public class SuggestedEditController {

    private final SuggestedEditService suggestedEditService;
    private final SuggestedEditMapper mapper;

    @PostMapping
    public ResponseEntity postEdit(@RequestParam("memberId") @Positive Long memberId,
                                   @RequestParam("boardId") @Positive Long boardId,
                                   @RequestBody @Valid SuggestedEditDto.Post postEdit) {
        SuggestedEdit suggestedEdit = mapper.suggestedEditPostDtoToEdit(postEdit);
        SuggestedEdit saveSuggestedEdit = suggestedEditService.postEdit(memberId, boardId, suggestedEdit);
        SuggestedEditDto.Response responseDto = mapper.editToSuggestedEditResponseDto(saveSuggestedEdit);

        log.info("{}", responseDto.getEditId());
        log.info("{}", responseDto.getEditStatus());

        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @PatchMapping("/{edit-id}")
    public ResponseEntity patchEdit(@PathVariable("edit-id") @Positive Long editId,
                                    @RequestBody @Valid SuggestedEditDto.Patch patchEdit) {
        SuggestedEdit suggestedEdit = mapper.suggestedEditPatchDtoToEdit(patchEdit);
        suggestedEdit.setId(editId);
        SuggestedEdit updateSUggestedEdit = suggestedEditService.patchEdit(suggestedEdit);

        return new ResponseEntity<>(mapper.editToSuggestedEditResponseDto(updateSUggestedEdit), HttpStatus.OK);
    }

    @GetMapping("/{edit-id}")
    public ResponseEntity findEdit(@PathVariable("edit-id") @Positive Long editId) {
        SuggestedEdit findEdit = suggestedEditService.findEdit(editId);

        return new ResponseEntity<>(mapper.editToSuggestedEditResponseDto(findEdit), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity findAllEdit(@RequestParam(value = "page", defaultValue = "1") @Positive int page,
                                      @RequestParam(value = "size", defaultValue = "20") @Positive int size) {
        List<SuggestedEdit> suggestedEdits = suggestedEditService.findAllEdit(page, size).getContent();

        return new ResponseEntity<>(mapper.editsTosuggestedEditResponseDtos(suggestedEdits), HttpStatus.OK);
    }

    @DeleteMapping("/{edit-id}")
    public ResponseEntity deleteEdit(@PathVariable("edit-id") @Positive Long editId) {
        suggestedEditService.deleteEdit(editId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
