import styled from 'styled-components';
import { Input } from '../components/atoms/Input';

import { Button } from '../components/atoms/Button';
import { InputLabel, EditorInputWrapper } from '../components/blocks/EditorInputWrapper';
import { MainRightSideInfoWidget } from '../components/blocks/MainRight';

const Main = styled.div`
  display: flex;
  flex-direction: column;
`;

const MainTop = styled.div`
  display: flex;
  justify-content: space-between;

  > h1 {
    font-size: 2.2rem;
    font-weight: 600;
    margin: 2.4rem 0 2.2rem;
    color: #232629;
  }
`;

const MainLeft = styled.div`
  display: flex;
  flex-direction: column;
`;

const GuideLine = styled.div`
  display: block;
  background-color: #ebf4fb;
  border: 0.1rem solid #6bbbf7;
  border-radius: 0.3rem;
  color: #3b4045;
  font-size: 1.3rem;
  padding: 2.4rem;

  > h2 {
    font-size: 2.1rem;
    margin-bottom: 0.8rem;
    font-weight: 400;
  }

  > p {
    font-size: 1.5rem;

    > a {
      color: hsl(206deg 100% 40%);
      text-decoration: none;
      cursor: pointer;
      font: inherit;
    }
  }

  > h5 {
    font-weight: 600;
    margin-bottom: 0.8rem;
  }

  > ul {
    list-style-type: disc;
    margin-left: 3rem;
  }
`;

const InputWrapper = styled.div`
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  text-align: left;
  background-color: #ffffff;
  border: 0.1rem solid #e3e6e8;
  border-radius: 0.3rem;
  color: #3b4045;
  font-size: 1.2rem;
  padding: 2.4rem;
`;

const ButtonWrapper = styled.div`
  display: flex;
`;

const DiscardButton = styled.button`
  background-color: transparent;
  border: 0.1rem solid transparent;
  border-radius: 0.3rem;
  color: #c22e32;
  font-size: 1.3rem;
  padding: 1.04rem;
  cursor: pointer;
  display: inline-block;
  outline: none;
  width: 9.62rem;
  height: 3.79rem;

  &:hover {
    background-color: #fdf2f2;
  }
`;

const MainRight = styled.div`

`;

const Write = () => {
  return (
    <>
      <Main>
        <MainTop>
          <h1>Ask a public question</h1>
          <div><img /></div>
        </MainTop>
        <MainLeft>
          <GuideLine>
            <h2>Writing a good question</h2>
            <p>
                You’re ready to 
                <a href="https://stackoverflow.com/help/how-to-ask"> ask </a> 
                a <a href="https://stackoverflow.com/help/on-topic"> programming-related question </a>
                and this form will help guide you through the process.
            </p>
            <p>
                You’re ready to 
                <a href="https://stackoverflow.com/help/how-to-ask">ask</a> 
                a <a href="https://stackoverflow.com/help/on-topic">programming-related question</a>
                and this form will help guide you through the process.
            </p>
            <h5>Steps</h5>
            <ul>
                <li>Summarize your problem in a one-line title.</li>
                <li>Describe your problem in more detail.</li>
                <li>Describe what you tried and what you expected to happen.</li>
                <li>Add “tags” which help surface your question to members of the community.</li>
                <li>Review your question and post it to the site.</li>
            </ul>
          </GuideLine>
          <div>
            <InputWrapper>
              <InputLabel 
                title='Title'
                label='Be specific and imagine you’re asking a question to another person.'
              />
              <Input
                placeholder='e.g. Is there an R function for finding the index of an element in a vector?'
              />
              <Button 
              buttonType='type2'
              buttonName='Next'
              width='4.96rem'
              height='3.79rem'
              />
            </InputWrapper>
          </div>
          <div>
            <EditorInputWrapper
              title='What are the details of your problem?'
              label='Introduce the problem and expand on what you put in the title. Minimum 20 characters.'
            />
            <Button 
              buttonType='type2'
              buttonName='Next'
              width='4.96rem'
              height='3.79rem'
              />
          </div>
          <div>
            <EditorInputWrapper
              title='What did you try and what were you expecting?'
              label='Describe what you tried, what you expected to happen, and what actually resulted. Minimum 20 characters.'
            />
            <Button 
              buttonType='type2'
              buttonName='Next'
              width='4.96rem'
              height='3.79rem'
              />
          </div>
          <div>
            <InputWrapper>
              <InputLabel 
                title='Tags'
                label='Add up to 5 tags to describe what your question is about. Start typing to see suggestions.'
              />
              <Input 
                placeholder='e.g. (c# laravel typescript)'
              />
              <Button 
              buttonType='type2'
              buttonName='Next'
              width='4.96rem'
              height='3.79rem'
              />
            </InputWrapper>
          </div>
          <ButtonWrapper>
            <Button 
              buttonType='type2'
              buttonName='Post your question'
              width='12.98rem'
              height='3.79rem'
              />
            <DiscardButton>Discard draft</DiscardButton>
          </ButtonWrapper>
        </MainLeft>
        <MainRight>
          {/* input focus */}
          <MainRightSideInfoWidget />
        </MainRight>
      </Main>
    </>
  )
};

export default Write;