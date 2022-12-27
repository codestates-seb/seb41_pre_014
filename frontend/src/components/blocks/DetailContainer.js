import styled from 'styled-components';
import { TagBlock } from '../atoms/TagBlock';
// import { UserMetaInfoType2 } from './UserInfoContainer';

const QuestionLeftButton = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  margin: -0.2rem;
  padding-right: 1.6rem;
  /* color: hsl(210deg 8% 75%); */
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
        <svg aria-hidden="true" className="svg-icon iconArrowUpLg" width="36" height="36" viewBox="0 0 36 36"><path d="M2 25h32L18 9 2 25Z"></path></svg>
      </VoteButton>
      <QuestionScoreDiv>{props.score}score</QuestionScoreDiv>
      <VoteButton>
        <svg aria-hidden="true" className="svg-icon iconArrowDownLg" width="36" height="36" viewBox="0 0 36 36"><path d="M2 11h32L18 27 2 11Z"></path></svg>
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
        <div className='content'>{props.questionContent}My question is following :
Can I remove boilerplate code by using threadpool, rayon or some other Rust crate ?

I know that I could do my own implementation, but would like to know is there some crate with same functionality ?

From my research threadpool/rayon are useful when you "send" code and it is executed, but I have not found way to make N threads that will have some code/logic that they need to remember ?

Basic idea is in let mut rng = rand::thread_rng(); this is instance that each thread need to have on it own.

Also is there are some other problems with code, please point it out.</div>
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
        <div className='content'>{props.answerContent}Yes, you can use Rayon to eliminate a lot of that code and make the remaining code much more readable, as illustrated in this gist:

https://gist.github.com/BillBarnhill/db07af903cb3c3edb6e715d9cedae028

The worker pool model is not great in Rust, due to the ownership rules. As a result parallel iterators are often a better choice.

I forgot to address your main concern, per thread context, originally. You can see how to store per thread context using a ThreadLocal! in this answer:

https://stackoverflow.com/a/42656422/204343

I will try to come back and edit the code to reflect ThreadLocal! use as soon as I have more time.

The gist requires nightly because of thread_id_value, but that is all but stable and can be removed if needed.

The real catch is that the gist has timing, and compares main_new with main_original, with surprising results. Perhaps not so surprising, Rayon has good debug support.</div>
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