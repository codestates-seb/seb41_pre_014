//package com.seb41_pre_014.restdocs.SuggestedEdit;
//
//import com.google.gson.Gson;
//import com.seb41_pre_014.suggestedEdit.controller.SuggestedEditController;
//import com.seb41_pre_014.suggestedEdit.dto.SuggestedEditDto;
//import com.seb41_pre_014.suggestedEdit.entity.SuggestedEdit;
//import com.seb41_pre_014.vote.controller.VoteController;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
//import org.springframework.http.MediaType;
//import org.springframework.restdocs.payload.JsonFieldType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.util.LinkedMultiValueMap;
//import org.springframework.util.MultiValueMap;
//
//import java.util.List;
//
//import static org.hamcrest.Matchers.is;
//import static org.hamcrest.Matchers.startsWith;
//import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
//import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
//import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.delete;
//import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
//import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
//import static org.springframework.restdocs.payload.PayloadDocumentation.*;
//import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
//import static org.springframework.restdocs.request.RequestDocumentation.*;
//import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(SuggestedEditController.class)
//@MockBean(JpaMetamodelMappingContext.class)
//@AutoConfigureRestDocs
//class SuggestedEditControllerRestDocsTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private Gson gson;
//
//    @Test
//    void postSuggestedEditTest() throws Exception {
//        // given
//        SuggestedEditDto.Post post = new SuggestedEditDto.Post("Length of title must be more than 15",
//                "Length of body must be more than 20",
//                List.of("tag1", "tag2"));
//        String content = gson.toJson(post);
//        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//        params.add("memberId", String.valueOf(1L));
//        params.add("boardId", String.valueOf(1L));
//
//        ResultActions actions =
//                mockMvc.perform(
//                        post("/suggested-edits")
//                                .params(params)
//                                .accept(MediaType.APPLICATION_JSON)
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(content)
//                );
//
//        // then
//        actions
//                .andExpect(status().isCreated())
//                .andDo(document(
//                        "post-suggested-edits",
//                        preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint()),
//                        requestParameters(
//                                List.of(
//                                        parameterWithName("memberId").description("수정을 제안하는 Member 인덱스"),
//                                        parameterWithName("boardId").description("수정하려는 Board 인덱스")
//                                )
//                        ),
//                        requestFields(
//                                List.of(
//                                        fieldWithPath("title").type(JsonFieldType.STRING).description("제목"),
//                                        fieldWithPath("body").type(JsonFieldType.STRING).description("내용"),
//                                        fieldWithPath("tags").type(JsonFieldType.ARRAY).description("태그")
//                                )
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("editId").type(JsonFieldType.NUMBER).description("SuggestedEdit 인덱스"),
//                                        fieldWithPath("boardId").type(JsonFieldType.NUMBER).description("수정하려는 Board 인덱스"),
//                                        fieldWithPath("editorId").type(JsonFieldType.NUMBER).description("수정을 제안하는 Member 인덱스"),
//                                        fieldWithPath("title").type(JsonFieldType.STRING).description("제목"),
//                                        fieldWithPath("body").type(JsonFieldType.STRING).description("내용"),
//                                        fieldWithPath("tags").type(JsonFieldType.ARRAY).description("태그"),
//                                        fieldWithPath("editStatus").type(JsonFieldType.STRING).description("수정 제안서 상태 : Pending / Accepted / Rejected")
//                                )
//                        )));
//    }
//
//    @Test
//    void updateSuggestedEditTest() throws Exception {
//        // given
//        SuggestedEditDto.Patch patch = new SuggestedEditDto.Patch(
//                "This is title, must be longer than 15",
//                "This is body, must be longer than 20",
//                List.of("tag1", "tag2"));
//        String content = gson.toJson(patch);
//
//        ResultActions actions =
//                mockMvc.perform(
//                        patch("/suggested-edits/{edit-id}", 1L)
//                                .accept(MediaType.APPLICATION_JSON)
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(content)
//                );
//
//        // then
//        actions
//                .andExpect(status().isOk())
//                .andDo(document(
//                        "update-suggested-edits",
//                        preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint()),
//                        pathParameters(
//                                List.of(parameterWithName("edit-id").description("수정하려는 SuggestedEdit 인덱스"))
//                        ),
//                        requestFields(
//                                List.of(
//                                        fieldWithPath("editId").type(JsonFieldType.NUMBER).description("SuggestedEdit 인덱스"),
//                                        fieldWithPath("boardId").type(JsonFieldType.NUMBER).description("수정하려는 Board 인덱스"),
//                                        fieldWithPath("editorId").type(JsonFieldType.NUMBER).description("수정을 제안하는 Member 인덱스"),
//                                        fieldWithPath("title").type(JsonFieldType.STRING).description("제목"),
//                                        fieldWithPath("body").type(JsonFieldType.STRING).description("내용"),
//                                        fieldWithPath("tags").type(JsonFieldType.ARRAY).description("태그")
//                                )
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("editId").type(JsonFieldType.NUMBER).description("SuggestedEdit 인덱스"),
//                                        fieldWithPath("boardId").type(JsonFieldType.NUMBER).description("수정하려는 Board 인덱스"),
//                                        fieldWithPath("editorId").type(JsonFieldType.NUMBER).description("수정을 제안하는 Member 인덱스"),
//                                        fieldWithPath("title").type(JsonFieldType.STRING).description("제목"),
//                                        fieldWithPath("body").type(JsonFieldType.STRING).description("내용"),
//                                        fieldWithPath("tags").type(JsonFieldType.ARRAY).description("태그"),
//                                        fieldWithPath("editStatus").type(JsonFieldType.STRING).description("수정 제안서 상태 : Pending / Accepted / Rejected")
//                                )
//                        )));
//    }
//
//    @Test
//    void findSuggestedEditTest() throws Exception {
//        // given
//        // when
//        ResultActions actions =
//                mockMvc.perform(
//                        get("/suggested-edits/{edit-id}", 1L)
//                                .accept(MediaType.APPLICATION_JSON)
//                );
//
//        // then
//        actions
//                .andExpect(status().isOk())
//                .andDo(document(
//                        "find-suggested-edit",
//                        preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint()),
//                        pathParameters(
//                                List.of(parameterWithName("edit-id").description("수정을 제안하는 Member 인덱스"))
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("editId").type(JsonFieldType.NUMBER).description("SuggestedEdit 인덱스"),
//                                        fieldWithPath("boardId").type(JsonFieldType.NUMBER).description("수정하려는 Board 인덱스"),
//                                        fieldWithPath("editorId").type(JsonFieldType.NUMBER).description("수정을 제안하는 Member 인덱스"),
//                                        fieldWithPath("title").type(JsonFieldType.STRING).description("제목"),
//                                        fieldWithPath("body").type(JsonFieldType.STRING).description("내용"),
//                                        fieldWithPath("tags").type(JsonFieldType.ARRAY).description("태그"),
//                                        fieldWithPath("editStatus").type(JsonFieldType.STRING).description("수정 제안서 상태 : Pending / Accepted / Rejected")
//                                )
//                        )));
//    }
//
//    @Test
//    void findAllSuggestedEditTest() throws Exception {
//        // given
//        String page = "1";
//        String size = "10";
//        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
//        queryParams.add("page", page);
//        queryParams.add("size", size);
//
//        // when
//        ResultActions actions =
//                mockMvc.perform(
//                        get("/suggested-edits")
//                                .params(queryParams)
//                                .accept(MediaType.APPLICATION_JSON)
//                );
//
//        // then
//        actions
//                .andExpect(status().isOk())
//                .andDo(document(
//                        "find-all-suggested-edit",
//                        preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint()),
//                        requestParameters(
//                                List.of(parameterWithName("page").description("page number"),
//                                        parameterWithName("size").description("number of edits"))
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("[].editId").type(JsonFieldType.NUMBER).description("수정 제안서 ID"),
//                                        fieldWithPath("[].title").type(JsonFieldType.STRING).description("제목"),
//                                        fieldWithPath("[].boardId").type(JsonFieldType.NUMBER).description("원본 게시글 ID"),
//                                        fieldWithPath("[].editorId").type(JsonFieldType.NUMBER).description("수정요청자 ID"),
//                                        fieldWithPath("[].body").type(JsonFieldType.STRING).description("내용"),
//                                        fieldWithPath("[].tags").type(JsonFieldType.ARRAY).description("태그"),
//                                        fieldWithPath("[].editStatus").type(JsonFieldType.STRING).description("수정 제안서 상태")
//                                )
//                        )));
//    }
//
//    @Test
//    void deleteSuggestedEditTest() throws Exception {
//        // given
//        // when
//        ResultActions actions =
//                mockMvc.perform(
//                        delete("/suggested-edits/{edit-id}", 1L)
//                );
//
//        // then
//        actions
//                .andExpect(status().isNoContent())
//                .andDo(document(
//                        "delete-suggested-edits",
//                        preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint()),
//                        pathParameters(
//                                List.of(parameterWithName("edit-id").description("삭제하려는 SuggestedEdit 인덱스")
//                                )
//                        )));
//    }
//}
