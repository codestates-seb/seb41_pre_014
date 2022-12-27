import styled from "styled-components";
import { Link, useNavigate } from "react-router-dom";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faArrowUpRightFromSquare } from '@fortawesome/free-solid-svg-icons';
import { useform } from 'react-hook-form';

import { Button, SNSLoginButton } from '../components/atoms/Button'; 

const StyledLogin = styled.div`
  width: inherit;
  min-height: inherit;
  display: flex;
  justify-content: center;
`;

const StyledLoginContainer = styled.section`
  width: 28.8445rem;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
`;

const StyledLogoIcon = styled.div`
  margin-bottom: 2.4rem;
  background-color: transparent;
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;

  & > a {
    width: 3.2rem;
    height: 3.7rem;
    background-image: url('/image/sprites.svg');
    background-position: 0rem -0.75rem;
  }
`;

const SNSLoginButtonWrapper = styled.div`
  margin: -0.4rem 0 1.6rem;
  width:100%;
  display:flex;
  flex-direction: column;

  & > button {
    flex: 1 auto;
    padding: 1.04rem;
    margin: 0.4rem 0;
    font-size: 1.3rem;
    color: #3b4045;
  }
`;

const LoginFormWrapper = styled.form`
  width:100%;
  padding: 2.4rem;
  margin-bottom: 2.4rem;
  box-shadow: 0 1rem 2.4rem hsla(0,0%,0%,0.05)
  , 0 2rem 4.8rem hsla(0, 0%, 0%, 0.05)
  , 0 0.1rem 0.4rem hsla(0, 0%, 0%, 0.1);
  border-radius: 0.7rem;

  & > div {
    display: flex;
    flex-direction: column;
    margin: 0.6rem 0;

    & > label {
      font-size: 1.5rem;
      font-weight: 600;
      color: #0C0D0E;
      margin: 0.2rem 0;
      padding: 0 0.2rem;
    };

    & > input {
      margin: 0.2rem 0;
      padding: 0.78rem 0.91rem;
      border: 0.1rem solid #BABFC4;
      border-radius: 0.3rem;
      font-size: 1.3rem;
    }
  }
`;

const LoginFooter = styled.div`
  padding: 1.6rem;
  margin-bottom: 2.4rem;
  font-size: 1.3rem;
  color: #232629;
  text-align:center;

  & * {
    font-size: 1.3rem;
    color: #232629;
  }

  & > a {
    text-decoration: none;
    color: #0074CC;
    margin-left: 0.5rem;
  }

  & > div {
    margin-top: 1.2rem;

    & > a {
      text-decoration: none;
      color: #0074CC;
      margin-left: 0.5rem;

      & > svg {
        margin-left: 0.5rem;
        & > path {
          color: #0074CC;
        };
      };
    };
  };
`;

const Login = () => {
  const navigate = useNavigate();
  const LogoEventHandler = (e) => {
    e.preventDefault();
    navigate('/');
  }

  return (
    <StyledLogin>
      <StyledLoginContainer>
        <StyledLogoIcon>
          <a href='#none' onClick={e => LogoEventHandler(e)}> </a>
        </StyledLogoIcon>
        <SNSLoginButtonWrapper>
          <SNSLoginButton 
            buttonType='google' 
            buttonName='Log in with Google' 
          />
          <SNSLoginButton 
            buttonType='github' 
            buttonName='Log in with GitHub' 
          />
          <SNSLoginButton 
            buttonType='facebook' 
            buttonName='Log in with Facebook' 
          />
        </SNSLoginButtonWrapper>
        <LoginFormWrapper>
          <div>
            <label htmlFor='email'>Email</label>
            <input id='email'></input>
          </div>
          <div>
            <label htmlFor='password'>Password</label>
            <input id='password'></input>
          </div>
          <Button 
            buttonType='type2' 
            buttonName='Log in' 
            width='100%'
            height='auto'
            padding='1.04rem'
            margin='0.8rem 0'
          ></Button>
        </LoginFormWrapper>
        <LoginFooter>
          Don't have an account? 
          <Link to='/users/signup'>Sign up</Link>
          <div>Are you an employer? 
            <a href='https://talent.stackoverflow.com/users/login'>
              Sign up on Talent
              <FontAwesomeIcon icon={faArrowUpRightFromSquare} />
            </a>
          </div>
        </LoginFooter>
      </StyledLoginContainer>
    </StyledLogin>
  )
};



export default Login;