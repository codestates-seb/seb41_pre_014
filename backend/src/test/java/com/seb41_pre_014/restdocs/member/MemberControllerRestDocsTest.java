//package com.seb41_pre_014.restdocs.member;
//
//import com.google.gson.Gson;
//import com.seb41_pre_014.member.controller.MemberController;
//import com.seb41_pre_014.member.dto.MemberDto;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
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
//@WebMvcTest(MemberController.class)
//@MockBean(JpaMetamodelMappingContext.class)
//@AutoConfigureRestDocs
//public class MemberControllerRestDocsTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private Gson gson;
//
//    @Test
//    void createMember() throws Exception {
//        // given
//        MemberDto.Post postDto = createPostDto();
//        String content = gson.toJson(postDto);
//
//        // when
//        ResultActions actions = mockMvc.perform(
//                post("/members")
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(content)
//        );
//
//        // then
//        actions
//                .andExpect(status().isCreated())
//                .andDo(document("craete-member",
//                        preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint()),
//                        requestFields(
//                                List.of(
//                                        fieldWithPath("email").type(JsonFieldType.STRING).description("회원 이메일"),
//                                        fieldWithPath("password").type(JsonFieldType.STRING).description("회원 비밀번호"),
//                                        fieldWithPath("displayName").type(JsonFieldType.STRING).description("회원 닉네임")
//                                )
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("memberId").type(JsonFieldType.NUMBER).description("회원 인덱스"),
//                                        fieldWithPath("email").type(JsonFieldType.STRING).description("회원 이메일"),
//                                        fieldWithPath("password").type(JsonFieldType.STRING).description("회원 비밀번호"),
//                                        fieldWithPath("displayName").type(JsonFieldType.STRING).description("회원 닉네임"),
//                                        fieldWithPath("fullName").type(JsonFieldType.STRING).description("회원 이름"),
//                                        fieldWithPath("location").type(JsonFieldType.STRING).description("회원 거주 지역"),
//                                        fieldWithPath("title").type(JsonFieldType.STRING).description("자기 소개 제목"),
//                                        fieldWithPath("aboutMe").type(JsonFieldType.STRING).description("자기 소개 내용"),
//                                        fieldWithPath("websiteLink").type(JsonFieldType.STRING).description("웹사이트 링크"),
//                                        fieldWithPath("twitterLink").type(JsonFieldType.STRING).description("트위터 링크"),
//                                        fieldWithPath("githubLink").type(JsonFieldType.STRING).description("깃허브 링크"),
//                                        fieldWithPath("profileImageUrl").type(JsonFieldType.STRING).description("프로필 이미지 URL"),
//                                        fieldWithPath("memberStatus").type(JsonFieldType.STRING).description("회원 상태: 활동중 / 휴면계정 / 삭제대기"),
//                                        fieldWithPath("reputation").type(JsonFieldType.NUMBER).description("회원 평판"),
//                                        fieldWithPath("questions").type(JsonFieldType.NUMBER).description("회원이 작성한 Question 개수"),
//                                        fieldWithPath("answers").type(JsonFieldType.NUMBER).description("회원이 작성한 Answer 개수")
//                                )
//                        )));
//
//    }
//
//    @Test
//    void updateMember() throws Exception {
//        // given
//        MemberDto.Patch patchDto = createPatchDto();
//        String content = gson.toJson(patchDto);
//
//        // when
//        ResultActions actions = mockMvc.perform(
//                patch("/members/{member-id}", 1L)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(content)
//        );
//
//        // then
//        actions
//                .andExpect(status().isOk())
//                .andDo(document("update-member",
//                        preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint()),
//                        pathParameters(
//                                List.of(
//                                        parameterWithName("member-id").description("수정하려는 Member의 인덱스")
//                                )
//                        ),
//                        requestFields(
//                                List.of(
//                                        fieldWithPath("password").type(JsonFieldType.STRING).description("회원 비밀번호"),
//                                        fieldWithPath("displayName").type(JsonFieldType.STRING).description("회원 닉네임"),
//                                        fieldWithPath("fullName").type(JsonFieldType.STRING).description("회원 이름"),
//                                        fieldWithPath("location").type(JsonFieldType.STRING).description("회원 거주 지역"),
//                                        fieldWithPath("title").type(JsonFieldType.STRING).description("자기 소개 제목"),
//                                        fieldWithPath("aboutMe").type(JsonFieldType.STRING).description("자기 소개 내용"),
//                                        fieldWithPath("websiteLink").type(JsonFieldType.STRING).description("웹사이트 링크"),
//                                        fieldWithPath("twitterLink").type(JsonFieldType.STRING).description("트위터 링크"),
//                                        fieldWithPath("githubLink").type(JsonFieldType.STRING).description("깃허브 링크"),
//                                        fieldWithPath("profileImageUrl").type(JsonFieldType.STRING).description("프로필 이미지 URL")
//                                )
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("memberId").type(JsonFieldType.NUMBER).description("회원 인덱스"),
//                                        fieldWithPath("email").type(JsonFieldType.STRING).description("회원 이메일"),
//                                        fieldWithPath("password").type(JsonFieldType.STRING).description("회원 비밀번호"),
//                                        fieldWithPath("displayName").type(JsonFieldType.STRING).description("회원 닉네임"),
//                                        fieldWithPath("fullName").type(JsonFieldType.STRING).description("회원 이름"),
//                                        fieldWithPath("location").type(JsonFieldType.STRING).description("회원 거주 지역"),
//                                        fieldWithPath("title").type(JsonFieldType.STRING).description("자기 소개 제목"),
//                                        fieldWithPath("aboutMe").type(JsonFieldType.STRING).description("자기 소개 내용"),
//                                        fieldWithPath("websiteLink").type(JsonFieldType.STRING).description("웹사이트 링크"),
//                                        fieldWithPath("twitterLink").type(JsonFieldType.STRING).description("트위터 링크"),
//                                        fieldWithPath("githubLink").type(JsonFieldType.STRING).description("깃허브 링크"),
//                                        fieldWithPath("profileImageUrl").type(JsonFieldType.STRING).description("프로필 이미지 URL"),
//                                        fieldWithPath("memberStatus").type(JsonFieldType.STRING).description("회원 상태: 활동중 / 휴면계정 / 삭제대기"),
//                                        fieldWithPath("reputation").type(JsonFieldType.NUMBER).description("회원 평판"),
//                                        fieldWithPath("questions").type(JsonFieldType.NUMBER).description("회원이 작성한 Question 개수"),
//                                        fieldWithPath("answers").type(JsonFieldType.NUMBER).description("회원이 작성한 Answer 개수")
//                                )
//                        )));
//    }
//
//    @Test
//    void findMember() throws Exception {
//        // given
//
//        // when
//        ResultActions actions = mockMvc.perform(
//                get("/members/{member-id}", 1L)
//                        .accept(MediaType.APPLICATION_JSON)
//        );
//
//        // then
//        actions
//                .andExpect(status().isOk())
//                .andDo(document("find-member",
//                        preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint()),
//                        pathParameters(
//                                List.of(
//                                        parameterWithName("member-id").description("수정하려는 Member의 인덱스")
//                                )
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("memberId").type(JsonFieldType.NUMBER).description("회원 인덱스"),
//                                        fieldWithPath("email").type(JsonFieldType.STRING).description("회원 이메일"),
//                                        fieldWithPath("password").type(JsonFieldType.STRING).description("회원 비밀번호"),
//                                        fieldWithPath("displayName").type(JsonFieldType.STRING).description("회원 닉네임"),
//                                        fieldWithPath("fullName").type(JsonFieldType.STRING).description("회원 이름"),
//                                        fieldWithPath("location").type(JsonFieldType.STRING).description("회원 거주 지역"),
//                                        fieldWithPath("title").type(JsonFieldType.STRING).description("자기 소개 제목"),
//                                        fieldWithPath("aboutMe").type(JsonFieldType.STRING).description("자기 소개 내용"),
//                                        fieldWithPath("websiteLink").type(JsonFieldType.STRING).description("웹사이트 링크"),
//                                        fieldWithPath("twitterLink").type(JsonFieldType.STRING).description("트위터 링크"),
//                                        fieldWithPath("githubLink").type(JsonFieldType.STRING).description("깃허브 링크"),
//                                        fieldWithPath("profileImageUrl").type(JsonFieldType.STRING).description("프로필 이미지 URL"),
//                                        fieldWithPath("memberStatus").type(JsonFieldType.STRING).description("회원 상태: 활동중 / 휴면계정 / 삭제대기"),
//                                        fieldWithPath("reputation").type(JsonFieldType.NUMBER).description("회원 평판"),
//                                        fieldWithPath("questions").type(JsonFieldType.NUMBER).description("회원이 작성한 Question 개수"),
//                                        fieldWithPath("answers").type(JsonFieldType.NUMBER).description("회원이 작성한 Answer 개수")
//                                )
//                        )));
//    }
//
//    @Test
//    void findAll() throws Exception {
//        // given
//        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//        params.add("page", String.valueOf(1));
//        params.add("size", String.valueOf(30));
//
//        // when
//        ResultActions actions = mockMvc.perform(
//                get("/members")
//                        .params(params)
//                        .accept(MediaType.APPLICATION_JSON)
//        );
//
//        // then
//        actions
//                .andExpect(status().isOk())
//                .andDo(document("find-All-members",
//                        preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint()),
//                        requestParameters(
//                                List.of(
//                                        parameterWithName("page").description("Page 번호"),
//                                        parameterWithName("size").description("Page에 노출될 데이터 개수")                                )
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("[].memberId").type(JsonFieldType.NUMBER).description("회원 인덱스"),
//                                        fieldWithPath("[].email").type(JsonFieldType.STRING).description("회원 이메일"),
//                                        fieldWithPath("[].password").type(JsonFieldType.STRING).description("회원 비밀번호"),
//                                        fieldWithPath("[].displayName").type(JsonFieldType.STRING).description("회원 닉네임"),
//                                        fieldWithPath("[].fullName").type(JsonFieldType.STRING).description("회원 이름"),
//                                        fieldWithPath("[].location").type(JsonFieldType.STRING).description("회원 거주 지역"),
//                                        fieldWithPath("[].title").type(JsonFieldType.STRING).description("자기 소개 제목"),
//                                        fieldWithPath("[].aboutMe").type(JsonFieldType.STRING).description("자기 소개 내용"),
//                                        fieldWithPath("[].websiteLink").type(JsonFieldType.STRING).description("웹사이트 링크"),
//                                        fieldWithPath("[].twitterLink").type(JsonFieldType.STRING).description("트위터 링크"),
//                                        fieldWithPath("[].githubLink").type(JsonFieldType.STRING).description("깃허브 링크"),
//                                        fieldWithPath("[].profileImageUrl").type(JsonFieldType.STRING).description("프로필 이미지 URL"),
//                                        fieldWithPath("[].memberStatus").type(JsonFieldType.STRING).description("회원 상태: 활동중 / 휴면계정 / 삭제대기"),
//                                        fieldWithPath("[].reputation").type(JsonFieldType.NUMBER).description("회원 평판"),
//                                        fieldWithPath("[].questions").type(JsonFieldType.NUMBER).description("회원이 작성한 Question 개수"),
//                                        fieldWithPath("[].answers").type(JsonFieldType.NUMBER).description("회원이 작성한 Answer 개수")
//                                )
//                        )));
//    }
//
//    @Test
//    void findQuestionsByMember() throws Exception {
//        // given
//        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//        params.add("page", String.valueOf(1));
//        params.add("size", String.valueOf(30));
//
//        // when
//        ResultActions actions = mockMvc.perform(
//                get("/members/{member-id}/questions", 1L)
//                        .params(params)
//                        .accept(MediaType.APPLICATION_JSON)
//        );
//
//        // then
//        actions
//                .andExpect(status().isOk())
//                .andDo(document("find-questions-by-member",
//                        preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint()),
//                        pathParameters(
//                                parameterWithName("member-id").description("조회하려는 Questions의 작성자 인덱스")
//                        ),
//                        requestParameters(
//                                List.of(
//                                        parameterWithName("page").description("Page 번호"),
//                                        parameterWithName("size").description("Page에 노출될 데이터 개수"))
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
//                                ))));
//    }
//
//    @Test
//    void findAnswersByMember() throws Exception {
//        // given
//        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//        params.add("page", String.valueOf(1));
//        params.add("size", String.valueOf(30));
//
//        // when
//        ResultActions actions = mockMvc.perform(
//                get("/members/{member-id}/answers", 1L)
//                        .params(params)
//                        .accept(MediaType.APPLICATION_JSON)
//        );
//
//        // then
//        actions
//                .andExpect(status().isOk())
//                .andDo(document("find-answers-by-member",
//                        preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint()),
//                        pathParameters(
//                                parameterWithName("member-id").description("조회하려는 Answers의 작성자 인덱스")
//                        ),
//                        requestParameters(
//                                List.of(
//                                        parameterWithName("page").description("Page 번호"),
//                                        parameterWithName("size").description("Page에 노출될 데이터 개수"))
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
//                                ))));
//    }
//
//    @Test
//    void findBoardsByBookmark() throws Exception {
//        // given
//        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//        params.add("page", String.valueOf(1));
//        params.add("size", String.valueOf(30));
//
//        // when
//        ResultActions actions = mockMvc.perform(
//                get("/members/{member-id}/bookmarks", 1L)
//                        .params(params)
//                        .accept(MediaType.APPLICATION_JSON)
//        );
//
//        // then
//        actions
//                .andExpect(status().isOk())
//                .andDo(document("find-boards-by-bookmark",
//                        preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint()),
//                        pathParameters(
//                                parameterWithName("member-id").description("조회하려는 Boards의 작성자 인덱스")
//                        ),
//                        requestParameters(
//                                List.of(
//                                        parameterWithName("page").description("Page 번호"),
//                                        parameterWithName("size").description("Page에 노출될 데이터 개수"))
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
//                                ))));
//    }
//
//    @Test
//    void findBoardsByVotes() throws Exception {
//        // given
//        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//        params.add("page", String.valueOf(1));
//        params.add("size", String.valueOf(30));
//
//        // when
//        ResultActions actions = mockMvc.perform(
//                get("/members/{member-id}/votes", 1L)
//                        .params(params)
//                        .accept(MediaType.APPLICATION_JSON)
//        );
//
//        // then
//        actions
//                .andExpect(status().isOk())
//                .andDo(document("find-boards-by-vote",
//                        preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint()),
//                        pathParameters(
//                                parameterWithName("member-id").description("조회하려는 Boards의 작성자 인덱스")
//                        ),
//                        requestParameters(
//                                List.of(
//                                        parameterWithName("page").description("Page 번호"),
//                                        parameterWithName("size").description("Page에 노출될 데이터 개수"))
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
//                                ))));
//    }
//
//    @Test
//    void findTagsByMember() throws Exception {
//        // given
//        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//        params.add("page", String.valueOf(1));
//        params.add("size", String.valueOf(30));
//
//        // when
//        ResultActions actions = mockMvc.perform(
//                get("/members/{member-id}/tags", 1L)
//                        .params(params)
//                        .accept(MediaType.APPLICATION_JSON)
//        );
//
//        // then
//        actions
//                .andExpect(status().isOk())
//                .andDo(document("find-tags-by-member",
//                        preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint()),
//                        pathParameters(
//                                parameterWithName("member-id").description("조회하려는 Answers의 작성자 인덱스")
//                        ),
//                        requestParameters(
//                                List.of(
//                                        parameterWithName("page").description("Page 번호"),
//                                        parameterWithName("size").description("Page에 노출될 데이터 개수"))
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("[].tagId").type(JsonFieldType.NUMBER).description("Tag 인덱스"),
//                                        fieldWithPath("[].name").type(JsonFieldType.STRING).description("Tag 이름")
//                                ))));
//    }
//
//
//
//    @Test
//    void deleteMember() throws Exception {
//        // given
//
//        // when
//        ResultActions actions = mockMvc.perform(
//                delete("/members/{member-id}", 1L));
//        // tehn
//        actions
//                .andExpect(status().isNoContent())
//                .andDo(document("delete-member",
//                        preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint()),
//                        pathParameters(
//                                List.of(
//                                        parameterWithName("member-id").description("삭제하려는 Member의 인덱스")
//                                )
//                        )));
//    }
//
//    public MemberDto.Post createPostDto() {
//        MemberDto.Post.PostBuilder builder = MemberDto.Post.builder();
//        builder.email("email@gmail.com");
//        builder.displayName("나는개발자");
//        builder.password("password1234!");
//        MemberDto.Post post = builder.build();
//        return post;
//    }
//
//    public MemberDto.Patch createPatchDto() {
//        MemberDto.Patch.PatchBuilder builder = MemberDto.Patch.builder();
//        builder.displayName("나도개발자");
//        builder.password("password1234!");
//        builder.fullName("홍길동");
//        builder.title("What is Lorem Ipsum?");
//        builder.aboutMe("Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
//        builder.location("의정부");
//        builder.websiteLink("link1");
//        builder.githubLink("link2");
//        builder.twitterLink("link3");
//        builder.profileImageUrl("image url");
//        MemberDto.Patch patch = builder.build();
//        return patch;
//    }
//}
