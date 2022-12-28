import styled from "styled-components";
import { FilterContainer } from "./UserActivityAnswers";

const StyledDiv = styled.div`
  display: flex;
  align-items: center;
`

const TagBtn = styled.button`
  outline: none;
  background-color: #e1ecf4;
  height: 2.36rem;
 // Button atoms 스타일 확장
`

const TagDetailWrap = styled.div`
  display: flex;
  justify-content: space-between;
  height: 5.4rem;
  & > div > span {
    margin: 0.5rem;
  }
`

export const TagDetail = () => {
  return (
    <TagDetailWrap>
      <StyledDiv>
        <TagBtn>태그명</TagBtn>
      </StyledDiv>
      <StyledDiv>
        <span>Score총합</span>
        <span>Posts 개수</span>
      </StyledDiv>
    </TagDetailWrap>
  );
}

export const UserActivityTags = () => {
  return (
    <div>
      <FilterContainer>
        <div>
          <h2>총 태그수</h2>
        </div>
        <div>
          필터버튼
          {/* <FilterButtonWrapper></FilterButtonWrapper> 스타일 확장 */}
        </div>
      </FilterContainer>
      <TagDetail/>
      {/* map */}
      {/* <Pagnation/> */}
    </div>
  )
}