import { MainLeftNavBar } from "../components/blocks/NavBar";
import { Outlet } from "react-router-dom";
import styled from "styled-components";

const StyledUserActivity = styled.div`
  display:flex;
  margin-bottom: 4.8rem;

  & > nav {
    margin-right: 3.2rem;
  }
`;

const UserActivity = () => {
  const NavItems = [
    {name: 'Answers', to: `answers`},
    {name: 'Questions', to: `questions`},
    {name: 'Tags', to: `tags`},
    {name: 'Following', to: `following`},
    // {name: 'Reputation', to: `reputation`},
    {name: 'Votes', to: `votes`}
  ]
  
  return (
    <StyledUserActivity>
      <MainLeftNavBar NavItems={NavItems} />
      <Outlet />
    </StyledUserActivity>
  )
};

export default UserActivity;

