import styled from 'styled-components';
import { TagBlock } from '../atoms/TagBlock';
import { UserMetaInfoType2 } from './UserInfoContainer';

const QuestionLeftButton = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
`;

const VoteButton = styled.button`
  width: 3.6rem;
  height: 3.6rem;
  cursor: pointer;
  border: none;
  background-color: inherit;
`;

const QuestionScoreDiv = styled.div`
  font-size: 1.6rem;
  color: #6a737c;
`;

const BookmarkButton = styled.button`
  padding: 0.4rem 0;
  cursor: pointer;
  width: 4rem;
  height: 2.6rem;
  border: none;
  background-color: inherit;
`;

const DetailWrapper = styled.div`
  display: flex;
`;

const RightDetailWrapper = styled.div`
  display: flex;
  flex-direction: column;

`;

const RightFooter = styled.div`
  display: flex;
  justify-content: space-between;
  flex-wrap: wrap;
`;

const RightFooterButtonWrapper = styled.div`
  display: flex;
  flex-wrap: wrap;
  text-align: left;
`;

const RightFooterButton = styled.button`
  display: block;
  cursor: pointer;
  background-color: inherit;
  border: none;
  margin: 0.4rem;

  > a {
    color: #6a737c;
    text-decoration: none;
  }
`;

export const LeftButtonWrapper = (questionScore) => {
  return (
    <QuestionLeftButton>
      <VoteButton><svg /></VoteButton>
      <QuestionScoreDiv>{questionScore}</QuestionScoreDiv>
      <VoteButton><svg /></VoteButton>
      <BookmarkButton><svg /></BookmarkButton>
    </QuestionLeftButton>
  )
};

export const QuestionDetail = (questionContent) => {
  return (
    <DetailWrapper>
      <LeftButtonWrapper />
      <RightDetailWrapper>
        <div>{questionContent}</div>
        <div>
          <ul><TagBlock /></ul>
        </div>
        <RightFooter>
          <RightFooterButtonWrapper>
            <RightFooterButton>
              <a href=''>Share</a>
            </RightFooterButton>
            <RightFooterButton>
              <a href=''>Edit</a>
            </RightFooterButton>
            <RightFooterButton>
              <a href=''>Follow</a>
            </RightFooterButton>
          </RightFooterButtonWrapper>
          <UserMetaInfoType2 />
        </RightFooter>
      </RightDetailWrapper>
    </DetailWrapper>
  )
};

export const AnswerDetail = (answerContent) => {
  return (
    <DetailWrapper>
      <LeftButtonWrapper />
      <RightDetailWrapper>
        <div>{answerContent}</div>
        <RightFooter>
          <RightFooterButtonWrapper>
            <RightFooterButton>
              <a href=''>Share</a>
            </RightFooterButton>
            <RightFooterButton>
              <a href=''>Improve the answer</a>
            </RightFooterButton>
            <RightFooterButton>
              <a href=''>Follow</a>
            </RightFooterButton>
          </RightFooterButtonWrapper>
          <UserMetaInfoType2 />
        </RightFooter>
      </RightDetailWrapper>
    </DetailWrapper>
  )
};