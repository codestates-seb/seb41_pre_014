import styled from "styled-components";
import { Button } from '../components/atoms/Button';
import { QuestionDetail, AnswerDetail } from "../components/blocks/DetailContainer";
import { EditorInput } from '../components/blocks/EditorInputWrapper';
import { MainRightSideInfoWidget, MainRightRelatedQuestions } from '../components/blocks/MainRight';
import { DetailSideInfoWidgetData } from "../data/staticData/SideBarData";

const Main = styled.div`
  display: flex;
  flex-direction: column;
  /* padding: 2.4rem; */
`;

const MainTop = styled.div`
  display: flex;
  flex-direction: column;
  gap: 0.8rem;

  & .titleAndButton {
    display: flex;
    margin-bottom: 1.2rem;
    justify-content: space-between;

    & > h1 {
      color: #3b4045;
      font-size: 2.7rem;
      overflow-wrap: break-word;
      margin-bottom: 0.8rem;
      display: block;
      text-align: left;
    }
  }
`;

const QuestionMetaInfoWrapper = styled.div`
  display: flex;
  padding-bottom: 0.8rem;
  margin-bottom: 1.6rem;
  flex-wrap: wrap;
  border-color: hsl(210deg 8% 90%);
  border-bottom-style: solid;
  border-bottom-width: 0.1rem;
  text-align: left;

  > div {
    color: #6a737c;
    font-size: 1.3rem;
    margin-right: 1.6rem;
  }

`;

const MainLeftRightWrapper = styled.div`
  display: flex;
`;

const MainLeft = styled.div`
  display: flex;
  flex-direction: column;
  /* overflow: scroll; */
`;

const AnswerFilterWrapper = styled.div`
  display: flex;
  justify-content: space-between;
  margin-bottom: 0.8rem;

  > h2 {
    font-weight: 400;
    font-size: 1.9rem;
  }
`;

const AnswerFilterSelectBoxWrapper = styled.div`
  display: flex;
  align-items: center;
  gap: 0.4rem;

  > div {
    font-size: 1.2rem;
  }
  
  > select {
    position: relative;
    padding: 0.78rem 3.2rem 0.78rem 0.91rem;
    border: 0.1rem solid hsl(210deg 8% 75%);
    border-radius: 0.3rem;
    background-color: #fff;
    outline: 0;
    font-size: 1.3rem;
    color: #0c0d0e;
  }
`;

const EditorWrapper = styled.div`
  display: flex;
  flex-direction: column;
  gap: 1.9rem;

  > h2 {
    font-weight: 400;
    font-size: 1.9rem;
    padding-top: 2rem;
  }
`;

const MainRight = styled.div`
  display: flex;
  flex-direction: column;
  gap: 1.6rem;
  padding-left: 2.4rem;
`;

export const QuestionMetaInfo = (props) => {
  return (
    <QuestionMetaInfoWrapper>
      {/* today, yesterday, n days ago */}
      <div>Asked {props.asked}</div>
      <div>Modified {props.modified}</div>
      <div>Viewed {props.viewed}</div>
    </QuestionMetaInfoWrapper>
  )
};

export const AnswerFilter = (props) => {
  return (
    <AnswerFilterWrapper>
      <h2>{props.answerCount}Answer</h2>
      <AnswerFilterSelectBoxWrapper>
        <div>Sorted by:</div>
        <select defaultValue={'highest'}>
          <option value='highest'> Highest score (default) </option>
          <option value='oldest'> Date created (oldest first) </option>
        </select>
      </AnswerFilterSelectBoxWrapper>
    </AnswerFilterWrapper>
  )
};

const Detail = (props) => {
  return (
    <>
        <Main>
          <MainTop>
            <div className="titleAndButton">
              <h1>{props.questionTitle}questionTitle</h1>
              <a href="./pages/Write">
                <Button 
                buttonType='type2' 
                buttonName='Ask Question'
                width='9.87rem'
                height='3.78rem'
                />
              </a>
            </div>
            <QuestionMetaInfo />
          </MainTop>
          <MainLeftRightWrapper>
            <MainLeft>
              <QuestionDetail />
              <AnswerFilter />
              <ul>
                <AnswerDetail />
              </ul>
              <EditorWrapper>
                <h2>Your Answer</h2>
                <EditorInput />
                <Button 
                  buttonType='type2'
                  buttonName='Post Your Answer'
                  width='12.18rem'
                  height='3.79rem'
                />
              </EditorWrapper>
            </MainLeft>
            <MainRight>
              <MainRightSideInfoWidget />
              <MainRightSideInfoWidget />
              <MainRightSideInfoWidget />
              {/* {DetailSideInfoWidgetData.map((el) => {
                return (
                  <MainRightSideInfoWidget title={el.title} />
                )
              })} */}
              <MainRightRelatedQuestions />
            </MainRight>
          </MainLeftRightWrapper>
        </Main>
    </>
  )
};

export default Detail;