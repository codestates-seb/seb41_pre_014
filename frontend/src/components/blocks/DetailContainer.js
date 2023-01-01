import styled from 'styled-components';
import { TagBlock } from '../atoms/TagBlock';
// import { UserMetaInfoType2 } from './UserInfoContainer';
import { SNSShareBox } from './SNSShareBox';
import { useState, useEffect } from 'react';
import { useSelector } from 'react-redux';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

export const LeftButtonWrapper = (props) => {
  return (
    <QuestionLeftButton>
      <VoteButton 
        className='up' 
        onClick={props.upButtonClick}
      >
        <svg aria-hidden="true" className="svg-icon iconArrowUpLg" width="34" height="34" viewBox="0 0 36 36"><path d="M2 25h32L18 9 2 25Z"></path></svg>
      </VoteButton>

      <QuestionScoreDiv>
        {props.score || 'score'}
      </QuestionScoreDiv>

      <VoteButton
        className='down'
        onClick={props.downButtonClick}
      >
        <svg aria-hidden="true" className="svg-icon iconArrowDownLg" width="34" height="34" viewBox="0 0 36 36"><path d="M2 11h32L18 27 2 11Z"></path></svg>
      </VoteButton>
      
      <BookmarkButton 
        onClick={e => props.followButtonClick(e)} 
        className={props.isBookmark ? 'active' : null}
      >
        <svg aria-hidden="true" className="js-saves-btn-unselected svg-icon iconBookmarkAlt" width="18" height="18" viewBox="0 0 18 18"><path d="m9 10.6 4 2.66V3H5v10.26l4-2.66ZM3 17V3c0-1.1.9-2 2-2h8a2 2 0 0 1 2 2v14l-6-4-6 4Z"></path></svg>
      </BookmarkButton>
    </QuestionLeftButton>
  )
};

export const QuestionDetail = (props) => {

  const navigate = useNavigate();

  const [ shareModal, setShareModal ] = useState(false); 
  const shareButtonClick = (e) => {
    e.preventDefault();
    setShareModal(!shareModal);
  }

  const editButtonClick = () => {
    navigate(`/posts/${props.boardId}/edit`, {
      state: {
        title: props.title,
        body: props.body,
        tags: props.tags
      }
    })
  }

  const [ isBookmark, setIsBookmark ] = useState(false); 
  const memberId = useSelector(state => state.loginUserInfo.loginUserInfo?.memberId);
  const followButtonClick = async (e) => {
    e.preventDefault();
    isBookmark || await axios({
      method: 'POST',
      url: `${process.env.REACT_APP_SERVER_URL}`,
      params: {
        memberId,
        boardId: props.boardId,
      }
    })
    .then(res => {
      alert('Bookmark Success!');
      setIsBookmark(true);
    })
    .catch(err => {
      alert('Bookmark Failed');
      console.error(err);
    })
  }

  const isLogin = useSelector(state => state.loginStatus.status);
  const goLogin = () => {
    alert('로그인 후에 이용해주세요. 로그인 페이지로 이동합니다.');
    navigate('/users/login');
  }

  return (
    <DetailWrapper>
      <LeftButtonWrapper 
        upButtonClick={props.upButtonClick} 
        downButtonClick={props.downButtonClick}
        score={props.score}
        isBookmark={isBookmark}
        followButtonClick={isLogin ? followButtonClick : goLogin}
      />
      <RightDetailWrapper>
        <div className='content'>{props.questionContent}</div>
        <div className='tags'>
          {props.tags.length > 0 && 
            props.tags.map((el, idx) => {
              return (
                <TagBlock key={idx} tagName={el} />
              )
            })
          }
        </div>
        <RightFooter>
          <RightFooterButtonWrapper>
            <RightFooterButton>
              <a 
                href='#none'
                onClick={e => shareButtonClick(e)}
              >Share</a>
              { shareModal ? (
                <SNSShareBox 
                  boardId={props.boardId}
                  title={props.title}
                  description={props.body}
                />
              ) : null}
            </RightFooterButton>
            <RightFooterButton>
              <a 
                href='#none'
                onClick={editButtonClick}
              >Edit</a>
            </RightFooterButton>
            <RightFooterButton>
              <a 
                href='#none'
                onClick={e => isLogin ? followButtonClick(e) : goLogin()}
              >Bookmark</a>
            </RightFooterButton>
          </RightFooterButtonWrapper>
          {/* <UserMetaInfoType2 /> */}
        </RightFooter>
      </RightDetailWrapper>
    </DetailWrapper>
  )
};

export const AnswerDetail = (props) => {
  const [ answerData, setAnswerData ] = useState({});
  useEffect(() => {
    axios({
      method: 'GET',
      url:`${process.env.REACT_APP_SERVER_URL}/boards/${props.boardId}`,
    })
    .then(res => {
      setAnswerData(res.data);
    })
    .catch(err => {
      console.error(err);
    })
  },[props.boardId]);

  const [ shareModal, setShareModal ] = useState(false); 
  const shareButtonClick = (e) => {
    e.preventDefault();
    setShareModal(!shareModal);
  };

  const [ isBookmark, setIsBookmark ] = useState(false); 
  const memberId = useSelector(state => state.loginUserInfo.loginUserInfo?.memberId);
  const followButtonClick = async (e) => {
    e.preventDefault();
    isBookmark || await axios({
      method: 'POST',
      url: `${process.env.REACT_APP_SERVER_URL}`,
      params: {
        memberId,
        boardId: props.boardId,
      }
    })
    .then(res => {
      alert('Bookmark Success!');
      setIsBookmark(true);
    })
    .catch(err => {
      alert('Bookmark Failed');
      console.error(err);
    })
  };
  
  const navigate = useNavigate();

  const editButtonClick = (e) => {
    e.preventDefault();
    navigate(`/posts/${props.boardId}/answer/edit`, {
      state: {
        questionBoardId: answerData.questionId,
      }
    })
  }

  const isLogin = useSelector(state => state.loginStatus.status);
  const goLogin = () => {
    alert('로그인 후에 이용해주세요. 로그인 페이지로 이동합니다.');
    navigate('/users/login');
  }

  return (
    <DetailWrapper>
      <LeftButtonWrapper />
      <RightDetailWrapper>
        <div className='content'>{answerData.body}</div>
        <RightFooter>
          <RightFooterButtonWrapper>
            <RightFooterButton>
              <a 
                href='#none'
                onClick={e => shareButtonClick(e)}
              >Share</a>
              { shareModal ? (
                <SNSShareBox 
                  boardId={props.boardId}
                  description={answerData.body}
                />
              ) : null}
            </RightFooterButton>
            <RightFooterButton>
              <a 
                href='#none'
                onClick={editButtonClick}  
              >Edit</a>
            </RightFooterButton>
            <RightFooterButton>
              <a 
                href='#none'
                onClick={e => isLogin ? followButtonClick(e) : goLogin()}
              >Bookmark</a>
            </RightFooterButton>
          </RightFooterButtonWrapper>
          {/* <UserMetaInfoType2 /> */}
        </RightFooter>
      </RightDetailWrapper>
    </DetailWrapper>
  )
};

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

  &.active > svg > path {
    fill: #F2740D;
  }
`;

const DetailWrapper = styled.div`
  display: flex;
`;

const RightDetailWrapper = styled.div`
  flex: auto;
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
  position:relative;
  > a {
    color: #6a737c;
    font-size: 1.3rem;
    text-decoration: none;
  }
<<<<<<< HEAD
`;
=======
`;