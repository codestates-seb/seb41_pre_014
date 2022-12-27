package com.seb41_pre_014.restdocs.Tag;


import com.google.gson.Gson;
import com.seb41_pre_014.suggestedEdit.controller.SuggestedEditController;
import com.seb41_pre_014.suggestedEdit.dto.SuggestedEditDto;
import com.seb41_pre_014.tag.dto.TagDto;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.headers.HeaderDocumentation.headerWithName;
import static org.springframework.restdocs.headers.HeaderDocumentation.responseHeaders;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.patch;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.restdocs.operation.preprocess.OperationRequestPreprocessor;
import org.springframework.restdocs.operation.preprocess.OperationResponsePreprocessor;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;

import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;


@WebMvcTest(SuggestedEditController.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
public class TagControllerRestDocsTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Gson gson;

    @Test
    public void postTagTest() throws Exception {
        // given
        TagDto.Post post = new TagDto.Post("tagName");
        String content = gson.toJson(post);

        TagDto.Response response =
                new TagDto.Response(1L, "tagName", 1L);

        ResultActions actions =
                mockMvc.perform(
                        post("/tags")
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(content)
                );

        // then
        actions
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", is(startsWith("/tags/"))))
                .andDo(document(
                        "post-tags",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        requestParameters(
                                List.of(parameterWithName("tagId").description("Tag ID"))
                        ),
                        requestFields(
                                List.of(
                                        fieldWithPath("name").type(JsonFieldType.STRING).description("태그명")
                                )
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("tagId").type(JsonFieldType.STRING).description("Tag ID"),
                                        fieldWithPath("name").type(JsonFieldType.STRING).description("태그명"),
                                        fieldWithPath("boardId").type(JsonFieldType.STRING).description("원본 게시글 ID")
                                )

                        )));
    }


    @Test
    public void findTagTest() throws Exception {
        // given
        // when

        ResultActions actions =
                mockMvc.perform(
                        post("/tags/{tag-id}", 1L)
                                .accept(MediaType.APPLICATION_JSON)
                );

        // then
        actions
                .andExpect(status().isOk())
                .andExpect(header().string("Location", is(startsWith("/tags/{tag-id}"))))
                .andDo(document(
                        "find-tag",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        requestParameters(
                                List.of(parameterWithName("tagId").description("Tag ID"))
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("tagId").type(JsonFieldType.STRING).description("Tag ID"),
                                        fieldWithPath("name").type(JsonFieldType.STRING).description("태그명"),
                                        fieldWithPath("boardId").type(JsonFieldType.STRING).description("원본 게시글 ID")
                                )

                        )));
    }

    @Test
    public void findAllSuggestedEditTest() throws Exception {
        // given
        String page = "1";
        String size = "10";
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("page", page);
        queryParams.add("size", size);

        // when

        ResultActions actions =
                mockMvc.perform(
                        get("/tags/")
                                .params(queryParams)
                                .accept(MediaType.APPLICATION_JSON)
                );

        // then
        actions
                .andExpect(status().isOk())
                .andExpect(header().string("Location", is(startsWith("/tags"))))
                .andDo(document(
                        "find-all-tag",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        requestParameters(
                                List.of(parameterWithName("page").description("page number"),
                                        parameterWithName("size").description("number of edits"))
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("tagId").type(JsonFieldType.STRING).description("Tag ID"),
                                        fieldWithPath("name").type(JsonFieldType.STRING).description("태그명"),
                                        fieldWithPath("boardId").type(JsonFieldType.STRING).description("원본 게시글 ID")
                                )

                        )));
    }

    @Test
    public void deleteTagTest() throws Exception {
        // given

        // when

        ResultActions actions =
                mockMvc.perform(
                        delete("/tags/{tag-id}", 1L)
                );

        // then
        actions
                .andExpect(status().isNoContent())
                .andDo(document(
                        "delete-tags",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        pathParameters(
                                List.of(parameterWithName("tagId").description("삭제 대상 tag ID")
                                )


                        )));
    }
}

