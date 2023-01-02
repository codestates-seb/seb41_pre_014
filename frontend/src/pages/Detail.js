import styled from "styled-components";
import { Button } from '../components/atoms/Button';
import { QuestionDetail, AnswerDetail } from "../components/blocks/DetailContainer";
import { EditorInput } from '../components/blocks/EditorInputWrapper';
import { MainRightSideInfoWidget, MainRightRelatedQuestions } from '../components/blocks/MainRight';
import { BoardDetailSideInfoWidgetData } from "../data/staticData/SideBarData";
import { DetailWriteButton } from "../components/blocks/DetailWriteButton";
import { useEffect, useState, useRef } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';
import axios from "axios";
import { useSelector } from "react-redux";

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

const Detail = () => {
  const location = useLocation();
  const boardId = location.pathname.split('/')[2];

  const [ detailData, setDetailData ] = useState({});

  const getFetchData = () => {
    axios({
      method: 'GET',
      url: `${process.env.REACT_APP_SERVER_URL}/boards/${boardId}`,
    })
    .then(res => {
      setDetailData(res.data);
    })
    .catch(err => {
      console.error(err);
    });
  }

  useEffect(() => {
    getFetchData();
  },[])

  const upButtonClick = () => {
    console.log('up!');
  }

  const downButtonClick = () => {
    console.log('down!');
  }
  const navigate = useNavigate();
  const loginUserId = useSelector(state => state.loginUserInfo.loginUserInfo?.memberId);
  const answerWrite = useRef();

  const postAnswerButtonClick = async () => {
    const answerCont = answerWrite.current.getInstance().getHTML();
    await axios({
      method: 'POST',
      url: `${process.env.REACT_APP_SERVER_URL}/boards/answers/${boardId}`,
      params: {
        memberId: loginUserId
      },
      data: {
        title: 'This is a title of Answer.',
        body: answerCont,
        tags: ['javascript', 'reactjs','codestates'],
      }
    })
    .then(res => {
      answerWrite.current.getInstance().setHTML('');
      getFetchData();
    })
    .catch(err => {
      console.error(err);
    })
  };

  const isLogin = useSelector(state => state.loginStatus.status);
  const goLogin = () => {
    alert('로그인 후에 이용해주세요. 로그인 페이지로 이동합니다.');
    navigate('/users/login');
  };


  return (
    <>
        <Main>
          <MainTop>
            <div className="titleAndButton">
              <h1>{detailData.title || 'Question Title'}</h1>
              <DetailWriteButton />
            </div>
            <QuestionMetaInfo 
              asked={detailData.createdAt || 'unknown'}
              modified={detailData.lastModifiedAt || 'unknown'} 
              viewed={detailData.viewCount || 'unknown'} 
            />
          </MainTop>
          <MainLeftRightWrapper>
            <MainLeft>
              <QuestionDetail 
                upButtonClick={isLogin ? upButtonClick : goLogin}
                downButtonClick={isLogin ? downButtonClick : goLogin}
                score={detailData.score}
                boardId={boardId}
                tags={detailData.tags}
                title={detailData.title}
                body={detailData.body}
              />
              <AnswerWapper>
              {detailData.answers && detailData.answers.length > 0 && <AnswerFilter />}
              {detailData.answers && detailData.answers.length > 0 && detailData.answers.map((el, idx) => {
                return (
                  <AnswerDetail 
                    key={idx}
                    boardId={el}
                  />
                )
              })}
              </AnswerWapper>
              <EditorWrapper>
                <h2>Your Answer</h2>
                <EditorInput 
                  toolbarItems = {[
                    ['bold', 'italic'],
                    ['hr', 'quote'],
                    ['ul', 'ol', 'indent', 'outdent'],
                    ['table', 'image', 'link'],
                    ['code', 'codeblock']
                  ]}
                  ref={answerWrite}
                />
                <Button 
                  onClick={isLogin ? postAnswerButtonClick : goLogin}
                  buttonType='type2'
                  buttonName='Post Your Answer'
                  width='12.18rem'
                  height='3.79rem'
                />
              </EditorWrapper>
            </MainLeft>
            <MainRight>
              {BoardDetailSideInfoWidgetData.map((el, idx) => {
                return (
                  <MainRightSideInfoWidget 
                    title={el.title}
                    contents={el.contents}
                    key={idx}
                  />
                )
              })}
              {/* <MainRightRelatedQuestions /> */}
            </MainRight>
          </MainLeftRightWrapper>
        </Main>
    </>
  )
};

export default Detail;

const Main = styled.div`
  display: flex;
  flex-direction: column;
`;

const MainTop = styled.div`
  display: flex;
  flex-direction: column;

  & .titleAndButton {
    display: flex;
    margin-bottom: 1.2rem;
    justify-content: space-between;
    align-items: center;

    & > h1 {
      color: #3b4045;
      font-size: 2.7rem;
      overflow-wrap: break-word;
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
`;

const AnswerWapper = styled.div`
  padding-top: 1rem;
`;

const AnswerFilterWrapper = styled.div`
  display: flex;
  justify-content: space-between;
  margin-bottom: 0.8rem;
  margin-top: 1rem;

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
  padding-left: 2.4rem;
`;