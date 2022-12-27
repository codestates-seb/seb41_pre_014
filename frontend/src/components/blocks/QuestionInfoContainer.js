import styled from 'styled-components';
import { UserMetaInfoType1 } from './UserInfoContainer';
import { TagBlock } from '../atoms/TagBlock';

const QuestionWrapper = styled.div`
  display: flex;
`;

const QuestionMetaInfo = styled.div`
  display: flex;
  flex-direction: column;
  align-items: flex-end;
  width: 10.8rem;
  height: 10.2rem;
  gap: 0.6rem;
  color: #525960;
  margin: 0 1.6rem 0 0;
`;

const QuestionInfo = styled.div`
  display: flex;
  flex-direction: column;
  width: 59.5rem;
  height: 10.4rem;
`;

const CustomDiv = styled.div`
  display: flex;
  gap: 0.3rem;
`;

const VoteAnswerView = styled(CustomDiv)`

`;

const QuestionContent = styled.div`
  display: -webkit-box;
  -webkit-line-clamp: 2;
  -webkit-box-orient: vertical;
  overflow: hidden;
`;

const TagAndUserMeta = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
`;

const Tag = styled(CustomDiv)`

`;

export const QuestionMetaInfoWrapper = ({votes, answers, views}) => {
  return (
    <QuestionMetaInfo>
      <VoteAnswerView>
        <span>{votes}</span>
        <span>votes</span>
      </VoteAnswerView>
      <VoteAnswerView>
        <span>{answers}</span>
        <span>answers</span>
      </VoteAnswerView>
      <VoteAnswerView>
        <span>{views}</span>
        <span>views</span>
      </VoteAnswerView>
    </QuestionMetaInfo>
  )
};

export const QuestionInfoWrapper = () => {
  return (
    <QuestionInfo>
      <h3><a href=''></a></h3>
      <QuestionContent></QuestionContent>
      <TagAndUserMeta>
        <Tag> 
          <ul>
            {/* <TagBlock /> */}
          </ul>
        </Tag>
        <UserMetaInfoType1 />
      </TagAndUserMeta>
    </QuestionInfo>
  )
};

export const QuestionInfoContainer = () => {
  return (
    <QuestionWrapper>
      <QuestionMetaInfoWrapper />
      <QuestionInfoWrapper />
    </QuestionWrapper>
  )
}
