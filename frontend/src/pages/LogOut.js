import styled from "styled-components";
import { otherSiteLink } from '../data/staticData/LogOutStaticData';
import { useNavigate } from "react-router-dom";
import { Button } from '../components/atoms/Button';
import { useDispatch } from 'react-redux';
import { loginStatusSlice, loginUserInfoSlice } from '../ducks/slice';

const LogOut = () => {
  const navigate = useNavigate();
  const dispatch = useDispatch();

  const LogOutButtonClick = () => {
    dispatch(loginStatusSlice.logout());
    dispatch(loginUserInfoSlice.getLoginUser({}));
    navigate('/');
  }

  const CancelButtonClick = () => {
    navigate('/');
  };

  return (
    <StyledLogOut>
      <StyledLogOutContainer>
        <StyledLogOutComment>
          Clicking “Log out” will log you out of the following domains on this device:
        </StyledLogOutComment>
        <StyledLogOutForm>
          <StyledOtherSiteList>
            {otherSiteLink.map((el, idx) => {
              return (
                <li key={idx}>
                  <a href={el.link}>
                    {el.title}
                  </a>
                </li>
              )
            })}
          </StyledOtherSiteList>
          <StyledLogOutCheckBox>
            <input id='allLogOut' type='checkbox' />
            <label htmlFor='allLogOut'>Log out on all devices</label>
          </StyledLogOutCheckBox>
          <StyledButtonWrapper>
            <Button 
              buttonType='type2'
              buttonName='Log out'
              width='6.856rem'
              height='3.78rem'
              margin='0.2rem'
              onClick={LogOutButtonClick}
            />
            <Button 
              buttonType='type4'
              buttonName='Cancel'
              width='6.439rem'
              height='3.78rem'
              margin='0.2rem'
              onClick={CancelButtonClick}
            />
          </StyledButtonWrapper>
          <StyledLogOutFooter>
            If you’re on a shared computer, remember to log out of your Open ID provider (Facebook, Google, Stack Exchange, etc.) as well.
          </StyledLogOutFooter>
        </StyledLogOutForm>
      </StyledLogOutContainer>
    </StyledLogOut>
  )
};

export default LogOut;


const StyledLogOut = styled.div`
  width: inherit;
  min-height: inherit;
  display:flex;
  justify-content: center;
  align-items: center;
`;

const StyledLogOutContainer = styled.div`
  width: 52.6656rem;
`;

const StyledLogOutComment = styled.div`
  margin-bottom: 2.4rem;
  font-size: 2.2rem;
  color: #232629;
  text-align:center;
`;

const StyledLogOutForm = styled.div`
  width:31.6rem;
  padding: 2.4rem;
  margin: 0 auto;
  margin-bottom: 2.4rem;
  box-shadow: 0 1rem 2.4rem hsla(0,0%,0%,0.05), 
    0 2rem 4.8rem hsla(0, 0%, 0%, 0.05), 0 0.1rem 0.4rem hsla(0, 0%, 0%, 0.1);
  border-radius: 0.7rem;
`;

const StyledOtherSiteList = styled.ul`
  list-style: none;
  padding-bottom: 1.2rem;
  border-bottom: 0.1rem solid #D6D9DC;
  margin-bottom: 1.6rem;

  display:flex;
  flex-direction: column;
  align-items: center;

  & > li {
    width: 100%;
    display: flex;
    align-items: center;
    margin: 0.4rem 0;

    & > a {
      text-decoration: none;
      font-size: 1.5rem;
      color: #0074CC;
    }
  }
`;

const StyledLogOutCheckBox = styled.div`
  margin-bottom: 1.6rem;
  display: flex;
  align-items: center;

  & > label {
    font-size: 1.2rem;
    color: #0C0D0E;
    margin-left: 0.4rem;
  }
`;

const StyledButtonWrapper = styled.div`
  width: 100%;
  display: flex;
`;

const StyledLogOutFooter = styled.div`
  margin-top: 3.2rem;
  color: #6A737C;
  font-size: 1.2rem;
`;