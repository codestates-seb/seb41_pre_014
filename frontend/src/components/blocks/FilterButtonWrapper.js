import styled from "styled-components"
import { useState } from 'react';

// ********** 컴포넌트 설명 ********** //
// 본 컴포넌트를 사용할 때, 부모 컴포넌트에서 아래 filterData와 같이
// 각 버튼의 이름과 Click Event Handler 함수가 담긴 객체를 props로 전달해줘야 함
// 
// const filterData = [
//   {
//     buttonName : "Interesting",
//     onClick : () => {console.log('button1')},
//   },
//   {
//     buttonName : "Hot",
//     onClick : () => {console.log('button2')},
//   },
//   {
//     buttonName : "Week",
//     onClick : () => {console.log('button3')},
//   }
// ];
// ********** 컴포넌트 설명 ********** //

export const FilterButtonWrapper = (props) => {

  const [ btnActive, setBtnActive ] = useState(0);

  const ButtonEventHandler = (idx, buttonEvent) => {
    setBtnActive(idx);
    buttonEvent();
  };

  return (
    <StyledButtonWrapper>
      {props.filterData.map((el, idx) => {
        return (
          <StyledButton 
            key={idx}
            className={ btnActive === idx && 'active' }
            onClick={() => ButtonEventHandler(idx, el.onClick)}
            padding={props.padding}
            fontSize={props.fontSize}
          >{el.buttonName}</StyledButton>
        )
      })}
    </StyledButtonWrapper>
  )
};

const StyledButtonWrapper = styled.div`
  display: flex;
  flex-wrap: wrap;


  & > div:first-child {
    border-top-left-radius: 0.3rem;
    border-bottom-left-radius: 0.3rem;
  };

  & > div:last-child {
    margin-right: 0;
    border-top-right-radius: 0.3rem;
    border-bottom-right-radius: 0.3rem;

  };
`;

const StyledButton = styled.div`
  color: #6A737C;
  border: 1px solid hsl(210,8%,65%);
  margin-right: -0.1rem;
  cursor: pointer;
  font-size: ${props => props.fontSize || '1.3rem'};
  padding: ${props => props.padding || '1.04rem'};

  &:hover {
    background-color: hsl(210deg 8% 98%);
  };

  &.active {
    background-color: hsl(210deg 8% 90%);
    border-color: hsl(210deg 8% 55%);
    color: #3B4045;
  };
`;