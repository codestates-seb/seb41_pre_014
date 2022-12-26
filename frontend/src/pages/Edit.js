import styled from "styled-components";
import { Header } from '../components/blocks/Header';
import { Footer } from '../components/blocks/Footer';
import { LeftNavBar } from '../components/blocks/NavBar';
import { Input } from '../components/atoms/Input';
import { ButtonType4, ButtonType11 } from '../components/atoms/Button';
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

export const QuestionEdit = (questionContent) => {
  return (
    <>
      <Header />
      <Body>
        <LeftNavBar />
        <Main>
          <MainLeft>
            <div>
              <div>Title</div>
              <Input />
            </div>
            <div>
              <div>Body</div>
              <EditorInput />
              <div>{questionContent}</div>
            </div>
            <div>
              <div>Tags</div>
              <Input />
            </div>
            <div>
              <div>Edit Summary</div>
              <Input />
            </div>
            <div>
              <ButtonType4 />
              <ButtonType11 />
            </div>
          </MainLeft>
          <MainRight>
            <MainRightSideInfoWidget />
          </MainRight>
        </Main>
      </Body>
      <Footer />
    </>
  )
};

export const AnswerEdit = (title, questionContent) => {
  return (
    <>
      <Header />
      <Body>
        <LeftNavBar />
        <Main>
          <MainLeft>
            <div>
              <div>{title}</div>
              <div>{questionContent}</div>
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
              <ButtonType4 />
              <ButtonType11 />
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
