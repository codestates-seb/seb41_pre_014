import styled from 'styled-components';
import { FilterContainer } from './UserActivityAnswers';

export const UserActivityQuestions = () => {
  return (
    <div>
      <FilterContainer>
        <div>
          <h2>총 질문수</h2>
        </div>
        <div>
          필터버튼
          {/* <FilterButtonWrapper></FilterButtonWrapper> 스타일 확장 */}
        </div>
      </FilterContainer>
      {/* <QuestionInfoContainer/> -> flex-direction opposite / import / map */}
    {/* <Pagination></Pagination> */}
    </div>
  );
};