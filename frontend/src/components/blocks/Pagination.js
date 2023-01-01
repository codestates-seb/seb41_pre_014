import styled from 'styled-components';
import { useState } from 'react';

const PerPageWrapper = styled.div`
  display: flex;
  flex-wrap: wrap;
  gap: 0.4rem;
  align-items: center;
  
  > span {
    font-size: 1.3rem;
    color: hsl(210deg 8% 25%);
    padding: 0 0.8rem;
  }
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

export const PerPage = (props) => {
  const [ btnActive, setBtnActive ] = useState(0);

  const ButtonEventHandler = (idx, buttonEvent) => {
    setBtnActive(idx);
    buttonEvent();
  }

  return (
    <PerPageWrapper>
      {props.PerPageData.map((el, idx) => {
        return <StyledButton
          key={idx}
          className={btnActive === idx && 'active'}
          onClick={() => ButtonEventHandler(idx, el.onClick)}
        >{el.buttonName}</StyledButton>
      })}
      <span>per page</span>
    </PerPageWrapper>
  )
};