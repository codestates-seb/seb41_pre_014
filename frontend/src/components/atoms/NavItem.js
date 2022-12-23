import styled from 'styled-components';

const NavItemStyled = styled.li`
  margin: ${props => props.margin || '0'};
  padding: ${props => props.padding || '0'};

  & .type1 {
    background-color: #F2740D;
    color: #FFF;
  };

  & .type2 {
    background-color: #E3E6E8;
    color: #525960;
  };

  & .type3 {
    background-color: #FFF;
    color: #525960;
  };
`;

// < NavItem Type >
// type1 - 주황색 배경
// type2 - 회색 배경
// type3 - 하얀색 배경
export const NavItem = (props) => 
{
  return (
    <NavItemStyled className={props.NavItemType}></NavItemStyled>
  )
};