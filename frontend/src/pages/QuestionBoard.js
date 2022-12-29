import styled from 'styled-components';
import { Button } from '../components/atoms/Button';
import { FilterButtonWrapper } from '../components/blocks/FilterButtonWrapper';
import { QuestionInfoContainer } from '../components/blocks/QuestionInfoContainer';
import { MainRightSideInfoWidget, MainRightTagAdded, MainRightTagBasic, MainRightTagInput } from '../components/blocks/MainRight';
// import { Page, PerPage } from '../components/blocks/Pagination'
import { BoardDetailSideInfoWidgetData } from '../data/staticData/SideBarData';

const Main = styled.div`
  display: flex;
`;

const MainLeft = styled.div`
  display: flex;
  flex-direction: column;
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

  > div {
    display: flex;
    align-items: center;

    > span {
      font-size: 1.7rem;
      color: #232629;
    }
  }  
`;

// const Pagination = styled.div`
//   display: flex;
//   justify-content: space-between;
// `;

const MainRight = styled.div`
  display: flex;
  flex-direction: column;
  gap: 1.6rem;
  padding-left: 2.4rem;
`;

const filterData = [
  {
    buttonName : "Newest",
    onClick : () => {console.log('button1')},
  },
  {
    buttonName : "Unanswered",
    onClick : () => {console.log('button2')},
  },
  {
    buttonName : "Frequent",
    onClick : () => {console.log('button3')},
  },
  {
    buttonName : "Score",
    onClick : () => {console.log('button3')},
  }
];

const QuestionBoard = ({questions}) => {
  return (
    <>
        <Main>
          <MainLeft>
            <MainTop>
              <h1>All Questions</h1>
              <Button
                buttonType='type2'
                buttonName='Ask Question'
                width='9.87rem'
              />
            </MainTop>
            <FilterContainer>
              <div>
                {/* <span>{questions.length}</span> */}
                <span>questions</span>
              </div>
              <div>
                <FilterButtonWrapper filterData={filterData} />
              </div>
            </FilterContainer>
            
            {/* {questions.map((el, idx) => {
              <QuestionInfoContainer
                title={el.title}
                content={el.content}
                votes={el.votes}
                answers={el.answers}
                views={el.views}
              />
            })} */}

            <QuestionInfoContainer />
            <QuestionInfoContainer />
            <QuestionInfoContainer />

            {/* <Pagination>
              <Page />
              <PerPage />
            </Pagination> */}
          </MainLeft>
          <MainRight>
            {BoardDetailSideInfoWidgetData.map((el) => {
                return (
                  <MainRightSideInfoWidget 
                    title={el.title}
                    contents={el.contents} 
                  />
                )
              })}
            <MainRightTagBasic />
            <MainRightTagAdded />
            <MainRightTagInput />
          </MainRight>
        </Main>
    </>
  )
};

export default QuestionBoard;