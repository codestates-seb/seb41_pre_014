import styled from 'styled-components';
import { useState, useEffect } from 'react';
import axios from 'axios';
import { FilterButtonWrapper } from '../components/blocks/FilterButtonWrapper';
import { QuestionInfoContainer } from '../components/blocks/QuestionInfoContainer';
import { MainRightSideInfoWidget, MainRightTagAdded, MainRightTagBasic, MainRightTagInput } from '../components/blocks/MainRight';
import { PerPage } from '../components/blocks/Pagination'
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
  justify-content: space-between;
  padding-left: 2.4rem;

  .questionNum {
    display: flex;
    gap: 0.4rem;
  }

  > div {
    display: flex;
    align-items: center;

    > span {
      font-size: 1.7rem;
      color: #232629;
    }
  }  
`;

const Pagination = styled.div`
  display: flex;
  justify-content: space-between;
  border-top: 0.1rem solid hsl(210deg 8% 90%);
  padding-top: 4.5rem;
`;

const MainRight = styled.div`
  display: flex;
  flex-direction: column;
  gap: 1.6rem;
  padding-left: 2.4rem;
`;

const PageWrapper = styled.div`
  display: flex;
  flex-wrap: wrap;
  gap: 0.4rem;
`;

const StyledButton = styled.div`
  border: 0.1rem solid hsl(210deg 8% 85%);
  border-radius: 0.3rem;
  font-size: 1.3rem;
  padding: 0.36rem 0.8rem;
  cursor: pointer;
  color: hsl(210deg 8% 25%);
  height: 2.7rem;
  
  &:hover {
    background-color: hsl(210deg 8% 85%);
    color: hsl(210deg 8% 5%);
  };

  &.active {
    background-color: hsl(27deg 90% 55%);
    border: 0.1rem solid transparent;
    color: #fff;
  };
`;

const QuestionBoard = () => {
  const [questions, setQuestions] = useState([]);
  const [filter, setFilter] = useState('questions');
  const [perPage, setPerPage] = useState(15);
  const [currentPage, setCurrentPage] = useState(1);

  const getQuestions = async () => {
    try {
      const response = await axios({
        url: `/boards/${filter}?page=${currentPage || 1}&size=${perPage || 15}`,
        baseURL: `${process.env.REACT_APP_SERVER_URL}`,
      });
      setQuestions(response.data);
      console.log(questions);
    } catch (error) {
      console.error(error);
    }
  }

  useEffect(() => {
    getQuestions();
  }, []);

  const filterData = [
      {
        buttonName : "Newest",
        onClick : () => {
          setFilter("questions");
          // console.log(filter, currentPage, perPage);
          getQuestions();
        },
      },
      {
        buttonName : "Unanswered",
        onClick : () => {
	        setFilter("unanswered");
          // console.log(filter, currentPage, perPage);
          getQuestions();
        },
      },
      {
        buttonName : "Frequent",
        onClick : () => {
          setFilter("frequent");
          // console.log(filter, currentPage, perPage);
          getQuestions();
        },
      },
      {
        buttonName : "Score",
        onClick : () => {
          setFilter("score");
          // console.log(filter, currentPage, perPage);
          getQuestions();
        },
      }
    ];

  const PerPageData = [
    {
      buttonName : "15",
      onClick : () => {
        setPerPage(15);
        // console.log(filter, currentPage, perPage);
        getQuestions();
      },
    },
    {
      buttonName : "30",
      onClick : () => {
        setPerPage(30);
        // console.log(filter, currentPage, perPage);
        getQuestions();
      },
    },
    {
      buttonName : "50",
      onClick : () => {
        setPerPage(50);
        // console.log(filter, currentPage, perPage);
        getQuestions()
      },
    },
  ];

  const pageNums = [];
  const [btnActive, setBtnActive] = useState(1);

  for (let i = 1; i <= Math.ceil(questions.length / perPage); i++) {
    pageNums.push(i);
  }

  return (
    <>
      <Main>
        <MainLeft>
          <MainTop>
            <h1>All Questions</h1>
            <DetailWriteButton />
          </MainTop>
          <FilterContainer>
            <div className='questionNum'>
              <span>{questions.length}</span>
              <span>questions</span>
            </div>
            <div>
              <FilterButtonWrapper filterData={filterData} />
            </div>
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
              tags={question.tags}
              key={question.boardId}
              detailId={question.boardId}
              createdAt={question.createdAt}
            />
          })}
          <Pagination>
            <PageWrapper>
              {pageNums.includes(currentPage - 1) &&  <StyledButton 
                onClick={() => {
                  setCurrentPage(currentPage - 1);
                  getQuestions({page: currentPage - 1});
                  setBtnActive(currentPage - 1);
                }
              }
              >Prev</StyledButton>
              }
              {pageNums.map((el, idx) => {
                return <StyledButton
                key={idx}
                className={btnActive === el && 'active'}
                onClick={() => {
                  setBtnActive(el);
                  setCurrentPage(el);
                  getQuestions({
                    page: {el}
                  });
                  console.log(filter, perPage, el);
                }}>{el}</StyledButton>
              })}
              {pageNums.includes(currentPage + 1) &&  <StyledButton 
                onClick={() => {
                  setCurrentPage(currentPage + 1);
                  getQuestions({page: currentPage + 1});
                  setBtnActive(currentPage + 1);
                }
              }
              >Next</StyledButton>
              }
            </PageWrapper> 
            <PerPage 
              PerPageData={PerPageData}
            />
          </Pagination>
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
          {/* <MainRightTagAdded /> */}
          {/* <MainRightTagInput /> */}
        </MainRight>
      </Main>
    </>
  )
};

export default QuestionBoard;