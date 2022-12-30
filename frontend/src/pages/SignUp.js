import styled from "styled-components";
import { Link } from "react-router-dom";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faMessage, faSort, faTags, faTrophy, faArrowUpRightFromSquare } from '@fortawesome/free-solid-svg-icons';
import { Button, SNSLoginButton } from "../components/atoms/Button";
import ReCAPTCHA from 'react-google-recaptcha';

const StyledSignUp = styled.div`
  width: inherit;
  min-height: inherit;
  display: flex;
  justify-content: center;
  align-items: center;
`;

const StyledTextBox = styled.section`
  margin: 0 4.8rem 12.8rem 0;
`;

const Styledh1 = styled.h1`
  font-size: 2.7rem;
  margin-bottom: 3.2rem;
  color: #232629;
`;

const StyledTextList = styled.div`
  display:flex;
  align-items: center;
  margin-bottom: 2.4rem;
`;

const StyledTextIcon = styled.div`
    width: 2.6rem;
    height: 2.6rem;
    margin-right: 0.5rem;
    text-align: center;
    & > svg {
      font-size: ${props => props.fontSize || '2.2rem'};
      color: #0A95FF;
    }
`;

const StyledText = styled.div`
  font-size: 1.5rem;
  color: #232629;
`;

const StyledTextFooter = styled.div`
  font-size: 1.3rem;
  color: #6A737C;

  & > a {
    display: block;
    font-size: inherit;
    text-decoration: none;
    color: #0074CC;
  }
`;

const StyledSignUpContainer = styled.section`
  width: 34.8rem;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
`;

const StyledSNSSignUpButtonWrapper = styled.div`
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

const StyledSignUpFormBox = styled.form`
  width:100%;
  padding: 2.4rem;
  margin-bottom: 2.4rem;
  box-shadow: 0 1rem 2.4rem hsla(0,0%,0%,0.05)
  , 0 2rem 4.8rem hsla(0, 0%, 0%, 0.05)
  , 0 0.1rem 0.4rem hsla(0, 0%, 0%, 0.1);
  border-radius: 0.7rem;
`;

const StyledSignUpFormWrapper = styled.div`
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
  };

  & > div {
    font-size: 1.2rem;
    color: #6A737C;
    margin: 0.4rem 0;
  };
`;

const StyledCaptchaBox = styled.div`
  margin: 0.6rem 0;
`;

const Captcha = () => {
  function onChange(value) {
    console.log('Captcha value:', value);
  }
  return (
    <div>
      <ReCAPTCHA
        sitekey={process.env.REACT_APP_RECAPTCHA_KEY}
        onChange={onChange}
        data-size='20rem 8rem'
      />
    </div>
  );
};

const StyledFormBoxFooter = styled.div`
  width:100%;
  margin-top: 3.2rem;
  font-size: 1.2rem;
  color: #6A737C;

  & > a {
    width:100%;
    font-size: 1.2rem;
    color: #0074CC;
  }
`;

const StyledSignUpFooter = styled.div`
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

const SignUp = () => {

  return (
    <StyledSignUp>
      <StyledTextBox>
        <Styledh1>Join the Stack Overflow community</Styledh1>
        <StyledTextList>
          <StyledTextIcon fontSize='2.0rem'>
            <FontAwesomeIcon icon={faMessage} />
          </StyledTextIcon>
          <StyledText>
            Get unstuck - ask a question
          </StyledText>
        </StyledTextList>
        <StyledTextList>
        <StyledTextIcon fontSize='2.6rem'>
          <FontAwesomeIcon icon={faSort} />
        </StyledTextIcon>
          <StyledText>
            Unlock new privileges like voting and commenting
          </StyledText>
        </StyledTextList>
        <StyledTextList>
        <StyledTextIcon>
          <FontAwesomeIcon icon={faTags} />
        </StyledTextIcon>
          <StyledText>
            Save your favorite tags, filters, and jobs
          </StyledText>
        </StyledTextList>
        <StyledTextList>
        <StyledTextIcon>
          <FontAwesomeIcon icon={faTrophy} />
        </StyledTextIcon>
          <StyledText>
            Earn reputation and badges
          </StyledText>
        </StyledTextList>
        <StyledTextFooter>
          Collaborate and share knowledge with a private group for FREE.
          <a 
            href='https://stackoverflow.co/teams/?utm_source=so-owned&utm_medium=product&utm_campaign=free-50&utm_content=public-sign-up'
            target='_blank'
            rel='noreferrer'  
          >
            Get Stack Overflow for Teams free for up to 50 users.
          </a>
        </StyledTextFooter>
      </StyledTextBox>
      <StyledSignUpContainer>
        <StyledSNSSignUpButtonWrapper>
        <SNSLoginButton 
            buttonType='google' 
            buttonName='Sign up with Google' 
          />
          <SNSLoginButton 
            buttonType='github' 
            buttonName='Sign up with GitHub' 
          />
          <SNSLoginButton 
            buttonType='facebook' 
            buttonName='Sign up with Facebook' 
          />
        </StyledSNSSignUpButtonWrapper>
        <StyledSignUpFormBox>
          <StyledSignUpFormWrapper>
            <label htmlFor='DisplayName'>Display name</label>
            <input id='DisplayName'></input>
          </StyledSignUpFormWrapper>
          <StyledSignUpFormWrapper>
            <label htmlFor='email'>Email</label>
            <input id='email'></input>
          </StyledSignUpFormWrapper>
          <StyledSignUpFormWrapper>
            <label htmlFor='password'>Password</label>
            <input id='password'></input>
            <div>Passwords must contain at least eight characters, 
              including at least 1 letter and 1 number.</div>
          </StyledSignUpFormWrapper>
          <StyledCaptchaBox>
            <Captcha />
          </StyledCaptchaBox>
          <Button 
            buttonType='type2' 
            buttonName='Sign up' 
            width='100%'
            height='auto'
            padding='1.04rem'
            margin='0.8rem 0'
          ></Button>
          <StyledFormBoxFooter>
            By clicking “Sign up”, you agree to our &nbsp;
            <a 
              href='https://stackoverflow.com/legal/terms-of-service/public'
              target='_blank'
              rel='noreferrer'>terms of service</a>, &nbsp;
            <a
              href='https://stackoverflow.com/legal/privacy-policy'
              target='_blank'
              rel='noreferrer'>privacy policy</a> and &nbsp;
            <a
              href='https://stackoverflow.com/legal/cookie-policy'
              target='_blank'
              rel='noreferrer'>cookie policy</a>
          </StyledFormBoxFooter>
        </StyledSignUpFormBox>
        <StyledSignUpFooter>
          Already have an account? 
            <Link to='/users/login'>Log in</Link>
            <div>Are you an employer? 
              <a href='https://talent.stackoverflow.com/users/login'>
                Sign up on Talent
                <FontAwesomeIcon icon={faArrowUpRightFromSquare} />
              </a>
            </div>
        </StyledSignUpFooter>
      </StyledSignUpContainer>
    </StyledSignUp>
  )
};

export default SignUp;