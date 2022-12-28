import styled from 'styled-components';
import { UserMetaInfoType1 } from './UserInfoContainer';
import { Link } from 'react-router-dom';
import { TagBlock } from '../atoms/TagBlock';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faCheck } from '@fortawesome/free-solid-svg-icons';

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

const CustomDiv = styled.div`
  display: flex;
  gap: 0.3rem;
`;

const VoteAnswerView = styled(CustomDiv)`

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

const QuestionMetaInfoH = styled.div`
  width: auto;
  flex-direction: row;
  align-items: center;
  gap: 0.6rem;
  display: flex;
  font-size: 1.3rem;
  color: #6A737C;
`;

const VoteH = styled.div`
  color: #0C0D0E;
  display: inline-flex;
  gap: 0.3em;
  align-items: center;
  justify-content: center;
  white-space: nowrap;
  border: 0.1rem solid transparent;
  font-size: inherit;
  & > span {
    font-size: 1.3rem;
  };
`;

const VoteCountH = styled.span`
  font-weight: 500;
  font-size: inherit;
`;

const AnswerH = styled.div`
  border: 0.1rem solid #2F6F44;
  border-radius: 0.3rem;
  background-color: #2F6F44;
  color: #FFF;
  padding: 0.2rem 0.4rem;
  display: inline-flex;
  gap: 0.3em;
  align-items: center;
  justify-content: center;
  white-space: nowrap;
  font-size: 1.3rem;

  & > span {
    font-size: 1.3rem;

    & > svg {
      font-size: 1.3rem;
    }
  };
`;

const AnswerCountH = styled(VoteCountH);

const ViewH = styled.div`
  display: inline-flex;
  gap: 0.3em;
  align-items: center;
  justify-content: center;
  white-space: nowrap;
  border: 0.1rem solid transparent;
  color: hsl(47,84%,28%);
  font-size: 1.3rem;

  & > span {
    font-size: 1.3rem;
  }
`;
const ViewCountH = styled(VoteCountH);

export const QuestionMetaInfoWrapperH = (props) => {
  return (
    <QuestionMetaInfoH>
      <VoteH>
        <VoteCountH>{props.votes}</VoteCountH>
        <span>votes</span>
      </VoteH>
      <AnswerH>
        {props.QorA === 'A'
          ? (
            <>
              <span><FontAwesomeIcon icon={faCheck} /></span>
              <AnswerCountH>{props.answer}</AnswerCountH>
              <span>answers</span>
            </>
          )
          : (
            <>
              <span><FontAwesomeIcon icon={faCheck} /></span>
              <span>Accepted</span>
            </>
          )
        }
      </AnswerH>
      {props.QorA === 'Q' && (
        <ViewH>
          <ViewCountH>{props.view}</ViewCountH>
          <span>views</span>
        </ViewH>
      )}
    </QuestionMetaInfoH>
  )
};

const QuestionInfo = styled.div`
  display: flex;
  flex-direction: column;
  width: 100%;
  height: 100%;

  & > h3 {
    padding-right: 2.4rem;
    margin: -0.195rem 0 0.5rem;

    & > a {
      word-break: break-word;
      overflow-wrap: break-word;
      -webkit-hyphens: auto;
      -moz-hyphens: auto;
      -ms-hyphens: auto;
      hyphens: auto;
      font-size: 1.5rem;
      color: #0074CC;
      text-decoration: none;
      font-weight: normal;
    };
  }
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

const Tag = styled.div`
  display: flex;
  gap: 0.3rem;
  & > ul {
    margin-bottom: 1.3rem;
    list-style: none;

    & > li {
      display: inline-block;
      margin-right: 0.4rem;
    }
  }
`;

export const QuestionInfoWrapper = (props) => {
  return (
    <QuestionInfo>
      <h3>
        <Link to={`/questions/:${props.detailId}`} >
          {props.title}
        </Link>
      </h3>
      <QuestionContent>
        {props.content}
      </QuestionContent>
      <TagAndUserMeta>
        <Tag> 
          <ul>
            <li><TagBlock tagName='Javascript' /></li>
            <li><TagBlock tagName='React' /></li>
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

const CreateDate = styled.div`
  font-size: 1.2rem;
  color: #6A737C;
`;

export const QuestionInfoWrapperUserPage = (props) => {
  return (
    <QuestionInfo>
      <h3>
        <Link to={`/questions/:${props.detailId}`} >
          {props.title}
        </Link>
      </h3>
      <QuestionContent>
        {props.content}
      </QuestionContent>
      <TagAndUserMeta>
        <Tag> 
          <ul>
            <li><TagBlock tagName='Javascript' /></li>
            <li><TagBlock tagName='React' /></li>
          </ul>
        </Tag>
        <CreateDate>
          {props.QnA === 'A' ? 'answerd' : 'asked'} {props.date}
        </CreateDate>
      </TagAndUserMeta>
    </QuestionInfo>
  )
};