import styled from "styled-components";
import { useState } from "react";
import { UserMetaInfoType4 } from "../components/blocks/UserInfoContainer";
import { StyledInput } from "../components/atoms/SearchBar";
import { FilterButtonWrapper } from "../components/blocks/FilterButtonWrapper";
import { NavItem } from "../components/atoms/NavItem";

const StyledDiv = styled.div`
  font-size: 2.7rem;
  margin-bottom: 2.4rem;
`

const StyledSearchBar = styled(StyledInput)`
  width: 19rem;
  height: 3.7rem;
`

const StyledFilterBar = styled.ul`
  list-style: none;
  display: flex;

`

const StyledFilterBtn = styled.li`
  font-size: 1.2rem;
  color: #6a737c;
  padding: 0.8rem;
  margin: 0 0 0 0.2rem;
  &:hover {
    color: black;
    border-bottom: 0.1rem solid hsl(27, 90%, 50%);
  }
  &.selected {
    color: black;
    font-weight: bold;
    border-bottom: 0.1rem solid hsl(27, 90%, 50%);
  }
`

const StyledFilterWrapper = styled.div`
  display: flex;
  margin: 0.8rem 0 1.2rem 0;
  justify-content: flex-end;
`

const PeriodFilter = (props)  => {
  const FilterItems = [
    {name: 'week'},
    {name: 'New users'},
    {name: 'Voters'},
    {name: 'Editors'},
    {name: 'Moderators'}
  ]

  return (
      <StyledFilterWrapper>
        <StyledFilterBar>
          {FilterItems.map((el,index)=>{
            return (
              <NavItem 
              key={index}
              NavItemName={el.name}
              NavTo={el.to}
              width={props.width || '12.61rem'}
              padding={props.padding || '0.6rem 4.8rem 0.6rem 1.2rem'}
              activeBg={props.activeBg || '#F1F2F3'}
              activeColor={props.activeColor || '#232629'}/>
            )
          })}
        </StyledFilterBar>
      </StyledFilterWrapper>
  )
};

const users = [
  {id: 1, name: 'vonc'},
  {id: 2, name: 'conc'},
  {id: 3, name: 'vbnc'},
  {id: 4, name: 'dnc'},
  {id: 5, name: 'vsnc'},
  {id: 6, name: 'wonc'},
  {id: 7, name: 'fonc'},
  {id: 8, name: 'gonc'},
  {id: 9, name: 'honc'},
  {id: 10, name: 'jonc'},
]

const StyledUserWrapper = styled.div`
  display: grid;
  grid-gap: 0.2rem;
	grid-template-columns: repeat(auto-fill, minmax(25%, auto));
`

const StyledA = styled.a`
  color: #0074cc;
  font-weight: bold;
  text-decoration: none;
`

const Users = () => {
  return (
    <div>
      <StyledDiv>Users</StyledDiv>
      <div>
        <StyledSearchBar placeholder="Filter by User" />
        {/* <FilterButtonWrapper /> */}
      </div>
      <StyledFilterWrapper>
        <PeriodFilter />
      </StyledFilterWrapper>
      <StyledUserWrapper>
        {users.map((el) => {
          return <UserMetaInfoType4 key={el.id} name />;
        })}
      </StyledUserWrapper>
      <div>
      <StyledA href='https://stackexchange.com/leagues/1/week/stackoverflow'>weekly / monthly / quarterly reputation leagues</StyledA>
      {/*페이지네이션*/}
      </div>
    </div>
  );
};

export default Users;