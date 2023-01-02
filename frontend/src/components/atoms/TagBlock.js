import styled from 'styled-components';

const StyledTagBlock = styled.div`
  display:flex;
  justify-content: left;
  align-items: center;
  background-color: #E1ECF4;
  color: #39739D;
  padding: 0.48rem 0.6rem;
  border: 1px solid transparent;
  margin: 0 0.2rem 0.2rem 0;
  border-radius: 0.3rem;
  
  & > div {
    font-size: 1.2rem;
  }
`;

export const TagBlock = (props) => {
  return (
    <StyledTagBlock>
      {props.tagImg ? <img src={props.tagImg} alt='tag'/> : null}
      <div>{props.tagName}</div>
    </StyledTagBlock>
  )
}