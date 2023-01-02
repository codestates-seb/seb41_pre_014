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

import java.util.Optional;

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

    @Transactional
    public Tag findTagByName(String tagName) {
        return findVerifiedTagByName(tagName);
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

    @Transactional
    public Tag findVerifiedTagByName(String tagName) {
        Optional<Tag> tag = tagRepository.findByName(tagName);
        if (tag.isEmpty()) {
            return createTag(Tag.builder().name(tagName).build());
        }
        return tag.get();
    }

}
