import styled from "styled-components";
import { UserStats } from "../components/blocks/UserStats";
import { UserPostedQnA } from "../components/blocks/UserPostedQnA";

const Main = styled.div`
  display: flex;
`
const MainLeft = styled.div`
  margin: 1.2rem;
`

const MainRight = styled.div`
  display: flex;
  flex-direction: column;
  flex-grow: 1;
  margin: 1.2rem;
`

const UserProfile = () => {
  return (
    <Main>
      <MainLeft>
        <UserStats />
      </MainLeft>
      <MainRight>
        <UserPostedQnA />
      </MainRight>
    </Main>
  );
}

export default UserProfile;