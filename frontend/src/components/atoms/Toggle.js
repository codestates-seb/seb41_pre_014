import { useState } from 'react';
import styled from 'styled-components';

const ToggleContainer = styled.div`
  position: relative;
  display: inline-block;
  cursor: pointer;

  > .toggle-container {
    width: 4.4rem;
    height: 2.4rem;
    border-radius: 10rem;
    background-color: #949CA3;

    &.toggle--checked {
      background-color: #4BB274;
    }
  }

  > .toggle-circle {
    position: absolute;
    top: 0.3rem;
    left: 0.3rem;
    width: 1.8rem;
    height: 1.8rem;
    border-radius: 50%;
    background-color: #FFFFFF;
    transition: .2s;

    &.toggle--checked {
      left: 2.3rem;
      transition: .2s ease;
    }
  }
`;

export const Toggle = () => {
  const [isOn, setisOn] = useState(false);

  const toggleHandler = () => {
    setisOn(!isOn);
  };

  return (
    <>
      <ToggleContainer onClick={toggleHandler}>
        <div className={`toggle-container ${isOn ? "toggle--checked" : ""}`}/>
        <div className={`toggle-circle ${isOn ? "toggle--checked" : ""}`}/>
      </ToggleContainer>
    </>
  );
};