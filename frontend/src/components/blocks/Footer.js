import styled from 'styled-components';
import { FooterNavData, FooterSNSData } from '../../data/staticData/FooterStaticData';
import { useLocation } from 'react-router-dom';

export const Footer = () => {
  const location = useLocation();
  const currentUrl = location.pathname;
  const noFooterUrlPathList = ['/users/signup', '/users/login', '/users/logout'];

  return noFooterUrlPathList.includes(currentUrl) || (
    <StyledFooter>
      <StyledFooterContainer>
        <StyledFooterLeft></StyledFooterLeft>
        <StyledFooterNav>
          {FooterNavData.map((el, idx) => {
            return (
              <StyledFooterNavWrapper key={idx}>
                <StyledFooterNavTitle>
                  <a 
                    href={el.title.link} 
                    target='_blank' 
                    rel='noreferrer'
                  >
                    {el.title.name}
                  </a>
                </StyledFooterNavTitle>
                {el.content.map((ele, idx) => {
                  return (
                    <StyledFooterNavContents key={idx}>
                      <StyledFooterNavContent>
                        <a 
                          href={ele.link} 
                          target='_blank' 
                          rel='noreferrer'
                        >
                          {ele.name}
                        </a>
                        </StyledFooterNavContent>
                    </StyledFooterNavContents>
                  )
                })}
              </StyledFooterNavWrapper>
            );
          })}
        </StyledFooterNav>
        <StyledFooterRight>
          <StyledFooterRightSNSWrapper>
            {FooterSNSData.map((el, idx) => {
              return (
                <StyledFooterRightSNS key={idx}>
                  <a 
                    href={el.link} 
                    target='_blank' 
                    rel='noreferrer'
                  >{el.name}</a>
                </StyledFooterRightSNS>
              )
            })}
          </StyledFooterRightSNSWrapper>
          <StyledFooterRightCopyright>
            Site design / logo © 2022 Stack Exchange Inc; 
            user contributions licensed under 
            <span>
              <a 
                href='https://stackoverflow.com/help/licensing'
                target='_black' 
                rel='noreferrer'
              >
              CC BY-SA
              </a>
            </span>. 
            <span>rev 2022.12.21.43127</span>
          </StyledFooterRightCopyright>
        </StyledFooterRight>
      </StyledFooterContainer>
    </StyledFooter>
  )
}

const StyledFooter = styled.footer`
  width:100%;
  background-color: #232629;
`;

const StyledFooterContainer = styled.div`
  width: 126.4rem;
  height: 32.2rem;
  padding: 3.2rem 1.2rem 1.2rem;
  margin: 0 auto;
  display:flex;
  flex-flow:row wrap;

  & * {
    font-size: 1.3rem;
  }
`;

const StyledFooterLeft = styled.div`
  flex: 0 0 6.4rem;
  margin: -1.2rem 0 3.2rem;
`;

const StyledFooterNav = styled.nav`
  flex: 2 1 auto;
  flex-wrap: wrap;
  display:flex;
`;

const StyledFooterNavWrapper = styled.div`
  flex: 1 0 auto;
  padding: 0 1.2rem 2.4rem 0;
`;

const StyledFooterNavTitle = styled.h5`
  font-weight: bold;
  margin-bottom: 1.2rem;

  & > a {
    text-decoration: none;
    color: #BABFC4;
  };
`;

const StyledFooterNavContents = styled.ul`
  list-style: none;
`;

const StyledFooterNavContent = styled.li`
  & > a {
    color: #9199A1;
    padding: 0.4rem 0;
    text-decoration: none;
    display:inline-block;
  };
`;

const StyledFooterRight = styled.div`
  flex: 1 1 15rem;
  display:flex;
  flex-direction: column;
`;

const StyledFooterRightSNSWrapper = styled.ul`
  display: flex;
  list-style: none;
`;

const StyledFooterRightSNS = styled.li`
  font-size:1.1rem;
  & > a {
    color: #9199A1;
    margin-right: 1.2rem;
    text-decoration: none;
    display:inline-block;
    font-size:1.1rem;
  }
`;

const StyledFooterRightCopyright = styled.p`
  margin: auto 0 2.4rem;
  color: #9199A1;
  font-size:1.1rem;

  & > span > a {
    text-decoration: underline;
    color: #9199A1;
    font-size:1.1rem;
  }

  & > span:last-child {
    font-size:1.1rem;
    display:block;
  }
`;