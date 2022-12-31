import styled from "styled-components";
import { Outlet } from "react-router-dom";
import { MainLeftNavBar } from "../components/blocks/NavBar";

const StyledUserSettings = styled.div`
  display:flex;
  margin-bottom: 4.8rem;
  height: 100%;

  & > nav {
    margin-right: 3.2rem;
  }
`;

const UserSettings = () => {
  const navItems = [
    {name: 'Edit profile', to: ``, end: true},
    {name: 'Delete profile', to: `delete`},
  ]
  return (
    <StyledUserSettings>
      <MainLeftNavBar navItems={navItems} width='20rem'/>
      <Outlet/>
    </StyledUserSettings>
  )
}

export default UserSettings;