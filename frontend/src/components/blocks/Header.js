import styled from 'styled-components';
import { useState } from 'react';
import { useNavigate, useLocation } from 'react-router-dom';
import { FontAwesomeIcon} from '@fortawesome/react-fontawesome';
import { faBars, faXmark, faCircleUser } from "@fortawesome/free-solid-svg-icons";
import { useSelector } from 'react-redux';

import { NavItem } from '../atoms/NavItem';
import { SearchBar } from '../atoms/SearchBar';
import { Button } from '../atoms/Button';
import { DropdownNavBar } from './DropdownNavBar';
import { RandomAvartar } from '../blocks/RandomAvartar';

export const Header = () => {
  const location = useLocation();
  const currentUrl = location.pathname;

  const [ isleftMenuOpen, setLeftMenuOpen ] = useState(false);
  const leftMenuEventHandler = () => {
    setLeftMenuOpen(!isleftMenuOpen);
  }

  const LoginStatus = useSelector(state => state.loginStatus.status);
  const LoginUser = useSelector(state => state.loginUserInfo);
  
  const navigate = useNavigate();
  const LogoEventHandler = (e) => {
    e.preventDefault();
    setLeftMenuOpen(false);
    navigate('/');
  }
  const LogInEventHandler = () => {
    setLeftMenuOpen(false);
    navigate('/users/login');
  }

  const SignUpEventHandler = () => {
    setLeftMenuOpen(false);
    navigate('/users/signup');
  }

  const UserIconEventHandler = () => {
    navigate(`/users/${LoginUser.memberId}`)
  }

  const [ isMenuOpen, setIsMenuOpen ] = useState(false);
  const MenuIconEventHandler = () => {
    setIsMenuOpen(!isMenuOpen);
  }

  const LogOutEventHandler = () => {
    navigate('/users/logout');
    setIsMenuOpen(false);
  }

  return (
    <>
      {LoginStatus 
      ? <StyeldHeader>
          <StyledHeaderContainer>
            <StyledLogoIcon>
              <a href='#none' onClick={e => LogoEventHandler(e)}> </a>
            </StyledLogoIcon>
            <StyledNavItemBox>
              <NavItem />
            </StyledNavItemBox>
            <StyledSearchBarBox>
              <SearchBar />
            </StyledSearchBarBox>
            <StyledIconWrapper>
              <StyledIconBox width='6rem' className='LoggedHeaderIcon' onClick={UserIconEventHandler}>
                {LoginUser.loginUserInfo.profileImageUrl
                ? <img src='LoginUser.loginUserInfo.profileImageUrl' alt='avatar' />
                : <RandomAvartar width='2.4rem' height='2.4rem' fontSize='1.3rem' /> }
                <StyledRepu>{LoginUser.loginUserInfo.reputation || '1'}</StyledRepu>
              </StyledIconBox>
              <StyledIconBox className='LoggedHeaderIcon'>
                <svg aria-hidden="true" className="svg-icon iconInbox" width="20" height="18" viewBox="0 0 20 18"><path d="M4.63 1h10.56a2 2 0 0 1 1.94 1.35L20 10.79V15a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2v-4.21l2.78-8.44c.25-.8 1-1.36 1.85-1.35Zm8.28 12 2-2h2.95l-2.44-7.32a1 1 0 0 0-.95-.68H5.35a1 1 0 0 0-.95.68L1.96 11h2.95l2 2h6Z"></path></svg>
              </StyledIconBox>
              <StyledIconBox className='LoggedHeaderIcon'>
                <svg aria-hidden="true" className="svg-icon iconAchievements" width="18" height="18" viewBox="0 0 18 18"><path d="M15 2V1H3v1H0v4c0 1.6 1.4 3 3 3v1c.4 1.5 3 2.6 5 3v2H5s-1 1.5-1 2h10c0-.4-1-2-1-2h-3v-2c2-.4 4.6-1.5 5-3V9c1.6-.2 3-1.4 3-3V2h-3ZM3 7c-.5 0-1-.5-1-1V4h1v3Zm8.4 2.5L9 8 6.6 9.4l1-2.7L5 5h3l1-2.7L10 5h2.8l-2.3 1.8 1 2.7h-.1ZM16 6c0 .5-.5 1-1 1V4h1v2Z"></path></svg>
              </StyledIconBox>
              <StyledIconBox className='LoggedHeaderIcon'>
                <svg aria-hidden="true" className="svg-icon iconHelp" width="18" height="18" viewBox="0 0 18 18"><path d="M9 1C4.64 1 1 4.64 1 9c0 4.36 3.64 8 8 8 4.36 0 8-3.64 8-8 0-4.36-3.64-8-8-8Zm.81 12.13c-.02.71-.55 1.15-1.24 1.13-.66-.02-1.17-.49-1.15-1.2.02-.72.56-1.18 1.22-1.16.7.03 1.2.51 1.17 1.23ZM11.77 8c-.59.66-1.78 1.09-2.05 1.97a4 4 0 0 0-.09.75c0 .05-.03.16-.18.16H7.88c-.16 0-.18-.1-.18-.15.06-1.35.66-2.2 1.83-2.88.39-.29.7-.75.7-1.24.01-1.24-1.64-1.82-2.35-.72-.21.33-.18.73-.18 1.1H5.75c0-1.97 1.03-3.26 3.03-3.26 1.75 0 3.47.87 3.47 2.83 0 .57-.2 1.05-.48 1.44Z"></path></svg>
              </StyledIconBox>
              <StyledIconBox className='LoggedHeaderIcon'>
                <svg className="svg-icon" width="18" height="18" viewBox="0 0 18 18"><path d="m8.9844-0.013672a1 1 0 0 0 -0.98438 1.0137v0.38281l-0.55273-0.27734a1 1 0 0 0 -0.48242 -0.11133 1 1 0 0 0 -0.41211 1.9004l1.4473 0.72266v3.6523l-3.1621-1.8262 0.097656-1.6152a1 1 0 0 0 -0.95117 -1.0742 1 1 0 0 0 -1.0449 0.95508l-0.037109 0.61719-0.33008-0.19141a1 1 0 0 0 -0.57422 -0.14062 1 1 0 0 0 -0.42578 1.8711l0.33203 0.19141-0.51758 0.3418a1 1 0 1 0 1.1016 1.668l1.3516-0.89258 3.1621 1.8262-3.1621 1.8262-1.3516-0.89258a1 1 0 0 0 -0.56445 -0.17383 1 1 0 0 0 -0.53711 1.8418l0.51758 0.3418-0.33203 0.19141a1 1 0 1 0 1 1.7305l0.33008-0.19141 0.037109 0.61719a1 1 0 1 0 1.9961 -0.11914l-0.097656-1.6152 3.1621-1.8262v3.6523l-1.4473 0.72266a1 1 0 0 0 0.89453 1.7891l0.55273-0.27734v0.38281a1 1 0 1 0 2 0v-0.38281l0.55273 0.27734a1 1 0 1 0 0.89453 -1.7891l-1.4473-0.72266v-3.6523l3.1621 1.8262-0.097656 1.6152a1 1 0 1 0 1.9961 0.11914l0.037109-0.61719 0.33008 0.19141a1 1 0 1 0 1 -1.7305l-0.33203-0.19141 0.51758-0.3418a1 1 0 0 0 -0.56641 -1.8418 1 1 0 0 0 -0.53516 0.17383l-1.3516 0.89258-3.1621-1.8262 3.1621-1.8262 1.3516 0.89258a1 1 0 1 0 1.1016 -1.668l-0.51758-0.3418 0.33203-0.19141a1 1 0 0 0 -0.45508 -1.8711 1 1 0 0 0 -0.54492 0.14062l-0.33008 0.19141-0.037109-0.61719a1 1 0 0 0 -0.97461 -0.95508 1 1 0 0 0 -1.0215 1.0742l0.097656 1.6152-3.1621 1.8262v-3.6523l1.4473-0.72266a1 1 0 1 0 -0.89453 -1.7891l-0.55273 0.27734v-0.38281a1 1 0 0 0 -1.0156 -1.0137z"></path></svg>
              </StyledIconBox>
              <StyledIconBox className='LoggedHeaderIcon' onClick={MenuIconEventHandler}>
                <svg aria-hidden="true" className="svg-icon iconStackExchange" width="18" height="18" viewBox="0 0 18 18"><path d="M15 1H3a2 2 0 0 0-2 2v2h16V3a2 2 0 0 0-2-2ZM1 13c0 1.1.9 2 2 2h8v3l3-3h1a2 2 0 0 0 2-2v-2H1v2Zm16-7H1v4h16V6Z"></path></svg>  
              </StyledIconBox>
              {isMenuOpen ? <StyledMenu onClick={LogOutEventHandler}>Log out</StyledMenu> : null}
            </StyledIconWrapper>
        </StyledHeaderContainer>
      </StyeldHeader>
      : <StyeldHeader>
          <StyledHeaderContainer>
            {currentUrl === '/' && <StyledIconBox width='4.8rem' onClick={leftMenuEventHandler}>
              {isleftMenuOpen 
                ? <FontAwesomeIcon icon={faXmark} /> 
                : <FontAwesomeIcon icon={faBars} />
              }
            </StyledIconBox>}
            {isleftMenuOpen && 
              <DropdownNavBar 
                position='absolute' 
                top='4.7rem' 
                left='0rem' 
                zIndex='999'
                setLeftMenuOpen={setLeftMenuOpen}
              />
            }
            <StyledLogoIcon>
              <a href='#none' onClick={e => LogoEventHandler(e)}> </a>
            </StyledLogoIcon>
            <StyledNavItemWrapper>
              <NavItem NavItemName='About' />
              <NavItem NavItemName='Products' />
              <NavItem NavItemName='For Teams' />
            </StyledNavItemWrapper>
            <StyledSearchBarBox>
              <SearchBar />
            </StyledSearchBarBox>
            <StyledButtonWrapper>
              <Button 
                buttonType='type3' 
                buttonName='Log In'
                width='auto'
                padding='0.8rem 1.04rem'
                height='3.1rem'
                margin='0 0.4rem 0 0'
                onClick={LogInEventHandler}
              />
              <Button 
                buttonType='type2' 
                buttonName='Sign Up'
                width='auto'
                padding='0.8rem 1.04rem'
                height='3.1rem'
                onClick={SignUpEventHandler}
              />
            </StyledButtonWrapper>
          </StyledHeaderContainer>
        </StyeldHeader>
      }
    </>
  )
};

const StyeldHeader = styled.header`
  width:100%;
  background-color: hsl(210,8%,97.5%);
  box-shadow: 0 0.1rem 0.2rem hsla(0,0%,0%,0.05)
  , 0 0.1rem 0.4rem hsla(0, 0%, 0%, 0.05)
  , 0 0.2rem 0.8rem hsla(0, 0%, 0%, 0.05);
  border-top: 0.3rem solid #F48225;
  position: fixed;
  top: 0;
  z-index: 99999;
`;

const StyledHeaderContainer = styled.div`
  display:flex;
  width: 126.4rem;
  height: 4.7rem;
  margin: 0 auto;
  position: relative;
`;

const StyledLogoIcon = styled.div`
  width: 16.6rem;
  height: 4.7rem;
  padding: 0 0.8rem;
  display: flex;
  align-items: center;
  &:hover {
    background-color: #E3E6E8;
  }

  & > a {
    width: 15rem;
    height: 3rem;
    margin-top: -0.4rem;
    background-image: url('/image/sprites.svg');
    background-position: 0px -50rem;
  }
`;

const StyledNavItemWrapper = styled.ul`
  list-style: none;
  width: 23.35rem;
  height: 4.7rem;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;

  & > li > a {
    font-size: 1.4rem;
    height: 2.9rem;
  }
`;

const StyledNavItemBox = styled.ul`
  list-style: none;
  width: 7.85rem;
  height: 4.7rem;
`;

const StyledSearchBarBox = styled.div`
  padding: 0 0.8rem;
  flex-shrink: 1000;
  flex-grow: 1;
  display: flex;
  align-items: center;

  & > form {
    flex-grow: 1;
  }
`;

const StyledButtonWrapper = styled.div`
  height: 4.7rem;
  list-style: none;
  display:flex;
  align-items:center;
`;

const StyledIconWrapper = styled.nav`
  width: 27.5rem;
  height: 4.7rem;
  display: flex;
  position: relative;
`;

const StyledIconBox = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 0 1.6rem;
  cursor: pointer;
  &:hover {
    background-color: #E3E6E8;
  };

  &.LoggedHeaderIcon {
      width: 100%;
      padding: 0;
  }

  & > svg {
    font-size: 1.6rem;
    fill: hsl(210,8%,35%);
  };

  & > svg.userIcon {
    font-size: 2rem;
    color: hsl(210,8%,35%);
  }
`;

const StyledRepu = styled.div`
  font-weight: bold;
  font-size: 1.3rem;
  color: #525960;
  padding-left: 0.5rem;
  margin-top: 0.2rem;
`;

const StyledMenu = styled.div`
  position:absolute;
  top:4.7rem;
  right:1rem;
  width:15rem;
  font-size:1.3rem;
  color:#525960;
  background-color: #FFF;
  border: 1px solid #E3E6E8;
  border-top: 0;
  box-shadow: 0 0.1rem 0.2rem hsla(0,0%,0%,0.05), 0 0.1rem 0.4rem hsla(0, 0%, 0%, 0.05), 0 0.2rem 0.8rem hsla(0, 0%, 0%, 0.05);
  padding: 1rem 2rem;
  display: flex;
  justify-content: center;
  align-items: center;
  cursor: pointer;
  &:hover {
    background-color: #E3E6E8;
    font-weight: 600;
  }
`;
