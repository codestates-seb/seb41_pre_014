import styled from "styled-components";
import { Button } from '../components/atoms/Button';
import { Header } from '../components/blocks/Header';
import { Footer } from '../components/blocks/Footer';import { LeftNavBar } from '../components/blocks/NavBar';
import { QuestionDetail, AnswerDetail } from "../components/blocks/DetailContainer";
// import { EditorInputWrapper } from '../components/blocks/EditorInputWrapper';
import { MainRightSideInfoWidget, MainRightRelatedQuestions } from '../components/blocks/MainRight';

const Body = styled.div`
  display: flex;
`;

const Main = styled.div`
  display: flex;
  padding: 2.4rem;
`;

const MainTop = styled.div`
  display: flex;
  gap: 0.8rem;

  > div {
    display: flex;
    margin-bottom: 1.2rem;
    justify-content: space-between;
  }

  > QuestionMetaInfo {
    color: #6a737c;
  }
`;

const MainLeft = styled.div`
  display: flex;
  flex-direction: column;
  overflow: scroll;
`;

const AnswerFilterWrapper = styled.div`
  display: flex;
  justify-content: space-between;
  margin-bottom: 0.8rem;
`;

const AnswerFilterSelectBoxWrapper = styled.div`
  display: flex;
`;

const MainRight = styled.div`
  display: flex;
  flex-direction: column;
  gap: 1.6rem;
  padding-left: 2.4rem;
`;

export const QuestionMetaInfo = (asked, modified, viewed) => {
  return (
    <>
      {/* today, yesterday, n days ago */}
      <div>Asked {asked}</div>
      <div>Modified {modified}</div>
      <div>Viewed {viewed}</div>
    </>
  )
};

export const AnswerFilter = (answerCnt) => {
  return (
    <AnswerFilterWrapper>
      <div>{answerCnt} Answer</div>
      <AnswerFilterSelectBoxWrapper>
        <div>Sorted by:</div>
        <select>
          <option selected='selected'> Highest score (default) </option>
          <option> Date created (oldest first) </option>
        </select>
      </AnswerFilterSelectBoxWrapper>
    </AnswerFilterWrapper>
  )
};

export const Detail = (questionTitle) => {
  return (
    <>
      <Header />
      <Body>
        <LeftNavBar />
        <Main>
          <MainTop>
            <div>
              <div>{questionTitle}</div>
              <Button buttonType='type2' />
            </div>
            <QuestionMetaInfo />
          </MainTop>
          <MainLeft>
            <QuestionDetail />
            <AnswerFilter />
            <ul>
              {/* <AnswerDetail /> */}
            </ul>
            {/* <EditorInputWrapper /> */}
            <Button buttonType='type2' />
          </MainLeft>
          <MainRight>
            <MainRightSideInfoWidget />
            <MainRightSideInfoWidget />
            <MainRightSideInfoWidget />
            <MainRightRelatedQuestions />
          </MainRight>
        </Main>
      </Body>
      <Footer />
    </>
  )
};

