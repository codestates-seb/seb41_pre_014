import styled from 'styled-components';

const StyledButton = styled.button`
  margin: ${props => props.margin || '0'};
  padding: ${props => props.padding || '0'};
  width: ${props => props.width || '15rem'};
  height: ${props => props.height || '4rem'};

  & .type1 {
    background-color: #F2740D;
    color: #FFF;
    border: 0.1rem solid #F2740D;
  };

  & .type2 {
    background-color: #0A95FF;
    color: #FFF;
    border: 0.1rem solid #0A95FF;
  };

  & .type3 {
    background-color: #E1ECF4;
    color: #39739D;
    border: 0.1rem solid #39739D;
  };

  & .type4 {
    background-color: #FFF;
    color: #0074CC;
    border: 0.1rem solid #FFF;
  };
`;

const StyledSNSButton = styled.button`
  & .google {
    background-color: #fff;
    color: #3b4045;
    border: 0.1rem solid #B3D9FF;
  };

  & .github {
    background-color: #2f3337;
    color: #fff;
    border: 0.1rem solid #D6D9DC;
  };

  & .facebook {
    background-color: #385499;
    color: #fff;
    border: 0.1rem solid transparent;
  };
`;

// < Button Type >
// type1 - 주황색 배경
// type2 - 파란색 배경
// type3 - 하늘색 배경
// type4 - 하얀색 배경
export const Button = (props) => {
  return (
      <StyledButton className={props.buttonType}>{props.buttonName}</StyledButton>
  )
};

export const SNSLoginButton = (props) => {
  return (
    <StyledSNSButton className={props.buttonType}>{props.buttonName}</StyledSNSButton>
  )
};