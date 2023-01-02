import styled from 'styled-components';

const UserStatsContainer = styled.div`
  width: 33.1rem;
  /* height: 23.9rem; */
`
const UserStatsTitle = styled.div`
  font-size: 2.1rem;
  margin-bottom: 0.8rem;
`

const UserStatsWrap = styled.div`
  padding: 1.2rem;
  border: 0.1rem solid rgb(214, 217, 220);
  border-radius: 0.3rem;
  & > div {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
  }
`

const UserStatItem = styled.div`
  margin: 0.8rem;
  font-size: 1.3rem;
  text-align: center;
  width: 13rem;
  & > div {
    font-size: 1.7rem;
    text-align: center;
  }
`

export const UserStats = (props) => { 


  return (
    <UserStatsContainer>
      <UserStatsTitle>Stats</UserStatsTitle>
        <UserStatsWrap>
          <div>
            <UserStatItem><div>{props.answerCount}</div>Answers</UserStatItem>
            <UserStatItem><div>{props.questionCount}</div>Questions</UserStatItem>
            <UserStatItem><div>{props.followCount}</div>Following</UserStatItem>
            <UserStatItem><div>{props.repCount}</div>Reputation</UserStatItem>
          </div>
        </UserStatsWrap>
    </UserStatsContainer>
  )
}