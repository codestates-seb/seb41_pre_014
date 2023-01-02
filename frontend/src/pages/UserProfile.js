import styled from "styled-components";
import { UserStats } from "../components/blocks/UserStats";
import { UserPostedQnA } from "../components/blocks/UserPostedQnA";
import { FilterButtonWrapper } from "../components/blocks/FilterButtonWrapper";
import { useState, useEffect } from "react";
import axios from 'axios';
import { useSelector } from "react-redux";

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


const FilterButtonContainer = styled.div`
  display: flex;
  justify-content: flex-end;
  gap: 1rem;
  margin-bottom: 1rem;
`
const MainRightTop = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  &>.elementTitle {
    font-size: 1.6rem;
    font-weight: 550;
  }
`


const UserProfile = () => {
  const memberId = useSelector(state => state.loginUserInfo.loginUserInfo.memberId);

  const filterDataType1 = [
    {
      buttonName : "All",
      onClick: () => {
        setIsSelected('All')
      }
    },
    {
      buttonName : "Questions",
      onClick: () => {
        setIsSelected('Questions')
      }
    },
    {
      buttonName : "Answers",
      onClick: () => {
        setIsSelected('Answers')
      }
    }
  ];
  
  const filterDataType2 = [
    {
      buttonName : "Score",
      onClick: () => {
      }
    },
    {
      buttonName : "Newest",
      onClick: () => {
      }
    }
  ]  

  const [isSelected,  setIsSelected] = useState('All');

  const [userData, setUserData] = useState(null);

  const getUserData = async () => {
    try {
      const response = await axios({
        url: `/members/${memberId}`,
        baseURL: `${process.env.REACT_APP_SERVER_URL}`
      });
      setUserData(response.data);
      console.log(userData);
    } catch (error) {
      console.error(error);
    }
  };

  console.log(userData);

  useEffect(() => {
    getUserData();
  }, []);

  return (
    <Main>
      <MainLeft>
        <UserStats 
        // userData 사용하기
        answerCount='0'
        questionCount='0'
        // 서버에 팔로잉 수 데이터 없음
        followCount='0'
        repCount='0'
        />
      </MainLeft>
      <MainRight>
        <MainRightTop>
          <div className='elementTitle'>{isSelected}</div>
          <FilterButtonContainer>
            <FilterButtonWrapper filterData={filterDataType1} />
            <FilterButtonWrapper filterData={filterDataType2} />
          </FilterButtonContainer>
        </MainRightTop>
        <UserPostedQnA
          score='0' 
          title='How to upload SVG images on firebase storage?'/>
      </MainRight>
    </Main>
  );
}

export default UserProfile;