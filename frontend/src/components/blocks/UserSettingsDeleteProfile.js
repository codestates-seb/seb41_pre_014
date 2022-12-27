import styled from "styled-components";

export const StyledTitle = styled.div`
  border-bottom: 0.1rem solid #e3e6e8;
`

export const StyledCheck = styled.div`
  display: flex;
`
export const StyledLabel = styled.div`
  margin: 0.4rem;
`

export const StyledGuideline = styled.div`
  font-size: 1.5rem;
`

export const UserSettingsDeleteProfile = () => {
  return (
    <div>
      <StyledTitle><h1>Delete Profile</h1></StyledTitle>
      <StyledGuideline>
        <p>
        Before confirming that you would like your profile deleted, 
        we'd like to take a moment to explain the implications of deletion:
        </p>
        <ul>
          <li>
            Deletion is irreversible, and you will have no way to regain any of your original content,
            should this deletion be carried out and you change your mind later on.</li>
          <li>
            Your questions and answers will remain on the site, but will be disassociated and anonymized (the author will be listed as "user20861592")
            and will not indicate your authorship even if you later return to the site.
          </li>
        </ul>
        <p>
          Confirming deletion will only delete your profile on Stack Overflow - it will not affect any of your other profiles on the Stack Exchange network.
          If you want to delete multiple profiles, you'll need to visit each site separately
          and request deletion of those individual profiles.
        </p>
        <form>
          <StyledCheck>
            <div><input type='checkbox'></input></div>
            <StyledLabel>
              I have read the information stated above and understand the implications of having my profile deleted.
              I wish to proceed with the deletion of my profile.
            </StyledLabel>
          </StyledCheck>
          <button>Delete Profile</button>
        </form>
      </StyledGuideline>
    </div>
  );
}