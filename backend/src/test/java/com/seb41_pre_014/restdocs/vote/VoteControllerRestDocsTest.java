//package com.seb41_pre_014.restdocs.vote;
//
//import com.google.gson.Gson;
//import com.seb41_pre_014.board.controller.BoardController;
//import com.seb41_pre_014.vote.controller.VoteController;
//import com.seb41_pre_014.vote.dto.VoteDto;
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
//import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
//import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
//import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
//import static org.springframework.restdocs.payload.PayloadDocumentation.*;
//import static org.springframework.restdocs.request.RequestDocumentation.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(VoteController.class)
//@MockBean(JpaMetamodelMappingContext.class)
//@AutoConfigureRestDocs
//public class VoteControllerRestDocsTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    void postVoteTest() throws Exception {
//        // given
//        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//        params.add("memberId", String.valueOf(1L));
//        params.add("boardId", String.valueOf(1L));
//        params.add("voteType", "Up");
//
//        // when
//        ResultActions actions = mockMvc.perform(
//                post("/votes")
//                        .params(params));
//
//        // then
//        actions
//                .andExpect(status().isCreated())
//                .andDo(document("post-vote",
//                        preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint()),
//                        requestParameters(
//                                List.of(
//                                        parameterWithName("memberId").description("평가한 Member 인덱스"),
//                                        parameterWithName("boardId").description("평가를 받은 Board 인덱스"),
//                                        parameterWithName("voteType").description("평가 타입: Up / Down")
//                                )
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("voteId").type(JsonFieldType.NUMBER).description("Vote 인덱스"),
//                                        fieldWithPath("voteType").type(JsonFieldType.STRING).description("Vote 타입: Up / Down"),
//                                        fieldWithPath("boardId").type(JsonFieldType.NUMBER).description("평가를 받은 Board 인덱스"),
//                                        fieldWithPath("voter").type(JsonFieldType.STRING).description("평가한 Member의 Display Name")
//                                )
//                        )));
//    }
//
//    @Test
//    public void patchVoteTest() throws Exception {
//        ResultActions actions = mockMvc.perform(
//                patch("/votes/{vote-id}", 1L)
//                        .accept(MediaType.APPLICATION_JSON));
//        // then
//        actions
//                .andExpect(status().isOk())
//                .andDo(document("patch-vote",
//                        preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint()),
//                        pathParameters(
//                                List.of(
//                                        parameterWithName("vote-id").description("조회하려는 Vote 인덱스")
//                                )
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("voteId").type(JsonFieldType.NUMBER).description("Vote 인덱스"),
//                                        fieldWithPath("voteType").type(JsonFieldType.STRING).description("Vote 타입: Up / Down"),
//                                        fieldWithPath("boardId").type(JsonFieldType.NUMBER).description("평가를 받은 Board 인덱스"),
//                                        fieldWithPath("voter").type(JsonFieldType.STRING).description("평가한 Member의 Display Name")
//                                )
//                        )));
//    }
//
//    @Test
//    public void getVoteTest() throws Exception {
//        // given
//        // when
//        ResultActions actions = mockMvc.perform(
//                get("/votes/{vote-id}", 1L)
//                        .accept(MediaType.APPLICATION_JSON));
//        // then
//        actions
//                .andExpect(status().isOk())
//                .andDo(document("get-vote",
//                        preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint()),
//                        pathParameters(
//                                List.of(
//                                        parameterWithName("vote-id").description("조회하려는 Vote 인덱스")
//                                )
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("voteId").type(JsonFieldType.NUMBER).description("Vote 인덱스"),
//                                        fieldWithPath("voteType").type(JsonFieldType.STRING).description("Vote 타입: Up / Down"),
//                                        fieldWithPath("boardId").type(JsonFieldType.NUMBER).description("평가를 받은 Board 인덱스"),
//                                        fieldWithPath("voter").type(JsonFieldType.STRING).description("평가한 Member의 Display Name")
//                                )
//                        )));
//    }
//
//    @Test
//    public void getVotes() throws Exception {
//        // given
//        // when
//        ResultActions actions = mockMvc.perform(
//                get("/votes")
//                        .accept(MediaType.APPLICATION_JSON));
//        // then
//        actions
//                .andExpect(status().isOk())
//                .andDo(document("get-votes",
//                        preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint()),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("[].voteId").type(JsonFieldType.NUMBER).description("Vote 인덱스"),
//                                        fieldWithPath("[].voteType").type(JsonFieldType.STRING).description("Vote 타입: Up / Down"),
//                                        fieldWithPath("[].boardId").type(JsonFieldType.NUMBER).description("평가를 받은 Board 인덱스"),
//                                        fieldWithPath("[].voter").type(JsonFieldType.STRING).description("평가한 Member의 Display Name")
//                                )
//                        )));
//    }
//
//    @Test
//    public void deleteVoteTest() throws Exception {
//        // given
//
//        // when
//        ResultActions actions = mockMvc.perform(
//                delete("/votes/{vote-id}", 1L));
//
//        // then
//        actions
//                .andExpect(status().isNoContent())
//                .andDo(document("delete-vote",
//                        preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint()),
//                        pathParameters(
//                                List.of(
//                                        parameterWithName("vote-id").description("삭제하려는 Vote의 인덱스")
//                                )
//                        )));
//    }
//
//}