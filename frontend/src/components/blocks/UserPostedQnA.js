import styled from "styled-components";

const PostedQnAContainer = styled.div`
  display: flex;
  border: 0.1rem solid #d6d9dc;
  
`

const PostedQnAInfo = styled.div`
  text-align: center;
  display: flex;
  flex-direction: column;
  justify-content: center;
  margin: 0 0.8rem;
`;

const PostedQnAInfo2 = styled(PostedQnAInfo)`
  width: 3.9rem;
`

const PostedQnAInfo3 = styled(PostedQnAInfo)`
  flex-grow: 1;
`

const NumberWrap = styled.div`
  border: 0.1rem solid #d6d9dc;
`

const StyledImg = styled.img`
    width: 4rem;
    height: 4rem;
    border-radius: 0.3rem;
`

export const UserPostedQnA = () => {
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
