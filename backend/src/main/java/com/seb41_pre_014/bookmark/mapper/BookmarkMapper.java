package com.seb41_pre_014.bookmark.mapper;

import com.seb41_pre_014.bookmark.dto.BookmarkDto;
import com.seb41_pre_014.bookmark.entity.Bookmark;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookmarkMapper {

    BookmarkDto.Response bookmarkToResponseDto(Bookmark bookmark);
    List<BookmarkDto.Response> bookmarksToResponseDtos(List<Bookmark> bookmarks);

}
