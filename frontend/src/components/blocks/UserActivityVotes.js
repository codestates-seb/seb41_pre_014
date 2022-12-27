import styled from "styled-components";
import { FilterContainer } from "./UserActivityAnswers";

export const UserActivityVotes = () => {
  return (
    <div>
    <FilterContainer>
      <div>
        <h2>n Votes</h2>
      </div>
      <div>
        필터버튼
        {/* <FilterButtonWrapper></FilterButtonWrapper> 스타일 확장*/}
      </div>
    </FilterContainer> 
    {/* <QuestionInfoContainer/> -> flex-direction oppposite / import / img 추가 / map */}
    {/* <Pagination></Pagination> */}
  </div>
  )
}