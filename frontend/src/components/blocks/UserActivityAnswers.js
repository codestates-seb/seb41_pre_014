import styled from "styled-components";

export const FilterContainer = styled.div`
  display: flex;
  justify-content: space-between;
  margin-bottom: 0.8rem;
`
// Answer 없을 경우,
// export const EmptyAnswerContainer = () => {

// }

export const UserActivityAnswers = () => {
  return (
    
  <div>
    <FilterContainer>
      <div>
        <h2>총 답변수</h2>
      </div>
      <div>
        필터버튼
        {/* <FilterButtonWrapper></FilterButtonWrapper> 스타일 확장*/}
      </div>
    </FilterContainer>
    {/* <QuestionInfoContainer/> -> flex-direction oppposite / import / map */}
    {/* <Pagination></Pagination> */}
  </div>
  )
} 