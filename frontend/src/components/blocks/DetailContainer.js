import styled from 'styled-components';
import { TagBlock } from '../atoms/TagBlock';
// import { UserMetaInfoType2 } from './UserInfoContainer';

const QuestionLeftButton = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  margin: -0.2rem;
  padding-right: 1.6rem;
`;

const VoteButton = styled.button`
  width: 3.6rem;
  height: 3.6rem;
  cursor: pointer;
  border: none;
  background-color: inherit;

  & > svg > path {
    fill: #BABFC4;
  }
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

  & > svg > path {
    fill: #BABFC4;
  }
`;

const DetailWrapper = styled.div`
  display: flex;
`;

const RightDetailWrapper = styled.div`
  display: flex;
  flex-direction: column;
  padding-right: 1.6rem;
  text-align: left;

  & .content {
    font-size: 1.6rem;
    overflow-wrap: break-word;
    text-align: left;
    color: #232629;
  }

  & .tags {
    margin-top: 2.4rem;
    margin-bottom: 1.2rem;
    position: relative;
    display: flex;
    flex-wrap: wrap;
  }

`;

const RightFooter = styled.div`
  display: flex;
  justify-content: space-between;
  margin: 0.8rem 0;
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
  margin: 0.8rem;

  > a {
    color: #6a737c;
    font-size: 1.3rem;
    text-decoration: none;
  }
`;

export const LeftButtonWrapper = (props) => {
  return (
    <QuestionLeftButton>
      <VoteButton>
        <svg aria-hidden="true" className="svg-icon iconArrowUpLg" width="34" height="34" viewBox="0 0 36 36"><path d="M2 25h32L18 9 2 25Z"></path></svg>
      </VoteButton>
      <QuestionScoreDiv>{props.score}</QuestionScoreDiv>
      <VoteButton>
        <svg aria-hidden="true" className="svg-icon iconArrowDownLg" width="34" height="34" viewBox="0 0 36 36"><path d="M2 11h32L18 27 2 11Z"></path></svg>
      </VoteButton>
      <BookmarkButton>
        <svg aria-hidden="true" className="js-saves-btn-unselected svg-icon iconBookmarkAlt" width="18" height="18" viewBox="0 0 18 18"><path d="m9 10.6 4 2.66V3H5v10.26l4-2.66ZM3 17V3c0-1.1.9-2 2-2h8a2 2 0 0 1 2 2v14l-6-4-6 4Z"></path></svg>
      </BookmarkButton>
    </QuestionLeftButton>
  )
};

export const QuestionDetail = (props) => {
  return (
    <DetailWrapper>
      <LeftButtonWrapper />
      <RightDetailWrapper>
        <div className='content'>{props.questionContent}</div>
        {/* <div className='tags'>
          <ul><TagBlock /></ul>
        </div> */}
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
          {/* <UserMetaInfoType2 /> */}
        </RightFooter>
      </RightDetailWrapper>
    </DetailWrapper>
  )
};

export const AnswerDetail = (props) => {
  return (
    <DetailWrapper>
      <LeftButtonWrapper />
      <RightDetailWrapper>
        <div className='content'>{props.answerContent}</div>
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
          {/* <UserMetaInfoType2 /> */}
        </RightFooter>
      </RightDetailWrapper>
    </DetailWrapper>
  )
};