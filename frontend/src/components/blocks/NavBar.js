import styled from 'styled-components';
import { NavLink } from 'react-router-dom';
import { useSelector } from 'react-redux';
import { NavItem } from '../atoms/NavItem';
import { useLocation } from 'react-router-dom';

const StyledLeftNav = styled.div`
  min-height:inherit;
  border-right: 1px solid #e5e5e5;
  margin-right: -1px;
`;

const StyledLeftNavBar = styled.nav`
  width: 16.4rem;
  padding: 2.4rem 0 0.8rem;
  background-color: #FFF;
  position:sticky;
  top: 5rem;

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

export const LeftNavBar = () => {
  const location = useLocation();
  const currentUrl = location.pathname;
  const noFooterUrlPathList = [
    '/users/signup', '/users/login', '/users/logout', '/questions/ask'
  ];

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

  return (noFooterUrlPathList.includes(currentUrl) || 
    (!LoginStatus && currentUrl === '/')) || (
        <StyledLeftNav>
          <StyledLeftNavBar>
            <StyledLeftNavContainer>
              <StyledLeftNavContainer>
                <StyledNavHome>
                  <NavLink to='/' style={activeBar}>Home</NavLink>
                </StyledNavHome>
                <StyledNavPublic>
                  <p>PUBLIC</p>
                  <div><NavLink to='/questions' style={activeBar}>Questions</NavLink></div>
                  <div><NavLink to='/users' style={activeBar}>Users</NavLink></div>
                </StyledNavPublic>
              </StyledLeftNavContainer>
            </StyledLeftNavContainer>
          </StyledLeftNavBar>
        </StyledLeftNav>
      )
    
  
};

const StyledMainNavBar = styled.ul`
  display: flex;
  list-style: none;
  flex-direction: row;
  width: 100%;
  gap: 0.4rem;
`
// UserDetail 페이지 Main 상단 네비게이션
export const MainNavBar = (props) => {
  
  return (
    <div>
      <StyledMainNavBar>
        {props.navItems.map((el,index)=>{
          return (
          <NavItem 
            key={index}
            NavItemName={el.name}
            NavTo={el.to}
            width={props.width || '100%'}
            padding={props.padding || '0.6rem 1.2rem'}
            activeBg={props.activeBg || '#F48225'}
            activeColor={props.activeColor || '#FFF'}
            fontSize='1.3rem'
          />
          )
        })}
      </StyledMainNavBar>
    </div>
  );
};

// User 페이지의 콘텐츠 좌측 내비게이션
// ******* 설명 ******* //
// 본 컴포넌트를 가져가서 사용하실 때, props로 전달해줄 수 있는 것들은 아래와 같습니다.
// width - 각 NavItem과 NavBar의 width를 설정
// padding - 각 NavItem의 padding을 설정
// activeBg - 해당 NavItem을 클릭했을 때의 배경색
// activeColor - 해당 NavItem을 클릭했을 때의 글자색
const StyledMainLeftNavBar = styled.ul`
  display: flex;
  list-style: none;
  flex-direction: column;
  width: ${props => props.width || '12.61rem'};
  position: sticky;
  top: 5rem;
`

export const MainLeftNavBar = (props) => {
  return (
    <nav>
      <StyledMainLeftNavBar>
        {props.navItems.map((el,index)=>{
          return (
            <NavItem
              key={index}
              NavItemName={el.name}
              NavTo={el.to}
              NavEnd={el.end}
              width={props.width || '12.61rem'}
              padding={props.padding || '0.6rem 4.8rem 0.6rem 1.2rem'}
              activeBg={props.activeBg || '#F1F2F3'}
              activeColor={props.activeColor || '#232629'}
            />
          )
        })}
      </StyledMainLeftNavBar>
    </nav>
  )
}
// User 페이지의 콘텐츠 좌측 내비게이션