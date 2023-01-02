//package com.seb41_pre_014.restdocs.board;
//
//import com.google.gson.Gson;
//import com.seb41_pre_014.board.controller.BoardController;
//import com.seb41_pre_014.board.dto.BoardDto;
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
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(BoardController.class)
//@MockBean(JpaMetamodelMappingContext.class)
//@AutoConfigureRestDocs
//class BoardControllerRestDocsTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private Gson gson;
//
//    @Test
//    void postQuestion() throws Exception {
//        // given
//        BoardDto.Post postDto = createPostDto();
//        String content = gson.toJson(postDto);
//        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//        params.add("memberId", String.valueOf(1L));
//
//
//        // when
//        ResultActions actions = mockMvc.perform(
//                post("/boards/questions")
//                        .params(params)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(content)
//        );
//        // then
//        actions
//                .andExpect(status().isCreated())
//                .andDo(document("post-question",
//                        preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint()),
//                        requestParameters(
//                                List.of(
//                                        parameterWithName("memberId").description("작성자 인덱스")
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
//                                        fieldWithPath("boardId").type(JsonFieldType.NUMBER).description("Question 인덱스"),
//                                        fieldWithPath("writerMemberId").type(JsonFieldType.NUMBER).description("Question 작성자 인덱스"),
//                                        fieldWithPath("writerReputation").type(JsonFieldType.NUMBER).description("작성자 평판"),
//                                        fieldWithPath("writerProfileUrl").type(JsonFieldType.STRING).description("프로필 이미지 url"),
//                                        fieldWithPath("writerDisplayName").type(JsonFieldType.STRING).description("Question 작성자 닉네임"),
//                                        fieldWithPath("boardStatus").type(JsonFieldType.STRING).description("게시물 상태: 공개 / 임시저장 / 삭제"),
//                                        fieldWithPath("boardType").type(JsonFieldType.STRING).description("게시물 타입: Question / Answer"),
//                                        fieldWithPath("title").type(JsonFieldType.STRING).description("제목"),
//                                        fieldWithPath("body").type(JsonFieldType.STRING).description("내용"),
//                                        fieldWithPath("tags").type(JsonFieldType.ARRAY).description("태그"),
//                                        fieldWithPath("score").type(JsonFieldType.NUMBER).description("게시물 점수"),
//                                        fieldWithPath("viewCount").type(JsonFieldType.NUMBER).description("조회수"),
//                                        fieldWithPath("answerCount").type(JsonFieldType.NUMBER).description("답변 개수"),
//                                        fieldWithPath("bookmarkCount").type(JsonFieldType.NUMBER).description("북마크 된 개수"),
//                                        fieldWithPath("questionId").type(JsonFieldType.NUMBER).description("Question은 다른 Question에 소속될 수 없음").ignored(),
//                                        fieldWithPath("answers").type(JsonFieldType.ARRAY).description("Question에 소속된 Answer들의 인덱스")
//                                )
//                        )));
//    }
//
//    @Test
//    void postAnswer() throws Exception {
//        // given
//        BoardDto.Post postDto = createPostDto();
//        String content = gson.toJson(postDto);
//        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//        params.add("memberId", String.valueOf(1L));
//
//
//        // when
//        ResultActions actions = mockMvc.perform(
//                post("/boards/answers/{question-id}", 2L)
//                        .params(params)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(content)
//        );
//        // then
//        actions
//                .andExpect(status().isCreated())
//                .andDo(document("post-answer",
//                        preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint()),
//                        pathParameters(
//                                List.of(
//                                        parameterWithName("question-id").description("생성하려는 Answer의 question 인덱스")
//                                )
//                        ),
//                        requestParameters(
//                                List.of(
//                                        parameterWithName("memberId").description("작성자 인덱스")
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
//                                        fieldWithPath("boardId").type(JsonFieldType.NUMBER).description("Answer 인덱스"),
//                                        fieldWithPath("writerMemberId").type(JsonFieldType.NUMBER).description("Answer 작성자 인덱스"),
//                                        fieldWithPath("writerReputation").type(JsonFieldType.NUMBER).description("작성자 평판"),
//                                        fieldWithPath("writerProfileUrl").type(JsonFieldType.STRING).description("프로필 이미지 url"),
//                                        fieldWithPath("writerDisplayName").type(JsonFieldType.STRING).description("작성자 닉네임"),
//                                        fieldWithPath("boardStatus").type(JsonFieldType.STRING).description("게시물 상태: 공개 / 임시저장 / 삭제"),
//                                        fieldWithPath("boardType").type(JsonFieldType.STRING).description("게시물 타입: Question / Answer"),
//                                        fieldWithPath("title").type(JsonFieldType.STRING).description("제목"),
//                                        fieldWithPath("body").type(JsonFieldType.STRING).description("내용"),
//                                        fieldWithPath("tags").type(JsonFieldType.ARRAY).description("태그"),
//                                        fieldWithPath("score").type(JsonFieldType.NUMBER).description("게시물 점수"),
//                                        fieldWithPath("viewCount").type(JsonFieldType.NUMBER).description("조회수"),
//                                        fieldWithPath("answerCount").type(JsonFieldType.NUMBER).description("답변 개수"),
//                                        fieldWithPath("bookmarkCount").type(JsonFieldType.NUMBER).description("북마크 된 개수"),
//                                        fieldWithPath("questionId").type(JsonFieldType.NUMBER).description("Answer가 소속된 Question 인덱스"),
//                                        fieldWithPath("answers").type(JsonFieldType.ARRAY).description("Answer에는 Answer가 소속될 수 없음").ignored()
//                                )
//                        )));
//    }
//
//    @Test
//    void updateBoard() throws Exception {
//        // given
//        BoardDto.Post postDto = createPostDto();
//        String content = gson.toJson(postDto);
//
//        // when
//        ResultActions actions = mockMvc.perform(
//                patch("/boards/{board-id}", 2L)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(content)
//        );
//
//        // then
//        actions
//                .andExpect(status().isOk())
//                .andDo(document("update-board",
//                        preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint()),
//                        pathParameters(
//                                List.of(
//                                        parameterWithName("board-id").description("수정하려는 Board 인덱스")
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
//                                        fieldWithPath("boardId").type(JsonFieldType.NUMBER).description("Board 인덱스"),
//                                        fieldWithPath("writerMemberId").type(JsonFieldType.NUMBER).description("Board 작성자 인덱스"),
//                                        fieldWithPath("writerReputation").type(JsonFieldType.NUMBER).description("작성자 평판"),
//                                        fieldWithPath("writerProfileUrl").type(JsonFieldType.STRING).description("프로필 이미지 url"),
//                                        fieldWithPath("writerDisplayName").type(JsonFieldType.STRING).description("작성자 닉네임"),
//                                        fieldWithPath("boardStatus").type(JsonFieldType.STRING).description("게시물 상태: 공개 / 임시저장 / 삭제"),
//                                        fieldWithPath("boardType").type(JsonFieldType.STRING).description("게시물 타입: Question / Answer"),
//                                        fieldWithPath("title").type(JsonFieldType.STRING).description("제목"),
//                                        fieldWithPath("body").type(JsonFieldType.STRING).description("내용"),
//                                        fieldWithPath("tags").type(JsonFieldType.ARRAY).description("태그"),
//                                        fieldWithPath("score").type(JsonFieldType.NUMBER).description("게시물 점수"),
//                                        fieldWithPath("viewCount").type(JsonFieldType.NUMBER).description("조회수"),
//                                        fieldWithPath("answerCount").type(JsonFieldType.NUMBER).description("답변 개수"),
//                                        fieldWithPath("bookmarkCount").type(JsonFieldType.NUMBER).description("북마크 된 개수"),
//                                        fieldWithPath("questionId").type(JsonFieldType.NUMBER).description("Answer가 소속된 Question 인덱스").optional(),
//                                        fieldWithPath("answers").type(JsonFieldType.ARRAY).description("Question에 소속된 Answer들의 인덱스").optional()
//                                )
//                        )));
//    }
//
//    @Test
//    void findBoard() throws Exception {
//        // given
//
//        // when
//        ResultActions actions = mockMvc.perform(
//                get("/boards/{board-id}", 1L)
//                        .accept(MediaType.APPLICATION_JSON)
//        );
//
//        // then
//        actions
//                .andExpect(status().isOk())
//                .andDo(document("find-board",
//                        preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint()),
//                        pathParameters(
//                                List.of(
//                                        parameterWithName("board-id").description("조회하려는 Board 인덱스")
//                                )
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("boardId").type(JsonFieldType.NUMBER).description("Board 인덱스"),
//                                        fieldWithPath("writerMemberId").type(JsonFieldType.NUMBER).description("Board 작성자 인덱스"),
//                                        fieldWithPath("writerReputation").type(JsonFieldType.NUMBER).description("작성자 평판"),
//                                        fieldWithPath("writerProfileUrl").type(JsonFieldType.STRING).description("프로필 이미지 url"),
//                                        fieldWithPath("writerDisplayName").type(JsonFieldType.STRING).description("작성자 닉네임"),
//                                        fieldWithPath("boardStatus").type(JsonFieldType.STRING).description("게시물 상태: 공개 / 임시저장 / 삭제"),
//                                        fieldWithPath("boardType").type(JsonFieldType.STRING).description("게시물 타입: Question / Answer"),
//                                        fieldWithPath("title").type(JsonFieldType.STRING).description("제목"),
//                                        fieldWithPath("body").type(JsonFieldType.STRING).description("내용"),
//                                        fieldWithPath("tags").type(JsonFieldType.ARRAY).description("태그"),
//                                        fieldWithPath("score").type(JsonFieldType.NUMBER).description("게시물 점수"),
//                                        fieldWithPath("viewCount").type(JsonFieldType.NUMBER).description("조회수"),
//                                        fieldWithPath("answerCount").type(JsonFieldType.NUMBER).description("답변 개수"),
//                                        fieldWithPath("bookmarkCount").type(JsonFieldType.NUMBER).description("북마크 된 개수"),
//                                        fieldWithPath("questionId").type(JsonFieldType.NUMBER).description("Answer가 소속된 Question 인덱스").optional(),
//                                        fieldWithPath("answers").type(JsonFieldType.ARRAY).description("Question에 소속된 Answer들의 인덱스").optional()
//                                )
//                        )));
//    }
//
//    @Test
//    void findAllQuestions() throws Exception {
//        // given
//        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//        params.add("page", String.valueOf(1));
//        params.add("size", String.valueOf(30));
//
//        // when
//        ResultActions actions = mockMvc.perform(
//                get("/boards/questions")
//                        .params(params)
//                        .accept(MediaType.APPLICATION_JSON)
//        );
//
//        // then
//        actions
//                .andExpect(status().isOk())
//                .andDo(document("find-all-questions",
//                        preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint()),
//                        requestParameters(
//                                List.of(
//                                        parameterWithName("page").description("Page 번호"),
//                                        parameterWithName("size").description("Page에 노출될 데이터 개수")
//                                )
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("[].boardId").type(JsonFieldType.NUMBER).description("Question 인덱스"),
//                                        fieldWithPath("[].writerMemberId").type(JsonFieldType.NUMBER).description("Question 작성자 인덱스"),
//                                        fieldWithPath("[].writerReputation").type(JsonFieldType.NUMBER).description("작성자 평판"),
//                                        fieldWithPath("[].writerProfileUrl").type(JsonFieldType.STRING).description("프로필 이미지 url"),
//                                        fieldWithPath("[].writerDisplayName").type(JsonFieldType.STRING).description("Question 작성자 닉네임"),
//                                        fieldWithPath("[].boardStatus").type(JsonFieldType.STRING).description("게시물 상태: 공개 / 임시저장 / 삭제"),
//                                        fieldWithPath("[].boardType").type(JsonFieldType.STRING).description("게시물 타입: Question / Answer"),
//                                        fieldWithPath("[].title").type(JsonFieldType.STRING).description("제목"),
//                                        fieldWithPath("[].body").type(JsonFieldType.STRING).description("내용"),
//                                        fieldWithPath("[].tags").type(JsonFieldType.ARRAY).description("태그"),
//                                        fieldWithPath("[].score").type(JsonFieldType.NUMBER).description("게시물 점수"),
//                                        fieldWithPath("[].viewCount").type(JsonFieldType.NUMBER).description("조회수"),
//                                        fieldWithPath("[].answerCount").type(JsonFieldType.NUMBER).description("답변 개수"),
//                                        fieldWithPath("[].bookmarkCount").type(JsonFieldType.NUMBER).description("북마크 된 개수"),
//                                        fieldWithPath("[].questionId").type(JsonFieldType.NUMBER).description("Question은 다른 Question에 소속될 수 없음").ignored(),
//                                        fieldWithPath("[].answers").type(JsonFieldType.ARRAY).description("Question에 소속된 Answer들의 인덱스")
//                                )
//                        )));
//    }
//
//    @Test
//    void findAllByAnswerCount() throws Exception {
//        // given
//        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//        params.add("page", String.valueOf(1));
//        params.add("size", String.valueOf(30));
//
//        // when
//        ResultActions actions = mockMvc.perform(
//                get("/boards/unanswered")
//                        .params(params)
//                        .accept(MediaType.APPLICATION_JSON)
//        );
//
//        // then
//        actions
//                .andExpect(status().isOk())
//                .andDo(document("find-all-by-answer-count",
//                        preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint()),
//                        requestParameters(
//                                List.of(
//                                        parameterWithName("page").description("Page 번호"),
//                                        parameterWithName("size").description("Page에 노출될 데이터 개수")
//                                )
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("[].boardId").type(JsonFieldType.NUMBER).description("Question 인덱스"),
//                                        fieldWithPath("[].writerMemberId").type(JsonFieldType.NUMBER).description("Question 작성자 인덱스"),
//                                        fieldWithPath("[].writerReputation").type(JsonFieldType.NUMBER).description("작성자 평판"),
//                                        fieldWithPath("[].writerProfileUrl").type(JsonFieldType.STRING).description("프로필 이미지 url"),
//                                        fieldWithPath("[].writerDisplayName").type(JsonFieldType.STRING).description("Question 작성자 닉네임"),
//                                        fieldWithPath("[].boardStatus").type(JsonFieldType.STRING).description("게시물 상태: 공개 / 임시저장 / 삭제"),
//                                        fieldWithPath("[].boardType").type(JsonFieldType.STRING).description("게시물 타입: Question / Answer"),
//                                        fieldWithPath("[].title").type(JsonFieldType.STRING).description("제목"),
//                                        fieldWithPath("[].body").type(JsonFieldType.STRING).description("내용"),
//                                        fieldWithPath("[].tags").type(JsonFieldType.ARRAY).description("태그"),
//                                        fieldWithPath("[].score").type(JsonFieldType.NUMBER).description("게시물 점수"),
//                                        fieldWithPath("[].viewCount").type(JsonFieldType.NUMBER).description("조회수"),
//                                        fieldWithPath("[].answerCount").type(JsonFieldType.NUMBER).description("답변 개수"),
//                                        fieldWithPath("[].bookmarkCount").type(JsonFieldType.NUMBER).description("북마크 된 개수"),
//                                        fieldWithPath("[].questionId").type(JsonFieldType.NUMBER).description("Question은 다른 Question에 소속될 수 없음").ignored(),
//                                        fieldWithPath("[].answers").type(JsonFieldType.ARRAY).description("Question에 소속된 Answer들의 인덱스")
//                                )
//                        )));
//    }
//
//    @Test
//    void findAllByViewCount() throws Exception {
//        // given
//        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//        params.add("page", String.valueOf(1));
//        params.add("size", String.valueOf(30));
//
//        // when
//        ResultActions actions = mockMvc.perform(
//                get("/boards/frequent")
//                        .params(params)
//                        .accept(MediaType.APPLICATION_JSON)
//        );
//
//        // then
//        actions
//                .andExpect(status().isOk())
//                .andDo(document("find-all-by-view-count",
//                        preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint()),
//                        requestParameters(
//                                List.of(
//                                        parameterWithName("page").description("Page 번호"),
//                                        parameterWithName("size").description("Page에 노출될 데이터 개수")
//                                )
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("[].boardId").type(JsonFieldType.NUMBER).description("Board 인덱스"),
//                                        fieldWithPath("[].writerMemberId").type(JsonFieldType.NUMBER).description("Board 작성자 인덱스"),
//                                        fieldWithPath("[].writerReputation").type(JsonFieldType.NUMBER).description("작성자 평판"),
//                                        fieldWithPath("[].writerProfileUrl").type(JsonFieldType.STRING).description("프로필 이미지 url"),
//                                        fieldWithPath("[].writerDisplayName").type(JsonFieldType.STRING).description("작성자 닉네임"),
//                                        fieldWithPath("[].boardStatus").type(JsonFieldType.STRING).description("게시물 상태: 공개 / 임시저장 / 삭제"),
//                                        fieldWithPath("[].boardType").type(JsonFieldType.STRING).description("게시물 타입: Question / Answer"),
//                                        fieldWithPath("[].title").type(JsonFieldType.STRING).description("제목"),
//                                        fieldWithPath("[].body").type(JsonFieldType.STRING).description("내용"),
//                                        fieldWithPath("[].tags").type(JsonFieldType.ARRAY).description("태그"),
//                                        fieldWithPath("[].score").type(JsonFieldType.NUMBER).description("게시물 점수"),
//                                        fieldWithPath("[].viewCount").type(JsonFieldType.NUMBER).description("조회수"),
//                                        fieldWithPath("[].answerCount").type(JsonFieldType.NUMBER).description("답변 개수"),
//                                        fieldWithPath("[].bookmarkCount").type(JsonFieldType.NUMBER).description("북마크 된 개수"),
//                                        fieldWithPath("[].questionId").type(JsonFieldType.NUMBER).description("Answer가 소속된 Question 인덱스").optional(),
//                                        fieldWithPath("[].answers").type(JsonFieldType.ARRAY).description("Question에 소속된 Answer들의 인덱스").optional()
//                                )
//                        )));
//    }
//
//    @Test
//    void findAllByScore() throws Exception {
//        // given
//        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//        params.add("page", String.valueOf(1));
//        params.add("size", String.valueOf(30));
//
//        // when
//        ResultActions actions = mockMvc.perform(
//                get("/boards/questions")
//                        .params(params)
//                        .accept(MediaType.APPLICATION_JSON)
//        );
//
//        // then
//        actions
//                .andExpect(status().isOk())
//                .andDo(document("find-all-by-score",
//                        preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint()),
//                        requestParameters(
//                                List.of(
//                                        parameterWithName("page").description("Page 번호"),
//                                        parameterWithName("size").description("Page에 노출될 데이터 개수")
//                                )
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("[].boardId").type(JsonFieldType.NUMBER).description("Board 인덱스"),
//                                        fieldWithPath("[].writerMemberId").type(JsonFieldType.NUMBER).description("Board 작성자 인덱스"),
//                                        fieldWithPath("[].writerReputation").type(JsonFieldType.NUMBER).description("작성자 평판"),
//                                        fieldWithPath("[].writerProfileUrl").type(JsonFieldType.STRING).description("프로필 이미지 url"),
//                                        fieldWithPath("[].writerDisplayName").type(JsonFieldType.STRING).description("작성자 닉네임"),
//                                        fieldWithPath("[].boardStatus").type(JsonFieldType.STRING).description("게시물 상태: 공개 / 임시저장 / 삭제"),
//                                        fieldWithPath("[].boardType").type(JsonFieldType.STRING).description("게시물 타입: Question / Answer"),
//                                        fieldWithPath("[].title").type(JsonFieldType.STRING).description("제목"),
//                                        fieldWithPath("[].body").type(JsonFieldType.STRING).description("내용"),
//                                        fieldWithPath("[].tags").type(JsonFieldType.ARRAY).description("태그"),
//                                        fieldWithPath("[].score").type(JsonFieldType.NUMBER).description("게시물 점수"),
//                                        fieldWithPath("[].viewCount").type(JsonFieldType.NUMBER).description("조회수"),
//                                        fieldWithPath("[].answerCount").type(JsonFieldType.NUMBER).description("답변 개수"),
//                                        fieldWithPath("[].bookmarkCount").type(JsonFieldType.NUMBER).description("북마크 된 개수"),
//                                        fieldWithPath("[].questionId").type(JsonFieldType.NUMBER).description("Answer가 소속된 Question 인덱스").optional(),
//                                        fieldWithPath("[].answers").type(JsonFieldType.ARRAY).description("Question에 소속된 Answer들의 인덱스").optional()
//                                )
//                        )));
//    }
//
//    @Test
//    void findAllBySearch() throws Exception {
//        // given
//        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//        params.add("keyword", "keyword");
//        params.add("page", String.valueOf(1));
//        params.add("size", String.valueOf(30));
//
//        // when
//        ResultActions actions = mockMvc.perform(
//                get("/boards/search")
//                        .params(params)
//                        .accept(MediaType.APPLICATION_JSON)
//        );
//
//        // then
//        actions
//                .andExpect(status().isOk())
//                .andDo(document("find-all-by-search",
//                        preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint()),
//                        requestParameters(
//                                List.of(
//                                        parameterWithName("keyword").description("검색 키워드"),
//                                        parameterWithName("page").description("Page 번호"),
//                                        parameterWithName("size").description("Page에 노출될 데이터 개수")
//                                )
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("[].boardId").type(JsonFieldType.NUMBER).description("Board 인덱스"),
//                                        fieldWithPath("[].writerMemberId").type(JsonFieldType.NUMBER).description("Board 작성자 인덱스"),
//                                        fieldWithPath("[].writerReputation").type(JsonFieldType.NUMBER).description("작성자 평판"),
//                                        fieldWithPath("[].writerProfileUrl").type(JsonFieldType.STRING).description("프로필 이미지 url"),
//                                        fieldWithPath("[].writerDisplayName").type(JsonFieldType.STRING).description("작성자 닉네임"),
//                                        fieldWithPath("[].boardStatus").type(JsonFieldType.STRING).description("게시물 상태: 공개 / 임시저장 / 삭제"),
//                                        fieldWithPath("[].boardType").type(JsonFieldType.STRING).description("게시물 타입: Question / Answer"),
//                                        fieldWithPath("[].title").type(JsonFieldType.STRING).description("제목"),
//                                        fieldWithPath("[].body").type(JsonFieldType.STRING).description("내용"),
//                                        fieldWithPath("[].tags").type(JsonFieldType.ARRAY).description("태그"),
//                                        fieldWithPath("[].score").type(JsonFieldType.NUMBER).description("게시물 점수"),
//                                        fieldWithPath("[].viewCount").type(JsonFieldType.NUMBER).description("조회수"),
//                                        fieldWithPath("[].answerCount").type(JsonFieldType.NUMBER).description("답변 개수"),
//                                        fieldWithPath("[].bookmarkCount").type(JsonFieldType.NUMBER).description("북마크 된 개수"),
//                                        fieldWithPath("[].questionId").type(JsonFieldType.NUMBER).description("Answer가 소속된 Question 인덱스").optional(),
//                                        fieldWithPath("[].answers").type(JsonFieldType.ARRAY).description("Question에 소속된 Answer들의 인덱스").optional()
//                                )
//                        )));
//    }
//
//    @Test
//    void findAllAnswers() throws Exception {
//        // given
//
//        // when
//        ResultActions actions = mockMvc.perform(
//                get("/boards/answers/{question-id}/newest", 1L)
//                        .accept(MediaType.APPLICATION_JSON)
//        );
//
//        // then
//        actions
//                .andExpect(status().isOk())
//                .andDo(document("find-all-answers-by-desc",
//                        preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint()),
//                        pathParameters(
//                                List.of(
//                                        parameterWithName("question-id").description("조회하려는 Answer의 Question 인덱스")
//                                )
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("[].boardId").type(JsonFieldType.NUMBER).description("Answer 인덱스"),
//                                        fieldWithPath("[].writerMemberId").type(JsonFieldType.NUMBER).description("Answer 작성자 인덱스"),
//                                        fieldWithPath("[].writerReputation").type(JsonFieldType.NUMBER).description("작성자 평판"),
//                                        fieldWithPath("[].writerProfileUrl").type(JsonFieldType.STRING).description("프로필 이미지 url"),
//                                        fieldWithPath("[].writerDisplayName").type(JsonFieldType.STRING).description("작성자 닉네임"),
//                                        fieldWithPath("[].boardStatus").type(JsonFieldType.STRING).description("게시물 상태: 공개 / 임시저장 / 삭제"),
//                                        fieldWithPath("[].boardType").type(JsonFieldType.STRING).description("게시물 타입: Question / Answer"),
//                                        fieldWithPath("[].title").type(JsonFieldType.STRING).description("제목"),
//                                        fieldWithPath("[].body").type(JsonFieldType.STRING).description("내용"),
//                                        fieldWithPath("[].tags").type(JsonFieldType.ARRAY).description("태그"),
//                                        fieldWithPath("[].score").type(JsonFieldType.NUMBER).description("게시물 점수"),
//                                        fieldWithPath("[].viewCount").type(JsonFieldType.NUMBER).description("조회수"),
//                                        fieldWithPath("[].answerCount").type(JsonFieldType.NUMBER).description("답변 개수"),
//                                        fieldWithPath("[].bookmarkCount").type(JsonFieldType.NUMBER).description("북마크 된 개수"),
//                                        fieldWithPath("[].questionId").type(JsonFieldType.NUMBER).description("Answer가 소속된 Question 인덱스"),
//                                        fieldWithPath("[].answers").type(JsonFieldType.ARRAY).description("Answer에는 Answer가 소속될 수 없음").ignored()
//                                )
//                        )));
//    }
//
//    @Test
//    void findAnsersByold() throws Exception {
//        // given
//
//        // when
//        ResultActions actions = mockMvc.perform(
//                get("/boards/answers/{question-id}/oldest", 1L)
//                        .accept(MediaType.APPLICATION_JSON)
//        );
//
//        // then
//        actions
//                .andExpect(status().isOk())
//                .andDo(document("find-all-answers-by-asc",
//                        preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint()),
//                        pathParameters(
//                                List.of(
//                                        parameterWithName("question-id").description("조회하려는 Answer의 Question 인덱스")
//                                )
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("[].boardId").type(JsonFieldType.NUMBER).description("Answer 인덱스"),
//                                        fieldWithPath("[].writerMemberId").type(JsonFieldType.NUMBER).description("Answer 작성자 인덱스"),
//                                        fieldWithPath("[].writerReputation").type(JsonFieldType.NUMBER).description("작성자 평판"),
//                                        fieldWithPath("[].writerProfileUrl").type(JsonFieldType.STRING).description("프로필 이미지 url"),
//                                        fieldWithPath("[].writerDisplayName").type(JsonFieldType.STRING).description("작성자 닉네임"),
//                                        fieldWithPath("[].boardStatus").type(JsonFieldType.STRING).description("게시물 상태: 공개 / 임시저장 / 삭제"),
//                                        fieldWithPath("[].boardType").type(JsonFieldType.STRING).description("게시물 타입: Question / Answer"),
//                                        fieldWithPath("[].title").type(JsonFieldType.STRING).description("제목"),
//                                        fieldWithPath("[].body").type(JsonFieldType.STRING).description("내용"),
//                                        fieldWithPath("[].tags").type(JsonFieldType.ARRAY).description("태그"),
//                                        fieldWithPath("[].score").type(JsonFieldType.NUMBER).description("게시물 점수"),
//                                        fieldWithPath("[].viewCount").type(JsonFieldType.NUMBER).description("조회수"),
//                                        fieldWithPath("[].answerCount").type(JsonFieldType.NUMBER).description("답변 개수"),
//                                        fieldWithPath("[].bookmarkCount").type(JsonFieldType.NUMBER).description("북마크 된 개수"),
//                                        fieldWithPath("[].questionId").type(JsonFieldType.NUMBER).description("Answer가 소속된 Question 인덱스"),
//                                        fieldWithPath("[].answers").type(JsonFieldType.ARRAY).description("Answer에는 Answer가 소속될 수 없음").ignored()
//                                )
//                        )));
//    }
//
//    @Test
//    void findAnswersByScore() throws Exception {
//        // given
//
//        // when
//        ResultActions actions = mockMvc.perform(
//                get("/boards/answers/{question-id}/score", 1L)
//                        .accept(MediaType.APPLICATION_JSON)
//        );
//
//        // then
//        actions
//                .andExpect(status().isOk())
//                .andDo(document("find-all-answers-by-score",
//                        preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint()),
//                        pathParameters(
//                                List.of(
//                                        parameterWithName("question-id").description("조회하려는 Answer의 Question 인덱스")
//                                )
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("[].boardId").type(JsonFieldType.NUMBER).description("Answer 인덱스"),
//                                        fieldWithPath("[].writerMemberId").type(JsonFieldType.NUMBER).description("Answer 작성자 인덱스"),
//                                        fieldWithPath("[].writerReputation").type(JsonFieldType.NUMBER).description("작성자 평판"),
//                                        fieldWithPath("[].writerProfileUrl").type(JsonFieldType.STRING).description("프로필 이미지 url"),
//                                        fieldWithPath("[].writerDisplayName").type(JsonFieldType.STRING).description("작성자 닉네임"),
//                                        fieldWithPath("[].boardStatus").type(JsonFieldType.STRING).description("게시물 상태: 공개 / 임시저장 / 삭제"),
//                                        fieldWithPath("[].boardType").type(JsonFieldType.STRING).description("게시물 타입: Question / Answer"),
//                                        fieldWithPath("[].title").type(JsonFieldType.STRING).description("제목"),
//                                        fieldWithPath("[].body").type(JsonFieldType.STRING).description("내용"),
//                                        fieldWithPath("[].tags").type(JsonFieldType.ARRAY).description("태그"),
//                                        fieldWithPath("[].score").type(JsonFieldType.NUMBER).description("게시물 점수"),
//                                        fieldWithPath("[].viewCount").type(JsonFieldType.NUMBER).description("조회수"),
//                                        fieldWithPath("[].answerCount").type(JsonFieldType.NUMBER).description("답변 개수"),
//                                        fieldWithPath("[].bookmarkCount").type(JsonFieldType.NUMBER).description("북마크 된 개수"),
//                                        fieldWithPath("[].questionId").type(JsonFieldType.NUMBER).description("Answer가 소속된 Question 인덱스"),
//                                        fieldWithPath("[].answers").type(JsonFieldType.ARRAY).description("Answer에는 Answer가 소속될 수 없음").ignored()
//                                )
//                        )));
//    }
//
//    @Test
//    void deleteBoard() throws Exception {
//        // given
//
//        // when
//        ResultActions actions = mockMvc.perform(
//                delete("/boards/{board-id}", 1L));
//        // tehn
//        actions
//                .andExpect(status().isNoContent())
//                .andDo(document("delete-board",
//                        preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint()),
//                        pathParameters(
//                                List.of(
//                                        parameterWithName("board-id").description("삭제하려는 Board의 인덱스")
//                                )
//                        )));
//    }
//
//    public BoardDto.Post createPostDto() {
//        BoardDto.Post.PostBuilder builder = BoardDto.Post.builder();
//        builder.title("What is Lorem Ipsum?");
//        builder.body("Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
//        builder.tags(List.of("javascript"));
//        BoardDto.Post post = builder.build();
//        return post;
//    }
//
//    public BoardDto.Patch createPatchDto() {
//        BoardDto.Patch.PatchBuilder builder = BoardDto.Patch.builder();
//        builder.title("What is Lorem Ipsum?");
//        builder.body("Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
//        builder.tags(List.of("javascript"));
//        BoardDto.Patch patch = builder.build();
//        return patch;
//    }
//}
