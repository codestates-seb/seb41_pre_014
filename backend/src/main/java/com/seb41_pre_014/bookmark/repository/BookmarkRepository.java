package com.seb41_pre_014.bookmark.repository;

import com.seb41_pre_014.bookmark.entity.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
}
