// todo:tag, usermeta
import styled from 'styled-components';
import { UserMetaInfoType1 } from './UserInfoContainer';
// import { TagBlock } from '../atoms/TagBlock';

const QuestionWrapper = styled.div`
  display: flex;
  border-top: 0.1rem solid hsl(210deg 8% 90%);
  padding: 1.6rem;
`;

const QuestionMetaInfo = styled.div`
  display: flex;
  flex-direction: column;
  align-items: flex-end;
  width: 10.8rem;
  gap: 0.6rem;
  color: #525960;
  margin: 0 1.6rem 0 0;
`;

const QuestionHorizontalMetaInfo = styled.div`
  display: flex;
  align-items: flex-end;
  width: 10.8rem;
  gap: 0.6rem;
  color: #525960;
  margin: 0 1.6rem 0 0;
`;

const QuestionInfo = styled.div`
  display: flex;
  flex-direction: column;
  width: 59.5rem;

  > h3 {
    padding-right: 2.4rem;
    margin-bottom: 0.5rem;

    > a {
      word-break: break-word;
      overflow-wrap: break-word;
      hyphens: auto;
      color: hsl(206deg 100% 40%);
      text-decoration: none;
      cursor: pointer;
      font-weight: 400;
      font-size: 1.7rem;
    }
  }
`;

const CustomDiv = styled.div`
  display: flex;
  gap: 0.3rem;
`;

const VoteAnswerView = styled(CustomDiv)`
  > span {
    font-size: 1.3rem;
  }
`;

const QuestionContent = styled.div`
  display: -webkit-box;
  -webkit-line-clamp: 2;
  -webkit-box-orient: vertical;
  overflow: hidden;
  margin-top: 0.2rem;
  margin-bottom: 0.8rem;
  color: hsl(210deg 8% 25%);
  word-break: break-word;
  overflow-wrap: break-word;
  font-size: 1.3rem;
`;

const TagAndUserMeta = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
`;

const Tag = styled(CustomDiv)`

`;

export const QuestionMetaInfoWrapper = (props) => {
  return (
    <QuestionMetaInfo>
      <VoteAnswerView>
        <span>{props.votes}</span>
        <span>votes</span>
      </VoteAnswerView>
      <VoteAnswerView>
        <span>{props.answers}</span>
        <span>answers</span>
      </VoteAnswerView>
      <VoteAnswerView>
        <span>{props.views}</span>
        <span>views</span>
      </VoteAnswerView>
    </QuestionMetaInfo>
  )
};

export const QuestionHorizontalMetaInfoWrapper = (props) => {
  return (
    <QuestionHorizontalMetaInfo>
      <VoteAnswerView>
        <span>{props.votes}</span>
        <span>votes</span>
      </VoteAnswerView>
      <VoteAnswerView>
        <span>{props.answers}</span>
        <span>answers</span>
      </VoteAnswerView>
      <VoteAnswerView>
        <span>{props.views}</span>
        <span>views</span>
      </VoteAnswerView>
    </QuestionHorizontalMetaInfo>
  )
};

export const QuestionInfoWrapper = (props) => {
  return (
    <QuestionInfo>
      <h3><a href=''>{props.title}Title</a></h3>
      <QuestionContent>{props.content}content</QuestionContent>
      <TagAndUserMeta>
        <Tag> 
          <ul>
            {/* <TagBlock /> */}
          </ul>
        </Tag>
        {/* todo: props */}
        <UserMetaInfoType1 />
      </TagAndUserMeta>
    </QuestionInfo>
  )
};

export const QuestionInfoContainer = (props) => {
  return (
    <QuestionWrapper>
      <QuestionMetaInfoWrapper
        votes={props.votes}
        answers={props.answers}
        views={props.views}
      />
      <QuestionInfoWrapper
        title={props.title}
        content={props.content}
      />
    </QuestionWrapper>
  )
}
