//package com.seb41_pre_014.restdocs.bookmark;
//
//import com.google.gson.Gson;
//import com.seb41_pre_014.bookmark.controller.BookmarkController;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
//import org.springframework.restdocs.payload.JsonFieldType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.util.LinkedMultiValueMap;
//import org.springframework.util.MultiValueMap;
//
//import java.util.List;
//
//import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
//import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.delete;
//import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
//import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
//import static org.springframework.restdocs.payload.PayloadDocumentation.*;
//import static org.springframework.restdocs.request.RequestDocumentation.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(BookmarkController.class)
//@MockBean(JpaMetamodelMappingContext.class)
//@AutoConfigureRestDocs
//public class BookmarkControllerRestDocs {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private Gson gson;
//
//    @Test
//    void postBookmark() throws Exception {
//        // given
//        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//        params.add("memberId", String.valueOf(1L));
//        params.add("boardId", String.valueOf(1L));
//
//        // when
//        ResultActions actions = mockMvc.perform(
//                post("/bookmarks")
//                        .params(params));
//
//        // then
//        actions
//                .andExpect(status().isCreated())
//                .andDo(document("post-bookmark",
//                        preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint()),
//                        requestParameters(
//                                List.of(
//                                        parameterWithName("memberId").description("bookmark를 한 Member의 인덱스"),
//                                        parameterWithName("boardId").description("bookmark 된 Board의 인덱스")
//                                )
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("bookmarkId").type(JsonFieldType.NUMBER).description("bookmark 인덱스"),
//                                        fieldWithPath("memberId").type(JsonFieldType.NUMBER).description("bookmark를 한 Member의 인덱스"),
//                                        fieldWithPath("boardId").type(JsonFieldType.NUMBER).description("bookmark 된 Board의 인덱스")
//                                )
//                        )));
//    }
//
//    @Test
//    void deleteBookmark() throws Exception {
//        // given
//
//        // when
//        ResultActions actions = mockMvc.perform(
//                delete("/bookmarks/{bookmark-id}", 1L));
//        // tehn
//        actions
//                .andExpect(status().isNoContent())
//                .andDo(document("delete-bookmark",
//                        preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint()),
//                        pathParameters(
//                                List.of(
//                                        parameterWithName("bookmark-id").description("삭제하려는 Bookamrk의 인덱스")
//                                )
//                        )));
//    }
//}
