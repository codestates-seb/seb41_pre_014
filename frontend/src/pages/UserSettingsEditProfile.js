import styled from "styled-components";
import { InputLabel, EditorInput } from "../components/blocks/EditorInputWrapper";
import { StyledInput } from "../components/atoms/SearchBar";
import { Button } from "../components/atoms/Button";
import '@toast-ui/editor/dist/toastui-editor.css';
import { Editor } from '@toast-ui/react-editor';

const StyledTitle = styled.div`
  border-bottom: 0.1rem solid #e3e6e8;
  margin-bottom: 2.4rem;
  padding-bottom: 1.6rem;
`

const StyledH1 = styled.h1`
  font-size: 2.7rem;
`
const UserEditFormContainer = styled.div`
`
const UserEditFormTitle = styled.div`
  font-size: 2.1rem;
  margin-bottom: 0.8rem;
  display: flex;
  align-items: center;
`

const UserEditFormWrapper = styled.div`
  padding: 2.4rem;
  border: 0.1rem solid rgb(214, 217, 220);
  border-radius: 0.3rem;
  & > div {
    display: flex;
  }
  margin-bottom: 4.8rem;
`

const UserEditInputWrapper = styled.div`
  display: flex;
  flex-direction: column;
  margin: 0.7rem;
  flex-grow: 1;
`

const UserEditInputLabel = styled.label`
  font-size: 1.5rem;
  font-weight: bold;
  margin-bottom: 0.8rem;
`

const UserEditInput = styled(StyledInput)`
  background: ${props => props.background || 'none'};
  width: ${props => props.width || '42.2rem'};
  padding: ${props => props.padding || '0.78rem 0.91rem'};
`

const GithubLinkInput = styled(StyledInput)`
  background: transparent url('data:image/svg+xml,%3Csvg xmlns="http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg" width="18" height="18" preserveAspectRatio="xMidYMid meet" viewBox="0 0 24 24"%3E%3Cpath fill="%236a737c" d="M12 2A10 10 0 0 0 2 12c0 4.42 2.87 8.17 6.84 9.5c.5.08.66-.23.66-.5v-1.69c-2.77.6-3.36-1.34-3.36-1.34c-.46-1.16-1.11-1.47-1.11-1.47c-.91-.62.07-.6.07-.6c1 .07 1.53 1.03 1.53 1.03c.87 1.52 2.34 1.07 2.91.83c.09-.65.35-1.09.63-1.34c-2.22-.25-4.55-1.11-4.55-4.92c0-1.11.38-2 1.03-2.71c-.1-.25-.45-1.29.1-2.64c0 0 .84-.27 2.75 1.02c.79-.22 1.65-.33 2.5-.33c.85 0 1.71.11 2.5.33c1.91-1.29 2.75-1.02 2.75-1.02c.55 1.35.2 2.39.1 2.64c.65.71 1.03 1.6 1.03 2.71c0 3.82-2.34 4.66-4.57 4.91c.36.31.69.92.69 1.85V21c0 .27.16.59.67.5C19.14 20.16 22 16.42 22 12A10 10 0 0 0 12 2Z"%2F%3E%3C%2Fsvg%3E')
    no-repeat 1rem center;
  width: ${props => props.width || '42.2rem'};
`

const TwitterLinkInput = styled(StyledInput)`
  background: transparent url('data:image/svg+xml,%3Csvg xmlns="http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg" width="18" height="18" preserveAspectRatio="xMidYMid meet" viewBox="0 0 24 24"%3E%3Cpath fill="%236a737c" d="M8.283 20.263c7.547 0 11.676-6.259 11.676-11.677c0-.176 0-.352-.008-.528A8.36 8.36 0 0 0 22 5.928a8.317 8.317 0 0 1-2.36.649a4.129 4.129 0 0 0 1.808-2.273a8.163 8.163 0 0 1-2.61.993A4.096 4.096 0 0 0 15.847 4a4.109 4.109 0 0 0-4.106 4.106c0 .32.04.632.104.936a11.654 11.654 0 0 1-8.46-4.29a4.115 4.115 0 0 0 1.273 5.482A4.151 4.151 0 0 1 2.8 9.722v.056a4.113 4.113 0 0 0 3.29 4.026a4.001 4.001 0 0 1-1.08.144c-.265 0-.521-.024-.77-.072a4.104 4.104 0 0 0 3.834 2.85a8.231 8.231 0 0 1-5.098 1.76c-.328 0-.656-.016-.976-.056a11.674 11.674 0 0 0 6.283 1.833"%2F%3E%3C%2Fsvg%3E')
    no-repeat 1rem center;
  width: ${props => props.width || '42.2rem'}; 
`

const WebsiteLinkInput = styled(StyledInput)`
  background: transparent url('data:image/svg+xml,%3Csvg xmlns="http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg" width="18" height="18" preserveAspectRatio="xMidYMid meet" viewBox="0 0 24 24"%3E%3Cpath fill="%236a737c" d="m13.06 8.11l1.415 1.415a7 7 0 0 1 0 9.9l-.354.353a7 7 0 0 1-9.9-9.9l1.415 1.415a5 5 0 1 0 7.071 7.071l.354-.354a5 5 0 0 0 0-7.07l-1.415-1.415l1.415-1.414zm6.718 6.011l-1.414-1.414a5 5 0 1 0-7.071-7.071l-.354.354a5 5 0 0 0 0 7.07l1.415 1.415l-1.415 1.414l-1.414-1.414a7 7 0 0 1 0-9.9l.354-.353a7 7 0 0 1 9.9 9.9z"%2F%3E%3C%2Fsvg%3E')
    no-repeat 1rem center;
  width: ${props => props.width || '42.2rem'}; 
`

const StyledImg = styled.img`
  width: 16.4rem;
  height: 16.4rem;
` 

const ProfileImageWrapper = styled.div`
  display: flex;
  flex-direction: column;
  margin-left: 0.7rem;
`

const StyledDiv = styled.div`
  margin-left: 1.2rem;
`

const LabeledInput = (props) => {
  return (
  <UserEditInputWrapper>
    <UserEditInputLabel>{props.label}</UserEditInputLabel>
    <UserEditInput 
    placeholder={props.placeholder}
    width={props.width}
    padding={props.padding}/>
  </UserEditInputWrapper>
  )
}

const GithubInput = (props) => {
  return (
    <UserEditInputWrapper>
    <UserEditInputLabel>{props.label}</UserEditInputLabel>
    <GithubLinkInput 
    placeholder={props.placeholder}
    width={props.width}
    />
  </UserEditInputWrapper>
  )
}

const TwitterInput = (props) => {
  return (
    <UserEditInputWrapper>
    <UserEditInputLabel>{props.label}</UserEditInputLabel>
    <TwitterLinkInput 
    className={props.type}
    placeholder={props.placeholder}
    width={props.width}
    />
  </UserEditInputWrapper>
  )
}

const WebsiteInput = (props) => {
  return (
    <UserEditInputWrapper>
    <UserEditInputLabel>{props.label}</UserEditInputLabel>
    <WebsiteLinkInput 
    className={props.type}
    placeholder={props.placeholder}
    width={props.width}
    />
  </UserEditInputWrapper>
  )
}

const AboutmeWrapper = styled.div`
  display: flex;
  flex-direction: column;
  margin-left: 0.7rem;
`

const UserSettingsEditProfile = (props) => {
  return (
    <>
      <StyledTitle>
        <StyledH1>Edit your profile</StyledH1>
      </StyledTitle>
      <UserEditFormContainer>
        <UserEditFormTitle>Public information</UserEditFormTitle>
        <UserEditFormWrapper>
          <ProfileImageWrapper>
            <UserEditInputLabel>Profile image</UserEditInputLabel>
            <StyledImg
              src={props.profileImageUrl}
              alt="user avatar"
            ></StyledImg>
          </ProfileImageWrapper>
          <LabeledInput label="Display name" />
          <LabeledInput label="Location" />
          <LabeledInput label="Title" placeholder="No title has been set" />
          <AboutmeWrapper>
            <InputLabel title="About me" />
            <EditorInput />
          </AboutmeWrapper>
        </UserEditFormWrapper>
      </UserEditFormContainer>
      <UserEditFormContainer>
        <UserEditFormTitle>Links</UserEditFormTitle>
        <UserEditFormWrapper>
          <div>
            <WebsiteInput width="32rem" label="Website link" />
            <TwitterInput width="32rem" label="Twitter link or username" />
            <GithubInput width="32rem" label="Github link or username" />
          </div>
        </UserEditFormWrapper>
      </UserEditFormContainer>
      <UserEditFormContainer>
        <UserEditFormTitle>
          Private information
          <StyledDiv>Not shown publicly</StyledDiv>
        </UserEditFormTitle>
        <UserEditFormWrapper>
          <LabeledInput label="Full name" />
        </UserEditFormWrapper>
      </UserEditFormContainer>
      <div>
        <Button
          buttonType="type2"
          buttonName="Save profile"
          width="9rem"
          height="3.8rem"
          margin="0.4rem"
        />
        <Button
          buttonType="type4"
          buttonName="Cancel"
          width="6rem"
          height="3.8rem"
          margin="0.4rem"
        />
      </div>
    </>
  );
};

export default UserSettingsEditProfile;