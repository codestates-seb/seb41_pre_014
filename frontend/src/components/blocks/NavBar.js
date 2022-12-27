import styled from 'styled-components';
import { NavLink, Link } from 'react-router-dom';
import { useSelector } from 'react-redux';
import { useState } from 'react';

const StyledLeftNavBar = styled.nav`
  width: 16.4rem;
  padding: 2.4rem 0 0.8rem;
  background-color: #FFF;

  & * {
    font-size:1.3rem;
    color:#525960;
  }
`;

const StyledLeftNavContainer = styled.ul`
  list-style: none;
`;

const StyledNavHome = styled.li`
  width:100%;
  height: 3.4rem;
  display:flex;
  align-items: center;
  
  & > a {
    padding: 0.4rem 0.4rem 0.4rem 0.8rem;
    width: 100%;
    height: 100%;
    line-height: 2.6rem;
    text-decoration: none;
    cursor: pointer;
  }
`;

const StyledNavPublic = styled.li`
  width:100%;

  & > p {
    padding: 1.6rem 0 0.4rem 0.8rem;
    font-size: 1.1rem;
    color:#6A737C;
  }

  & > div {
    width:100%;
    height: 3.4rem;
    display:flex;
    flex-direction: column;
  }

  & > div > a {
    padding: 0.4rem 0.4rem 0.4rem 3rem;
    width: 100%;
    height: 100%;
    line-height: 2.6rem;
    text-decoration: none;
    cursor: pointer;
  }
`;

export const LeftNavBar = (props) => {
  const activeBar = ({ isActive }) =>
    isActive 
    ? {
      backgroundColor: '#F1F2F3',
      color: '#0C0D0E',
      fontWeight: 'bold',
      borderRight: '3px solid #F48225',
    } 
    : {};

    const LoginStatus = useSelector(state => state.loginStatus.status);

  return (
    <>
      {LoginStatus && (
        <StyledLeftNavBar
        >
          <StyledLeftNavContainer>
            <StyledLeftNavContainer>
              <StyledNavHome>
                <NavLink to='/' style={activeBar}>Home</NavLink>
              </StyledNavHome>
              <StyledNavPublic>
                <p>PUBLIC</p>
                <div><NavLink to='/board' style={activeBar}>Questions</NavLink></div>
                <div><NavLink to='/users' style={activeBar}>Users</NavLink></div>
              </StyledNavPublic>
            </StyledLeftNavContainer>
          </StyledLeftNavContainer>
        </StyledLeftNavBar>
      )}
    </>
  )
};

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
  width: 33.1rem;
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
