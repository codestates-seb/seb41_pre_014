import finalPropsSelectorFactory from "react-redux/es/connect/selectorFactory";
import styled from "styled-components";
import { RandomAvartar } from "./RandomAvartar";

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
  &>div {
    font-size: 1.5rem;
  }
`

const PostedQnAInfo4 = styled.div`
  text-align: center;
  display: flex;
  flex-direction: column;
  justify-content: center;
  margin: 0 0.8rem;
  &>div {
    font-size: 1.2rem;
  }
  font-size: 1.2rem;
`;

const NumberWrap = styled.div`
  border: 0.1rem solid #d6d9dc;
`

const StyledImg = styled.img`
    width: 4rem;
    height: 4rem;
    border-radius: 0.3rem;
`

export const UserPostedQnA = (props) => {
  return (
    <PostedQnAContainer>
      <PostedQnAInfo>
        <RandomAvartar 
          width='4.8rem' 
          height='4.8rem'
          fontSize='2rem'
          />
      </PostedQnAInfo>
        <PostedQnAInfo2>
          <NumberWrap>{props.score}</NumberWrap>
        </PostedQnAInfo2>
      <PostedQnAInfo3>
        <div>{props.title}</div>
      </PostedQnAInfo3>
      <PostedQnAInfo4>
        <div>upload time</div>
      </PostedQnAInfo4>
    </PostedQnAContainer>
  );
}
