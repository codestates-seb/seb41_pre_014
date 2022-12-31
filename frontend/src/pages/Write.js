import styled from 'styled-components';
import { Input } from '../components/atoms/Input';
import { Button } from '../components/atoms/Button';
import { InputLabel, EditorInputWrapper } from '../components/blocks/EditorInputWrapper';
import { MainRightSideInfoWidget } from '../components/blocks/MainRight';
import { useEffect } from 'react';
import { useForm } from 'react-hook-form';

const Write = () => {
  useEffect(() => {
    window.scrollTo(0, 0);
  }, []);

  const { register, handleSubmit } = useForm();

  return (
    <>
      <Main>
        <MainTop>
          <h1>Ask a public question</h1>
        </MainTop>
        <MainLeftRightWrapper>
          <MainLeft>
            <GuideLine>
              <h2>Writing a good question</h2>
              <p>
                You’re ready to 
                <a 
                  href="https://stackoverflow.com/help/how-to-ask"
                  target='_blank'
                  rel='noreferrer'
                > ask </a> 
                a <a 
                  href="https://stackoverflow.com/help/on-topic"
                  target='_blank'
                  rel='noreferrer'
                > programming-related question </a>
                and this form will help guide you through the process.
              </p>
              <p>
                Looking to ask a non-programming question? See 
                <a 
                  href="https://stackexchange.com/sites#technology"
                  target='_blank'
                  rel='noreferrer'
                > the topics here </a> to find a relevant site.
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
                  padding='0.78rem 0.91rem'
                  width='100%'
                  {...register('title')}
                />
                <Button 
                buttonType='type2'
                buttonName='Next'
                width='4.96rem'
                height='3.79rem'
                />
              </InputWrapper>
            </div>
            <InputWrapper>
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
            </InputWrapper>
            <InputWrapper>
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
            </InputWrapper>
            <div>
              <InputWrapper>
                <InputLabel 
                  title='Tags'
                  label='Add up to 5 tags to describe what your question is about. Start typing to see suggestions.'
                />
                <Input
                  placeholder='e.g. (c# laravel typescript)'
                  padding='0.78rem 0.91rem'
                  width='100%'
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
            {/* <MainRightSideInfoWidget /> */}
          </MainRight>
        </MainLeftRightWrapper>
      </Main>
    </>
  )
};

export default Write;

const Main = styled.div`
  display: flex;
  flex-direction: column;
`;

const MainTop = styled.div`
  display: flex;
  justify-content: space-between;
  height: 13rem;
  display: flex;
  align-items: center;
  background-image: url('/image/WriteBg.svg');
  background-repeat: no-repeat;
  background-position: right;
  margin-top: -2rem;

  > h1 {
    width: 100%;
    font-size: 2.7rem;
    font-weight: bold;
    color: #232629;
    margin: 2.4rem 0 2.7rem;
  }
`;

const MainLeftRightWrapper = styled.div`
  display: flex;
`;

const MainLeft = styled.div`
  display: flex;
  flex-direction: column;
  gap: 1.6rem;
  margin-top: 1.6rem;
`;

const GuideLine = styled.div`
  display: block;
  background-color: #ebf4fb;
  border: 0.1rem solid #6bbbf7;
  border-radius: 0.3rem;
  color: #3b4045;
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
    font-size: 1.3rem;
    font-weight: 600;
    margin-top: 1.5rem;
    margin-bottom: 0.8rem;
  }

  > ul {
    list-style-type: disc;
    margin-left: 3rem;

    > li {
      font-size: 1.3rem;
    }
  }
`;

const InputWrapper = styled.div`
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  text-align: left;
  gap: 0.6rem;
  background-color: #ffffff;
  border: 0.1rem solid #e3e6e8;
  border-radius: 0.3rem;
  color: #3b4045;
  padding: 2.4rem;
`;

const ButtonWrapper = styled.div`
  display: flex;
  gap: 1.6rem;
`;

const DiscardButton = styled.button`
  background-color: transparent;
  border: 0.1rem solid transparent;
  border-radius: 0.3rem;
  color: #c22e32;
  font-size: 1.3rem;
  padding: 1.04rem;
  cursor: pointer;
  width: 9.82rem;
  height: 3.79rem;

  &:hover {
    background-color: #fdf2f2;
  }
`;

const MainRight = styled.div`
  padding-left: 2.4rem;
`;