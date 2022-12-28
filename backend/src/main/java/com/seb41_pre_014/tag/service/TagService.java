package com.seb41_pre_014.tag.service;

import com.seb41_pre_014.exception.BusinessLogicException;
import com.seb41_pre_014.exception.ExceptionCode;
import com.seb41_pre_014.tag.entity.Tag;
import com.seb41_pre_014.tag.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepository;

    @Transactional
    public Tag createTag(Tag tag) {
        return tagRepository.save(tag);
    }

    public Tag findTag(Long tagId) {
        return findVerifiedTag(tagId);
    }

    public Page<Tag> findAll(int page, int size) {
        return tagRepository.findAll(PageRequest.of(page - 1, size,
                Sort.by("tagId").descending()));
    }

    @Transactional
    public void deleteTag(Long tagId) {
        findVerifiedTag(tagId);
        tagRepository.deleteById(tagId);
    }

    public Tag findVerifiedTag(Long tagId) {
        return tagRepository.findById(tagId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.TAG_NOT_FOUND));
    }
}
