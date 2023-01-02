import styled from 'styled-components';
import { useEffect, useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faMagnifyingGlass, faUnlockKeyhole } from '@fortawesome/free-solid-svg-icons';
import { Button } from '../components/atoms/Button';
import { HeaderEl3Data, Section1Data } from '../data/staticData/HomeStaticData';

const Home = () => {
  const navigate = useNavigate();
  const LinkToSignUpEventHandler = () => {
    navigate('/users/signup');
  };

  const [headerEl2TextIdx, setHeaderEl2TextIdx] = useState(0);
  const headerEl2TextList = [
    'developer',
    'data scientist', 
    'system admin', 
    'mobile developer', 
    'game developer'
  ];

  useEffect(()=>{
    const timer = setInterval(()=>{
      setHeaderEl2TextIdx(headerEl2TextIdx => {
        return headerEl2TextIdx >= headerEl2TextList.length-1
        ? 0 : headerEl2TextIdx + 1
      });
    },1500);
    return () => clearInterval(timer);
  }, [headerEl2TextList.length]);

  return (
    <>
      <StyledHomeHeader>
        <StyledHomeHeaderWrapper>
          <StyledHomeHeaderEl1>
            <StyledHeaderE1Left>
              <div>
                <FontAwesomeIcon icon={faMagnifyingGlass} />
                <h2>Find the best answer to your technical question, 
                  help others answer theirs</h2>
                <Button 
                  buttonType='type1' 
                  buttonName='Join the community'
                  fontWeight='700'
                  width='21.066rem'
                  onClick={LinkToSignUpEventHandler}
                />
                <p>or <Link to='/board'>search content</Link></p>
              </div>
            </StyledHeaderE1Left>
            <StyledHeaderE1Right>
              <div>
                <FontAwesomeIcon icon={faUnlockKeyhole} />
                <h2>Want a secure, private space for your technical knowledge?</h2>
                <Button 
                  buttonType='type2' 
                  buttonName='Discover Teams'
                  fontWeight='700'
                  width='21.066rem'
                  boxShadow='none'
                  onClick={() => window.open('https://stackoverflow.co/teams/', '_blank')}
                />
              </div>
            </StyledHeaderE1Right>
          </StyledHomeHeaderEl1>
          <StyledHomeHeaderEl2>
            Every <span>{headerEl2TextList[headerEl2TextIdx]}</span> has a 
            <br />tab open to Stack Overflow
          </StyledHomeHeaderEl2>
          <StyledHomeHeaderSplitLine />
          <StyledHomeHeaderEl3>
            {HeaderEl3Data.map((el,idx) => {
              return (
                <div key={idx}>
                  <StyledHeaderEl3Title>{el.title}</StyledHeaderEl3Title>
                  <StyledHeaderEl3Content>{el.content}</StyledHeaderEl3Content>
                </div>
              )
            })}
          </StyledHomeHeaderEl3>
        </StyledHomeHeaderWrapper>
      </StyledHomeHeader>
      <StyledHomeSection1>
        <div>
          <div>
            <StyledSection1Left>
              <Link to='/board'>
                <StyledLogoIcon />Stack<b>overflow</b>
              </Link>
              <StyledSection1LeftImg />
              <StyledSection1Title>{Section1Data[0].title}</StyledSection1Title>
              <StyledSection1Content>{Section1Data[0].content}</StyledSection1Content>
              <Button 
                  buttonType='type1' 
                  buttonName='Join the community'
                  fontWeight='700'
                  width='21.066rem'
                  onClick={LinkToSignUpEventHandler}
                />
                <p>or <Link to='/board'>search content</Link></p>
            </StyledSection1Left>
          </div>
          <div>
            <StyledSection1Right>
              <a 
                href='https://stackoverflow.co/teams/' 
                target='_blank'
                rel='noreferrer'
              >
                <StyledLogoIcon />
                <StyledBorderLine />
                <b>FOR TEAMS</b>
              </a>
              <StyledSection1RightImg />
              <StyledSection1Title>{Section1Data[1].title}</StyledSection1Title>
              <StyledSection1Content>{Section1Data[1].content}</StyledSection1Content>
              <StyledSection1GSWrapper>
                  <span />
                  Get started
                  <span />
              </StyledSection1GSWrapper>
              <StyledSection1ButtonWrapper>
                <Button 
                  buttonType='type2' 
                  buttonName='For large organizations'
                  fontWeight='700'
                  width='19.427rem'
                  boxShadow='none'
                  onClick={() => 
                    window.open('https://stackoverflow.co/explore-teams/', '_blank')
                  }
                />
                <Button 
                  buttonType='type2' 
                  buttonName='For small Teams'
                  fontWeight='700'
                  width='14.867rem'
                  boxShadow='none'
                  margin='0 0 0 0.5rem'
                  onClick={() => 
                    window.open('https://stackoverflow.co/teams/', '_blank')
                  }
                />
              </StyledSection1ButtonWrapper>
            </StyledSection1Right>
          </div>
        </div>
      </StyledHomeSection1>
      <StyledHomeSection2>
        <StyledSection2Title>
          Thousands of organizations around the globe use Stack Overflow for Teams
        </StyledSection2Title>
        <StyledSection2LogoList>
          <StyledSection2LogoBox>
            <MicrosoftLogo />
          </StyledSection2LogoBox>
          <StyledSection2LogoBox>
            <ChevronLogo />
          </StyledSection2LogoBox>
          <StyledSection2LogoBox>
            <DialpadLogo />
          </StyledSection2LogoBox>
          <StyledSection2LogoBox>
            <WisetechLogo />
          </StyledSection2LogoBox>
        </StyledSection2LogoList>
        <StyledSection2Pagination>
          <StyledSection2Page />
          <StyledSection2Page />
          <StyledSection2Page />
          <StyledSection2Page />
        </StyledSection2Pagination>
      </StyledHomeSection2>
    </>
  )
};

export default Home;

// ---------- Header 부분 ---------- //
const StyledHomeHeader = styled.header`
  max-width: 195rem;
  padding: 2.4rem;
  margin: 0 auto;
  border-top-left-radius: 0.7rem;
  border-top-right-radius: 0.7rem;
  position: relative;
  text-align: center;
`;

// clip-path에 대해서 알아봐야 할 듯
const StyledHomeHeaderWrapper = styled.div`
  background: linear-gradient(180deg, #232629 0%, #525960 130%);
  -webkit-font-smoothing: antialiased;
  position: relative;
  border-radius: 0.7rem;
  color: hsl(210,8%,97.5%);
  padding: 3.2rem 3.2rem 12.8rem;
  margin: 0 0 -12.8rem;
`;

const StyledHomeHeaderEl1 = styled.div`
  display: flex;
  margin: 0 auto;
  width: 94.8rem;

  & > div {
    flex-basis: 50%;
    padding: 1.6rem;

    & > div {
      height: 100%;
      padding: 2.4rem;
      position: relative;
      border-top-left-radius: 0.7rem;
      border-top-right-radius: 0.7rem;
      color: #232629;
      
      & > svg {
        width: 4.8rem;
        height: 4.8rem;
        margin-bottom: 1.6rem;

        & > path {
          font-size: 4.8rem;
        };
      };

      & > h2 {
        font-size: 1.9rem;
        color: #232629;
        margin: 0 3.9rem 1.9rem;
        font-weight: normal;
      };

      & > p {
        margin-top: 1.2rem;
        font-size: 1.3rem;
        color: #525960;

        & > a {
          font-size: 1.3rem;
          color: #3B4045;
          text-decoration: underline;
        }
      };
    }
  }
`;

const StyledHeaderE1Left = styled.div`
  & > div {
    background-color: #FEE3CD;
    border-bottom-left-radius: 0.7rem;

    & > svg > path {
      color: #F2740D;
    }

    &::after {
      clip-path: polygon(1.8rem 0, 3.2rem 0, 0 4rem, 0 3.8rem, 0 0, 1.8rem 0);
      transform: scaleX(-1);
      background: #FEE3CD;
      width: 3.2rem;
      height: 3.2rem;
      position: absolute;
      top: 99%;
      right: 0;
      display: block;
      content: '';
      border-radius: 0 0.5rem 0;
    };
  };
`;

const StyledHeaderE1Right = styled.div`
  & > div {
    background-color: #CDE9FE;
    border-bottom-right-radius: 0.7rem;

    & > svg > path {
      color: #0A95FF;
    }

    &::after {
      clip-path: polygon(1.8rem 0, 3.2rem 0, 0 4rem, 0 3.8rem, 0 0, 1.8rem 0);
      background: #CDE9FE;
      width: 3.2rem;
      height: 3.2rem;
      position: absolute;
      top: 99%;
      left: 0;
      display: block;
      content: '';
      border-radius: 0 0.5rem 0;
    };
  }
`;

// 부드럽게 변경되는 애니메이션 구현해보기
const StyledHomeHeaderEl2 = styled.h1`
  font-family: 'Roboto Slab Bold';
  padding: 6.4rem 0;
  font-weight: 700;
  font-size: 5.5rem;
  color: #F8F9F9;

  & > span {
    font-weight: 700;
    font-size: 5.5rem;
    color: #F2740D;
  }
`;

const StyledHomeHeaderSplitLine = styled.div`
  width: 6.4rem;
  height: 0.8rem;
  margin: 0 auto;
  background-color: #6A737C;
  border-radius: 100rem;
`;

const StyledHomeHeaderEl3 = styled.div`
  padding: 3.2rem 1.2rem 6.4rem;
  margin: 0 auto;
  display: flex;
  justify-content: center;

  & > div {
    flex-basis: 25%;
    padding: 3.2rem 0;
  }
`;

const StyledHeaderEl3Title = styled.div`
  font-size: 2.1rem;
  font-weight: 700;
  color: #F8F9F9;
  margin-bottom: 0.4rem;
`;

const StyledHeaderEl3Content = styled.div`
  font-size: 1.5rem;
  color: #9FA6AD;
  padding: 0 2.4rem;
`;

// ---------- Section1 부분 ---------- //
const StyledHomeSection1 = styled.section`
  padding: 3.2rem;
  margin: 0 auto;
  margin-top: -12.8rem;
  position: relative;

  & > div {
    margin: 0 4.8rem;
    display:flex;
    justify-content: center;

    & > div {
      max-width: 55.2rem;
      padding: 1.6rem;
      flex-basis: 50%;

      & > div {
        padding: 4.8rem 0;
        box-shadow: 0 1.2rem 1.1rem rgb(0 0 0 / 4%), 0 10rem 8rem rgb(0 0 0 / 7%);
        border-radius: 0.7rem;
        display:flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;

        & > a {
          width: 100%;
          height: 4.8rem;
          display:flex;
          justify-content: center;
          align-items: end;
          text-decoration: none;
          font-size: 2rem;
          color: #232629;

          & > b {
            font-size: 2rem;
            color: #232629;
            font-weight: bold;
          };
        };

        & > p {
        margin-top: 1.2rem;
        font-size: 1.3rem;
        color: #838C95;
        height: 1.7rem;

          & > a {
            font-size: 1.3rem;
            color: #838C95;
            text-decoration: underline;
          }
        };
      };
    };
  };
`;

const StyledLogoIcon = styled.span`
  width: 3.2rem;
  height: 3.7rem;
  background-image: url('/image/sprites.svg');
  background-position: 0rem -0.75rem;
  margin-right: 0.5rem;
`;

const StyledBorderLine = styled.span`
  border-left: 1px solid #9d9d9d;
  height: 1.5rem;
  margin: 0 1rem 0.6rem;
`;

const StyledSection1Left = styled.div`
  background: linear-gradient(0deg, #FEE3CD 30%, #FFF);
`;

const StyledSection1LeftImg = styled.div`
  width: 52rem;
  height: 34.6rem;
  margin: 3.2rem 0;
  background: url('/image/homeSprites.png') -55rem -1rem;
`;

const StyledSection1Right = styled.div`
  background: linear-gradient(0deg, #CDE9FE 30%, #FFF);
`;

const StyledSection1RightImg = styled.div`
  width: 52rem;
  height: 34.6rem;
  margin: 3.2rem 0;
  background: url('/image/homeSprites.png') -1rem -1rem;

`;

const StyledSection1Title = styled.div`
  margin: 0 4.8rem 1.2rem;
  font-weight: 700;
  font-size: 2.7rem;
  color: #232629;
  text-align: center;
`;

const StyledSection1Content = styled.div`
  margin: 0 4.8rem 3.2rem;
  font-weight: 400;
  font-size: 1.9rem;
  color: #525960;
  text-align: center;
`;

const StyledSection1GSWrapper = styled.div`
  width: 21rem;
  height: 1.7rem;
  margin: 0 auto;
  margin-bottom: 1.2rem;
  font-size: 1.3rem;
  display:flex;
  justify-content: space-between;
  align-items: center;

  & > span {
    flex-basis: 33.333333333%;
    border-top: 1px solid hsl(206,90%,69.5%);
  }
`;

const StyledSection1ButtonWrapper = styled.div`
  display:flex;

`;

// ---------- Section2 부분 ---------- //
const StyledHomeSection2 = styled.section`
  padding: 9.6rem 0 6.4rem;
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items:center;
  justify-content: center;
`;

const StyledSection2Title = styled.div`
  margin-bottom: 1.9rem;
  font-size: 1.9rem;
  color: #6A737C;
`;

const StyledSection2LogoList = styled.div`
  width:100%;
  height: 10.5rem;
  padding: 0 6.4rem;
  display: flex;
  justify-content: center;
  align-items: center;
`;

const StyledSection2LogoBox = styled.div`
  display:flex;
  justify-content: center;
  align-items: center;
  padding: 0 1.6rem;
  margin: 0 1.2rem;
`;

const MicrosoftLogo = styled.div`
  width: 165px; 
  height: 36px;
  background: url('/image/homeSprites.png') -510px -621px;
`;
const ChevronLogo = styled.div`
  width: 49px; 
  height: 55px;
  background: url('/image/homeSprites.png') -350px -862px;
`;
const DialpadLogo = styled.div`
  width: 187px; 
  height: 37px;
  background: url('/image/homeSprites.png') -850px -376px;
`;
const WisetechLogo = styled.div`
  width: 139px; 
  height: 43px;
  background: url('/image/homeSprites.png') -509px -733px;
`;

const StyledSection2Pagination = styled.div`
  display:flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  padding: 1.2rem 0;
`;

const StyledSection2Page = styled.div`
  width: 2.4rem;
  height: 0.6rem;
  cursor: pointer;
  background-color: #BABFC4;
  margin: 0.6rem 0.4rem;
  border-radius: 100rem;

  &:hover {
    background-color: #838C95;
  }
`;

// ---------- Section3 부분 ---------- //
// const StyledHomeSection3 = styled.section``;