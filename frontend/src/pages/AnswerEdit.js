import styled from "styled-components";
import { Input } from '../components/atoms/Input';
import { Button } from '../components/atoms/Button';
// import { MainRightSideInfoWidget } from "../components/blocks/MainRight";
import { InputLabel, EditorInput } from "../components/blocks/EditorInputWrapper";
import { useEffect, useState, useRef } from "react";
import { useNavigate, useLocation } from "react-router-dom";
import { useSelector } from "react-redux";
import axios from 'axios';

const AnswerEdit = (props) => {
  const isLogin = useSelector(state => state.loginStatus.status);
  const navigate = useNavigate();
  const goLogin = () => {
    alert('로그인 후에 이용해주세요. 로그인 페이지로 이동합니다.');
    navigate('/users/login');
  };

  const location = useLocation();
  const answerBoardId = location.pathname.split('/')[2];
  const questionBoardId = location.state.questionBoardId;

  const [ questionData, setQuestionData ] = useState();
  const editorRef = useRef();

  useEffect(() => {
    isLogin || goLogin();
    async function getInfo () {
      await axios({
        method: 'GET',
        url: `${process.env.REACT_APP_SERVER_URL}/boards/${answerBoardId}`,
      })
      .then(res => {
        editorRef.current.getInstance().setHTML(res.data);
      })
      .catch(err => {
        console.error(err);
      });

      await axios({
        method: 'GET',
        url: `${process.env.REACT_APP_SERVER_URL}/boards/${questionBoardId}`,
      })
      .then(res => {
        setQuestionData(res.data);
      })
      .catch(err => {
        console.error(err);
      });
    };
    getInfo();
  }, [])

  const saveEidtButtonClick = async () => {
    await axios({
      method: 'PATCH',
      url: `${process.env.REACT_APP_SERVER_URL}/boards/${answerBoardId}`,
      data: {
        title: '',
        body: editorRef.current.getInstance().getHTML(),
        tags: [],
      }
    })
    .then(res => {
      navigate(`/questions/${questionBoardId}`);
    })
    .catch(err => {
      console.error(err);
    })
  };

  const cancelButtonClick = () => {
    navigate(`/questions/${questionBoardId}`);
  };

  return (
    <Main>
      <MainLeft>
        <div>
          <div>{questionData.title}</div>
          <div>{questionData.body}</div>
        </div>
        <div>
          <InputLabel
            title='Answer'
          />
          <EditorInput 
            ref={editorRef}
          />
        </div>
        <div>
          <InputLabel 
            title='Edit Summary'
          />
          <Input 
            placeholder='briefly explain your changes (corrected spelling, fixed grammar, improved formatting)'
            padding='0.78rem 0.91rem'
            width='100%'
          />
        </div>
        <div className="buttonWrapper">
          <Button 
            onClick={saveEidtButtonClick}
            buttonType='type2'
            buttonName='Save edits'
            width='8.04rem'
            height='3.79rem' 
          />
          <Button
            onClick={cancelButtonClick}
            buttonType='type4'
            buttonName='Cancel'
            width='8.04rem'
            height='3.79rem' 
          />
        </div>
      </MainLeft>
      <MainRight>
        {/* <MainRightSideInfoWidget />
        <MainRightSideInfoWidget /> */}
      </MainRight>
    </Main>
  )
};

export default AnswerEdit;

const Main = styled.div`
  display: flex;
`;

const MainLeft = styled.div`
  display: flex;
  flex-direction: column;
  gap: 1.5rem;

  .buttonWrapper {
    display: flex;
    flex-direction: row;
    gap: 0.8rem;
    margin-top: 1.5rem;
  }

  > div {
    display: flex;
    flex-direction: column;
    gap: 0.4rem;
  }
`;

const MainRight = styled.div`
  padding-left: 2.4rem;
`;