import styled from "styled-components";

const StyledTitle = styled.div`
  border-bottom: 0.1rem solid #e3e6e8;
`
const StyledH1 = styled.h1`
  font-size: 2.7rem;
`

const StyledCheckForm = styled.div`
  display: flex;
  margin-bottom: 1.65rem;
`
const StyledLabel = styled.div`
  font-size: 1.7rem;
  margin: 0.4rem;
`

const StyledGuideline = styled.div`
`

const StyledParagraph = styled.p`
  font-size: 1.7rem;
  margin-bottom: 1.65rem;;
`

const StyledListWrapper = styled.div`
  margin: 2rem;
`

const StyledLi = styled.li`
  font-size: 1.7rem;
`
const StyledCheckBoxWrapper = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
`

const StyledDeleteBtn = styled.button`
  width: 12rem;
  height: 4rem;
  font-size: 1.5rem;
  padding: 1rem;
  background-color: rgb(208, 57, 62);
  color: #fff;
  border: none;
  border-radius: 0.3rem;
`

const UserSettingsDeleteProfile = () => {
  return (
    <div>
      <StyledTitle>
        <StyledH1>Delete Profile</StyledH1>
      </StyledTitle>
      <StyledGuideline>
        <StyledParagraph>
          Before confirming that you would like your profile deleted, we'd like
          to take a moment to explain the implications of deletion:
        </StyledParagraph>
        <StyledListWrapper>
          <ul>
            <StyledLi>
              Deletion is irreversible, and you will have no way to regain any
              of your original content, should this deletion be carried out and
              you change your mind later on.
            </StyledLi>
            <StyledLi>
              Your questions and answers will remain on the site, but will be
              disassociated and anonymized (the author will be listed as
              "user20861592") and will not indicate your authorship even if you
              later return to the site.
            </StyledLi>
          </ul>
        </StyledListWrapper>
        <StyledParagraph>
          Confirming deletion will only delete your profile on Stack Overflow -
          it will not affect any of your other profiles on the Stack Exchange
          network. If you want to delete multiple profiles, you'll need to visit
          each site separately and request deletion of those individual
          profiles.
        </StyledParagraph>
        <form>
          <StyledCheckForm>
            <StyledCheckBoxWrapper>
              <input type="checkbox"></input>
            </StyledCheckBoxWrapper>
            <StyledLabel>
              I have read the information stated above and understand the
              implications of having my profile deleted. I wish to proceed with
              the deletion of my profile.
            </StyledLabel>
          </StyledCheckForm>
          <StyledDeleteBtn>Delete Profile</StyledDeleteBtn>
        </form>
      </StyledGuideline>
    </div>
  );
};

export default UserSettingsDeleteProfile;