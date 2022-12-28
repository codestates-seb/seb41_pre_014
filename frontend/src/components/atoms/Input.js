import styled from 'styled-components';

const StyledInput = styled.input`
  border: 0.1rem solid #BABFC4;

  &:focus {
    outline: 0.1rem solid #379fef;
    box-shadow: 0 0 0.5rem #b3d3ea;
  }
`;

export const Input = (placeholder) => {
  return (
    <>
      <StyledInput placeholder={placeholder}></StyledInput>
    </>
  )
}
