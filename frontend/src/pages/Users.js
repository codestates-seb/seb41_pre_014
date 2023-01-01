import styled from "styled-components";
import { UserMetaInfoType4 } from "../components/blocks/UserInfoContainer";
import { StyledInput } from "../components/atoms/SearchBar";
import { FilterButtonWrapper } from "../components/blocks/FilterButtonWrapper";
import { useEffect, useState } from 'react';
import axios from 'axios';

const StyledDiv = styled.div`
  font-size: 2.7rem;
  margin-bottom: 2.4rem;
`

const StyledSearchBar = styled(StyledInput)`
  width: 19rem;
  height: 4.5rem;
  font-size: 1.5rem;
`

const StyledUserWrapper = styled.div`
  display: grid;
  grid-gap: 0.2rem;
	grid-template-columns: repeat( 4, 1fr );
  grid-template-rows: repeat( 9, 1fr );
`

const StyledA = styled.a`
  color: #0074cc;
  font-weight: bold;
  text-decoration: none;
  font-size: 1.2rem;
`

const StyledTopBar = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-between;
  margin-bottom: 6rem;
` 

const Users = () => {
  const filterData = [
    {
      buttonName: "Reputation",
      onClick: () => {console.log('reputation 순으로 정렬')}
    },
    {
      buttonName: "New users",
      onClick: () => {console.log('최신 생성 유저 순으로 정렬')}
    },
  ];

  // const [users, setUsers] = useState(null);

  // const getUsers = async () => {
  //   try {
  //     const response = await axios({
  //       url: `/members?page=1&size=30`,
  //       baseURL: `${process.env.REACT_APP_SERVER_URL}`
  //     });
  //     setUsers(response.data);
  //     console.log(users);
  //   } catch (error) {
  //     console.error(error);
  //   }
  // };

  // useEffect(() => {
  //   getUsers();
  // }, []);

  return (
    <div>
      <StyledDiv>Users</StyledDiv>
      <StyledTopBar>
        <StyledSearchBar placeholder="Filter by User" />
        <FilterButtonWrapper 
          filterData={filterData}
          fontSize='1.7rem'
          padding='1.2rem'
        />
      </StyledTopBar>
      <StyledUserWrapper>
        <UserMetaInfoType4 width='4.8rem' height='4.8rem' fontSize='2.4rem' />
      </StyledUserWrapper>
      <div>
      <StyledA href='https://stackexchange.com/leagues/1/week/stackoverflow'>weekly / monthly / quarterly reputation leagues</StyledA>
      {/*페이지네이션*/}
      </div>
    </div>
  );
};

export default Users;