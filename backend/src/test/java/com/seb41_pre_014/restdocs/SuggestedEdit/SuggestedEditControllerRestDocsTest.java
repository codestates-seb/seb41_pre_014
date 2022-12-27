package com.seb41_pre_014.restdocs.SuggestedEdit;

import com.google.gson.Gson;
import com.seb41_pre_014.suggestedEdit.dto.SuggestedEditDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.delete;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class SuggestedEditControllerRestDocsTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Gson gson;

    @Test
    public void postSuggestedEditTest() throws Exception {
        // given
        SuggestedEditDto.Post post = new SuggestedEditDto.Post("This is title, must be longer than 15",
                "This is body, must be longer than 20",
                List.of("tag1", "tag2"));
        String content = gson.toJson(post);

        SuggestedEditDto.Response response =
                new SuggestedEditDto.Response(1L,
                        "This is title, must be longer than 15",
                        1L,
                        1L,
                        "This is body, must be longer than 20",
                        List.of("tag1", "tag2"),
                        "PENDING");

        ResultActions actions =
                mockMvc.perform(
                        post("/suggested-edits")
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(content)
                );

        // then
        actions
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", is(startsWith("/suggested-edits"))))
                .andDo(document(
                        "post-suggested-edits",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        requestParameters(
                                List.of(parameterWithName("editId").description("수정 제안서 ID"))
                        ),
                        requestFields(
                                List.of(
                                        fieldWithPath("title").type(JsonFieldType.STRING).description("제목"),
                                        fieldWithPath("body").type(JsonFieldType.STRING).description("내용"),
                                        fieldWithPath("tags").type(JsonFieldType.STRING).description("태그")
                                )
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("editId").type(JsonFieldType.STRING).description("수정 제안서 ID"),
                                        fieldWithPath("title").type(JsonFieldType.STRING).description("제목"),
                                        fieldWithPath("boardId").type(JsonFieldType.STRING).description("원본 게시글 ID"),
                                        fieldWithPath("editorId").type(JsonFieldType.STRING).description("수정요청자 ID"),
                                        fieldWithPath("body").type(JsonFieldType.STRING).description("내용"),
                                        fieldWithPath("tag").type(JsonFieldType.STRING).description("태그"),
                                        fieldWithPath("editStatus").type(JsonFieldType.STRING).description("수정 제안서 상태")

                                )

                        )));
    }

    @Test
    public void updateSuggestedEditTest() throws Exception {
        // given
        SuggestedEditDto.Patch patch = new SuggestedEditDto.Patch(1L,
                "This is title, must be longer than 15",
                1L,
                1L,
                "This is body, must be longer than 20",
                List.of("tag1", "tag2"));
        String content = gson.toJson(patch);

        SuggestedEditDto.Response response =
                new SuggestedEditDto.Response(1L,
                        "This is title, must be longer than 15",
                        1L,
                        1L,
                        "This is body, must be longer than 20",
                        List.of("tag1", "tag2"),
                        "PENDING");

        ResultActions actions =
                mockMvc.perform(
                        patch("/suggested-edits/{edit-id}", 1L)
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(content)
                );

        // then
        actions
                .andExpect(status().isOk())
                .andExpect(header().string("Location", is(startsWith("/suggested-edits/{edit-id}"))))
                .andDo(document(
                        "update-suggested-edits",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        requestParameters(
                                List.of(parameterWithName("editId").description("원본 수정 제안서 ID"))
                        ),
                        requestFields(
                                List.of(
                                        fieldWithPath("title").type(JsonFieldType.STRING).description("제목"),
                                        fieldWithPath("body").type(JsonFieldType.STRING).description("내용"),
                                        fieldWithPath("tags").type(JsonFieldType.STRING).description("태그")
                                )
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("editId").type(JsonFieldType.STRING).description("수정 제안서 ID"),
                                        fieldWithPath("title").type(JsonFieldType.STRING).description("제목"),
                                        fieldWithPath("boardId").type(JsonFieldType.STRING).description("원본 게시글 ID"),
                                        fieldWithPath("editorId").type(JsonFieldType.STRING).description("수정요청자 ID"),
                                        fieldWithPath("body").type(JsonFieldType.STRING).description("내용"),
                                        fieldWithPath("tag").type(JsonFieldType.STRING).description("태그"),
                                        fieldWithPath("editStatus").type(JsonFieldType.STRING).description("수정 제안서 상태")

                                )

                        )));
    }

    @Test
    public void findSuggestedEditTest() throws Exception {
        // given
        // when

        ResultActions actions =
                mockMvc.perform(
                        post("/suggested-edits/{edit-id}", 1L)
                                .accept(MediaType.APPLICATION_JSON)
                );

        // then
        actions
                .andExpect(status().isOk())
                .andExpect(header().string("Location", is(startsWith("/suggested-edits/{edit-id}"))))
                .andDo(document(
                        "find-suggested-edit",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        requestParameters(
                                List.of(parameterWithName("editId").description("수정 제안서 ID"))
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("editId").type(JsonFieldType.STRING).description("수정 제안서 ID"),
                                        fieldWithPath("title").type(JsonFieldType.STRING).description("제목"),
                                        fieldWithPath("boardId").type(JsonFieldType.STRING).description("원본 게시글 ID"),
                                        fieldWithPath("editorId").type(JsonFieldType.STRING).description("수정요청자 ID"),
                                        fieldWithPath("body").type(JsonFieldType.STRING).description("내용"),
                                        fieldWithPath("tag").type(JsonFieldType.STRING).description("태그"),
                                        fieldWithPath("editStatus").type(JsonFieldType.STRING).description("수정 제안서 상태")

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
                        get("/suggested-edits")
                                .params(queryParams)
                                .accept(MediaType.APPLICATION_JSON)
                );

        // then
        actions
                .andExpect(status().isOk())
                .andExpect(header().string("Location", is(startsWith("/suggested-edits"))))
                .andDo(document(
                        "find-all-suggested-edit",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        requestParameters(
                                List.of(parameterWithName("page").description("page number"),
                                        parameterWithName("size").description("number of edits"))
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("editId").type(JsonFieldType.STRING).description("수정 제안서 ID"),
                                        fieldWithPath("title").type(JsonFieldType.STRING).description("제목"),
                                        fieldWithPath("boardId").type(JsonFieldType.STRING).description("원본 게시글 ID"),
                                        fieldWithPath("editorId").type(JsonFieldType.STRING).description("수정요청자 ID"),
                                        fieldWithPath("body").type(JsonFieldType.STRING).description("내용"),
                                        fieldWithPath("tag").type(JsonFieldType.STRING).description("태그"),
                                        fieldWithPath("editStatus").type(JsonFieldType.STRING).description("수정 제안서 상태")

                                )

                        )));
    }

    @Test
    public void deleteSuggestedEditTest() throws Exception {
        // given

        // when

        ResultActions actions =
                mockMvc.perform(
                        delete("/suggested-edits/{edit-id}", 1L)
                );

        // then
        actions
                .andExpect(status().isNoContent())
                .andDo(document(
                        "delete-suggested-edits",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        pathParameters(
                                List.of(parameterWithName("editId").description("삭제 대상 수정 제안서 ID")
                                )


                        )));
    }
}
