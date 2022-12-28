import styled from "styled-components";
import { Header } from '../components/blocks/Header';
import { Footer } from '../components/blocks/Footer';
import { LeftNavBar } from '../components/blocks/NavBar';
import { Input } from '../components/atoms/Input';
import { Button } from '../components/atoms/Button';
import { MainRightSideInfoWidget } from "../components/blocks/MainRight";
import { EditorInput } from "../components/blocks/EditorInputWrapper";

const Body = styled.div`
  display: flex;
`;

const Main = styled.div`
  display: flex;
  padding: 2.4rem;
`;

const MainLeft = styled.div`
  display: flex;
  flex-direction: column;
  overflow: scroll;
`;

const MainRight = styled.div`
  padding-left: 2.4rem;
`;

const AnswerEdit = (props) => {
  return (
    <>
      <Header />
      <Body>
        <LeftNavBar />
        <Main>
          <MainLeft>
            <div>
              <div>{props.title}</div>
              <div>{props.questionContent}</div>
            </div>
            <div>
              <div>Answer</div>
              <EditorInput />
              <div>answerPreview</div>
            </div>
            <div>
              <div>Edit Summary</div>
              <Input />
            </div>
            <div>
              <Button buttonType='type1' />
              <Button buttonType='type4' />
            </div>
          </MainLeft>
          <MainRight>
            <MainRightSideInfoWidget />
            <MainRightSideInfoWidget />
          </MainRight>
        </Main>
      </Body>
      <Footer />
    </>
  )
};

export default AnswerEdit;