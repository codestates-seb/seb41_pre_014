import styled from 'styled-components';
import { UserMetaInfoType1 } from './UserInfoContainer';
import { Link } from 'react-router-dom';
import { TagBlock } from '../atoms/TagBlock';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faCheck, faXmark } from '@fortawesome/free-solid-svg-icons';
import '@toast-ui/editor/dist/toastui-editor.css';
import { Viewer } from '@toast-ui/react-editor';

const QuestionWrapper = styled.div`
  display: flex;
  border-top: 0.1rem solid hsl(210deg 8% 90%);
  padding: 1.6rem;
`;

const QuestionMetaInfo = styled.div`
  display: flex;
  flex-direction: column;
  align-items: flex-end;
  gap: 0.6rem;
  color: #525960;
  margin: 0 1.6rem 0 0;
`;

const QuestionHorizontalMetaInfo = styled.div`
  display: flex;
  align-items: flex-end;
  gap: 0.6rem;
  color: #525960;
  margin: 0 1.6rem 0 0;
`;

const QuestionInfo = styled.div`
  display: flex;
  flex-direction: column;
  width: 100%;

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


const QuestionMetaInfoH = styled.div`
  width: auto;
  flex-direction: row;
  align-items: center;
  display: flex;
  justify-content: space-between;
`;

const MetaInfoHLeft = styled.div`
  width: auto;
  flex-direction: row;
  align-items: center;
  gap: 0.6rem;
  display: flex;
  font-size: 1.3rem;
  color: #6A737C;
`;

const MetaInfoHRight = styled.div`
  padding: 0.2rem;
  cursor: pointer;
  & > svg {
    font-size: 1.6rem;
    color: #7d7d7d;
  }
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

  &.following {
    border: 0.1rem solid #2F6F44;
    border-radius: 0.3rem;
    background-color: #FFF;;
    color: #2F6F44
  }
`;

const AnswerCountH = styled.span`
  font-weight: 500;
  font-size: inherit;
`;

const ViewH = styled.div`
  display: inline-flex;
  gap: 0.3em;
  align-items: center;
  justify-content: center;
  white-space: nowrap;
  border: 0.1rem solid transparent;
  color: hsl(47,84%,28%);
  font-size: 1.3rem;

  &.Following {
    color: #6A737C;
  }

  & > span {
    font-size: 1.3rem;
  }
`;
const ViewCountH = styled.span`
  font-weight: 500;
  font-size: inherit;
`;

export const QuestionMetaInfoWrapperH = (props) => {

  return (
    <QuestionMetaInfoH>
      <MetaInfoHLeft>
        <VoteH>
          <VoteCountH>{props.votes}</VoteCountH>
          <span>votes</span>
        </VoteH>
        <AnswerH className={props.activityType}>
          {props.activityType === 'Answer' && (
            <>
              <span><FontAwesomeIcon icon={faCheck} /></span>
              <AnswerCountH>{props.answer}</AnswerCountH>
              <span>answers</span>
            </>
          )}
          {props.activityType === 'Question' && (
            <>
              <span><FontAwesomeIcon icon={faCheck} /></span>
              <span>Accepted</span>
            </>
          )}
          {props.activityType === 'Following' && (
            <>
              <span><FontAwesomeIcon icon={faCheck} /></span>
              <AnswerCountH>{props.answer}</AnswerCountH>
              <span>answers</span>
            </>
          )}
        </AnswerH>
        { ['Question', 'Following'].includes(props.activityType) && (
          <ViewH className={props.activityType}>
            <ViewCountH>{props.view}</ViewCountH>
            <span>views</span>
          </ViewH>
        )}
      </MetaInfoHLeft>
      <MetaInfoHRight onClick={props.xmarkOnClick}>
        {props.activityType === 'Following' && (
          <>
            <FontAwesomeIcon icon={faXmark} />
          </>
        )}
      </MetaInfoHRight>
    </QuestionMetaInfoH>
  )
};

const QuestionInfoUser = styled.div`
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
  margin-top: 0.2rem;
  margin-bottom: 0.8rem;
  color: hsl(210deg 8% 25%);
  word-break: break-word;
  overflow-wrap: break-word;
  font-size: 1.3rem;
  & * {
    font-size: 1.3rem;
    margin: 0!important;
  }
  & > div {
    max-height: 4.2rem;
    overflow: hidden;
  }
`;

const TagAndUserMeta = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 100%;
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
        <Link to={`/questions/${props.detailId}`} >
          {props.title}
        </Link>
      </h3>
      <QuestionContent>
        {props.content && <Viewer initialValue={props.content} />}
      </QuestionContent>
      <TagAndUserMeta>
        <Tag> 
          <ul>
            {props.tags && props.tags.map((el, idx) => {
              return <li key={idx}><TagBlock tagName={el} /></li>
            })}
          </ul>
        </Tag>       
        <UserMetaInfoType1
          profileImageUrl={props.profileImageUrl}
          displayName={props.displayName}
          score={props.votes}
          createdAt={props.CreateAt}
          detailId={props.detailId}
        />
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
        detailId={props.detailId}
        title={props.title}
        content={props.content}
        createdAt={props.CreateAt}
        tags={props.tags}
        profileImageUrl={props.profileImageUrl}
        displayName={props.displayName}
        score={props.votes}
      />
    </QuestionWrapper>
  )
}

const CreateDate = styled.div`
  font-size: 1.2rem;
  color: #6A737C;
`;

export const QuestionInfoWrapperUserPage = (props) => {
  return (
    <QuestionInfoUser>
      <h3>
        <Link to={`/questions/:${props.detailId}`} >
          {props.title}
        </Link>
      </h3>
      <QuestionContent>
        {props.content && <Viewer initialValue={props.content} />}
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
    </QuestionInfoUser>
  )
};