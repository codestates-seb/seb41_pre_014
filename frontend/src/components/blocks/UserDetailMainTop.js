import styled from "styled-components"
import { UserMetaInfoType3 } from "./UserInfoContainer";
import { MainNavBar } from "./NavBar";
import finalPropsSelectorFactory from "react-redux/es/connect/selectorFactory";
import axios from "axios";
import { useEffect, useState } from "react";
import finalPropsSelectorFactory from "react-redux/es/connect/selectorFactory";
import axios from "axios";
import { useEffect, useState } from "react";

const MainTopWrapper = styled.div`
  display: flex;
  justify-content: center;
  flex-direction: column;
  margin-bottom: 1.6rem;
`

const MainTopProfileWrapper = styled.div`
  display: flex;
  justify-content: space-between;
  margin: -0.8rem;
`

const MainTopProfile = (props) => {
const MainTopProfile = (props) => {
  return (
    <MainTopProfileWrapper>
      <UserMetaInfoType3 
        displayName={props.displayName} 
        title={props.title} 
        location={props.location}/>
      <UserMetaInfoType3 
        displayName={props.displayName} 
        title={props.title} 
        location={props.location}/>
      <EditProfileBtn>Edit Profile</EditProfileBtn>
    </MainTopProfileWrapper>
  );
}

const EditProfileBtn = styled.button`
  cursor: pointer;
  font-size: 1.3rem;
  margin: 0.3rem;
  padding-left: 1.4rem;
  color: rgb(106, 115, 124);
  width: 12rem;
  height: 4rem;
  background-color: #fff;
  background: transparent url('data:image/svg+xml,%3Csvg xmlns="http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg" width="18" height="18" preserveAspectRatio="xMidYMid meet" viewBox="0 0 24 24"%3E%3Cpath fill="%236a737c" d="M20.71 7.04c.39-.39.39-1.04 0-1.41l-2.34-2.34c-.37-.39-1.02-.39-1.41 0l-1.84 1.83l3.75 3.75M3 17.25V21h3.75L17.81 9.93l-3.75-3.75L3 17.25Z"%2F%3E%3C%2Fsvg%3E')
  no-repeat 1.2rem center;
  border-radius: 0.3rem;
  border: 0.05rem solid #c3c7cc;
  &:hover {
    background-color: #f1f2f3;
  }
;
`

export const UserDetailMainTop = () => {
  const navItems = [
    {name: 'Profile', to: `profile`},
    {name: 'Activity', to: `activity`},
    {name: 'Settings', to: `settings`},
  ];

  const [user, setUserData] = useState(null)
  // member 정보 받아오기
  const getUser = async () => {
    try {
      const response = await axios.get({
        // ${memberId}로 변경
        url: `${process.env.REACT_APP_SERVER_URL}/members/4`
      });
      setUserData(response.data);
    } catch (error) {
      console.error(error);
    }
  };

  useEffect(() => {
    getUser();
  }, []);

  console.log(user);

  return (
    <div>
      <MainTopWrapper>
        <MainTopProfile 
        displayName={user && user.displayName}
        title={user && user.title}
        location={user && user.location}
        />
        <MainNavBar navItems={navItems} />
      </MainTopWrapper>
    </div>
  );
}