import styled from "styled-components";
import { FilterContainer } from './UserActivityAnswers';

export const DeleteButton = styled.button`
  all: unset;
  width: 3.7rem;
  height: 3.3rem;
`

export const UserActivityFollowing = () => {
  return (
    <div>
    <FilterContainer>
      <div>
        <h2>총 팔로잉 포스트 수</h2>
      </div>
      <div>
        필터버튼 x 2
        {/* <FilterButtonWrapper></FilterButtonWrapper> 스타일 확장*/}
        {/* <FilterButtonWrapper></FilterButtonWrapper> 스타일 확장*/}
      </div>
    </FilterContainer>
    {/* <QuestionInfoContainer/> -> flex-direction oppposite / import / img 추가 / DeleteButton추가 / map */}
    {/* <Pagination></Pagination> */}
  </div>
  )
}