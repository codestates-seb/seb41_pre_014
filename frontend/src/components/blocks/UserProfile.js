import styled from 'styled-components';

export const UserStatsContainer = styled.div`
  width: 33.1rem;
  /* height: 23.9rem; */
  border: 0.1rem solid black;
`
export const UserStatsTitle = styled.div`
  font-size: 2.1rem;
  margin-bottom: 0.8rem;
`

export const UserStatsWrap = styled.div`
  padding: 1.2rem;
  border: 0.1rem solid rgb(214, 217, 220);
  border-radius: 0.3rem;
  & > div {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
  }
`

export const UserStatItem = styled.div`
  margin: 0.8rem;
  font-size: 1.3rem;
  text-align: center;
  width: 13rem;
  & > div {
    font-size: 1.7rem;
    text-align: center;
  }
`

export const UserStats = () => { 
  return (
    <UserStatsContainer>
      <UserStatsTitle>Stats</UserStatsTitle>
        <UserStatsWrap>
          <div>
            <UserStatItem><div>Number</div>Answers</UserStatItem>
            <UserStatItem><div>Number</div>Questions</UserStatItem>
            <UserStatItem><div>Number</div>Following</UserStatItem>
            <UserStatItem><div>Number</div>Votes</UserStatItem>
          </div>
        </UserStatsWrap>
    </UserStatsContainer>
  )
}

export const PostedQnAContainer = styled.div`
  display: flex;
  border: 0.1rem solid #d6d9dc;
`

export const PostedQnAInfo = styled.div`
  text-align: center;
  display: flex;
  flex-direction: column;
  justify-content: center;
  margin: 0 0.8rem;
`;

export const PostedQnAInfo2 = styled(PostedQnAInfo)`
  width: 3.9rem;
`

export const PostedQnAInfo3 = styled(PostedQnAInfo)`
  flex-grow: 1;
`

export const NumberWrap = styled.div`
  border: 0.1rem solid #d6d9dc;
`

export const StyledImg = styled.img`
    width: 4rem;
    height: 4rem;
    border-radius: 0.3rem;
`

export const PostedQnA = () => {
  return (
    <PostedQnAContainer>
      <PostedQnAInfo>
        <StyledImg></StyledImg> {/*어떤 이미지?*/}
      </PostedQnAInfo>
        <PostedQnAInfo2>
          <NumberWrap>0</NumberWrap>
        </PostedQnAInfo2>
      {/*어떤 숫자?*/}
      <PostedQnAInfo3>
        <div>Question Title</div>
      </PostedQnAInfo3>
      <PostedQnAInfo>
        <div>upload time</div>
      </PostedQnAInfo>
    </PostedQnAContainer>
  );
}