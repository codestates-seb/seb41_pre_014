import styled from "styled-components";
import { UserStats } from "../components/blocks/UserStats";
import { UserPostedQnA } from "../components/blocks/UserPostedQnA";
import { FilterButtonWrapper } from "../components/blocks/FilterButtonWrapper";

const Main = styled.div`
  display: flex;
`
const MainLeft = styled.div`
  margin: 1.2rem;
`

const MainRight = styled.div`
  display: flex;
  flex-direction: column;
  flex-grow: 1;
  margin: 1.2rem;
`
const filterDataType1 = [
  {
    buttonName : "All",
    onClick: () => {console.log('모든 게시물 정렬')}
  },
  {
    buttonName : "Questions",
    onClick: () => {console.log('Question만 정렬')}
  },
  {
    buttonName : "Answers",
    onClick: () => {console.log('Answer만 정렬')}
  }
];

const filterDataType2 = [
  {
    buttonName : "Score",
    onClick: () => {console.log('Score를 기준으로 정렬')}
  },
  {
    buttonName : "Newest",
    onClick: () => {console.log('최신 작성일을 기준으로 정렬')}
  }
]

const FilterButtonContainer = styled.div`
  display: flex;
  justify-content: flex-end;
  gap: 1rem;
  margin-bottom: 1rem;
`
const MainRightTop = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  &>.elementTitle {
    font-size: 1.6rem;
    font-weight: 550;
  }
`

const UserProfile = () => {
  return (
    <Main>
      <MainLeft>
        <UserStats />
      </MainLeft>
      <MainRight>
        <MainRightTop>
          <div className='elementTitle'>Element Title</div>
          <FilterButtonContainer>
            <FilterButtonWrapper filterData={filterDataType1} />
            <FilterButtonWrapper filterData={filterDataType2} />
          </FilterButtonContainer>
        </MainRightTop>
        <UserPostedQnA />
      </MainRight>
    </Main>
  );
}

export default UserProfile;