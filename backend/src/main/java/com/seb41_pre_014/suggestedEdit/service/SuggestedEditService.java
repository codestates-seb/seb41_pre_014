package com.seb41_pre_014.suggestedEdit.service;

import com.seb41_pre_014.board.entity.Board;
import com.seb41_pre_014.board.service.BoardService;
import com.seb41_pre_014.exception.BusinessLogicException;
import com.seb41_pre_014.exception.ExceptionCode;
import com.seb41_pre_014.member.entity.Member;
import com.seb41_pre_014.member.service.MemberService;
import com.seb41_pre_014.suggestedEdit.entity.SuggestedEdit;
import com.seb41_pre_014.suggestedEdit.repository.SuggestedEditRepository;
import com.seb41_pre_014.util.CustomBeanUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.seb41_pre_014.suggestedEdit.entity.SuggestedEdit.EditStatus.EDIT_PENDING;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SuggestedEditService {

    private final SuggestedEditRepository suggestedEditRepository;
    private final CustomBeanUtils<SuggestedEdit> beanUtils;
    private final MemberService memberService;
    private final BoardService boardService;

    @Transactional
    public SuggestedEdit postEdit(Long memberId, Long boardId, SuggestedEdit suggestedEdit) {
        Member member = memberService.findMember(memberId);
        Board board = boardService.findBoard(boardId);
        suggestedEdit.setMemberAndBoard(member, board);
        suggestedEdit.changeStatus(EDIT_PENDING);

        return suggestedEditRepository.save(suggestedEdit);
    }

    @Transactional
    public SuggestedEdit patchEdit(SuggestedEdit suggestedEdit) {
        SuggestedEdit findSuggestedEdit = findVerifiedEdit(suggestedEdit.getEditId());
        return beanUtils.copyNonNullProperties(suggestedEdit, findSuggestedEdit);
    }

    public SuggestedEdit findEdit(Long editId) {
        return findVerifiedEdit(editId);
    }

    public Page<SuggestedEdit> findAllEdit(int page, int size) {
        return suggestedEditRepository.findAll(
                PageRequest.of(page - 1, size, Sort.by("editId").descending()));
    }

    public void deleteEdit(Long editId) {
        findVerifiedEdit(editId);
        suggestedEditRepository.deleteById(editId);
    }

    public SuggestedEdit findVerifiedEdit(Long editId) {
        return suggestedEditRepository.findById(editId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.SUGGESTED_EDIT_NOT_FOUND));
    }
}
