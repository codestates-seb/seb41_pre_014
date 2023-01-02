import React from 'react';
import styled from 'styled-components';
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';

export const SearchBar = () => {
  const [ searchCont, setSearchCont ] = useState('');
  const navigate = useNavigate();

  const SearchContOnChange = (e) => {
    setSearchCont(e.target.value);
  }

  const GoSearch = (e) => {
    e.preventDefault();
    navigate('/questions/search', {
      state: {
        keyword: searchCont
      }
    });
  }

  return (
    <StyledForm>
      <StyledInput 
        placeholder='Search...'
        value={searchCont}
        onChange={SearchContOnChange}
        onKeyUp={e => {
          if (e.key === 'Enter')
          GoSearch(e)
        }}
      />
    </StyledForm>
  );
};

// font 적용 필요
export const StyledForm = styled.div`
  position: relative;
  width: 100%;
`

export const StyledInput = styled.input`
  width: 100%;
  height: 3.2rem;
  padding: 0.78rem 0.91rem 0.78rem 3.9rem;  
  border: 0.1rem solid #d1d5d8;
  border-radius: 0.3rem;
  background: transparent url('data:image/svg+xml,%3Csvg xmlns="http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg" width="1em" height="1em" preserveAspectRatio="xMidYMid meet" viewBox="0 0 24 24"%3E%3Cpath fill="%23838c95" d="m19.6 21l-6.3-6.3q-.75.6-1.725.95Q10.6 16 9.5 16q-2.725 0-4.612-1.887Q3 12.225 3 9.5q0-2.725 1.888-4.613Q6.775 3 9.5 3t4.613 1.887Q16 6.775 16 9.5q0 1.1-.35 2.075q-.35.975-.95 1.725l6.3 6.3ZM9.5 14q1.875 0 3.188-1.312Q14 11.375 14 9.5q0-1.875-1.312-3.188Q11.375 5 9.5 5Q7.625 5 6.312 6.312Q5 7.625 5 9.5q0 1.875 1.312 3.188Q7.625 14 9.5 14Z"%2F%3E%3C%2Fsvg%3E')
  no-repeat 1rem center;
  background-size: 2.5rem;
  font-size: 1.3rem;
  font-weight: 400;
  display: block;

  &:focus {
    outline: 0.1rem solid #379fef;
    box-shadow: 0 0 0.5rem #b3d3ea;
  }
`