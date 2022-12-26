import styled from 'styled-components';

const StyledTagBlock = styled.div`
  display:flex;
  justify-content: left;
  align-items: center;
  background-color: #E1ECF4;
  color: #39739D;
`;

export const TagBlock = (props) => {
  return (
    <StyledTagBlock>
      {props.tagImg ? <img src={props.tagImg} alt='tag'/> : null}
      <div>{props.tagName}</div>
    </StyledTagBlock>
  )
}