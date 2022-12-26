import styled from 'styled-components';
import { Input } from '../atoms/Input';
import { TagBlock } from '../atoms/TagBlock';
import { Button } from '../atoms/Button';

const TagContainer = styled.div`
  display: flex;
  flex-direction: column;
  position: relative;
  margin-bottom: 1.6rem;
  background-color: #ffffff;
  border-radius: 0.3rem;
  box-shadow: 0 0.1rem 0.2rem hsla(0,0%,0%,0.05), 0 0.1rem 0.4rem hsla(0, 0%, 0%, 0.05), 0 0.2rem 0.8rem hsla(0, 0%, 0%, 0.05);
  width: 29.8rem;
  font-size: 1.3rem;
`;

const TagHeader = styled.div`
  display: flex;
  background-color: #f8f9f9;
  border-top: 0.1rem solid #e3e6e8;
  border-top-left-radius: 0.3rem;
  border-top-right-radius: 0.3rem;
  font-size: 1.5rem;
  color: #232629;
  padding: 1.2rem 1.5rem;
  /* height: 4.45rem; */
`;

const TagContent = styled.div`
  display: flex;
  flex-direction: column;
  border-top: 0.1rem solid #e3e6e8;
  font-size: inherit;
  padding: 1.6rem;
  //height props
`;

const EditButton = styled.button`
  font-size: 1.5rem;
  color: #6a737c;
  margin-left: 1.2rem;
  cursor: pointer;
`;

const RelatedCont = styled.div`
  display: flex;
  gap: 1rem;
  font-size: 1.3rem;
  cursor: pointer;
  text-decoration: none;
  word-wrap: break-word;
  text-align: left;

  > a > div {
    padding: 0.3rem 0;
    min-width: 1.6rem;
    color: #ffffff;
    background-color: #5eba7d;
    width: 3.8rem;
    text-align: center;
    border-radius: 0.2rem;
    font-size: 90%;
    transform: translateY(-0.1rem);
    border: 0.1rem solid transparent;
  }

  &.questionTitle {
    display: inline-block;
    padding-top: 0.2rem;
    color: #0074cc;
  }
`;

const RelatedContentWrapper = styled.ul`
  list-style: none;
`;

const SideInfoWidgetContainer = styled.div`
  display: flex;
  flex-direction: column;
  position: relative;
  background-color: #fdf7e2;
  border: 0.1rem solid #f1e5bc;
  font-size: 1.3rem;
  box-shadow: 0 0.1rem 0.2rem hsla(0,0%,0%,0.05), 
  0 0.1rem 0.4rem hsla(0, 0%, 0%, 0.05), 
  0 0.2rem 0.8rem hsla(0, 0%, 0%, 0.05);
`;

const SideInfoWidgetHeader = styled.div`
  color: #525960;
  font-size: 1.2rem;
  font-weight: bold;
  background-color: #fbf3d5;
  border-bottom: 0.1rem solid;
  border-color: #f1e5bc;
  padding: 1.2rem 1.5rem;
`;

const SideInfoWidgetContent = styled.div`

`;

export const MainRightTagBasic = () => {
  return (
    <TagContainer>
      <TagHeader>Ignored Tags</TagHeader>
      <TagContent>
        <Button buttonType='type3' buttonName='Add an ignored tag' />
      </TagContent>
    </TagContainer>
  )
};

export const MainRightTagInput = () => {
  return (
    <TagContainer>
      <TagHeader>Ignored Tags</TagHeader>
      <TagContent>
        <Input />
        <Button buttonType='type2' buttonName='Add' />
      </TagContent>
    </TagContainer>
  )
};

export const MainRightTagAdded = () => {
  return (
    <TagContainer>
      <div>
        <TagHeader>Ignored Tags</TagHeader>
        <EditButton>edit</EditButton>
      </div>
      <TagContent>
        <ul>
          {/* <TagBlock /> */}
        </ul>
      </TagContent>
    </TagContainer>
  )
};

export const RelatedContent = (questionScore, questionTitle, questionLink) => {
  return (
    <RelatedCont>
      <a href={questionLink}>
        <div>{questionScore}</div>
      </a>
      <a className='questionTitle' href={questionLink}>{questionTitle}</a>
    </RelatedCont>
  )
};

export const MainRightRelatedQuestions = () => {
  return (
    <>
      <h4>Related</h4>
      <RelatedContentWrapper>
        <li>
          <RelatedContent />
        </li>
      </RelatedContentWrapper>
    </>
  )
};

export const MainRightSideInfoWidget = () => {
  return (
    <SideInfoWidgetContainer>
      <SideInfoWidgetHeader>The Overflow Blog</SideInfoWidgetHeader>
      <SideInfoWidgetContent>
        <ul>
          <li></li>
        </ul>
      </SideInfoWidgetContent>
    </SideInfoWidgetContainer>
  )
};