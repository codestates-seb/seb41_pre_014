import styled from 'styled-components';
import { NavLink } from 'react-router-dom';

const NavItemStyled = styled.li`

& > a {
    margin: ${props => props.margin || '0'};
    padding: ${props => props.padding || '0.6rem 1.2rem'};
    width: ${props => props.width || 'auto'};
    height: ${props => props.height || 'auto'};
    font-size: ${props => props.fontSize || '1.3rem'};
    font-weight: ${props => props.fontWeight || 'normal'};
    /* 기본 */
    text-decoration: none;
    background-color: none;
    color: #525960;
    cursor: pointer;
    border-radius: 100rem;
    display:flex;
    align-items: center;
    &:hover {
      background-color: #E3E6E8;
      color: #232629;
    }

    &.type1 {
      background-color: #F2740D;
      color: #FFF;
    };

    &.type2 {
      background-color: #E3E6E8;
      color: #525960;
    };

    &.type3 {
      background-color: #FFF;
      color: #525960;
    };
  }
`;

// < NavItem Type >
// type1 - 주황색 배경
// type2 - 회색 배경
// type3 - 하얀색 배경
export const NavItem = (props) => {
  const activeBar = ({ isActive }) =>
    isActive 
    ? {
      backgroundColor: props.activeBg,
      color: props.activeColor,
      fontWeight: props.activeFontWg,
    } 
    : {};

  return (
    <NavItemStyled 
      className={props.NavItemType}
      width={props.width}
      height={props.height}
      padding={props.padding}
      margin={props.margin}
      fontSize={props.fontSize}
      fontWeight={props.fontWeight}
    ><NavLink to={props.NavTo} style={activeBar} >{props.NavItemName}</NavLink></NavItemStyled>
  )
};