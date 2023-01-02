//package com.seb41_pre_014.restdocs.Tag;
//
//
//import com.google.gson.Gson;
//import com.seb41_pre_014.tag.controller.TagController;
//import com.seb41_pre_014.tag.dto.TagDto;
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
//
//import java.util.List;
//
//import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
//import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
//import static org.springframework.restdocs.payload.PayloadDocumentation.*;
//import static org.springframework.restdocs.request.RequestDocumentation.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import org.springframework.util.LinkedMultiValueMap;
//import org.springframework.util.MultiValueMap;
//
//import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
//
//import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
//
//
//@WebMvcTest(TagController.class)
//@MockBean(JpaMetamodelMappingContext.class)
//@AutoConfigureRestDocs
//class TagControllerRestDocsTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private Gson gson;
//
//    @Test
//    void postTagTest() throws Exception {
//        // given
//        TagDto.Post post = new TagDto.Post("java");
//        String content = gson.toJson(post);
//
//        ResultActions actions =
//                mockMvc.perform(
//                        post("/tags")
//                                .accept(MediaType.APPLICATION_JSON)
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(content));
//
//        // then
//        actions
//                .andExpect(status().isCreated())
//                .andDo(document(
//                        "post-tag",
//                        preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint()),
//                        requestFields(
//                                List.of(
//                                        fieldWithPath("name").type(JsonFieldType.STRING).description("Tag 이름")
//                                )
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("tagId").type(JsonFieldType.NUMBER).description("Tag 인덱스"),
//                                        fieldWithPath("name").type(JsonFieldType.STRING).description("Tag 이름")
//                                )
//                        )));
//    }
//
//
//    @Test
//    void findTagTest() throws Exception {
//        // given
//        // when
//        ResultActions actions =
//                mockMvc.perform(
//                        get("/tags/{tag-id}", 1L)
//                                .accept(MediaType.APPLICATION_JSON)
//                );
//
//        // then
//        actions
//                .andExpect(status().isOk())
//                .andDo(document(
//                        "find-tag",
//                        preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint()),
//                        pathParameters(
//                                List.of(parameterWithName("tag-id").description("Tag 인덱스"))
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("tagId").type(JsonFieldType.NUMBER).description("Tag 인덱스"),
//                                        fieldWithPath("name").type(JsonFieldType.STRING).description("Tag 이름")
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
//                        get("/tags")
//                                .params(queryParams)
//                                .accept(MediaType.APPLICATION_JSON)
//                );
//
//        // then
//        actions
//                .andExpect(status().isOk())
//                .andDo(document(
//                        "find-all-tag",
//                        preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint()),
//                        requestParameters(
//                                List.of(parameterWithName("page").description("page number"),
//                                        parameterWithName("size").description("number of edits"))
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("[].tagId").type(JsonFieldType.NUMBER).description("Tag 인덱스"),
//                                        fieldWithPath("[].name").type(JsonFieldType.STRING).description("Tag 이름")
//                                )
//
//                        )));
//    }
//
//    @Test
//    void deleteTagTest() throws Exception {
//        // given
//        // when
//        ResultActions actions =
//                mockMvc.perform(
//                        delete("/tags/{tag-id}", 1L)
//                );
//
//        // then
//        actions
//                .andExpect(status().isNoContent())
//                .andDo(document(
//                        "delete-tags",
//                        preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint()),
//                        pathParameters(
//                                List.of(parameterWithName("tag-id").description("삭제하려는 Tag 인덱스")
//                                )
//                        )));
//    }
//}
//
