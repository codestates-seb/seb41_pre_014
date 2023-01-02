import styled from 'styled-components';
import { NavLink } from 'react-router-dom';

const StyledDropdownNavBar = styled.nav`
  width: 16.4rem;
  padding: 2.4rem 0 0.8rem;
  background-color: #FFF;
  z-index: 999;
  border: 1px solid #E3E6E8;
  border-top: 0;
  box-shadow: 0 0.1rem 0.2rem hsla(0,0%,0%,0.05), 0 0.1rem 0.4rem hsla(0, 0%, 0%, 0.05), 0 0.2rem 0.8rem hsla(0, 0%, 0%, 0.05);

  position: ${props => props.position || 'sticky'};
  top: ${props => props.top || null};
  left: ${props => props.left || null};

  & * {
    font-size:1.3rem;
    color:#525960;
  }
`;

const StyledDropdownNavContainer = styled.ul`
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

export const DropdownNavBar = (props) => {
  const activeBar = ({ isActive }) =>
    isActive 
    ? {
      backgroundColor: '#F1F2F3',
      color: '#0C0D0E',
      fontWeight: 'bold',
      borderRight: '3px solid #F48225',
    } 
    : {};

  return (
    <StyledDropdownNavBar
      position={props.position}
      top={props.top}
      left={props.left}
      onClick={() => props.setLeftMenuOpen(false)}
    >
      <StyledDropdownNavContainer>
        <StyledDropdownNavContainer>
          <StyledNavHome>
            <NavLink to='/' style={activeBar}>Home</NavLink>
          </StyledNavHome>
          <StyledNavPublic>
            <p>PUBLIC</p>
            <div><NavLink to='/questions' style={activeBar}>Questions</NavLink></div>
            <div><NavLink to='/users' style={activeBar}>Users</NavLink></div>
          </StyledNavPublic>
        </StyledDropdownNavContainer>
      </StyledDropdownNavContainer>
    </StyledDropdownNavBar>
  )
};