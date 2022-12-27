import styled from "styled-components";
import { StyledInput } from "../atoms/SearchBar";
import { MainLeftNavBar } from "./NavBar";
import { StyledTitle } from "./UserSettingsDeleteProfile";

const MainBody = styled.div`
  width: 111rem;
  height: 163.2rem;
  display: flex;
`

const MainLeft = styled.div`
  width: 34.2rem;
  height: 162.1rem;
`

const MainRight = styled.div`
  width: 75.5rem;
  height: 162.1rem;
  border: 0.1rem solid blue;
`

const StyledFormContainer = styled.form`
  width: 74.3rem;
`
const InputLabel = ({props}) => {
  return (
    <div>
      <div>{props.title}</div>
      <StyledInput/>
    </div>
  )
}

const StyledDiv = styled.div`
  width: 100%;
  border: 0.1rem solid #e3e6e8;
  border-radius: 0.3rem;
`

export const UserEditForm = () => {
  return (
    <StyledFormContainer>
      <div>Pubic information</div>
      <StyledDiv>
        <div>
          <div>
            <label></label>
          </div>
          <div>
            <img></img>
          </div>
        </div>
        <div>
          <InputLabel/>
        </div>
      </StyledDiv>
    </StyledFormContainer>
  );

}


export const UserSettingsEditProfile = () => {
  return (
    <div>
      <MainBody>
        <MainLeft>
          <MainLeftNavBar/>
        </MainLeft>
        <MainRight>
          <StyledTitle/>

        </MainRight>
      </MainBody>
    </div>
  )
}