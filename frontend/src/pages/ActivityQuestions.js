import styled from "styled-components";
import { FilterButtonWrapper } from '../components/blocks/FilterButtonWrapper';
import { QuestionMetaInfoWrapperH, QuestionInfoWrapperUserPage } from "../components/blocks/QuestionInfoContainer";

const ActivityQuestions = () => {

  const filterData = [
    {
      buttonName: "Score",
      onClick: () => {console.log('Score를 기준으로 정렬')},
    },
    {
      buttonName: "Newest",
      onClick: () => {console.log('작성일이 빠른 순으로 정렬')},
    },
    {
      buttonName: "Views",
      onClick: () => {console.log('조회수가 많은 순으로 정렬')},
    },
  ];

  return (
    <StyledActivityQuestions>
      <StyledAQTitle>
        <StyledAQTitleLeft>
          <h2>34 Answers</h2>
        </StyledAQTitleLeft>
        <FilterButtonWrapper 
          filterData={filterData}
          fontSize='1.1rem'
          padding='0.6rem'
        />
      </StyledAQTitle>
      <StyledAQContents>
        <StyledAQContent>
          <StyledAQContMeta>
            <QuestionMetaInfoWrapperH activityType='Question' />
          </StyledAQContMeta>
          <QuestionInfoWrapperUserPage title='Javascript에 대해서 알려주세요' />
        </StyledAQContent>
      </StyledAQContents>
    </StyledActivityQuestions>
  )
};

export default ActivityQuestions;

const StyledActivityQuestions = styled.section`
  max-width: 100%;
  flex-grow: 1;
`;

const StyledAQTitle = styled.div`
  width: 100%;
  margin-bottom: 0.8rem;
  display: flex;
  flex-direction: row;
  align-items: flex-end;
  justify-content: space-between;
  flex-wrap: wrap;
`;

const StyledAQTitleLeft = styled.div`
  flex-grow: 1;
  display: flex;
  flex-direction: column;

  & > h2 {
    font-size: 2.1rem;
    color: #232629;
  }
`;

const StyledAQContents = styled.div`
  border: 0.1rem solid hsl(210,8%,85%);
  border-radius: 0.5rem;
  display:flex;
  flex-direction: column;

  & > div:last-child {
    border-bottom: 0;
  }
`;

const StyledAQContent = styled.div`
  display: flex;
  flex-direction: column;
  padding: 1.6rem;
`;

const StyledAQContMeta = styled.div`
  margin: 0 0.16rem 0.8rem 0;
`;


const StyledPagination = styled.div`

`;