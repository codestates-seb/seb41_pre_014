import styled from 'styled-components';
import { Button } from '../components/atoms/Button';
import { FilterButtonWrapper } from '../components/blocks/FilterButtonWrapper';
import { QuestionInfoContainer } from '../components/blocks/QuestionInfoContainer';
import { MainRightSideInfoWidget, MainRightTagBasic } from '../components/blocks/MainRight';
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
  justify-content: flex-end;
`;

const MainRight = styled.div`
  display: flex;
  flex-direction: column;
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

const HomeLoginBoard = ({questions}) => {
  return (
    <>
        <Main>
          <MainLeft>
            <MainTop>
              <h1>Top Questions</h1>
              <Button
                buttonType='type2'
                buttonName='Ask Question'
                width='9.87rem'
              />
            </MainTop>
            <FilterContainer>
              <FilterButtonWrapper filterData={filterData} />
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
          </MainRight>
        </Main>
    </>
  )
};

export default HomeLoginBoard;