import styled from 'styled-components';
import { useState } from 'react';
import axios from 'axios';
import { Button } from '../components/atoms/Button';
import { FilterButtonWrapper } from '../components/blocks/FilterButtonWrapper';
import { QuestionInfoContainer } from '../components/blocks/QuestionInfoContainer';
import { MainRightSideInfoWidget, MainRightTagBasic } from '../components/blocks/MainRight';
import { BoardDetailSideInfoWidgetData } from '../data/staticData/SideBarData';
import { DetailWriteButton } from '../components/blocks/DetailWriteButton';

const Main = styled.div`
  display: flex;
`;

const MainLeft = styled.div`
  display: flex;
  flex-direction: column;
  width: 100%;
`;

const MainTop = styled.div`
  display: flex;
  justify-content: space-between;
  padding-left: 2.4rem;

  > h1 {
    margin-bottom: 2.7rem;
    font-size: 2.7rem;
  }
`;

const FilterContainer = styled.div`
  display: flex;
  margin-bottom: 1.2rem;
  justify-content: flex-end;
`;

const MainRight = styled.div`
  display: flex;
  flex-direction: column;
  padding-left: 2.4rem;
`;

const HomeLoginBoard = () => {
  const [questions, setQuestions] = useState();
  const [filter, setFilter] = useState('questions');

  const getQuestions = async () => {
    try {
      const response = await axios({
        url: `/boards/${filter}?page=1&size=50`,
        baseURL: `${process.env.REACT_APP_SERVER_URL}`,
      });
      setQuestions(response.data);
      console.log(questions);
    } catch (error) {
      console.error(error);
    }
  }

  const filterData = [
      {
        buttonName : "Newest",
        onClick : () => {
          setFilter("questions");
          getQuestions();
        },
      },
      {
        buttonName : "Unanswered",
        onClick : () => {
	        setFilter("unanswered");
          getQuestions();
        },
      },
      {
        buttonName : "Frequent",
        onClick : () => {
          setFilter("frequent");
          getQuestions();
        },
      },
      {
        buttonName : "Score",
        onClick : () => {
          setFilter("score");
          getQuestions();
        },
      }
    ];

  return (
    <>
        <Main>
          <MainLeft>
            <MainTop>
              <h1>Top Questions</h1>
              <DetailWriteButton />
            </MainTop>
            <FilterContainer>
              <FilterButtonWrapper filterData={filterData} />
            </FilterContainer>
            {questions && questions.map((question) => {
              return <QuestionInfoContainer
                title={question.title}
                content={question.body}
                votes={question.score}
                answers={question.answerCount}
                views={question.viewCount}
                profileImageUrl={question.writerProfileUrl}
                displayName={question.writerDisplayName}
                createdAt={question.createdAt}
                detailId={question.boardId}
              />
            })}
          </MainLeft>
          <MainRight>
            {BoardDetailSideInfoWidgetData.map((el, idx) => {
              return (
                <MainRightSideInfoWidget 
                  key={idx}
                  title={el.title}
                  contents={el.contents} 
                />
              )
            })}
            <MainRightTagBasic />
          </MainRight>
        </Main>
    </>
  )
};

export default HomeLoginBoard;