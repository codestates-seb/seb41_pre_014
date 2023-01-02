import styled from "styled-components";
import { Input } from '../components/atoms/Input';
import { Button } from '../components/atoms/Button';
// import { MainRightSideInfoWidget } from "../components/blocks/MainRight";
import { InputLabel, EditorInput } from "../components/blocks/EditorInputWrapper";
// import { EditSideInfoWidgetData } from "../data/staticData/SideBarData";
import { useEffect, useState, useRef } from "react";
import { useNavigate, useLocation } from "react-router-dom";
import { useSelector } from "react-redux";
import { Tag } from "../components/blocks/Tag";
import axios from "axios";

const QuestionEdit = (props) => {
  const isLogin = useSelector(state => state.loginStatus.status);
  const navigate = useNavigate();
  const goLogin = () => {
    alert('로그인 후에 이용해주세요. 로그인 페이지로 이동합니다.');
    navigate('/users/login');
  };

  const location = useLocation();
  const boardId = location.pathname.split('/')[2];
  const [ title, setTitle ] = useState(location.state.title);
  const [ tags, setTags ] = useState(location.state.tags);

  const editorRef= useRef();
  
  useEffect(() => {
    isLogin || goLogin();
    editorRef.current.getInstance().setHTML(location.state.body);
  }, [])

  const saveEditButtonClick = async () => {
    await axios({
      method: 'PATCH',
      url: `${process.env.REACT_APP_SERVER_URL}/boards/${boardId}`,
      data: {
        title,
        body: editorRef.current.getInstance().getHTML(),
        tags,
      }
    })
    .then(res => {
      navigate(`/questions/${boardId}`);
    })
    .catch(err => {
      console.error(err);
    })
  }
  
  const cancelButtonClick = () => {
    navigate(`/questions/${boardId}`);
  };

  return (
    <Main>
      <MainLeft>
        <div>
          <InputLabel 
            title='Title'
          />
          <Input
            value={title}
            onChange={e => setTitle(e.target.value)}
            padding='0.78rem 0.91rem'
            width='100%'
            />
        </div>
        <div>
          <InputLabel 
            title='Body'
          />
          <EditorInput 
            toolbarItems = {[
              ['bold', 'italic'],
              ['hr', 'quote'],
              ['ul', 'ol', 'indent', 'outdent'],
              ['table', 'image', 'link'],
              ['code', 'codeblock']
            ]}
            ref={editorRef}
          />
          <div>{props.questionContent}</div>
        </div>
        <div>
          <InputLabel 
            title='Tags'
          />
          <Tag 
            tags={tags}
            setTags={setTags}
          />
        </div>
        <div>
          <InputLabel 
            title='Edit Summary'
          />
          {/* data-min-length="10" data-max-length="300"  */}
          <Input
            placeholder='briefly explain your changes (corrected spelling, fixed grammar, improved formatting)'
            padding='0.78rem 0.91rem'
            width='100%'
            />
        </div>
        <div className="buttonWrapper">
          <Button 
            onClick={saveEditButtonClick}
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
        {/* {EditSideInfoWidgetData.map((el) => {
          return (
            <MainRightSideInfoWidget 
              title={el.title}
              contents={el.contents} 
              width='33rem'
            />
          )
        })}             */}
      </MainRight>
    </Main>
  )
};

export default QuestionEdit;

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