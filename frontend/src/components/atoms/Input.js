import styled from 'styled-components';

const StyledInput = styled.input`
  border: 0.1rem solid #BABFC4;
  padding: ${props => props.padding || '0'};
  width: ${props => props.width || '15rem'};
  border-radius: ${props => props.borderRadius || '0.3rem'};
  font-size: ${props => props.fontSize || '1.3rem'};
  &:focus {
    outline: 0.1rem solid #379fef;
    box-shadow: 0 0 0.5rem #b3d3ea;
  }
`;

export const Input = (props) => {
  return (
    <StyledInput 
      placeholder={props.placeholder}
      value={props.value}
      padding={props.padding}
      width={props.width}
      height={props.height}
      borderRadius={props.borderRadius}
      fontSize={props.fontSize}
      onFocus={props.onFocus}
      onChange={props.onChange}
      {...props.register}
    />
  )
}
