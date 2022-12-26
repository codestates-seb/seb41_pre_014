import styled from 'styled-components';
import { Link } from 'react-router-dom';
import { useState } from 'react';

const StyledUlType1 = styled.ul`
  display: flex;
  list-style: none;
  padding-left: 0rem;
  gap: 0.4rem;
`
const StyledLiType1 = styled.li`
  font-size: 1.3rem;
  color: #525960;
  padding: 0.6rem 1.2rem;
  border-radius: 10rem;
  &:hover {
    background-color: #d6d9dc;
  }
  &.selected {
    background-color: #f48225;
    color: #ffffff;
      &:hover {
        background-color: #da680b;
      }
  }
`
// User 페이지의 콘텐츠 상단 네비게이션
export const MainNavBar = () => {

  const navItems = [
    {name: 'Profile'},
    {name: 'Activity'},
    {name: 'Settings'}
  ]
  
  const [ isSelected, setSelected ] = useState(0);
  
  const handleSelect = (index) => {
    setSelected(index)
  }
  
  return (
    <div>
      <StyledUlType1>
        {navItems.map((el,index)=>{
          return <StyledLiType1 
          onClick={()=>handleSelect(index)} 
          className={`${index === isSelected ? 'selected' : ''}`} 
          key={index}>{el.name}</StyledLiType1>
        })}
      </StyledUlType1>
    </div>
  );
};

const StyledUlType2 = styled(StyledUlType1)`
  flex-direction: column;
  width: 12.3rem;
  gap: 0;
`

const StyledLiType2 = styled(StyledLiType1)`
  &:hover {
    background-color: #e3e6e8;
  }
  &.selected {
    color: #525960;
    background-color: #f1f2f3;
    &:hover {
      background-color: #ffffff;
    }
  }
`

// User 페이지의 Profile/Activity 콘텐츠 좌측 내비게이션
export const MainLeftNavBar = () => {
  
  const mainLeftNavItems = [
    {name: 'Answers'},
    {name: 'Questions'},
    {name: 'Tags'},
    {name: 'Following'},
    {name: 'Reputation'},
    {name: 'Votes'},
  ]

  const [ isSelected, setSelected ] = useState(0);
  
  const handleSelect = (index) => {
    setSelected(index)
  }

  return (
    <nav>
      <StyledUlType2>
        {mainLeftNavItems.map((el,index)=>{
          return <StyledLiType2 key={index}
          onClick={()=>handleSelect(index)} 
          className={`${index === isSelected ? 'selected' : ''}`} 
          >{el.name}</StyledLiType2>
        })}
      </StyledUlType2>
    </nav>
  )
}

export const StyledUlType3 = styled(StyledUlType2)`
  width: 17.5rem;
`

// User 페이지의 Settings 좌측 내비게이션
export const MainLeftNavBar2 = () => {
  
  const mainLeftNavItems = [
    {name: 'Edit Profile'},
    {name: 'Delete Profile'},
  ]

  const [ isSelected, setSelected ] = useState(0);
  
  const handleSelect = (index) => {
    setSelected(index)
  }

  return (
    <nav>
      <StyledUlType3>
        {mainLeftNavItems.map((el,index)=>{
          return <StyledLiType1 key={index}
          onClick={()=>handleSelect(index)} 
          className={`${index === isSelected ? 'selected' : ''}`} 
          >{el.name}</StyledLiType1>
        })}
      </StyledUlType3>
    </nav>
  )
}