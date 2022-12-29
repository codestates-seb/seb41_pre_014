import styled from 'styled-components';
import { Input } from '../atoms/Input';
import { TagBlock } from '../atoms/TagBlock';
import { Button } from '../atoms/Button';

const TagContainer = styled.div`
  display: flex;
  flex-direction: column;
  position: relative;
  margin: 1.6rem 0;
  background-color: #ffffff;
  border-radius: 0.3rem;
  box-shadow: 0 0.1rem 0.2rem hsla(0,0%,0%,0.05), 0 0.1rem 0.4rem hsla(0, 0%, 0%, 0.05), 0 0.2rem 0.8rem hsla(0, 0%, 0%, 0.05);
  width: 29.8rem;
  font-size: 1.3rem;

  .tagAddedHeader {
    display: flex;
    justify-content: space-between;
    background-color: #f8f9f9;
    border-top: 0.1rem solid #e3e6e8;

  }
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
`;

const TagContent = styled.div`
  display: flex;
  border-top: 0.1rem solid #e3e6e8;
  font-size: inherit;
  padding: 1.6rem;
  justify-content: center;
`;

const EditButton = styled.button`
  font-size: 1.5rem;
  color: #6a737c;
  padding: 0 1.2rem;
  cursor: pointer;
  border: none;
  background-color: transparent;
`;

const RelatedWrapper = styled.div`
    margin: 1.6rem 0;

  > h4 {
    color: hsl(210deg 8% 25%);
    font-size: 1.9rem;
    font-weight: 400;
    margin-bottom: 1.9rem;
  }
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
    height: 2.32rem;
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
  width: ${props => props.width || '29.8rem'};
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
  > ul {
    list-style-type: disc;
    list-style-position : inside ;

    > li {
      margin: 1.2rem;
      padding: 0 1.6rem;

      > a {
        font-size: 1.3rem;
        color: hsl(210deg 8% 25%);
        text-decoration: none;
        cursor: pointer;
      }
    }
  }
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
        <Input 
          width='22.25rem'
        />
        <Button 
          buttonType='type2' 
          buttonName='Add'
          width='4.65rem'
        />
      </TagContent>
    </TagContainer>
  )
};

export const MainRightTagAdded = () => {
  return (
    <TagContainer>
      <div className='tagAddedHeader'>
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

export const RelatedContent = (props) => {
  return (
    <RelatedCont>
      <a href={props.link}>
        <div>{props.score}</div>
      </a>
      <a className='questionTitle' href={props.link}>{props.title}</a>
    </RelatedCont>
  )
};

export const MainRightRelatedQuestions = () => {
  return (
    <RelatedWrapper>
      <h4>Related</h4>
      <RelatedContentWrapper>
        <li>
          <RelatedContent />
        </li>
      </RelatedContentWrapper>
    </RelatedWrapper>
  )
};

export const MainRightSideInfoWidget = (props) => {
  return (
    <SideInfoWidgetContainer width={props.width}>
      <SideInfoWidgetHeader>{props.title}</SideInfoWidgetHeader>
      <SideInfoWidgetContent>
        <ul>
          {props.contents.map((el, idx) => {
            return (
              <li key={idx}><a href={el.link}>{el.item}</a></li>
            )
          })}
        </ul>
      </SideInfoWidgetContent>
    </SideInfoWidgetContainer>
  )
};